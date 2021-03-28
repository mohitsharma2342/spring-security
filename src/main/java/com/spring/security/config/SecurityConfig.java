 package com.spring.security.config;

   

 import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



 @Configuration
 @EnableWebSecurity
 public class SecurityConfig extends WebSecurityConfigurerAdapter {

 	
 	@Resource(name = "userDetailService")
 	private UserDetailsService userDetailsService;
 	
 	@Autowired
 	private SuccessHandler successHandler;
 	
 	@Autowired
 	private FailureHandler failureHandler;
 	
 	  @Override
 	    protected void configure(HttpSecurity http) throws Exception {
 	        http.cors().and().authorizeRequests().anyRequest().
 			authenticated().and().exceptionHandling().and().formLogin().loginProcessingUrl("/authenticate").
 			successHandler(successHandler).failureHandler(failureHandler)
 			// .logoutSuccessUrl("/login/login.html").invalidateHttpSession(true).deleteCookies("JSESSIONID")
 	                .permitAll().and().csrf().disable();
 	  }

 	
 	 @Autowired
 	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(userDetailsService);
 	}

 	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
 	
 }
