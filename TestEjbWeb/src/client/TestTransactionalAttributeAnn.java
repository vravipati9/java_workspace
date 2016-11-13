package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbeans.transactionAnnotation.OuterBean;

public class TestTransactionalAttributeAnn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	OuterBean outerBean;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("*************Client called****************");
			outerBean.insertUser();
		} catch (Exception e) {
			System.out.println("In Client classs Exception caught");
		}
	}
}
