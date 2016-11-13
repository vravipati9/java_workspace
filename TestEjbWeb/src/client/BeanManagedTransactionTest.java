package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbeans.beanMangedTx.BeanManagedTxService;

/**
 * Servlet implementation class BeanManagedTransactionTest
 */
public class BeanManagedTransactionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	BeanManagedTxService bean;
	
    public BeanManagedTransactionTest() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("++++++Test Bean Managed Transactions+++++++++++");
		bean.insertRecord();
	}
	
}
