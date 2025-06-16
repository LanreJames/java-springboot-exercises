package com.crystalcrumbs.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.view.IResultView;

public interface IVaccineService {
	List<IResultView> findByCostLessThan (Double cost);

	
}
