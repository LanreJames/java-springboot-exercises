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
		
//		Vaccine v = service.fetchVacineById(53);
//		System.out.println(v);
		
//		service.fetchVaccineByInfo(new Vaccine ("HireTeacher","CrystalCrumbs",405.3))
//		.forEach(v->System.out.println(v));
		
//		ArrayList ids = new ArrayList<>();
////		ids.add(53);
////		ids.add(102);
//		ids.add(104);
		
//		String status=service.removeVaccineByGivenIds(ids);
//		System.out.println(status);
		
		ArrayList ids = new ArrayList<>();
		ids.add(new Vaccine (154,"HireTeacher","CrystalCrumbs",400.0));
		ids.add(new Vaccine (103,"HireTeachers","CrystalCrumbs",405.3));
		String status = service.removeVaccineByentity(ids);
		System.out.println(status);
		
		
		
	}

}
