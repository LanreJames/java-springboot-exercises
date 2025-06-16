package com.crystalcrumbs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

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
	
	
	@GetMapping("/greet2")
	
	public ResponseEntity<String> getWish2() {
		String response= service.generategreetings();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	

}
