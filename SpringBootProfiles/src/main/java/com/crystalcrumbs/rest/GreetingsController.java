package com.crystalcrumbs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crystalcrumbs.service.IGreetingsService;

@Controller
public class GreetingsController {
	
	@Autowired
	private IGreetingsService service;
	
	@GetMapping("/greet1")
	@ResponseBody
	public String getWish() {
		String response= service.generategreetings();
		return response;
	}
	
	
	@GetMapping("/greet2")
	@ResponseBody
	public ResponseEntity<String> getWish2() {
		String response= service.generategreetings();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	

}
