package com.rest.min.listinbuilt;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDao userDao;
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userDao.findAll();
		
	}
	@GetMapping("/users/{id}")
	public User retriveOneUser(@PathVariable int id) {
		 User findone = userDao.findone(id);
		 if(findone==null) {
			 throw new UserNotFoundException("Id :"+id);
		 }
		 return findone;
	}
	
//	@GetMapping("/users1/{id}")
//	public EntityModel<User> retriveOneUser1(@PathVariable int id) {//instaed of returning user will return entity model which will return user n link
//		 User findone = userDao.findone(id);
//		 if(findone==null) {
//			 throw new UserNotFoundException("Id :"+id);
//		 }
//		 EntityModel<User> em = EntityModel.of(findone);
//		 WebMvcLinkBuilder linkTousers = linkT 
//		 
//		 return findone;
//	}
	
	@PostMapping("/users")
	public void crateUser(@RequestBody User user){
		 User save = userDao.save(user);//whatever i passed body of the request would be mapped to this userParamter..for ex if i passed vishal it will mapped to user.name
		

}
	@PostMapping("/users1")
	public ResponseEntity<Object> crateUser1(@Valid @RequestBody User user){
		 User save = userDao.save(user);
		 URI location = ServletUriComponentsBuilder
		 .fromCurrentRequest()//gives /user1
		 .path("/{id}")
		 .buildAndExpand(save.getId()).toUri();
		 return  ResponseEntity.created(location).build();
		
}
	@DeleteMapping("/users/{id}")
	public void deleteOneUser(@PathVariable int id) {
		 User deleteOne = userDao.deleteById(id);
		 if(deleteOne==null) {
			 throw new UserNotFoundException("Id :"+id);
		 }
		 
	}
	
}
