package org.rsr;
import org.rsr.Customer;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support. ClassPathXmlApplicationContext; 

public class TestCustomerBean {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Customer c = (Customer)context.getBean("customer");
		
		System.out.println(c.getCustomerName()+""+c.getCustomerId());
		System.out.println(c.getAddress().getLocation()+", "+c.getAddress().getCity());

	}
}
