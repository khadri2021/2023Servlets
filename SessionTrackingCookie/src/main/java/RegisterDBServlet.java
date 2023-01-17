import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterDBServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
		String edu = req.getParameter("edu");
		String work = req.getParameter("work");
		
		Cookie[] cookies = req.getCookies();

		PrintWriter pw = resp.getWriter();
		pw.println("Registeration Form Details inserting into DataBase");

		for (Cookie c : cookies) {
			pw.println(c.getName()+" : " + c.getValue());
		}
	
		
		pw.println("EDUCATION OF GIRL : " + edu);
		pw.println("WORKING OF GIRL : " + work);

	}
}
