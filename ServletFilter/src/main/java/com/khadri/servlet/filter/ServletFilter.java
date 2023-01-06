package com.khadri.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.khadri.servlet.dao.LoginDao;

public class ServletFilter implements Filter {

	private LoginDao loginDao = new LoginDao();;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		System.out.println("ServletFilter Trapped");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		ResultSet resultSet = loginDao.checkValidUser(username, password);

		try {
			int result = 0;
			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
			if (result == 1) {
				chain.doFilter(request, response);
			} else {

				PrintWriter writer = response.getWriter();
				writer.println("<html>");
				writer.println("<head>");
				writer.println("<title>Error html</title");
				writer.println("</head>");
				writer.println("<body bgcolor='red'>");
				writer.println("<center>");
				writer.println("Login failed ! Please try again !!!!!");
				writer.println("other wise create new account");
				writer.println("</center>");
				writer.println("</body>");
				writer.println("</html>");
				writer.close();
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}
