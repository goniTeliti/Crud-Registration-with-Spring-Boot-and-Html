package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.user.User;

@RestController
public class UserControllerCrud {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("add")
	public ResponseEntity<String> addUser(@RequestBody User u){
		
	String us =	userService.saveUser(u);
		
		return new ResponseEntity<>(us,HttpStatus.CREATED);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		
		User u=userService.getByIdd(id);
		
		
		return new ResponseEntity<>(u,HttpStatus.OK);
		
		
	}
	@GetMapping("getAll")
	public ResponseEntity<List<User>> getAll(){
		
		List<User> uss= userService.getAllUsers();
		
		return new ResponseEntity<List<User>>(uss,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id){
		
		String user=userService.deleteUser(id);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
		
		
		
		
	}
	
}
