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
	public List<Vaccine> findByVaccineCompany(String company) {
		// TODO Auto-generated method stub
		return repo.searchByVaccineCompany(company);
	}

	@Override
	public List<Vaccine> findByVaccineCompanies(String comp1, String comp2) {
		// TODO Auto-generated method stub
		return repo.searchByVaccineCompanies(comp1, comp2);
	}

	@Override
	public List<String> fetchByVaccineCost(Double minPrice, Double maxPrice) {
		// TODO Auto-generated method stub
		return repo.searchByVaccineCost(minPrice, maxPrice);
	}

	@Override
	public int updateCostByVaccineName(Double newCost, String VaccineName) {
		// TODO Auto-generated method stub
		return repo.updateCostByVaccineName(newCost, VaccineName);
	}

	@Override
	public int deleteTheVaccineByVaccineName(String name) {
		// TODO Auto-generated method stub
		return repo.deleteVaccineByVaccineName(name);
	}

	@Override
	public int insertTheVaccineInfo(Integer id, String vaccineName, String vaccinecompany, Double cost) {
		// TODO Auto-generated method stub
		return repo.insertVaccineInfo(id, vaccineName, vaccinecompany, cost);
	}

	@Override
	public int updateTheVaccineById(String newVaccineName, Integer id) {
		// TODO Auto-generated method stub
		return repo.updateVaccineById(newVaccineName, id);
	}

	
	
}
