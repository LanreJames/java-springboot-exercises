package com.crystalcrumbs.service;


import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public Iterable<Vaccine> fetchVaccineInfoBySorting(boolean status, String... properties) {
		Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, properties);
		// 
		return repo.findAll(sort);
		//return null;
	}

	@Override
	public Iterable<Vaccine> fetchVaccineInfoByPaging(int pgNo, int pgSize, boolean status, String... properties) {
		// TODO Auto-generated method stub
		
		//option1
		//Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, properties);
		 //PageRequest pagereq = PageRequest.of(pgNo, pgSize, sort);
		 
		//option2
		PageRequest pagereq = PageRequest.of(pgNo, pgSize, status?Direction.ASC:Direction.DESC, properties);
		 
		Page<Vaccine> page = repo.findAll(pagereq);
		return page.getContent();
		//return null;
	}

	@Override
	public void fetchVaccineInfoByPaging(int pgSize) {
		// TODO Auto-generated method stub
		long count=8;
		long pageCount=count/pgSize;
		pageCount = count%pgSize==0?pageCount:++pageCount;
		
		for(int i=0; i<pageCount; i++) {
			PageRequest pages = PageRequest.of(i, pgSize);
			Page<Vaccine> page = repo.findAll(pages);
			page.getContent().forEach(v->System.out.println(v));
			System.out.println("*****************************");
			
		}
		
	}

	

}
