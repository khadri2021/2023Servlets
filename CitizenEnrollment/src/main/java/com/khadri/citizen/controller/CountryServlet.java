package com.khadri.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.citizen.dao.CitizenDao;

public class CountryServlet extends HttpServlet {

	private CitizenDao citizenDao;

	@Override
	public void init() throws ServletException {
		citizenDao = new CitizenDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> countries = citizenDao.getCountries();
		req.setAttribute("countries", countries);
		req.setAttribute("countrySelected", "INDIA");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("state");
		dispatcher.forward(req, resp);
	}
}
