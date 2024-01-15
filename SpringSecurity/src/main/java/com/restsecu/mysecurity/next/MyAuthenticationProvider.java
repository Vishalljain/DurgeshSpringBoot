package com.restsecu.mysecurity.next;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();//getCredentials returns obj so toString
		if("tom".equals(userName)&&"crusie".equals(password)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, password,Arrays.asList());//in 3rd parameter we can send roles like read write now empty as of now
			return usernamePasswordAuthenticationToken;
		}
		else {
			throw new BadCredentialsException("Invalid UserName or Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {//this method is to check whether the authentication type is supported or not
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
//in this lecture you will learn how to create a custom authentication provider so far you have used user deatils service and password encoder now you will write custom
//autehntication logic inside the authentication provider and we dont even need the user deatils service and password encoder to do that




//so in this lecture you have successfully impemented your own authenticator provider that implements the authentication provider interface .The first method where you write the logic and 2nd method simply tells the authentication manager that this guy can support a username n pw authenticaton  type
