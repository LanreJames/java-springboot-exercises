package com.crystalcrumbs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Tourist;
import com.crystalcrumbs.service.ITouristService;

@RestController
public class TouristController {
	
	private ITouristService service;

	@Autowired
	public void setService(ITouristService service) {
		this.service = service;
	}
	
	@PostMapping("/register-tourist")
	public ResponseEntity<String> registerTourist (@RequestBody Tourist tourist){
		
		String res = service.registerTourist(tourist);
		
		return new ResponseEntity<String>(res,HttpStatus.CREATED);
	}
	
	
	@GetMapping("get-tourist/{id}")
	public ResponseEntity<?> getTourist(@PathVariable("id") Integer id){
	
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-tourist")
	public ResponseEntity<?> updateTourist (@RequestBody Tourist tourist){
		
			String res = service.updateTouristInfo(tourist);
			return new ResponseEntity<String>(res,HttpStatus.OK);
			
		
	}
	
	
	@PatchMapping("/update-budget/{id}/{budget}")
	public ResponseEntity<?> updateTourist (@PathVariable("id")Integer id,@PathVariable("budget") Double budget){
		
			String res = service.updateTheTouristBudget(id, budget);
			return new ResponseEntity<String>(res,HttpStatus.OK);
			
		
	}
	
	@DeleteMapping("/delete-tourist/{id}")
	public ResponseEntity<?> deleteTourist (@PathVariable("id")Integer id){
		
			String res = service.deleteTouristById(id);
			return new ResponseEntity<String>(res,HttpStatus.OK);
			
		
		
	}
	
	@GetMapping("get-tourist")
	public ResponseEntity<?> getTourist(){
		
			 List<Tourist> tourist = service.fetchAllTouristInfo();
			return new ResponseEntity<List>(tourist,HttpStatus.OK);
		
		
	}

}
