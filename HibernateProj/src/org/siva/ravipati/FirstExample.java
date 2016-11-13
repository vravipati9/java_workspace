
package org.siva.ravipati;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FirstExample {
	public static void main(String[] args) {
		Session session = null;
		Configuration config = null;
		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			//config = new Configuration().configure("hibernate.cfg.xml");
			//SessionFactory sessionFactory = config.buildSessionFactory();
			//session =sessionFactory.openSession();
			 	session = HibernateUtil.getSessionFactory().openSession();
				
			 	org.hibernate.Transaction tx  = session.beginTransaction();
			 	Contact contact = new Contact();
			 	System.out.println("Inserting Record1");
				contact.setId(6);
				contact.setFirstName("siva");
				contact.setLastName("rp");
				contact.setEmail("siva@abc.com");
				System.out.println("Inserting Record2");
				session.save(contact);
				System.out.println("Inserting Record3");
				session.flush();
				System.out.println("Done");
				
				tx.commit();
				Contact ct = (Contact)session.load(Contact.class,contact.getId());
				System.out.println("ct.getEmail().."+ct.getEmail());
				
		}catch(Exception e){
			System.out.println("ex.."+e);
			System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			
			//session.close();

			}
		
	}
}
