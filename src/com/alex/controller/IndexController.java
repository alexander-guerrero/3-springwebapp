package com.alex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//@SessionAttributes({"txtAbout", "txtAdmin"}) //Variables de sesión
@SessionAttributes("txtAbout")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(HttpSession session) {
		session.setAttribute("txtIndex", "Hola desde el HttpSession :O");
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(Model model) {
		model.addAttribute("txtAbout", "Hola desde el Model con SessionAttributes :)");
		return "about";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete(); // Limpia la variable de sesión definida en SessionAttributes (txtAbout)
		model.addAttribute("txtAdmin", "Hola desde el Model :D");
		return "admin";
	}

}
