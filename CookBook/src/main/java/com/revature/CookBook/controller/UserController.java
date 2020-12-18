package com.revature.CookBook.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.service.UserService;

@RestController
@RequestMapping(path = "user")
public class UserController {
	
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value = "")
	public void createUser(@RequestBody UserDto user, HttpServletResponse response) {
	
		if(userService.createUser(user.toPojo())) {
			response.setStatus(201);
		}
		else {
			response.setStatus(400);
		}
		
	}
	
	@GetMapping(value = "{username}")
	public UserDto readUser(@PathVariable(name = "username") String username, HttpServletResponse response) {
		
		UserDto userDto = new UserDto(userService.readUser(username));
		
		return userDto;
	}
}
