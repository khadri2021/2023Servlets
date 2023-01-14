package com.khadri.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.citizen.dao.CitizenDao;

public class TownServlet extends HttpServlet {

	private CitizenDao citizenDao;

	@Override
	public void init() throws ServletException {
		citizenDao = new CitizenDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choosenMandal = (String) req.getAttribute("choosenMandal");

		ArrayList<String> towns = citizenDao.getTownsByChoosenMandal(choosenMandal);

		req.setAttribute("towns", towns);

		RequestDispatcher rd = req.getRequestDispatcher("citizen");
		rd.forward(req, resp);

	}
}
