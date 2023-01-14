package com.khadri.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.citizen.dao.CitizenDao;

public class DistrictServlet extends HttpServlet {

	private CitizenDao citizenDao;

	@Override
	public void init() throws ServletException {
		citizenDao = new CitizenDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choosenState = (String) req.getAttribute("stateSelected");

		ArrayList<String> districts = citizenDao.getDistrictsByChoosenState(choosenState);

		req.setAttribute("districts", districts);
		req.setAttribute("choosenDistrict", "SSS");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("mandal");
		requestDispatcher.forward(req, resp);

	}
}
