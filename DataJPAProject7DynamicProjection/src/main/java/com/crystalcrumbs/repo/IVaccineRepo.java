package com.crystalcrumbs.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.view.IView;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	public <T extends IView >  List <T> searchByCostLessThan (Double cost, Class <T> cls);
}