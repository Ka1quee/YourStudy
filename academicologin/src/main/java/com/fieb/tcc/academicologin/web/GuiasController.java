package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiasController {
	
	@GetMapping("/users/guia-cadastro")
	public String guiaCadastro() {
		return "admin/guia-cadastro";
	}

}
