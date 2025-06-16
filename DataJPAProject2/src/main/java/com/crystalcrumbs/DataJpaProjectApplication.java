package com.crystalcrumbs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.crystalcrumbs.model.Vaccine;
import com.crystalcrumbs.service.VaccineService;



@SpringBootApplication
public class DataJpaProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(DataJpaProjectApplication.class, args);
		VaccineService service = container.getBean(VaccineService.class);
		
//		String status = service.registerVaccineDetails(new Vaccine("CovidShield","Astrazenecca",342.2));
//		String status = service.registerVaccineDetails(new Vaccine("ChickenPox","Pfizer",4309.2));
//		System.out.println(status);
		
		List<Vaccine> vaccines = new ArrayList<>();
//		
//		vaccines.add(new Vaccine("Conixa","Evans",200.3));
//		vaccines.add(new Vaccine("Recorder","CrystalCrumbs",405.3));
		vaccines.add(new Vaccine("HireTeacher","Crystal Crumbs",400.0));
		
		//option 1
//		Iterable<Vaccine> vac = service.registerMultipleVaccies(vaccines);
//		for(Vaccine v : vac) {
//			System.out.println(v);
//		}
//		
//		//option2
//		Iterator<Vaccine> itr = vac.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		//option 3
		service.registerMultipleVaccies(vaccines).forEach(v->System.out.println(v));
		
//		Long count = service.getTotalVaccines();
//		System.out.println("Total vaccines available is "+count);
//		service.checkAvailability(7);
		
		//service.fetchAllVaccines().forEach(v->System.out.println(v));
		
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(54);
//		ids.add(55);
//		
//		service.fetchAllVaccinesByIds(ids).forEach(v->System.out.println(v));
		//int id=2;
//		Optional<Vaccine> optional = service.fetchVaccineById(id);
//		if(optional.isPresent()) {
//			System.out.println(optional.get());
//		}else {
//			System.out.println("No vaccine with Id "+id);
//		}
		
//		String status = service.removeVaccineById(2);
//		
//		System.out.println(status);
		
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(54);
//		ids.add(55);
//		
//		String status = service.removeVaccineByIds(ids);
//		System.out.println(status);
		
//		Vaccine vac = new Vaccine();
//		vac.setId(52);
//		vac.setCost(405.3);
//		vac.setVaccinecompany("CrystalCrumbs");
//		vac.setVaccineName("Recorder");
//		
//		String status = service.removeVaccineByVaccine(vac);
//		System.out.println(status);
//		
		
	}

}
