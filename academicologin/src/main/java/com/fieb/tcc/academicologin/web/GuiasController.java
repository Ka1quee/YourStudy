package com.fieb.tcc.academicologin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
		mv.setViewName("redirect:/users/informacoes-enviadas");
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

// listagem dos guias em tabela

	@GetMapping("/users/guia-list")
	public ModelAndView guiaList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conteudo/listagem-de-guias");
		mv.addObject("guiaList", guiarepositorio.findAll());

		return mv;
	}

	// exclusao dos cadastros dos guias

	@GetMapping("/users/excluir-guia/{id}")
	public String excluirGuia(@PathVariable("id") Long id) {
		guiarepositorio.deleteById(id); 
										
		return "redirect:/users/guia-list";
	}

	// editar cadastros

	@GetMapping("/users/editar-guia/{id}")
	public ModelAndView editarGuia(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/guia-editar");
		Guia guia = guiarepositorio.getOne(id);
		mv.addObject("guia", guia); 
									
		return mv;
	}

	// postagem das alterações

	@PostMapping("/editar-guia")
	public ModelAndView alterar(Guia guia) {									
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/guia-list"); 
		guiarepositorio.save(guia);

		return mv;
	}
	
	
	
	// conteudo cadastrado no guia
	
	@GetMapping("/users/guia/{id}")
	public ModelAndView conteudoGuia(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conteudo/guia-conteudo");
		Guia guia = guiarepositorio.getOne(id);
		mv.addObject("guia", guia); 
									
		return mv;
	}
	
	
	 

}
