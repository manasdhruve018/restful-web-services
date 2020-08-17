package com.manas.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList();
	
	private static int countUsers = 3;
	
	static{
		users.add(new User(1,"Manas",new Date()));
		users.add(new User(2,"Falak",new Date()));
		users.add(new User(3,"Saurabh",new Date()));
	}
	
	//Find all Users
	public List<User> findAll(){
		return users;
	}
	
	//Save a User
	public User save(User user){
		if(user.getId()==null){
			user.setId(++countUsers);
		}
		users.add(user);
		return user;
	}
	
	//Find one User
	public User findUser(int id){
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
	//Delete one User
	public User deleteById(int id){
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()){
			User user = itr.next();
			if(user.getId()==id){
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
