package com.crystalcrumbs.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.view.IView;

public interface IVaccineService {
	public  <T extends IView >  List <T> findByCostLessThan (Double cost, Class <T> cls);
	
}
