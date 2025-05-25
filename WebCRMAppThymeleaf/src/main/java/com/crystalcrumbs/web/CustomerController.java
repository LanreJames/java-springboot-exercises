package com.crystalcrumbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crystalcrumbs.model.Customer;
import com.crystalcrumbs.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/customer-info")
	public String getCustomerData(Model model) {
		List<Customer> customers = service.getCustomerInfo();
		model.addAttribute("customers", customers);
		customers.forEach(c->System.out.println(c));
		return "customerlist";
	}
	
	
	@PostMapping("/register-customer")
	public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		service.registerCustomer(customer);
		model.addAttribute("editMode", false);
		return "redirect:/customer-info";
	}
	
	@GetMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "showform";
		
	}
	
	
	@GetMapping("/update-form")
	public String updateCustomerDetails(@RequestParam("customerId")Integer id, Model model)
	{
		Customer cx = service.fetchCustomerById(id);
		model.addAttribute("customer", cx);
		model.addAttribute("editMode", true);
		return "showform";
		
	}
	
	
	@GetMapping("/delete-data")
	public String deleteCustomerDetails(@RequestParam("customerId")Integer id)
	{
		service.deleteCustomerRecord(id);
		
		return "redirect:/customer-info";
		
	}

}
