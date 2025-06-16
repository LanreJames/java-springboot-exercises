package com.crystalcrumbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {
	
	@RequestMapping("/info/{name}/{course}")
	public String displayInfo(@PathVariable("name")String name, @PathVariable("course") String course, Model model) {
		
		String response = "Hello! "+name+" Welcome to Banks "+course+" Stuff";
				model.addAttribute("info", response);
		
				return "index";
		
	}
	


}
