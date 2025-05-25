package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.DevOpsCourse;
import service.JavaCourse;
import service.Telusko;

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
