package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMainClass {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		factory = new Configuration().configure().buildSessionFactory();
		Message message  = new Message();
		message.setMessageText("Hello World!");
		Session session =factory.openSession();
		
		Transaction tnx = session.beginTransaction();
		Integer idInserted= (Integer)session.save(message);
		
		System.out.println("ID inserted is:"+idInserted);
		tnx.commit();
		session.close();
		
		
	}

}
