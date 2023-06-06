package com.fieb.tcc.academicologin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fieb.tcc.academicologin.model.Guia;
import com.fieb.tcc.academicologin.repository.GuiaRepository;

@Controller
public class GuiasController {
	
	
	@Autowired
	private GuiaRepository guiarepositorio;

	
	
	@GetMapping("/users/guia-cadastro")
	public ModelAndView cadastrarGuia(Guia guia) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/guia-cadastro");
		mv.addObject("guia", new Guia());
		return mv;

	}
	
	@PostMapping("inserirGuias")
	public ModelAndView inserirGuias(Guia guia) { 
		
		ModelAndView mv = new ModelAndView();


			mv.setViewName("redirect:/users/guias"); 
													
			guiarepositorio.save(guia);
		
	
		return mv;
	}
	
	// listagem de guias
	
	
	@GetMapping("/users/guias")
	public ModelAndView listagemGuias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conteudo/guias-list");
		mv.addObject("guiaList", guiarepositorio.findAll()); 
		
		return mv;
	}
	@GetMapping("/users/guia")
	public String guiaEstudo() {
		return "conteudo/guia-conteudo";
	} 
	
	// Fazer método pra entrar nos cards dos guias
	
	
	
	

// listagem dos guias em tabela
	
	@GetMapping("/users/guia-list")
	public ModelAndView guiaList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conteudo/listagem-de-guias");
		mv.addObject("guiaList", guiarepositorio.findAll()); 
		
		return mv;
	}
	
	//exclusao dos cadastros dos guias
	
	@GetMapping("/users/excluir-guia/{id}")
	public String excluirGuia(@PathVariable("id") Long id) {
		guiarepositorio.deleteById(id); // dessa vez usamos o metodo de delete ao inves de save, dessa maneira ele
											// irá deletar o usuario buscando pelo seu id
		return "redirect:/users/guia-list";
	}
}
