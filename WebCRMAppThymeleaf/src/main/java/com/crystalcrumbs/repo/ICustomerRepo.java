package com.crystalcrumbs.repo;

import org.springframework.data.repository.CrudRepository;

import com.crystalcrumbs.model.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
