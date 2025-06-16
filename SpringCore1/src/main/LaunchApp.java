package main;

import service.JavaCourse;
import service.Telusko;

public class LaunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Telusko telusko = new Telusko();//Target Object/Class---Class where there methods will be used
		telusko.setCourse(new JavaCourse());//Dependent Object---object used by someone else
		//SetCourse Setter Injection
		
		boolean status=telusko.buyTheCourse(20.6);
		
		if (status)
			System.out.println("Enrolled to course");
		else
			System.out.println("Failed to enroll");

	}

}
