package org.siva.ravipati.javabrains;


import javax.persistence.OneToOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.siva.ravipati.javabrains.dto.FourWheeler;
import org.siva.ravipati.javabrains.dto.TwoWheeler;
import org.siva.ravipati.javabrains.dto.UserDetails;
import org.siva.ravipati.javabrains.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) throws HibernateException, ClassNotFoundException {
		System.out.println("HibernateTest");
		
		
		SessionFactory sf = new Configuration().configure("oracleconfig.cfg.xml").buildSessionFactory();
		System.out.println("Connection Established");
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1); // will not hit db, because it will look object in session
		session.getTransaction().commit();

		session.close();
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		UserDetails user1 = (UserDetails) session2.get(UserDetails.class, 1);// will hit db, because it is another session
		session2.getTransaction().commit();
		
	}
}
