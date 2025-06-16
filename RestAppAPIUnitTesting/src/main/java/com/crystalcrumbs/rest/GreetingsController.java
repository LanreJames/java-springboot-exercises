package com.crystalcrumbs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Student;
import com.crystalcrumbs.service.IGreetingsService;

@RestController
public class GreetingsController {
	
	@Autowired
	private IGreetingsService service;
	
	@GetMapping("/greet1")
	
	public String getWish() {
		String response= service.generategreetings();
		return response;
	}
	
	
	@PostMapping("/add-stu")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		System.out.println(student);
		//String res = "Student added successfully";
		Boolean status=service.addStudent(student);
		if(status) {
			String res="Student data inserted successfully";
			return new ResponseEntity<String>(res,HttpStatus.CREATED);
		}else {
			String res="Student data iError";
			return new ResponseEntity<String>(res,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		//return new ResponseEntity<String>(res,HttpStatus.CREATED);
	}
	
	

}
