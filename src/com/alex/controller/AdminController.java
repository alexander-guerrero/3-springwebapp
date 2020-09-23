package com.alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alex.pojo.Admin;
import com.alex.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	// Si no se indica el método HTTP, por defecto asume el request de tipo GET
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		System.out.println(admin);
		return "admin";
	}

	// Atiende el request de tipo POST
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, RedirectAttributes ra) {
		
		System.out.println(adminForm);
		
		if (adminService.save(adminForm)) {
			// Flash Attribute persiste entre diferentes Controladores
			ra.addFlashAttribute("resultadoSave", "Cambios realizados correctamente :)");
		} else {
			// Flash Attribute persiste entre diferentes Controladores
			ra.addFlashAttribute("resultadoSave", "Cambios no realizados :(");
		}

		// Redirección al Método Controlador para index "/" en IndexController
		return "redirect:/";
	}

}
