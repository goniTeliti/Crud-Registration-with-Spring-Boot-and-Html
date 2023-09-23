package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@Service
public class UserService {

	
	
	private final UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository=userRepository;
	}
	
	public String  saveUser(@RequestBody User u) {
		
		 userRepository.save(u);
		 
		 return "User   saved";
	}
	public User getByIdd(@PathVariable  Long id) {
		
		Optional<User> us=userRepository.findById(id);
		
		return us.get(); 
	}
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public String deleteUser(long id) {
		Optional<User> us=userRepository.findById(id);
		userRepository.deleteById(id);
		
		if(us.isPresent()) {
		return" Deleted";
		}
		else {
			return " Not Found";
		}
	}
	
}
