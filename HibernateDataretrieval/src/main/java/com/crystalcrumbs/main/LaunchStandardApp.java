package com.crystalcrumbs.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.crystalcrumbs.model.Student;

public class LaunchStandardApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionFac = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		boolean flag = false;
		Session session = null;
		
		try {
			
			session = sessionFac.openSession();
//			Student student = session.get(Student.class, 2);
			//Student student = session.load(Student.class, 2);
			Student student = session.getReference(Student.class, 2);
			System.out.println("Id "+ student.getId());
			System.out.println("Id "+ student.getCity());
			System.out.println("Name "+ student.getName());
//			if (student != null) {
//			    System.out.println("value " + student);
//			} else {
//			    System.out.println("Student not found!");
//			}

			//System.out.println("value "+student);
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch ( Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFac.close();
		}
		
	}

}
