import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet2 Invoked");
		System.out.println("=================");
		String value = (String) req.getAttribute("username");
		System.out.println(value);
		System.out.println("=================");
		
		req.setAttribute("username", "allen");//modify attribute
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("hit3");
		dispatcher.forward(req, resp);

	}
}
