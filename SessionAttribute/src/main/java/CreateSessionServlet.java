import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateSessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		req.setAttribute("username", "JHON");
		
		HttpSession session = req.getSession();
		session.setAttribute("password", "Welcome@123");

		pw.println("Servlet1 user = " + req.getAttribute("username"));
		pw.println("Servlet1 password = " + session.getAttribute("password"));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkInSession");
		requestDispatcher.include(req, resp);
	}
}

