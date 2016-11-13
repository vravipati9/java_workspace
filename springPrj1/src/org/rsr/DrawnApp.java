package org.rsr;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawnApp {
	public static void main(String a[]) {
		/*

		 */
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		 
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//For desktop application context we need to register hook for shutdown. means when the application ends 
		//it executes AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		
		//bean alias
		//Triangle triangle = (Triangle)context.getBean("triangle-alias");
		 
		Shape shape = (Shape)context.getBean("triangle");
		//Shape shape = (Shape)context.getBean("square"); // code to an interface
		shape.draw();
		System.out.println(context.getMessage("points", new Object[] {"siva" , "ravipati"}, "Default Greeting", null));
		
		
		SpringLifeCycle springLifeCycle = (SpringLifeCycle)context.getBean("springLifeCycle");
		System.out.println();
		
		
	}
}
