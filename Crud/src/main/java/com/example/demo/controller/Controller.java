package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.User;

import com.example.demo.Reposiatory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class Controller {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/value")
	List<User>getAll(){
		return userRepository.findAll();
	}
		
	@PostMapping("/postvalue")
	User newUser(@RequestBody User newUser) 
	{
		return userRepository.save(newUser);
	}
}