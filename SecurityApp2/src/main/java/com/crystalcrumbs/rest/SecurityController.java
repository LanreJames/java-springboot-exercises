package com.crystalcrumbs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Alien;
import com.crystalcrumbs.model.Users;
import com.crystalcrumbs.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	@Autowired
	private UsersService service;
	
	BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder(12);
	
	
	@GetMapping("/info")
	
	public ResponseEntity<String> getInfo(HttpServletRequest request){
		
		String info = "Telusko Might Launch Gen AI" + request.getSession().getId();
		
		return new ResponseEntity<String>(info, HttpStatus.OK);	
	}
	
	
@GetMapping("/more-info")
	
	public ResponseEntity<String> getMoreInfo(HttpServletRequest request){
		
		String info = "Telusko Might Launch Spring AI" + request.getSession().getId();
		
		return new ResponseEntity<String>(info, HttpStatus.OK);	
	}

@PostMapping("/add-resource")

public ResponseEntity<Alien> addResource(@RequestBody Alien alien){
	
	//String info = "Telusko Might Launch Spring AI" ;
	
	return new ResponseEntity<Alien>(alien, HttpStatus.OK);	
}

@GetMapping("/csrf")

public CsrfToken getCsrf (HttpServletRequest request){
	
	return (CsrfToken) request.getAttribute("_csrf");//csrf is used under hood by spring
}

@PostMapping("/add-user")

public ResponseEntity<Users> addUser(@RequestBody Users user){
	
	String encodedPassword = bcrypt.encode(user.getPassword());	
	user.setPassword(encodedPassword);
	Users userDb = service.addUsers(user);
	
	return new ResponseEntity<Users>(user, HttpStatus.OK);	
}

}
