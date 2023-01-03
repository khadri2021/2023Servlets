import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadOnServlet extends HttpServlet {

	{
		System.out.println("LoadOnServlet instance block");
	}

	public LoadOnServlet() {
		System.out.println("LoadOnServlet constructor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LoadOnServlet init() method");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LoadOnServlet service(-,-) Invoked");
	}
}
