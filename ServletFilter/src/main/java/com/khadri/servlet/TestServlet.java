package com.khadri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServlet : displaying dynamic page");

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor='green'>");
		writer.println("<center>");
		writer.println("Hurry successfuly logged in !!!!!");
		writer.println("</center>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();

	}
}
