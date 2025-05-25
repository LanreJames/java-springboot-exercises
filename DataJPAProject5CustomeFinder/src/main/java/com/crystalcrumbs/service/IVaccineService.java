package com.crystalcrumbs.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;

public interface IVaccineService {

	public List<Vaccine> searchByCost(Double cost);
	
	public List<Vaccine> searchBycostIs(Double cost);
	
	public List<Vaccine> searchBycostEquals(Double cost);
	
	public List<Vaccine> searchBycostLessThanEqual(Double cost);
	
	public List<Vaccine> searchByCostBetween(Double minCost, Double maxCost);
	
	public List<Vaccine> searchByvaccinecompanyEquals(String cName);
	
	public List<Vaccine> searchByVaccineNameInAndCostBetween(Collection<String> cName,Double minCost, Double maxCost);
}
