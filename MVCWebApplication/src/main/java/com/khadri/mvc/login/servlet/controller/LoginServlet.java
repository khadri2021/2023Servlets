package com.khadri.mvc.login.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet Invoked");
	
		int count =(int) req.getAttribute("count");
		
		PrintWriter writer = resp.getWriter();

		if(!(count <=0)) {
			 writer.println("Logged in successful");
		}else {
			 writer.println("Logged in Failed");
		}
	
	}
}
