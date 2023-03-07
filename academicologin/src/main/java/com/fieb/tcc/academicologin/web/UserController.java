package com.fieb.tcc.academicologin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fieb.tcc.academicologin.service.UserService;

@Controller
public class UserController {
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService = userService;
	}

}
