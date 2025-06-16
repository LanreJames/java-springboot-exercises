package com.crystalcrumbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Vaccine;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	
	

}
