import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EducationalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phone = req.getParameter("phone");
		String email = req.getParameter("mail");
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		
		
		
		String html = "<body><form action='hit4' method='post'><table border='4'><tr><td>Qualification <br> <input type='text' name='qly'></td></tr><tr><td>University<br> <input type='text' name='uni'></td></tr> <input type='hidden' name='phone' value='"+phone+"'/><input type='hidden' name='mail' value='"+email+"'/><input type='hidden' name='name' value='"+name+"'/><input type='hidden' name='dob' value='"+dob+"'/><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}
