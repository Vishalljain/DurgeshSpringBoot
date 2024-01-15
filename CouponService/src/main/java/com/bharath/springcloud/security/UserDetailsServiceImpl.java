package com.bharath.springcloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bharath.springcloud.model.User;
import com.bharath.springcloud.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found in db"+username);
		}
		//but we want to return is user details thanks to spring security it gives us a user object of its own from the sucurity package
		//return new org.springframework.security.core.userdetails.User(username, password, false, false, false, false, authorities);//user name is user.getEmail
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.getRoles());//the last one although it expect authorities we are passing in roles and that is the reason our role class implements grantedauthority
	//we use the username fetch the user from the db convert it into userdetails object tht is requred by spring security so that authentication provider can do the authentication
	}

}
