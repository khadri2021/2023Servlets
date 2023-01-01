package com.khadri.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.customer.dao.CakeDao;
import com.khadri.customer.result.DisplayResult;

public class CakeServlet extends HttpServlet {

	private CakeDao cakeDao = new CakeDao();

	private DisplayResult displayResult = new DisplayResult();

	private PrintWriter pw;

	private Double doubleCost;

	private Integer intPhoneNumber;

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

		String phoneNumber = req.getParameter("phone");

		String mode = req.getParameter("mode");

		// creating object here is not industry standard
		// CakeDao dao = new CakeDao();

		if (Objects.nonNull(cost)) {
			doubleCost = Double.valueOf(cost);
		}
		
		intPhoneNumber = Integer.valueOf(phoneNumber);
		try {
			pw = resp.getWriter();

			if (mode.equals("add")) {
				int insertResult = cakeDao.inserOrder(cake, doubleCost, intPhoneNumber);
				displayResult.showInsert(insertResult, pw);
			} else if (mode.equals("modify")) {
				int updateResult = cakeDao.updateOrder(cake, doubleCost, intPhoneNumber);
				displayResult.showUpdate(updateResult, pw);
			} else if (mode.equals("view")) {
				ResultSet resultSet = cakeDao.showOrders(intPhoneNumber);
				displayResult.showOrders(resultSet, pw);
			} else if(mode.equals("delete")) {
				Integer result = cakeDao.deleteOrders(intPhoneNumber);
				displayResult.showDelete(result, pw);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
