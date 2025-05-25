package com.crystalcrumbs.service;

import org.springframework.stereotype.Service;

@Service
public class JavaCourse implements ICourse {

	public JavaCourse() {
		//super();
		System.out.println("Java Bean Created");
	}

	@Override
	public boolean getTheCourse(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Java Course Is Purchased and amount paid is "+ amount);
		return true;
	}

}
