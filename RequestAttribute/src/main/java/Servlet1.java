import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet1 Invoked");
		System.out.println("=================");
		String user = req.getParameter("username");
		System.out.println(user);
		
		if(user == null) {
			req.setAttribute("username", "jhon");//add attribute
		}
		System.out.println("=================");
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("hit2");
		dispatcher.forward(req, resp);
	}

}
