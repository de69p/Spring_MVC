package myproject.config.security;

import com.google.protobuf.Service;
import com.sun.nio.file.SensitivityWatchEventModifier;
import lombok.AllArgsConstructor;
import myproject.config.ConfigApp;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.beans.Encoder;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Configuration
@Import({EncoderConfig.class, ConfigApp.class})
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@AllArgsConstructor
public class SecurityConfig {

    UserDetailsService service;

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
                        req.requestMatchers("/security/user").hasRole("USER")
                                .requestMatchers("/security/admin").hasRole("ADMIN")
                                .requestMatchers("/student/save").permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin();
            //    .defaultSuccessUrl("/find/all");
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
