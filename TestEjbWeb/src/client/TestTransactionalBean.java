package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbeans.transactionEx.TransactionalService;


public class TestTransactionalBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
    TransactionalService serviceBean;
	
    public TestTransactionalBean() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			serviceBean.saveRecord();
		} catch (Exception e) {
			System.out.println("In Client classs Exception caught");
		}
	}
}
