package org.rsr.jdbc;

import org.rsr.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBCDemo {
	public static void main(String ...strings) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-spring.xml");
		System.out.println("Connecting to Database..");
		JdbcDAOImpl dao = context.getBean("jdbcDAOImpl", JdbcDAOImpl.class);
		//Executives o = (Executives)dao.findByCustomerId(1001);
		//System.out.println(o.getEmpId()+" , "+o.getFirstName()+" , "+o.getLastName()+" , "+o.getState());
		
		System.out.println("Number of Executives>>"+dao.getExecutivesCount());
		
		System.out.println("Executive First Name>>>"+dao.getExecutiveName(1001));
		
		//Executives executives = dao.getExecutiveForID(1001);
		//System.out.println("Executive Details ::state ["+executives.getState()+"]   last_name ["+executives.getLastName()+"]   ");
		
		Executives e = new Executives();
		e.setEmpId("1005"); e.setFirstName("krishna"); e.setLastName("ravi"); e.setState("MP");
		//dao.insert(e);
		System.out.println("Number of Executives after insert>>"+dao.getExecutivesCount());
		
		//By using Spring DAO Support class
		SimpleJdbcDAOImpl simpleDao = context.getBean("simpleJdbcDAOImpl", SimpleJdbcDAOImpl.class);
		System.out.println(simpleDao.getExecutivesCount());
		
	}
	 
}
