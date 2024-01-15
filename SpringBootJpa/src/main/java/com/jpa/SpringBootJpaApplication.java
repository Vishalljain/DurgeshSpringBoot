package com.jpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entities.User;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
	UserRepository userRepository = context.getBean(UserRepository.class);
//	User user = new User();
//	user.setCity("Bhadravati");
//	user.setName("Akash");
//	user.setStatus("Business Man");
//	
//	User user2 = new User();
//	user2.setCity("Bhadravati");
//	user2.setName("Lalith");
//	user2.setStatus("Business Man");
//	
//	List<User> userDetails = Arrays.asList(user,user2);
//	
//	
//	Iterable<User> saveAll = userRepository.saveAll(userDetails);
//	System.out.println(saveAll);
	
	List<User> name = userRepository.findByName("vishal");
	System.out.println(name);
	System.out.println("**********************");
	
	List<User> name1 = userRepository.findByNameAndCity("vishal","Bangalore");
	System.out.println(name1);
	System.out.println("**********************");
	
	List<User> allStudents = userRepository.getAllStudents();
	allStudents.forEach(user->System.out.println(user));
	System.out.println("**********************");
	
	List<User> byName = userRepository.getUserByName("vishal");
	byName.forEach(e->System.out.println(e));
	System.out.println("**********************");
	
	List<User> byNameAndCity = userRepository.getUserByNameAndCity("Akash","Bhadravati");
	byNameAndCity.forEach(u->{
		System.out.println(u);
	});
	System.out.println("**********************");
	
	List<User> list = userRepository.getAllInfoUser();
	list.forEach(info->System.out.println("Native query : "+info));
	System.out.println("**********************");
	}
	


}
