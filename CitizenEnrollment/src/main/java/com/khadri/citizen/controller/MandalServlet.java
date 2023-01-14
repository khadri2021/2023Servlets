package com.khadri.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.citizen.dao.CitizenDao;

public class MandalServlet extends HttpServlet {

	private CitizenDao citizenDao;

	@Override
	public void init() throws ServletException {
		citizenDao = new CitizenDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choosenDistrict = (String) req.getAttribute("choosenDistrict");

		ArrayList<String> mandals = citizenDao.getMandalsByChoosenDistrict(choosenDistrict);

		req.setAttribute("mandals", mandals);
		req.setAttribute("choosenMandal", "PTP");

		RequestDispatcher dispatcher = req.getRequestDispatcher("town");
		dispatcher.forward(req, resp);

	}
}
