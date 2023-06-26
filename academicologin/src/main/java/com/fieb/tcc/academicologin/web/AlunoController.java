package com.fieb.tcc.academicologin.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fieb.tcc.academicologin.model.FaleConosco;
import com.fieb.tcc.academicologin.model.Guia;
import com.fieb.tcc.academicologin.model.User;
import com.fieb.tcc.academicologin.repository.FaleConoscoRepository;
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
	
	@Autowired
	private FaleConoscoRepository faleconoscorepositorio;

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
	
	@GetMapping("/admin/user-list")
	public ModelAndView userList(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/usuario-list");
		mv.addObject("userList", userrepositorio.findAll());
	
		String username = userService.getAuthenticatedUser().getEmail();
		model.addAttribute("username", username);
		return mv;
	}

	
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
	
	//Fale conosco
	
	@GetMapping("/home/fale-conosco")
	public ModelAndView faleConoscoForm(FaleConosco faleconosco) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/fale-conosco-form");
		mv.addObject("faleconosco", new FaleConosco());
		return mv;

	}
	
	@PostMapping("inserirMensagem")
	public ModelAndView inserirMensagem(@Valid FaleConosco faleconosco, BindingResult br ) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("aluno/fale-conosco-form"); // caso tenha algum erro a tela continará em formulario
			mv.addObject("faleconosco");
		} else {

			// caso contrario ele redionará para a tela de usuarios cadastrados
			mv.setViewName("redirect:/home/fale-conosco?success"); // aqui redirecionamos para a requisição q esta no get, e
																// nao ao
			// arquivo na pasta
			faleconoscorepositorio.save(faleconosco);
		}
		return mv;
	}
	
	
	@GetMapping("/admin/mensagem")
	public ModelAndView mensagem() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/fale-conosco-list");
		mv.addObject("faleconoscoList", faleconoscorepositorio.findAll());
		mv.addObject("faleconosco", new FaleConosco());
		return mv;
	}
	
	@GetMapping("/admin/excluir-mensagem/{id}")
	public String excluirMensagem(@PathVariable("id") Long id) {
		faleconoscorepositorio.deleteById(id); 
										
		return "redirect:/admin/mensagem";
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
	
	@GetMapping("/home/sobre-nos")
	public String sobre() {
		return "aluno/sobre-nos";
	}
	
	@GetMapping("/home")
	public String home() {
		return "aluno/landingPage";
	}
}
