package org.rsr.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {
	public static void main(String a[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/aop-spring.xml");
		ShapeService shapeServicec = context.getBean("shapeService", ShapeService.class);
		CircleModel circle = shapeServicec.getCircle();
		circle.setName("Circle One");
		//System.out.println(shapeServicec.getCircle().getName());
		System.out.println(circle.getName());
		
	}
}
