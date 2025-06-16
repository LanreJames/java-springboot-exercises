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
		
//		service.searchByCost(342.2).forEach(v->System.out.println(v));
//		System.out.println("***************************");
//		service.searchBycostIs(342.2).forEach(v->System.out.println(v));
//		System.out.println("***************************");
//		service.searchBycostEquals(342.2).forEach(v->System.out.println(v));
//		System.out.println("***************************");
//		service.searchBycostLessThanEqual(342.2).forEach(v->System.out.println(v));
//		System.out.println("***************************");
//		service.searchByCostBetween(342.2, 4309.2).forEach(v->System.out.println(v));
		
		//service.searchByvaccinecompanyEquals("CrystalCrumbs").forEach(v->System.out.println(v));
		
		Collection<String> names =new HashSet<>();
		names.add("Conixa");
		names.add("Recorder");
		names.add("CovidShield");
		names.add("HireTeacher");
		
		//service.searchByVaccineNameInAndCostBetween(342.2, 4309.2, Collection).forEach(v->System.out.println(v));
		service.searchByVaccineNameInAndCostBetween(names,342.2, 4309.2).forEach(v->System.out.println(v));
		
		
		
		
	}

}
