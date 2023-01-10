import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test3 invoked");

		System.out.println("Your Name: " + req.getParameter("name"));

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor='yellow'>");
		writer.println("<h1>its from third servlet</h1>");
		writer.println("</body>");
		writer.println("</html>");
//		writer.close();
 
	}
}
