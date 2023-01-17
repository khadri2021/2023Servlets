import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session= req.getSession(false);
		session.invalidate();
		System.out.println(session.getId());
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<body bgcolor='red'>");
		pw.println("<table border='2'>");
	
		try {
		pw.println("<tr>");
		pw.println("<td>");
		pw.println(session.getAttribute("user"));
		pw.println("</td>");
		pw.println("<td>");
		pw.println("<a href='logout'>logout</a>");
		pw.println("</td>");
		pw.println("</tr>");
		
		}catch (IllegalStateException  e) {
			pw.println("New User?");
			pw.println("</td>");
			pw.println("<td>");
			pw.println("<a href='login.html'>login</a>");
			pw.println("</td>");
			pw.println("</tr>");
		}
		
		pw.println("</table>");		
		pw.println("</body>");
		pw.println("</html>");
		pw.println("<hr>");
	
	
	}
}
