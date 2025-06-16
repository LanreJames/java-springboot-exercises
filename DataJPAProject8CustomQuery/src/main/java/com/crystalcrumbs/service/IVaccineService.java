package com.crystalcrumbs.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import com.crystalcrumbs.model.Vaccine;

public interface IVaccineService {
	public List <Vaccine> findByVaccineCompany(String company);
	public List <Vaccine> findByVaccineCompanies(String comp1,String comp2);
	public List<String> fetchByVaccineCost(Double minPrice, Double maxPrice);
	public int updateCostByVaccineName(Double newCost,String VaccineName);
	public int deleteTheVaccineByVaccineName(String name);
	public int insertTheVaccineInfo(Integer id, String vaccineName, String vaccinecompany, Double cost);
	public int updateTheVaccineById(String newVaccineName, Integer id);
	
}

