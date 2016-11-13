package com.javaworld.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaworld.email.dao.DummyEmailDao;
import com.javaworld.email.dao.EmailDao;

public class DisplayEmailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering DisplayEmailsAction.execute()");
		EmailDao emailDao = new DummyEmailDao();
		request.setAttribute("emailList", emailDao.getInboxEmails());
		System.out.println("Exiting DisplayEmailsAction.execute()");
		request.getRequestDispatcher("/displayEmail.jsp").forward(request, response);
 	}

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		this.doGet(request, response);
 	}

}
