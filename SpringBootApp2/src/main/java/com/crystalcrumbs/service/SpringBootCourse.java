package com.crystalcrumbs.service;

import org.springframework.stereotype.Service;

@Service
public class SpringBootCourse implements ICourse {

	@Override
	public boolean getTheCourse(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Springboot Is Purchased and amount paid is "+ amount);
		return true;
	}

	public SpringBootCourse() {
		//super();
		System.out.println("Java Bean Created");
	}

}
