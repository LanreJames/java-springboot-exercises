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
		
		//service.fetchVaccineInfoBySorting(false, "vaccineName","vaccinecompany").forEach(v->System.out.println(v));
		//service.fetchVaccineInfoByPaging(1,2,true,"vaccinecompany", "vaccineName").forEach(v->System.out.println(v));
		service.fetchVaccineInfoByPaging(2);
	}

}
