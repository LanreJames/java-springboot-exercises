package com.crystalcrumbs.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Vaccine;

@Repository
public interface IVaccineRepo extends CrudRepository<Vaccine, Integer> 
{
	
	

}
