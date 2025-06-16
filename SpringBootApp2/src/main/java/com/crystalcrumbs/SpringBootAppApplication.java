package com.crystalcrumbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.crystalcrumbs.service.Telusko;



@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBootAppApplication.class, args);
		
		Telusko telusko = container.getBean(Telusko.class);
		boolean status =telusko.buyTheCourse(30.23);
		if(status) {
			System.out.println("Value printed");
		}else {
			System.out.println("No Brain");
		}
		
	
	}

}
