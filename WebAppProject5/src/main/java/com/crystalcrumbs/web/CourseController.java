package com.crystalcrumbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crystalcrumbs.model.Course;

@Controller
public class CourseController {
	
	@GetMapping("/course-info")
	public String getCourseInfo(Model model) {
		
		
		Course course = new Course(10,"AI Devops",897.9);
		model.addAttribute("course",course);
		System.out.println("Reaching Here");
		return "index";
	}
	
	
	@GetMapping("/books-info")
	public String getBooksInfo(Model model) {
	    String booksName[] = new String[] {"Rankxe", "SlimyNinky", "BaybeeBanks"};
	    model.addAttribute("books", booksName);
	    return "book"; // loads book.jsp
	}

}
