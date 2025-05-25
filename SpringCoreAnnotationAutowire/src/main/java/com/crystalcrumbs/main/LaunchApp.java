package com.crystalcrumbs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crystalcrumbs.service.DevOpsCourse;
import com.crystalcrumbs.service.JavaCourse;
import com.crystalcrumbs.service.Telusko;

public class LaunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Activate IOC Container
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");
		Telusko telusko = container.getBean(Telusko.class);
		
		//JavaCourse telusk = container.getBean(JavaCourse.class);
//		telusko.setCourse(container.getBean(JavaCourse.class));
//		telusko.setCourse(new DevOpsCourse());
		
		telusko.buyTheCourse(23.12);

	}

}
