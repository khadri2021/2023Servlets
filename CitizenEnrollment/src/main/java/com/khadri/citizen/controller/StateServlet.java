package com.khadri.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.citizen.dao.CitizenDao;

public class StateServlet extends HttpServlet {
	
	private CitizenDao citizenDao;
	
	@Override
	public void init() throws ServletException {
		citizenDao  = new CitizenDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choosenCountry = (String)req.getAttribute("countrySelected");
	
		ArrayList<String> states = citizenDao.getStatesByChoosenCountry(choosenCountry);
		req.setAttribute("states", states);
		req.setAttribute("stateSelected", "TS");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("district");
		dispatcher.forward(req, resp);
		
	}
}
