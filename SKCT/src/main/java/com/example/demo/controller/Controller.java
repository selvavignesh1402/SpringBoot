package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/path")
public class Controller {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/get")
	List<Student>get()
	{
		return userRepo.findAll();
	}
	
	@PostMapping("/post")
	List<Student> newUser(@RequestBody List<Student> Userlist)
	{
		return userRepo.saveAll(Userlist);
	}
	
//	@PostMapping("/post")
//	public Iterable<Student> postMethod(@RequestBody Iterable<Student> newUser) {
//		return userRepo.saveAll(newUser);
//	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> Updatemethod(@PathVariable long id,@RequestBody Student userData)
	{
		Optional<Student> userupdate=userRepo.findById(id);
		if(userupdate.isPresent())
		{
			Student user=userupdate.get();
			user.setRegno(userData.getRegno());
			user.setName(userData.getName());
			user.setDept(userData.getDept());
			user.setCgpa(userData.getCgpa());
			
			userRepo.save(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		userRepo.deleteById(id);
	}
}
