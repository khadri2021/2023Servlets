import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MatchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
		String qly = req.getParameter("qly");
		String uni = req.getParameter("uni");
		
	
		
		
		String html = "<body><form action='hit5' method='post'><table border='4'><tr><td>Education <br> <input type='text' name='edu'></td></tr><tr><td>Working Women<br> <input type='text' name='work'></td></tr><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		Cookie cookie5 = new Cookie("qualification", qly);
		Cookie cookie6 = new Cookie("university", uni);
		
		resp.addCookie(cookie5);
		resp.addCookie(cookie6);
		
		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}

