package com.bharath.springcloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bharath.springcloud.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeHttpRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupons").hasAnyRole("USER","ADMIN").mvcMatchers(HttpMethod.POST,"/couponapi/coupons").hasRole("ADMIN").and().csrf().disable();
		//http.authorizeHttpRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupons").hasAnyRole("USER","ADMIN").mvcMatchers(HttpMethod.POST,"/couponapi/coupons").hasRole("ADMIN").anyRequest().denyAll().and().csrf().disable();will not work it will work only for /couponapi/coupons but not for/couponapi/coupons/anythingextra
		//http.authorizeHttpRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupons/**").hasAnyRole("USER","ADMIN").mvcMatchers(HttpMethod.POST,"/couponapi/coupons").hasRole("ADMIN").and().csrf().disable();//it will work 


	//BY DEFAULT CSRF IS ENABLED WE CANNOT PERFORM POST OPERATION
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
