package com.pragmaticbitbucket.spring5tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/css/**", "/js/**", "/images/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().and().httpBasic();
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();*/

        // this is needed since if everything is locked down, these files
        // would not come down before the authentication happens
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/css/**", "/js/**", "/images/**")
                .permitAll();
/*
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll();*/

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and().httpBasic();
    }
}

