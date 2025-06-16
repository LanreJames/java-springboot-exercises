package com.crystalcrumbs.service;

import java.util.List;

import com.crystalcrumbs.model.Customer;

public interface ICustomerService {
	List<Customer> getCustomerInfo();
	void registerCustomer(Customer customer);
	Customer fetchCustomerById(Integer id);
	void deleteCustomerRecord(Integer id);

}
