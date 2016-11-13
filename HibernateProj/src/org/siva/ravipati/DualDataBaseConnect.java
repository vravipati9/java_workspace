package org.siva.ravipati;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DualDataBaseConnect {
	    SessionFactory sessionFactory1 = new  Configuration().configure("oracleconfig.cfg.xml").buildSessionFactory();
	    SessionFactory sessionFactory2 = new Configuration().configure("derbyconfig.cfg.xml").buildSessionFactory();
	    Session session = null;
	    Transaction transaction = null;
	    public void findAllEmployees() {
	        ArrayList<Employee> empList = new ArrayList();
	               try {
	            session = sessionFactory1.openSession();
	            transaction = session.beginTransaction();
	            //transaction.begin();
	            Criteria crit = session.createCriteria(Employee.class);
	            empList = (ArrayList) crit.list();
	             System.out.println("Records from Oracle Database");
	            for (Employee emp : empList) {
	                System.out.println(emp.getEmpid() + " " + emp.getEmpname() );
	            }
	            session.close();
	            session = sessionFactory2.openSession();
	            Criteria crit1 = session.createCriteria(Employee.class);
	            empList = (ArrayList) crit1.list();
	            System.out.println("Records from Derby Database");
	            for (Employee emp : empList) {
	                System.out.println(emp.getEmpid() + " " + emp.getEmpname() );
	            }
	            session.close();
	        } catch (Exception he) {
	            he.printStackTrace();
	        }
	    }
		public void insertEmployee(Employee e) {
	        try {
	            session = sessionFactory1.openSession();
	            transaction = session.beginTransaction();
	            
	            session.save(e);
	            transaction.commit();
	            session.close();
	            session = sessionFactory2.openSession();
	            transaction = session.beginTransaction();
	            
	            session.save(e);
	            transaction.commit();
	            session.close();
	        } catch (HibernateException he) {
	            he.printStackTrace();
	        }
	    }
	}


	class Employee {
		private String empid;
		private String empname;
		public String getEmpid() {
			return empid;
		}
		public void setEmpid(String empid) {
			this.empid = empid;
		}
		public String getEmpname() {
			return empname;
		}
		public void setEmpname(String empname) {
			this.empname = empname;
		}
		
		
	}