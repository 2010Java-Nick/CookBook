package com.revature.CookBook.controller;

import javax.servlet.http.HttpServletResponse;

import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/user")
	public boolean createUser(@RequestBody UserDto user, HttpServletResponse response) {
	
		System.out.println("Request received");
		System.out.println(user);

		if(userService.createUser(user.toPojo())) {
			response.setStatus(200);
			return true;
		}
		else {
			response.setStatus(400);
			return false;
		}
		
	}
	
	@GetMapping("/user/{username}")
	public UserDto readUser(@PathVariable(name = "username") String username, HttpServletResponse response) {
		
		UserDto userDto = new UserDto(userService.readUser(username));
		response.setStatus(200);
		return userDto;
	}
}
