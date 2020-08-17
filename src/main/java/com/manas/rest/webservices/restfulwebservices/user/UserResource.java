package com.manas.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user =  userService.findUser(id);
		if(user==null)
			throw new UserNotFoundException("id - "+id);
		return user;
	}
	
	//Create a new User
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser = userService.save(user);
		
		//Return CREATED status to REST Client (Postman)
		URI location = 
		ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}	

}
