package com.crystalcrumbs.service;


import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.repo.IVaccineRepo;

@Service
public class VaccineService implements IVaccineService {
	
	
	private IVaccineRepo repo;
	
	@Autowired
	public void setRepo(IVaccineRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Vaccine> searchByCost(Double cost) {
		// TODO Auto-generated method stub
		return repo.findByCost(cost);
		//return null;
	}

	@Override
	public List<Vaccine> searchBycostIs(Double cost) {
		// TODO Auto-generated method stub
		return repo.findByCostIs(cost);
	}

	@Override
	public List<Vaccine> searchBycostEquals(Double cost) {
		// TODO Auto-generated method stub
		return repo.findByCostEquals(cost);
	}

	@Override
	public List<Vaccine> searchBycostLessThanEqual(Double cost) {
		// TODO Auto-generated method stub
		return repo.findByCostLessThanEqual(cost);
	}

	@Override
	public List<Vaccine> searchByCostBetween(Double minCost, Double maxCost) {
		// TODO Auto-generated method stub
		return repo.findByCostBetween(minCost, maxCost);
	}

	@Override
	public List<Vaccine> searchByvaccinecompanyEquals(String cName) {
		// TODO Auto-generated method stub
		return repo.findByvaccinecompanyEquals(cName);
	}

	@Override
	public List<Vaccine> searchByVaccineNameInAndCostBetween(Collection<String> cName,Double minCost, Double maxCost) {
		// TODO Auto-generated method stub
		return repo.findByVaccineNameInAndCostBetween(cName,minCost, maxCost);
	}

	
	

	

}
