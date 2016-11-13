package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Userdetail;

import sessionbeans.AccountStatelessBeanLocal;
import sessionbeans.StudentDao;


/**
 * Servlet implementation class TestDemoEJB
 */
public class TestDemoEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB
	AccountStatelessBeanLocal accountStatelessBean;
	
	@EJB
	StudentDao  bean;
	
    public TestDemoEJB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//jndi:FirstDemoEJB/remote
		System.out.println("************Entered into Servlet*@!****************");
		try {
			/*InitialContext ic = new InitialContext();
			Object o = ic.lookup("FirstDemoEJB/remote");
			if (o instanceof FirstDemoEJBRemote) {
				System.out.println("o is an instance of FirstDemoEJBRemote");
			} else {
				System.out.println("o is not an instance of FirstDemoEJBRemote");
			}
			FirstDemoEJBRemote remote = (FirstDemoEJBRemote)o;
			String s = remote.testDemo();
			*/
			/*
			Context ic = new InitialContext();
			Object o = ic.lookup("studentDaoEJB");
			if (o instanceof StudentDaoImpl) {
				System.out.println("o is an instance of StudentDaoImpl");
			} else {
				System.out.println("o is not an instance of StudentDaoImpl");
			}
			*/
			//java:global/TestEjbWeb/StudentDaoImpl
			
			//accountStatelessBean.getBalance();
			
			System.out.println("---------------List all JNDI Entry's START------------------");
			InitialContext ctx = new InitialContext();
			NamingEnumeration<NameClassPair> list = ctx.list("");
			while (list.hasMore()) {
				System.out.println(list.next().getName());
			}
			System.out.println("---------------List all GLOBAL JNDI Entry's ------------------");
			Context root = (Context) new InitialContext().lookup("ejb");
			NamingEnumeration<NameClassPair> names = root.list("");
			while (names.hasMore()) {
				System.out.println(names.next().getName());
			}
			System.out.println("---------------List all JNDI Entry's END------------------");

			
			InitialContext context = new InitialContext();
			Object o = context.lookup("java:global/TestEjbWeb/StudentDaoImpl");
			StudentDao bean = (StudentDao)o;
			bean.addRecord();
			if (o instanceof StudentDao) {
				System.out.println("o is an instance of StudentDao");
			} else {
				System.out.println("o is not an instance of StudentDao");
			}
			
			Userdetail ud = new Userdetail();
			System.out.println("Called Session bean!!!!!!!!!!!!!");
		} catch (Exception e) {
			System.out.println("Exception Caught::::::::::::::");
			System.out.println(e);
		}
	}

}
