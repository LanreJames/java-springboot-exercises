package com.crystalcrumbs.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crystalcrumbs.model.Student;

public class LaunchDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Configuration config = new Configuration();
//		
//		config.configure();
//		
//		config.addAnnotatedClass(Student.class)
//		
//		SessionFactory sessionFac = config.buildSessionFactory();
		
		SessionFactory sessionFac = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		boolean flag = false;
		Session session = null;
		Transaction trx = null;
		try {
			session = sessionFac.openSession();
			trx = session.beginTransaction();
			Student st = new Student();
			st.setCity("Fatai Atere");
			st.setId(3);
			st.setName("Kimmon");
			
			//session.persist(st);
			//session.delete(st);
			
			session.remove(st);
			flag =true;
		}catch(HibernateException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(flag==true) {
				trx.commit();
			}else {
				trx.rollback();
			}
			session.close();
			sessionFac.close();
		}
		
		//Create non select procedure---transaction
		

	}

}
