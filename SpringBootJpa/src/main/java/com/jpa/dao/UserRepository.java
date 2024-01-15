package com.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//select * from mydb5.user where name="Vishal"
	//custom finder methods or derived query methods
public List<User> findByName(String name);// here find is known as introducer and ByName is known as criteria
public List<User> findByNameAndCity(String name,String city);
//

//IF WE WANT TO FIRE OUR OWN QUERY WE CAN USE @QUERY WHICH TAKES JPQL(Java persistent query lng) QURIES AND NATIVE QUERIES
//@Query takes JPQL query and Native queries

//will see JPQL query if we want 
@Query("Select u from User u")
public List<User> getAllStudents();


@Query("select u from User u WHERE u.name =:n")
public List<User> getUserByName(@Param("n")String name);

@Query("select u from User u WHERE u.name =:n and u.city=:c")
public List<User> getUserByNameAndCity(@Param("n")String name,@Param("c")String city);

//using native query that is normal sql query
@Query(value="select * from User", nativeQuery = true)
public List<User> getAllInfoUser();
}
