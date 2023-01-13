import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========================");
		System.out.println("Servlet1 Invoked");
		System.out.println("=========================");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println("Fetching Account information");
		Account accInfo = getAccountInformation(username, password);

		if (accInfo == null) {
			System.out.println("Invalid Account!!!!!!!!!!!!!!!!!!");
		} else {
			System.out.println("Setting Account information to Attributes");
			req.setAttribute("ACCNO", accInfo.getAccNo());
			req.setAttribute("ADHAAR", accInfo.getAdhaarNo());
			req.setAttribute("BRANCH", accInfo.getBranchName());
			req.setAttribute("IFSC", accInfo.getIfscCode());
			req.setAttribute("PASSWORD", accInfo.getPassword());
			req.setAttribute("PHONE", accInfo.getPhoneNo());
			req.setAttribute("USER", accInfo.getUserName());

			
			RequestDispatcher dispatcher = req.getRequestDispatcher("hit2");
			System.out.println("forwaring Account Information to Second Servlet");
			dispatcher.forward(req, resp);

		}
	}

	private Account getAccountInformation(String username, String password) {
		Account account = null;
		Connection connection = getNewConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from bank_account where username='" + username + "' and pass='" + password + "'");

			if (rs.next()) {
				account = new Account();
				account.setAccNo(rs.getString(1));
				account.setUserName(rs.getString(2));
				account.setIfscCode(rs.getString(3));
				account.setAdhaarNo(rs.getString(4));
				account.setPhoneNo(rs.getString(5));
				account.setPassword(rs.getString(6));
				account.setBranchName(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}

	private Connection getNewConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
