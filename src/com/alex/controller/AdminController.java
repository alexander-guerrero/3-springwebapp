package com.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alex.pojo.Admin;

@Controller
public class AdminController {

	// Si no se indica el m�todo HTTP, por defecto asume el request de tipo GET
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		System.out.println(admin);
		return "admin";
	}

	// Atiende el request de tipo POST
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model) {
		model.addAttribute("adminForm", adminForm);
		System.out.println(adminForm);
		return "index";
	}

}
