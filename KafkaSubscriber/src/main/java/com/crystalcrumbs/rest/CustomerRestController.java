package com.crystalcrumbs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Customer;
import com.crystalcrumbs.service.KafkaService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private KafkaService service;
	
	
	@PostMapping("/add-customer")
	public String addCustomer(@RequestBody Customer customer) {
		return service.addCustomerMessage(customer);
	}

}
