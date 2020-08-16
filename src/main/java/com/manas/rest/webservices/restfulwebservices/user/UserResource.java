package com.manas.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	UserDaoService userService;
	
	//Retrieve all Users
	@GetMapping("/users/all")
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	
	//Retrieve a single User
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable int id){
		return userService.findUser(id);
	}
	
	//Create a new User
	@PostMapping("/users")
	public void createUser(@RequestBody User user){
		User savedUser = userService.save(user);
	}
	
}
