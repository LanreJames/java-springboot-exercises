package main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import util.Employee;

public class LaunchLayInit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bean Factory
		//Lazy Loading
		DefaultListableBeanFactory container = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(container);
		
		reader.loadBeanDefinitions("applicationconfig.xml");
		
		Employee emp=container.getBean("emp", Employee.class);
		System.out.println(emp);

	}

}
