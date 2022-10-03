package com.authenticator.BasicAuthenticator.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public void configureGlobalSecurity (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("alberto").password("Alberto").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("alberto").password("Alberto").roles("ADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers("/todos_profesore_public").permitAll()
                .antMatchers("/todos_profesore_admin").hasRole("ADMIN")
                .antMatchers("/todos_profesore_user").hasRole("USER")
                .and()
                .httpBasic();
    }
}
