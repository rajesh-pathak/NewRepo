package com.mo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class MainApp {
	//private static SessionFactory factory;
	public static void main(String args[]) {
		//create session factory
		SessionFactory sFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		//open session
		Session session=sFactory.openSession();
		
		//begin transaction
		Transaction txn=session.beginTransaction();
		
		/*
		 * Many Customers can have same complaint
		 * 
		 * So create complaint object and give same complaint object to multiple
		 * customers
		 */
		
		//create complaint object
		Complaint oc=new Complaint(11,"Test Complaint only"); 
		
		//give same complaint object to each customer
		Customer cr1=new Customer(101,"Customer_Name1",oc);
		Customer cr2=new Customer(102,"Customer_Name2",oc);
		Customer cr3=new Customer(103,"Customer_Name3",oc);
		Customer cr4=new Customer(104,"Customer_Name4",oc);
		
		session.save(cr1);
		session.save(cr2);
		session.save(cr3);
		session.save(cr4);
		
		
		/*
		 * Resource Leak - If we dont close the session and transaction 
		 * there might be a resource leak
		 */
		txn.commit();
		session.close();
		sFactory.close();
	}
}
