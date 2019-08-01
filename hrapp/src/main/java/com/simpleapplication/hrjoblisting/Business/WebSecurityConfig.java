package com.simpleapplication.hrjoblisting.Business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/joblist","/joblists","/uploadFile", "/uploadMultipleFiles", "/downloadFile/**").permitAll()
                .antMatchers("/add").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and().csrf().disable()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
        
       
    }

	 /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .httpBasic().and()
        .authorizeRequests()
        .antMatchers("/add" ,"/joblists", "/update","/delete/**","/joblist/{id}","/newjoblist")
        .permitAll().anyRequest().authenticated()
        .and().csrf().disable();
  }
      */

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}