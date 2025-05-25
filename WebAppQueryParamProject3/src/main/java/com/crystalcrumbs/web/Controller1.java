package com.crystalcrumbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {
	
	@RequestMapping("/info")
	public String displayInfo(String name, Model model) {
		
		String response = "Hello! "+name+" Welcome to Banks MVC Stuff";
				model.addAttribute("info", response);
		
				return "index";
		
	}
	


}
