package com.crystalcrumbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Alien;
import com.crystalcrumbs.repo.IAlienRepo;

@Service
public class AlienService implements IAlienService {
	
	@Autowired
	private IAlienRepo repo;

	@Override
	public Alien registerAlien(Alien alien) {
		// TODO Auto-generated method stub
		
		
		return repo.save(alien);
	}

	@Override
	public List<Alien> getAllAlienInfo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
