package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConteudoController {
	
	@GetMapping("/users/artigos")
	public String artigos() {
		return "conteudo/guias-list";
	}
	
	@GetMapping("/users/exercicios")
	public String exercicios() {
		return "conteudo/exercicios-list";
	}
}
