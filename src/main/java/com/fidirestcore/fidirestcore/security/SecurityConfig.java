package com.fidirestcore.fidirestcore.security;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fidirestcore.fidirestcore.request.AuthRequest;

import lombok.RequiredArgsConstructor;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(new AuthRequest(authenticationManagerBean()));
    }

    // Error
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     // AuthRequest authRequest = new AuthRequest(authenticationManagerBean());
    //     // Rewrite default auth url to /api/login
    //     // authRequest.setFilterProcessesUrl("/api/login");
    //     //
    //     http.csrf().disable();
    //     http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //     //
    //     http.authorizeRequests().antMatchers(POST, "/login/**").permitAll();
    //     // Setup permissions by URL
    //     http.authorizeRequests().antMatchers(GET, "/api/user/**").hasAnyAuthority("ROLE_USER");
    //     http.authorizeRequests().antMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
    //     http.authorizeHttpRequests().anyRequest().authenticated();
    //     //
    //     // http.addFilter(authRequest);
    //     http.addFilter(new AuthRequest(authenticationManagerBean()));
    // }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
