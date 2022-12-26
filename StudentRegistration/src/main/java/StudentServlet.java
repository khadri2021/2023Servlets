import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentServlet Invoked");

		String firstName = request.getParameter("fname");
		System.out.println("First Name " + firstName);
		
		String lastName = request.getParameter("lname");
		System.out.println("Last Name " + lastName);
		
		String gender = request.getParameter("gender");
		System.out.println("Gender " + gender);
		
		
		String course = request.getParameter("course");
		System.out.println("Course " + course);
		
		String[] parameterValues = request.getParameterValues("hobbies");
		System.out.println("Hobbies: ");
		for (String eachValue : parameterValues) {
			System.out.println(eachValue);
		}
		
		
		String[] foodValues = request.getParameterValues("food");
		System.out.println("Food Items: ");
		for (String eachValue : foodValues) {
			System.out.println(eachValue);
		}

	}
}
