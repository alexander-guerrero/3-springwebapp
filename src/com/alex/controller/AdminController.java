package com.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alex.pojo.Admin;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin";
	}

}
