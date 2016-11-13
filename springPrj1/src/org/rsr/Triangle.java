package org.rsr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//@Component
//@Service
//@Repository
//@Controller
//If we specify bean with these annotations no need to define in beans xml file. Spring container looks in side code also.
// For this we have to add <context:component-scan base-package="org.rsr"></context:component-scan>
public class Triangle implements Shape{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	public Point getPointA() {
		return pointA;
	}
	
	//@Required
	// Required annotation tell us that this bean initialization is required for Triangle
	@Autowired
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}
	//@Required
	@Autowired
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}
	//@Required
	@Autowired
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("Point A =("+getPointA().getX()+", "+getPointA().getY()+")\n"+
				"Point B =("+getPointB().getX()+", "+getPointB().getY()+")\n"+
				"Point C =("+getPointC().getX()+", "+getPointC().getY()+")\n"
				);
		System.out.println(messageSource.getMessage("greeting", null, "Default Greeting", null));
	}

	
/*	List<Point> pointsList = new ArrayList<Point>();
	
	public List<Point> getPointsList() {
		return pointsList;
	}

	public void setPointsList(List<Point> pointsList) {
		this.pointsList = pointsList;
	}

	public void draw() {
		for (Point point : pointsList) {
			System.out.println(point.getX() +", "+point.getY());
		}		
	}*/
	
	public void myInt() {
		System.out.println("MyInt method called for Triangle");
	}
	public void cleanUp() {
		System.out.println("cleanUp method called for Triangle");
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	
}
