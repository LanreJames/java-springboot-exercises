package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;

public interface IVaccineService {
	String registerVaccineDetails(Vaccine vaccine);
	Iterable registerMultipleVaccies(Iterable<Vaccine> vaccines);
	Long getTotalVaccines();
	Boolean checkAvailability(Integer id);
	Iterable<Vaccine> fetchAllVaccines();
	Iterable<Vaccine> fetchAllVaccinesByIds(Iterable<Integer> ids);
	
	Optional<Vaccine> fetchVaccineById(Integer id);
	String removeVaccineById(Integer id);
	String removeVaccineByVaccine(Vaccine vac);
	String removeVaccineByIds(List<Integer> ids);

}
