import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletConfig extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServletConfig Invoked");

		ServletConfig config = getServletConfig();

		System.out.println("My Servlet Name : " + config.getServletName());

		Enumeration<String> paramNames = config.getInitParameterNames();

		while (paramNames.hasMoreElements()) {
			String paraName = paramNames.nextElement();
			System.out.println("name : " + paraName + "  value : " + config.getInitParameter(paraName));

		}
	}

}
