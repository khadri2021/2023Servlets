package com.khadri.servlet.jdbc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.servlet.jdbc.dao.InsertPhoneDetails;

public class PhoneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.readPhoneDetails(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.readPhoneDetails(req, resp);
	}

	private void readPhoneDetails(HttpServletRequest req, HttpServletResponse resp) {
		InsertPhoneDetails details = new InsertPhoneDetails();

		String name = req.getParameter("phoneName");
		String cost = req.getParameter("phoneCost");

		Double costDouble = Double.valueOf(cost);

		details.insert(name, costDouble);

		System.out.println("Phone Name : " + name);
		System.out.println("Phone Cost : " + cost);

	}

}
