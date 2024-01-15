package com.bharath.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.springcloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	//in the user repo we need to define a finder method that will retrive the user details given his email
	
	User findByEmail(String email);

}
