package myproject.config.security;

import lombok.AllArgsConstructor;
import myproject.config.ConfigApp;
import myproject.jwt.JwtAuthenticationEntryPoint;
import myproject.jwt.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@Import({EncoderConfig.class, ConfigApp.class})
@EnableWebSecurity
@ComponentScan(basePackages = "myproject.jwt")
@EnableMethodSecurity(securedEnabled = true)
@AllArgsConstructor
public class SecurityConfig {

    UserDetailsService service;
    JwtAuthenticationEntryPoint entryPoint;
    JwtRequestFilter jwtRequestFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(service)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers("/jwt/registration", "/jwt/authenticate").permitAll()
                                .requestMatchers("/login*").permitAll()
                                .requestMatchers("/security/user").hasRole("USER")
                                .requestMatchers("/security/admin").hasRole("ADMIN")
                                .requestMatchers("/student/save", "/role/save").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .logout()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception {
        auth.inMemoryAuthentication()
                .withUser("John")
                .password("$2a$10$tUsEKBhFQk.ffWNMDog20uHHtMzFUIC78QIlkCwNIg/mAU3o0cbrq")
                .roles("USER")//123
                .and()
                .withUser("Jack")
                .password("$2a$10$59XvGiRSGoNXMLjmoyFTlO3dAfzaAommcr4lkKxph9/sQRLAtaxzC")
                .roles("ADMIN");//123456
    }*/

    @Bean(name = "mvcHandlerMappingIntrospector")
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }
}
