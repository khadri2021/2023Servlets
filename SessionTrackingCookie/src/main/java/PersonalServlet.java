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

		String html = "<body><form action='hit3' method='post'><table border='4'><tr><td>Name <br> <input type='text' name='name'></td></tr><tr><td>DOB<br> <input type='text' name='dob'></td></tr><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		Cookie cookie1 = new Cookie("phone", phone);
		Cookie cookie2 = new Cookie("mail", email);
		cookie1.setMaxAge(60);
		cookie2.setMaxAge(60);

		resp.addCookie(cookie1);
		resp.addCookie(cookie2);

		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}
