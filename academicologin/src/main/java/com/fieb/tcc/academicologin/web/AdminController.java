package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	
	@GetMapping("/users/admin-home")
	public String adminHome() {
		return "admin/admin-home";
	}
	


}
