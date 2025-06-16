package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;

public interface IVaccineService {
	Iterable<Vaccine> fetchVaccineInfoBySorting(boolean status, String...properties);
	
	Iterable<Vaccine> fetchVaccineInfoByPaging(int pgNo, int pgSize, boolean status, String...properties);
	
	void fetchVaccineInfoByPaging(int pgSize);

}
