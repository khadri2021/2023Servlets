import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========================");
		System.out.println("Servlet2 Invoked");
		System.out.println("=========================");
		System.out.println("Account from Attribute " + req.getAttribute("ACCNO"));
		System.out.println("Adhaar from Attribute " + req.getAttribute("ADHAAR"));
		System.out.println("Branch from Attribute " + req.getAttribute("BRANCH"));
		System.out.println("IFSC from Attribute " + req.getAttribute("IFSC"));
		System.out.println("Password from Attribute " + req.getAttribute("PASSWORD"));
		System.out.println("Phone from Attribute " + req.getAttribute("PHONE"));
		System.out.println("User from Attribute " + req.getAttribute("USER"));

		RequestDispatcher dispatcher = req.getRequestDispatcher("hit3");
		System.out.println("forwaring Account Information to Third Servlet");

		dispatcher.forward(req, resp);

	}
}
