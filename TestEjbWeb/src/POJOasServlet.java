
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class POJOasServlet
 */
@WebService(targetNamespace = "http://www.openuri.org/2004/04/HelloWorld", serviceName = "HelloWorldPOJOService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class POJOasServlet {
	private static final long serialVersionUID = 1L;

	public String hello(String input) {
		System.out.println("aasdfasdfasdf");
		return "hello from pojo " + input;
	}
	
	@PostConstruct
	public void post_cons() {
		System.out.println("=================POST CONSTRUCT=!==============");
	}
	
	@PreDestroy
	public void pre_destroy() {
		System.out.println("=================PRE DESTRORY====!===========");
	}
}
