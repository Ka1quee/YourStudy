package com.fieb.tcc.academicologin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fieb.tcc.academicologin.model.User;
import com.fieb.tcc.academicologin.service.UserService;
import com.fieb.tcc.academicologin.web.dto.UserDto;

@Controller
public class AuthController {
	
	
	private UserService userService;
	
	public AuthController(UserService userService) {
		
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}
	
	@GetMapping("/registration-admin")
	public String showRegistrationFormAdmin() {
		return "admin/admin-cadastro";
	}
	
	//usuario comum
	
	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
		userService.save(userDto);
		return "redirect:/registration?success";
	}
	
	//admin

	@PostMapping("/registration-admin")
	public String registerAdminAccount(@ModelAttribute("user") UserDto userDto) {
		userService.saveAdmin(userDto);
		return "redirect:/registration-admin?success";
	}
	

	
	
	@ResponseBody
	@RequestMapping(value="/registration/ajax/getEmail/{campo}/{valor}")
	public String getSearchResultViaAjaxRegister(@PathVariable("campo") String campo,
			                                     @PathVariable("valor") String valor) {
		
		String msg= "";
		UserDto userDto = new UserDto();
		userDto.setEmail(valor);
		User user = userService.findByEmail(userDto);
		if(user != null) {
			msg = "Email já existe, escolha um email válido!";
		}
		return msg;
	}

}
