package com.bharath.springcloud.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)//in many to many these roles will be loaded lazily but it is good idea to fetch them as soon as the user is loaded so that security framework can use all the roles for authorization
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	//how are these 2(user n role) entities map?in db we are using mapping table so use @Jointable and within brackets name is equal to give the name of the joint tale within the double quotes which is user_role.we need to tell using which colums we are doing the join
	//or mapping join columns joincolumns is the attribute we use for that. and @joincolumns specify the join column from user table  user_id and now we have to specify join column from the other side which is from role side we use inverse joint column for that
	private Set<Role> roles;//a user may have multiple roles
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
