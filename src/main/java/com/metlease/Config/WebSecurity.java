package com.metlease.Config;

import com.metlease.Service.ApplicationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.metlease.Config.ConfigConstants.*;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private ApplicationUserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public WebSecurity(ApplicationUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(LOGIN_URL);
        return authenticationFilter;
    }

    public AuthorizationFilter getAuthorizationFilter() throws Exception {
        AuthorizationFilter authorizationFilter = new AuthorizationFilter(authenticationManager());
        return authorizationFilter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("Authorization");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("OPTIONS");
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
          .authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.OPTIONS, SIGN_UP_URL).permitAll()
                .anyRequest().authenticated().and()
                .addFilter(getAuthenticationFilter())
                .addFilter(getAuthorizationFilter())
                .cors().and()
            .formLogin()
                .loginPage("/secure").permitAll()
                .loginProcessingUrl("/secure/use").permitAll()
                .and()
                .csrf().disable()
            .logout()
                .logoutUrl(LOGOUT_URL).permitAll();

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}
