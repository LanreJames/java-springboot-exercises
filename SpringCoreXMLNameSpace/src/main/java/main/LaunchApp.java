package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.Employee;

public class LaunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");
		
//		Employee emp=container.getBean(Employee.class);
//		System.out.println(emp);
		
		Employee emp=container.getBean("emp", Employee.class);
		System.out.println(emp);
		
		Employee emp1=container.getBean("emp1", Employee.class);
		System.out.println(emp1);
		
		Employee emp2=container.getBean("emp2", Employee.class);
		System.out.println(emp2);

	}

}
