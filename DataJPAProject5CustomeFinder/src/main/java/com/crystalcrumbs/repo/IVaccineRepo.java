package com.crystalcrumbs.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Vaccine;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	//findBy-property-keyword
	public List<Vaccine> findByCost(Double cost);
	
	public List<Vaccine> findByCostIs(Double cost);
	
	public List<Vaccine> findByCostEquals(Double cost);
	
	public List<Vaccine> findByCostLessThanEqual(Double cost);
	
	public List<Vaccine> findByCostBetween(Double minCost, Double maxCost);
	
	public List<Vaccine> findByvaccinecompanyEquals(String cName);
	
	public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> cName,Double minCost, Double maxCost);
}
