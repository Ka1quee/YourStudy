package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	
	@GetMapping("/admin/admin-home")
	public String adminHome() {
		return "admin/admin-home";
	}
	
	@GetMapping("/admin/teste")
	public String adminteste() {
		return "admin/admin-home";
	}
	
	@GetMapping("/users/aluno-cadastro")
	public String alunoCadastro() {
		return "admin/aluno-cadastro";
	}
	
	
	@GetMapping("/users/informacoes-enviadas")
	public String informacoesEnviadas() {
		return "admin/informacoes-enviadas";
	}
	


}
