package com.revature.CookBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//@RequestMapping(path = "/", method = RequestMethod.POST)
	@PostMapping(value = "")
	public void createUser(@RequestBody UserDto user) {
		
		//TODO: make this
	}
	
	//@RequestMapping(path = "/{username}", method = RequestMethod.GET)
	@GetMapping(value = "{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void readUser(@PathVariable(name = "username") String username) {
		
		//TODO: make this
	}
}
