package com.khadri.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.customer.dao.CakeDao;

public class CakeServlet extends HttpServlet {

	private CakeDao cakeDao = new CakeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.readInputs(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.readInputs(req, resp);
	}

	private void readInputs(HttpServletRequest req, HttpServletResponse resp) {

		String cake = req.getParameter("cake");

		String cost = req.getParameter("cost");

		// creating object here is not industry standard
		// CakeDao dao = new CakeDao();

		Double doubleCost = Double.valueOf(cost);

		int result = cakeDao.inserOrder(cake, doubleCost);
		
		try {
			PrintWriter pw = resp.getWriter();
			pw.println(result+" order inserted successfuly");
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
