package com.crystalcrumbs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
		
		//service.findByVaccineCompany("Pfizer").forEach(v->System.out.println(v));
		service.findByVaccineCompanies("Astrazenecca", "Crystal Crumbs").forEach(v->System.out.println(v));
		System.out.println("******************************************");
		service.fetchByVaccineCost(342.2,405.3).forEach(v->System.out.println(v));
		System.out.println("******************************************");
//		int id = service.updateCostByVaccineName(321.4, "ChickenPox");
//		System.out.println("Total Number of Rows affected "+id);
		
//		int deletedRow = service.deleteTheVaccineByVaccineName("CovidShield");
//		System.out.println("Total Number of Rows deleted "+deletedRow);
		
//		int affectedRow = service.insertTheVaccineInfo(300, "Scented", "Ehis", 27.4);
//		System.out.println("Total Number of Rows deleted "+affectedRow);
		
		int id = service.updateTheVaccineById("Scented", 300);
		System.out.println("Total Number of Rows affected "+id);
		
	}

}
