package com.crystalcrumbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.crystalcrumbs.model.Employee;

@Controller
public class EmployeeController {
	
	
	@GetMapping("/register")
	public String getHomePage() {
		
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerEmployee(Model model,Employee emp) {
		
		System.out.println(emp);
		model.addAttribute("emp", emp);
		return "response";
	}

}
