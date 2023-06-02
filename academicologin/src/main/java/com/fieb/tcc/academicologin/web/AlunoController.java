package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {

	@GetMapping("/users/dashboard")
	public String dashbord() {
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
	
}
