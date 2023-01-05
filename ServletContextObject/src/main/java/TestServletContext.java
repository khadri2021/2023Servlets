import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServletContext Invoked");

		ServletConfig config = getServletConfig();

		ServletContext context = config.getServletContext();
		
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");

		System.out.println("User Name: " + username + " Password: " + password);

	}
}
