import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class StudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentServlet Invoked");

		String firstName = request.getParameter("fname");

		String lastName = request.getParameter("lname");

		String gender = request.getParameter("gender");

		String course = request.getParameter("course");

		String[] hobbies = request.getParameterValues("hobbies");
		String[] foods = request.getParameterValues("food");

		StudentValidations(firstName, lastName, gender, course, hobbies, foods);

	}

	private void StudentValidations(String firstName, String lastName, String gender, String course, String[] hobbies,
			String[] foodValues) {

		// 3+ yrs exp guys coding.
		if (StringUtils.isEmpty(firstName)) {
			throw new RuntimeException("#########Please Enter valid First Name########");

		}

		if (StringUtils.isEmpty(lastName)) {
			throw new RuntimeException("#########Please Enter valid Last Name########");

		}

		if (StringUtils.isEmpty(gender)) {
			throw new RuntimeException("#########Please Select valid Gender########");

		}

		// Basic Programmer coding.
		if (firstName == "") {
			throw new RuntimeException("#########Please Enter valid First Name########");
		}

		// 1 year exp guy coding.
		if (firstName.equals("")) {
			throw new RuntimeException("#########Please Enter valid First Name########");
		}

		// 2 yrs exp guy coding.
		if (Objects.isNull(firstName)) {
			throw new RuntimeException("#########Please Enter valid First Name########");
		}

		if (Objects.isNull(hobbies)) {
			throw new RuntimeException("#########Please Select valid Hobbies########");

		}
		if (Objects.isNull(foodValues)) {
			throw new RuntimeException("#########Please Select valid Foods########");

		}

	}
}
