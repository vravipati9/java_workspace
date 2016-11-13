

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TagLibEx1
 */
public class TagLibEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagLibEx1() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.Map<String, String> petMap = new HashMap<String, String>();
		System.out.println("TagLibEx1");
		petMap.put("catName", "Lilly");
		request.setAttribute("PetMap", petMap);
		request.getRequestDispatcher("taglibex1.jsp").forward(request, response);
	}

}
