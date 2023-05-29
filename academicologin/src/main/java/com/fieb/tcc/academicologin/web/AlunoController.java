package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {

	@GetMapping("/users/dashboard")
	public String dashbord() {
		return "aluno/dashboard-aluno";
	}
	
}
