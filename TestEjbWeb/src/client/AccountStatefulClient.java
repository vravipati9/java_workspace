package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbeans.AccountStatelessBeanLocal;


/**
 * Servlet implementation class AccountStatefulClient
 */
public class AccountStatefulClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AccountStatelessBeanLocal accountStatelessBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountStatefulClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		accountStatelessBean.deposit(250);
		int balance = accountStatelessBean.getBalance();
		System.out.println(balance);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
