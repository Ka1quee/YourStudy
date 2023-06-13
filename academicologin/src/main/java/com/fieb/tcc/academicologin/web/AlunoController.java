package com.fieb.tcc.academicologin.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fieb.tcc.academicologin.service.UserService;






@Controller
public class AlunoController {
	
	@Autowired
	UserService userService;

	@GetMapping("/users/dashboard")
	public String dashbord(Model model) {
		
		String username = userService.getAuthenticatedUser().getEmail();
		model.addAttribute("username", username);
		
		return "aluno/dashboard-aluno";
	}
	
	@GetMapping("/users/perfil-teste")
	public String perfilTeste() {
		return "aluno/aluno-perfil";
	}
	
	@GetMapping("/users/front-end")
	public String frontEnd() {
		return "aluno/aluno-home";
	}
	
	@GetMapping("/users/cadastro")
	public String cadastro() {
		return "aluno/aluno-cadastro";
	}
	
	@GetMapping("/users/salvos")
	public String salvos() {
		return "aluno/salvos";
	}
	
}
