package com.restsecu.mysecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.restsecu.mysecurity.next.MyAuthenticationProvider;

@Configuration
public class MySecurity extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {//this method will allow us to customize the authentication manager we can configure  the userdeatils service and pw encoder on this auth object(AuthenticationManagerBuilder auth)
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();//to create user detail service instead of creating userServiceInterface  we use the implementation of userServiceInterface that is InMemoryUserDetailsManager.This guy will store the user information in memory
//		//so the autentication manager which internally uses authentication provider knows how to use this as the userdetailsservice instead of using default implementation.But this
//		//users service does not know which user to use so we use next line to know which user to use
//		UserDetails user = User.withUsername("tom").password(passwordEncoder.encode("crusie")).authorities("read").build();
//		userDetailsService.createUser(user);
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
//	//we can create bean of Bcryptpasswordencoder instaed of writing everything in one method
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("tom").password(passwordEncoder.encode("crusie")).authorities("read").build();
//		userDetailsService.createUser(user);
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//	}
	//now we are using MyAuthenticationProvider
	@Autowired
	private MyAuthenticationProvider myAuthenticationProvider;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(myAuthenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//this method takes the http security as the parameter.this is where we can customize what security we want to use that is we want to use form based authentication ,http basic etc
		//http.httpBasic();//if u want form just change this line all same
		http.formLogin();
		//http.authorizeHttpRequests().anyRequest().authenticated();//means any request that is all the requests that come to our application need to be authenticated only then they can access the resources
		http.authorizeHttpRequests().antMatchers("/hello").authenticated();//i can access bye method with authentication
		//http.authorizeHttpRequests().anyRequest().permitAll();//if we say permit all without authentication that means anybody can access our application
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

}

//here in this class we have provided inmemory user and pw
//if we dont use pw encoder at all when u hit the send no respone and in console there is no pw encoded for the id "null" from 2 version it has become necessary the pw need to be encoded
