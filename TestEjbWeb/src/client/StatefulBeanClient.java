package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbeans.stateful.MyBean;

/**
 * Servlet implementation class StatefulBeanClient
 */
public class StatefulBeanClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	MyBean myBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------StatefulBeanClient-------------------");
		myBean.increment(myBean);
		System.out.println("Number Retrieved from Session Bean:::::"+myBean.getNumber());
		
		myBean.increment(myBean);
		System.out.println("Number Retrieved from Session Bean:::::"+myBean.getNumber());
	}
}
