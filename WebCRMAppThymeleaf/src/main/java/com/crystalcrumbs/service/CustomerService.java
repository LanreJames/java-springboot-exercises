package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Customer;
import com.crystalcrumbs.repo.ICustomerRepo;

@Service
public class CustomerService implements ICustomerService {

private ICustomerRepo repo;
	
	
	@Autowired
	public void setRepo(ICustomerRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Customer> getCustomerInfo() {
		// TODO Auto-generated method stub
		return (List<Customer>) repo.findAll();
	}

	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		repo.save(customer);

	}

	@Override
	public Customer fetchCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> option = repo.findById(id);
		return option.get();
	}

	@Override
	public void deleteCustomerRecord(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
