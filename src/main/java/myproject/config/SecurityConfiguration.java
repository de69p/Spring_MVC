//package myproject.config;
//
//import myproject.config.security.EncoderConfig;
//import myproject.jwt.JwtAuthenticationEntryPoint;
//import myproject.jwt.JwtRequestFilter;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
///*
// * class extends the WebSecurityConfigurerAdapter which is a convenience class that allows customization to both WebSecurity and HttpSecurity.
// * */
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackages = "com")
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@Import(EncoderConfig.class)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final UserDetailsService userDetailsService;
//
//    private final JwtAuthenticationEntryPoint entryPoint;
//
//    private final JwtRequestFilter jwtRequestFilter;
//
//    public SecurityConfiguration(@Qualifier("mvcDetailsServiceImpl") UserDetailsService userDetailsService,
//                                 PasswordEncoder passwordEncoder, JwtAuthenticationEntryPoint entryPoint,
//                                 JwtRequestFilter jwtRequestFilter) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//        this.entryPoint = entryPoint;
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }
//
///*     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//
//         String loginPage = "/login*";
//         String home = "/home/auth";
//         String logoutPage = "/logout*";
//
//         http.
//                 authorizeRequests()
//                 .antMatchers("/").permitAll()
//                 .antMatchers(loginPage).permitAll()
//                 .antMatchers("/admin/**").hasAuthority("ADMIN")
//                 .anyRequest()
//                 .authenticated()
//                 .and().csrf().disable()
//                 .formLogin()
//                 .failureUrl("/login?error=true")
//                 .defaultSuccessUrl(home)
//                 .usernameParameter("user_name")
//                 .passwordParameter("password")
//                 .and().logout()
//                 .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
//                 .logoutSuccessUrl(loginPage).and().exceptionHandling();
//     }*/
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/jwt/registration").permitAll()
//                .antMatchers("/jwt/authenticate").permitAll()
//                .mvcMatchers("/login*")
//                .permitAll()
//
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .and().csrf().disable()
////
////               /* * .exceptionHandling() -
////                * Allows configuring exception handling. This is automatically applied when using
////                 * WebSecurityConfigurerAdapter.
////                 * authenticationEntryPoint -
////                 * Handles any AccessDeniedException and AuthenticationException
////                    thrown within the filter chain.
////                    This filter is necessary because it provides the bridge between Java exceptions and
////                    HTTP responses. Он занимается исключительно поддержанием пользовательского интерфейса. Этот фильтр
////                     не выполняет никаких фактических мер безопасности.
////                  If an AuthenticationException is detected, the filter will launch the
////                    authenticationEntryPoint.
////                * */
//                .exceptionHandling().authenticationEntryPoint(entryPoint).and()
////
////                /*Allows configuring of Session Management.
////                * Spring Security will never create an {@link HttpSession} and it will never use it
////                * to obtain the SecurityContext
////                * */
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        // Add a filter to validate the tokens with every request
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}