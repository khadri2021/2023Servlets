import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session= req.getSession(true);//new session
		session.setAttribute("user", req.getParameter("uname"));
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<body bgcolor='green'>");
		pw.println("<table border='2'>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println(session.getAttribute("user"));
		pw.println("</td>");
		pw.println("<td>");
		pw.println("<a href='logout'>logout</a>");

		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");		
		pw.println("</body>");
		pw.println("</html>");
		pw.println("<hr>");
	
	
	}
}
