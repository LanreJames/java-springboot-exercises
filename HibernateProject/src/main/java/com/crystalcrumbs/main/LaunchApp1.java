package com.crystalcrumbs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crystalcrumbs.model.Student;

public class LaunchApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create configuration object
		
		Configuration config = new Configuration();
		
		//Step 2---Configure --reference the herbernate config file used
		config.configure();
		
		//3 Create  session factory
		SessionFactory sessionFac = config.buildSessionFactory();
		
		//4 Get Object fom Object session factory
		Session session = sessionFac.openSession();
		
		//Create non select procedure---transaction
		Transaction trx = session.beginTransaction();
		
		Student stud = new Student();
		stud.setId(1);
		stud.setName("Baybee Kobo Banks");
		stud.setCity("Malta");
		
		//Perform operation
		session.save(stud);
		
		//7
		trx.commit();
		
		//8close session
		session.close();
	}

}
