package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import com.vamosaprogramar.umedicalapi.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

		@Autowired
	 	private UserService userService;
	    
	 	@Autowired
	 	private BCryptPasswordEncoder bCryptPasswordEncoder;

	    
	    
	    public UserController(UserService userService,
	                     BCryptPasswordEncoder bCryptPasswordEncoder) {
	    	
	        this.userService = userService;
	        
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	    
	    @GetMapping()
	    public List<ApplicationUser> getUsers(){
	    	return userService.getUsers();
	    }
	    
	    
	    @GetMapping("/{username}")
	    public ApplicationUser getUser(@PathVariable String username) {
	    	
	    	return userService.findByUsername(username);
	    }
	    
	    @GetMapping("/{id}/schedules")
	    public List<Schedule> getSchedules(@PathVariable int id){
	    	return userService.getSchedules(id);
	    }
	    
	    @PostMapping("/sign-up")
	    public ResponseEntity<String> signUp(@RequestBody ApplicationUser user) {
	    	
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	       	        
	        try {
	        	userService.saveUser(user);
	    		
			} catch (Exception e) {
				 return new ResponseEntity<>(
				          e.getMessage(), 
				          HttpStatus.BAD_REQUEST);
			}
	   	 return new ResponseEntity<>(
   		      "The user was saved correctly!", 
   		      HttpStatus.OK);
	    }
	    
	    @PostMapping("/{id}/schedules")
	    public ResponseEntity<String> addSchedules(@PathVariable int id, @RequestBody List<Schedule> schedules){
	    		    	
	    	try {
	    		userService.addSchedules(schedules,id);
	    		
			} catch (Exception e) {
				 return new ResponseEntity<>(
				          e.getMessage(), 
				          HttpStatus.BAD_REQUEST);
			}
	    	
	    	 return new ResponseEntity<>(
	    		      "The schedule was set correctly!", 
	    		      HttpStatus.OK);
	    }
	
	
	
}
