package com.alex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes({"txtAbout", "txtAdmin"}) //Variables de sesión
@SessionAttributes("txtAbout")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(HttpSession session, @ModelAttribute("resultadoSave") String resultado, Model model) {
		session.setAttribute("txtIndex", "Hola desde el HttpSession :O");
		
		// Agrega al Modelo el Flash Attribute pasado por parámetro
		model.addAttribute("respuesta", resultado);
		
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(Model model) {
		model.addAttribute("txtAbout", "Hola desde el Model con SessionAttributes :)");
		return "about";
	}

}
