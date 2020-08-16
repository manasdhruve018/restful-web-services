package com.manas.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	UserDaoService userService;
	
	@GetMapping("/users/all")
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable int id){
		return userService.findUser(id);
	}
	
}
