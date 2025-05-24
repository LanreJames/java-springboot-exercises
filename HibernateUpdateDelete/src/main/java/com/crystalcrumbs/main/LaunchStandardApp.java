package com.crystalcrumbs.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crystalcrumbs.model.Student;

public class LaunchStandardApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		boolean flag = false; 
		
		config= new Configuration();
		config.configure();
		sessionFactory= config.buildSessionFactory();
		session = sessionFactory.openSession();
		
		Student student= new Student();
		
		student.setId(2);
		student.setName("Majekodunmu");
		student.setCity("Agbara");
		
		try {
			transaction=session.beginTransaction();
			session.persist(student);
			flag=true;
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch ( Exception e) {
			e.printStackTrace();
		}finally {
			if (flag==true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
		
	}

}
