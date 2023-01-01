package com.khadri.customer.result;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayResult {

	public void showInsert(int result, PrintWriter pw) {
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>ResultPage</title>");
		pw.println("<style type='text/css'>");

		pw.println("#res{color:red}");
		pw.println("</style>");

		pw.println("</head>");
		pw.println("<body bgcolor='gold'>");

		pw.println("<h1 id='res'>" + result + " Order placed successfuly!!!</h1>");

		pw.println("<a href='index.html'>Go Home</a>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}

	public void showUpdate(int result, PrintWriter pw) {
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>ResultPage</title>");
		pw.println("<style type='text/css'>");

		pw.println("#res{color:red}");
		pw.println("</style>");

		pw.println("</head>");
		pw.println("<body bgcolor='gold'>");

		pw.println("<h1 id='res'>" + result + " Order Modified successfuly!!!</h1>");

		pw.println("<a href='index.html'>Go Home</a>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}

	public void showOrders(ResultSet resultSet, PrintWriter pw) throws SQLException {
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>ResultPage</title>");
		pw.println("<style type='text/css'>");

		pw.println("#res{color:red}");
		pw.println("</style>");

		pw.println("</head>");
		pw.println("<body bgcolor='gold'>");

		pw.println("<table border=3>");
		pw.println("<caption>Customer Orders</caption>");
		pw.println("<tr>");
		pw.println("<td>cake</td>");
		pw.println("<td>cost</td>");
		pw.println("<td>cust id</td>");
		pw.println("</tr>");

		while (resultSet.next()) {
			pw.println("<tr>");
			pw.println("<td>");
			pw.println(resultSet.getString(1));
			pw.println("</td>");

			pw.println("<td>");
			pw.println(resultSet.getDouble(2));
			pw.println("</td>");

			pw.println("<td>");
			pw.println(resultSet.getInt(3));
			pw.println("</td>");
			pw.println("</tr>");
		}

		pw.println("</table>");

		pw.println("<a href='index.html'>Go Home</a>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}
	
	
	public void showDelete(int result, PrintWriter pw) {
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>ResultPage</title>");
		pw.println("<style type='text/css'>");

		pw.println("#res{color:red}");
		pw.println("</style>");

		pw.println("</head>");
		pw.println("<body bgcolor='gold'>");

		pw.println("<h1 id='res'>" + result + " Orders Canceled successfuly!!!</h1>");

		pw.println("<a href='index.html'>Go Home</a>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}
}
