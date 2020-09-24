package com.alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String showAdmin(Model model, @ModelAttribute("adminUpdate") Admin admin) {
		
		model.addAttribute("admin", admin);
		System.out.println("ShowAdmin: " + admin);
		
		return "admin";
	}

	// Atiende el request de tipo POST
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, RedirectAttributes ra) {
		
		System.out.println(adminForm);
		
		if (adminService.saveOrUpdate(adminForm)) {
			// Flash Attribute persiste entre diferentes Controladores
			ra.addFlashAttribute("resultado", "Cambios realizados correctamente :)");
		} else {
			// Flash Attribute persiste entre diferentes Controladores
			ra.addFlashAttribute("resultado", "Cambios no realizados :(");
		}
		// Se cambió el nombre del Flash Attribute de "resultadoSaveOrUpdate" a "resultado"
		// para reutilizar luego el mismo nombre del atributo del Modelo en la Vista

		// Redirección al Método Controlador para index "/" en IndexController
		return "redirect:/";
	}
	
	@RequestMapping("admin/{idAdmin}/update")
	public String handleAdminPreUpdate(@PathVariable("idAdmin") int id, RedirectAttributes ra) {
		
		Admin admin = adminService.findById(id);
		System.out.println("PreUpdate: " + admin);
		
		ra.addFlashAttribute("adminUpdate", admin);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("admin/{idAdmin}/delete")
	public String handleAdminDelete(@PathVariable("idAdmin") int id, RedirectAttributes ra) {
		
		if (adminService.delete(id)) {
			ra.addFlashAttribute("resultado", "Registro eliminado correctamente :)");
		} else {
			ra.addFlashAttribute("resultado", "Registro no eliminado :(");
		}
		// Se usa "resultado" como nombre del Flash Attribute
		// para reutilizar luego el mismo nombre del atributo del Modelo en la Vista
		
		return "redirect:/";
	}

}
