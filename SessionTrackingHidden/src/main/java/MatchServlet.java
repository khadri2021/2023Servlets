import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MatchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phone = req.getParameter("phone");
		String email = req.getParameter("mail");
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		
		String qly = req.getParameter("qly");
		String uni = req.getParameter("uni");
		
		
		
		String html = "<body><form action='hit5' method='post'><table border='4'><tr><td>Education <br> <input type='text' name='edu'></td></tr><tr><td>Working Women<br> <input type='text' name='work'></td></tr> <input type='hidden' name='phone' value='"+phone+"'/><input type='hidden' name='mail' value='"+email+"'/><input type='hidden' name='name' value='"+name+"'/><input type='hidden' name='dob' value='"+dob+"'/><input type='hidden' name='qly' value='"+qly+"'/><input type='hidden' name='uni' value='"+uni+"'/><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}
