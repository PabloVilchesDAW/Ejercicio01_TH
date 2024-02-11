package com.ejemplos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController1 {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("titulo","pasar datos al controlador con interfaz Model");
		return "index2";
	}
	
	@GetMapping("/index3")
	public String index3(ModelMap model) {
		model.addAttribute("titulo","pasar datos al controlador con clase ModelMap");
		return "index2";
	}
	
	@GetMapping("/index4")
	public String index4(Map<String, Object> map) {
		map.put("titulo", "pasar datos al controlador con interfaz Mapa");
		return "index2";
	}
	
	@GetMapping("/index5")
	public ModelAndView index5(ModelAndView mv) {
		mv.addObject("titulo", "pasar datos al controlador con interfaz ModelAndView");
		mv.setViewName("index2");
		return mv;
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Pablo");
		usuario.setApellido("Vilches");
		usuario.setEmail("invent@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	
	@RequestMapping("/listar1")
	public String listar1(Model model) {
		//habria que crear una lista de usuarios previamente
		List<Usuario> usuarios=new ArrayList<Usuario>();
		model.addAttribute("titulo","Listado de Usuarios");
		model.addAttribute("usuarios", usuarios);
		
		return "listar1";
	}
	
	@GetMapping("/listar2")
	public String listar2(Model model) {
		/*
		 * Usuario usuario1=new Usuario("Pablo","Vilches","invent@gmail.com"); Usuario
		 * usuario2=new Usuario("Juan","Perez","invent@gmail.com"); Usuario usuario3=new
		 * Usuario("Manuel","Acedo","invent@gmail.com"); List<Usuario> usuarios=new
		 * ArrayList<Usuario>(); usuarios.add(usuario1); usuarios.add(usuario2);
		 * usuarios.add(usuario3);
		 */
		model.addAttribute("titulo","Listado de Usuarios");
		//model.addAttribute("usuarios", usuarios);
		return "listar1";
	}
	
	//pasar datos a la vista con modelAtribute
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios=Arrays.asList(
				new Usuario("Pablo","Vilches","invent@invent.com"),
				new Usuario("Juan","Perez","invent@invent.com"),
				new Usuario("Manuel","Gandia","invent@invent.com")
				);
		return usuarios;
	}

}
