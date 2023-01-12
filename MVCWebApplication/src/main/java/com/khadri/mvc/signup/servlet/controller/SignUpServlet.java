package com.khadri.mvc.signup.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.mvc.signup.dao.SignUpDao;
import com.khadri.mvc.signup.pojo.SignUp;

public class SignUpServlet extends HttpServlet {

	private SignUpDao signUpDao;

	private SignUp signUp;

	@Override
	public void init() throws ServletException {
		signUpDao = new SignUpDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SignUpServlet Invoked");

		String name = req.getParameter("name");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		signUp = new SignUp(name, userName, password);

		int[] batch = signUpDao.createAccount(signUp);

		if (batch.length >= 1) {
			 resp.sendRedirect("signup_success.html");
		}

	}

}
