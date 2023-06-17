package com.fieb.tcc.academicologin.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fieb.tcc.academicologin.model.Guia;
import com.fieb.tcc.academicologin.model.User;
import com.fieb.tcc.academicologin.repository.GuiaRepository;
import com.fieb.tcc.academicologin.repository.UserRepository;
import com.fieb.tcc.academicologin.service.UserService;
import com.fieb.tcc.academicologin.web.dto.UserDto;






@Controller
public class AlunoController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userrepositorio;

	@GetMapping("/users/dashboard")
	public String dashbord(Model model) {
		
		String username = userService.getAuthenticatedUser().getEmail();
		model.addAttribute("username", username);
		
		return "aluno/dashboard-aluno";
	}
	
	@GetMapping("/users/cadastro")
	public String cadastro() {
		return "aluno/aluno-cadastro";
	}
	
	// listagem de usuarios
	
	@GetMapping("/users/user-list")
	public ModelAndView userList(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/usuario-list");
		mv.addObject("userList", userrepositorio.findAll());
	
		String username = userService.getAuthenticatedUser().getEmail();
		model.addAttribute("username", username);
		return mv;
	}
	
	// método pra exclusão de usuario
	
	
	
	//método pra edição de cadastro de usuario
	
	@GetMapping("/users/editar-user/{id}")
	public ModelAndView editarGuia(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/aluno-editar");
		User user = userrepositorio.getOne(id);
		mv.addObject("user", user); 
									
		return mv;
	} 
	
	//Método pra salvar a alteração
	@PostMapping("/users/editar-user")
	public String updatePerfilAccount(@ModelAttribute("user")UserDto userDto) {
		userService.update(userDto);
		return "redirect:/users/user-list";
	}
	
	@GetMapping("/users/perfil-teste")
	public String perfilTeste() {
		return "aluno/aluno-perfil";
	}
	
	@GetMapping("/users/front-end")
	public String frontEnd() {
		return "aluno/aluno-home";
	}
	

	
	@GetMapping("/users/salvos")
	public String salvos() {
		return "aluno/salvos";
	}
	
}
