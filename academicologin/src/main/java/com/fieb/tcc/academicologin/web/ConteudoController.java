package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConteudoController {
	
	
	@GetMapping("/users/exercicios")
	public String exercicios() {
		return "conteudo/exercicios-list";
	}
	
	@GetMapping("/users/exercicio-html")
	public String exercicioHtml() {
		return "Exercicio1Html/index";
	}
}
