package com.khadri.mvc.login.filter.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.khadri.mvc.login.dao.LoginDao;
import com.khadri.mvc.login.pojo.Login;

public class LoginFilter implements Filter {

	private LoginDao loginDao;

	private Login login;

	public LoginFilter() {
		loginDao = new LoginDao();
		login = new Login();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter Invoked");

		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		login.setUserName(user);
		login.setPassword(pass);

		int count = loginDao.validateCredentials(login);
		request.setAttribute("count", count);
		
		chain.doFilter(request, response);

	}

}
