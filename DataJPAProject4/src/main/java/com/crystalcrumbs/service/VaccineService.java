package com.crystalcrumbs.service;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public Vaccine fetchVacineById(Integer id) {
		return repo.getReferenceById(id);
		//return null;
	}

	@Override
	public List<Vaccine> fetchVaccineByInfo(Vaccine vac) {
		
		
		Example<Vaccine> example = Example.of(vac);
		return repo.findAll(example);
		//return null;
	}

	@Override
	public String removeVaccineByGivenIds(Iterable<Integer> ids) {
		List<Vaccine> vaccines = repo.findAllById(ids);
		if(vaccines.size()!=0) {
			repo.deleteAllByIdInBatch(ids);
			return "vaccines deleted for the given ids";
		}
		
		return "Unable to delete records";
	}

//	@Override
//	public String removeVaccineByentity(List <Vaccine> vac) {
//		// TODO Auto-generated method stub
//		List<Integer> ids = vac.stream()
//                .map(Vaccine::getId)
//                .toList();
//
//		// Fetch existing IDs from the DB
//		List<Integer> existingIds = repo.findAllById(ids)
//		                    .stream()
//		                    .map(Vaccine::getId)
//		                    .toList();
//		
//		// Find missing IDs
//		List<Integer> missingIds = ids.stream()
//		                  .filter(id -> !existingIds.contains(id))
//		                  .toList();
//		
//		if (!missingIds.isEmpty()) {
//		return "Cannot delete. Vaccines with IDs " + missingIds + " not found.";
//		}
//		
//		// All IDs exist, safe to delete
//		repo.deleteAllInBatch(vac);
//		return vac.size() + " vaccine(s) deleted successfully!";
//	}

	@Override
	public String removeVaccineByentity(List <Vaccine> vac) {
		// TODO Auto-generated method stub
		List<Integer> ids = vac.stream()
                .map(Vaccine::getId)
                .toList();

		// Fetch existing IDs from the DB
		List<Integer> existingIds = repo.findAllById(ids)
		                    .stream()
		                    .map(Vaccine::getId)
		                    .toList();
		
		//Found Ids
		List<Integer> foundIds = ids.stream()
				.filter(existingIds::contains)
				.toList();
		
		// Find missing IDs
				List<Integer> missingIds = ids.stream()
				                  .filter(id -> !existingIds.contains(id))
				                  .toList();
		
		if(!foundIds.isEmpty()) {
			repo.deleteAllByIdInBatch(foundIds);
			
			if(!missingIds.isEmpty()) {
				return "Vaccines with id's "+foundIds+" were deleted while ids "+missingIds+" were not found";
			}else {
				return "All Ids were successfully deleted";
			}
				
		}else {
			return "No vaccine was found";
		}
		
		
//		if (!missingIds.isEmpty()) {
//		return "Cannot delete. Vaccines with IDs " + missingIds + " not found.";
//		}
		
		// All IDs exist, safe to delete
//		repo.deleteAllInBatch(vac);
//		return vac.size() + " vaccine(s) deleted successfully!";
//	
	}
	

	

}
