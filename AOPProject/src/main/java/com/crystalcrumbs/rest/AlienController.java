package com.crystalcrumbs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Alien;
import com.crystalcrumbs.service.IAlienService;

@RestController
public class AlienController {
	
	@Autowired
	private IAlienService service;
	
	
	@PostMapping("/add-alien")
	public ResponseEntity<Alien> registerAlien(@RequestBody Alien alien){
		
		Alien response = service.registerAlien(alien);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@GetMapping("/get-alien")
	public ResponseEntity<List> fetchAlien(){
		List<Alien> response = service.getAllAlienInfo();
		
		return new ResponseEntity<List>(response,HttpStatus.OK);
		
		
	}
}
