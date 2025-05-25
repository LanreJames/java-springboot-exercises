package com.crystalcrumbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Telusko {
	public Telusko() {
		//super();
		System.out.println("Telusko Bean Created");
	}

	public Telusko(ICourse course) {
		super();
		this.course = course;
	}

	private ICourse course;
	
	public boolean buyTheCourse(double amount) {
		return course.getTheCourse(amount);
	}

	@Autowired
	@Qualifier("devOpsCourse")
	public void setCourse(ICourse course) 
	{
		this.course = course;
	}	

}
