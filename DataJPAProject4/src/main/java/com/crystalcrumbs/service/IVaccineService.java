package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;

public interface IVaccineService {
	Vaccine fetchVacineById(Integer id);
	List <Vaccine> fetchVaccineByInfo(Vaccine vac);
	String removeVaccineByGivenIds(Iterable<Integer> ids);
	String removeVaccineByentity(List <Vaccine> vac);
	

}
