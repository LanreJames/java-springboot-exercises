package com.crystalcrumbs.service;


import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.repo.IVaccineRepo;
import com.crystalcrumbs.view.IResultView;

@Service
public class VaccineService implements IVaccineService {
	
	
	private IVaccineRepo repo;
	
	@Autowired
	public void setRepo(IVaccineRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<IResultView> findByCostLessThan(Double cost) {
		
		return repo.searchByCostLessThan(cost);
	}

	
	
}
