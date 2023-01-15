import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ServletContext sc = req.getServletContext();
		sc.setAttribute("username", "JHON");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("Servlet1 username ===> "+sc.getAttribute("username"));
		
	}
}
