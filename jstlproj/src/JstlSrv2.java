import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlSrv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<String> list = new ArrayList<String>();
		list.add("This site rocks");
		list.add("This site is cool");
		list.add("This site is stupid");
		request.setAttribute("commentList", list);
		request.setAttribute("userType", "member");
		request.getRequestDispatcher("Jstl2.jsp").forward(request, response);
		
	}

}
