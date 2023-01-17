import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phone = req.getParameter("phone");
		String email = req.getParameter("mail");

		String html = "<body><form action='hit3' method='post'><table border='4'><tr><td>Name <br> <input type='text' name='name'></td></tr><tr><td>DOB<br> <input type='text' name='dob'></td></tr> <input type='hidden' name='phone' value='"
				+ phone + "'/><input type='hidden' name='mail' value='" + email
				+ "'/><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}
