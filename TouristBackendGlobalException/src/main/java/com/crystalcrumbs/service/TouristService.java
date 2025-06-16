package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.exception.TouristNotFoundException;
import com.crystalcrumbs.model.Tourist;
import com.crystalcrumbs.repo.ITouristRepo;

@Service
public class TouristService implements ITouristService {
	
	private ITouristRepo repo;
	
	@Autowired
	public void setRepo(ITouristRepo repo) {
		this.repo = repo;
	}

	@Override
	public String registerTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		Tourist tr = repo.save(tourist);
		
		return "Tourist information registered by id "+tr.getId();
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		
//		Optional<Tourist> optional = repo.findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		else
//			throw new TouristNotFoundException("Tourist Not Found");
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist Not Found"));
	}

	@Override
	public List<Tourist> fetchAllTouristInfo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String updateTouristInfo(Tourist tourist) {
		Optional<Tourist> optional = repo.findById(tourist.getId());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist saved successfully"; 
		}
		throw new TouristNotFoundException("Tourist Not Found");
	}

	@Override
	public String updateTheTouristBudget(Integer id, Double budget) {
		Optional<Tourist> optional = repo.findById(id);
		
		
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist info updated successfully";
		}
			
		throw new TouristNotFoundException("Tourist Not Found");
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);	
		
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Tourist with id "+id+" deleted" ;
		}
		throw new TouristNotFoundException("Tourist Not Found");
	}

}
