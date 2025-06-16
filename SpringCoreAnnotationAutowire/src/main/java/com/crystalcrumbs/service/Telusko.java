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

	@Autowired
	
	public Telusko(@Qualifier("devOpsCourse")ICourse course) {
		super();
		this.course = course;
	}
//	@Autowired
//	@Qualifier("javaCourse")
	private ICourse course;
	
	public boolean buyTheCourse(double amount) {
		return course.getTheCourse(amount);
	}
//@Autowired
//@Qualifier("springBootCourse")
	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	

}
