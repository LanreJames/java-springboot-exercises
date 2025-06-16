package com.crystalcrumbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.repo.IVaccineRepo;

@Service
public class VaccineService implements IVaccineService {
	
	@Autowired
	private IVaccineRepo repo;

	@Override
	public String registerVaccineDetails(Vaccine vaccine) {
		// TODO Auto-generated method stub
		Vaccine vac = repo.save(vaccine);
		return "Vaccine information stored with id "+vac.getId();
	}

	@Override
	public Iterable registerMultipleVaccies(Iterable<Vaccine> vaccines) {
		// TODO Auto-generated method stub
		return repo.saveAll(vaccines);
		//return null;
	}

	@Override
	public Long getTotalVaccines() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	@Override
	public Boolean checkAvailability(Integer id) {
		// TODO Auto-generated method stub
		boolean status = repo.existsById(id);
		if (status) {
			System.out.println("Vaccine with id "+ id+" is available");
		}else {
			System.out.println("Vaccine with id "+ id+" is unavailable");
		}
		return status;
	}

	@Override
	public Iterable<Vaccine> fetchAllVaccines() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Iterable<Vaccine> fetchAllVaccinesByIds(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return repo.findAllById(ids);
	}

	@Override
	public Optional<Vaccine> fetchVaccineById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
		//return Optional.empty();
	}

	@Override
	public String removeVaccineById(Integer id) {
		// TODO Auto-generated method stub
//		Optional<Vaccine> optional = repo.findById(id);
//		if(optional.isPresent()) {
//			repo.deleteById(id);
//			return "Vaccine Record of Id "+id+" is deleted";
//		}
		//return "there is no such record";
		
		boolean status = repo.existsById(id);
		if(status) {
			repo.deleteById(id);
			return "Vaccine Record of Id "+id+" is deleted";
		}
		return "there is no such record";
	}

	@Override
	public String removeVaccineByVaccine(Vaccine vac) {
		// TODO Auto-generated method stub
		Integer id = vac.getId();
		boolean status = repo.existsById(id);
		//boolean status = repo.existsById(id);
		if(status) {
			repo.deleteById(id);
			
			return "Vaccine Record of Id "+id+" is deleted";
		}
		
		return "there is no such record";
	}

	@Override
	public String removeVaccineByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		List <Vaccine> vaccines=(List<Vaccine>)repo.findAllById(ids);
		int count1=ids.size();
		int count2=vaccines.size();
		if (count2>0) {
			repo.deleteAllById(ids);
			return "Deleted all selected Id";
					}
		//int count2=v
		return "No Data Deleted";
	}

}
