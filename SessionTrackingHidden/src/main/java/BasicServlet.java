import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String html = "<body><form action='hit2' method='post'><table border='4'><tr><td>phone number<br> <input type='text' name='phone'></td></tr><tr><td>Email<br> <input type='text' name='mail'></td></tr><tr><td><input type='submit' value='next'> <input type='reset' value='cancel'></td></tr></table></form></body>";

		PrintWriter pw = resp.getWriter();
		pw.println(html);
	}
}
