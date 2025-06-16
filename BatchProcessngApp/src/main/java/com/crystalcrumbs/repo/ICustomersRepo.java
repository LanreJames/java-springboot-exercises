package com.crystalcrumbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Customers;

@Repository
public interface ICustomersRepo extends JpaRepository<Customers, String> {

}
