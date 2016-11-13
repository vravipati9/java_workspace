

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JstlSrv
 */
public class JstlSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] musicArray = {"one", "two", "three"};
		request.setAttribute("musicArray", musicArray);
		
		String[] movies1 = {"Dookudu", "Dammu", "Racha"};
		String[] movies2 = {"BodyGuard", "Ready", "Dabang"};
		java.util.List<String[]> movieList = new ArrayList<String[]>();
		movieList.add(movies1);
		movieList.add(movies2);
		
		request.setAttribute("movieList", movieList);
		String res = null;
		for (int i = 0; i < musicArray.length; i++) {
			String s = musicArray[i];
		    res = res + " <a href=javascript:newAction('"+request.getContextPath()+"/aasservice?service=1212" +
		      "&abc=12"+
		      "','','600','700')> "+ s + " </a>";	
		}

	      request.setAttribute("hrefLink", res);
		getServletContext().getRequestDispatcher("/Jstl1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
