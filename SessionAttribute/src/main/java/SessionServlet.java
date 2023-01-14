import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter(); 
		HttpSession session = req.getSession();
		
		pw.println("Servlet2 user = " + req.getAttribute("username"));
		pw.println("Servlet2 password = " + session.getAttribute("password"));

		if(session.isNew()) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("InvalidateSessionServlet");
		requestDispatcher.include(req, resp);
		}
	}
}