import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterDBServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phone = req.getParameter("phone");
		String email = req.getParameter("mail");

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");

		String qly = req.getParameter("qly");
		String uni = req.getParameter("uni");

		String edu = req.getParameter("edu");
		String work = req.getParameter("work");

		PrintWriter pw = resp.getWriter();
		pw.println("Registeration Form Details inserting into DataBase");

		pw.println("NAME : " + name);
		pw.println("DOB : " + dob);
		pw.println("PHONE NUMBER : " + phone);
		pw.println("EMAIL ID : " + email);
		pw.println("QULIFICATION : " + qly);
		pw.println("UNIVERSITY : " + uni);
		pw.println("EDUCATION OF GIRL : " + edu);
		pw.println("WORKING OF GIRL : " + work);

	}
}
