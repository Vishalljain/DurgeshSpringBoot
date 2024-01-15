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

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@ManyToMany(mappedBy = "roles")//meaning this type of the relationship is already mapped in user.java that is 
	//@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
//these where we are defining the actual relationshaip in the mapped by we simply use the variable name that is roles from here(private Set<Role> roles;)
	private Set<User> users;
	
	//what we are telling is for the above users the mapping is already happened on the other side of the relationship and file name in that entity is roles.
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String getAuthority() {//get authority will be invoked internally by spring security to get the role of a particular user and it shld return the name of the role
		// TODO Auto-generated method stub
		return name;
	}



	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

//whenever the getAuthority name is invoked on a particular rool instance we shld return back the name of the role authority 
