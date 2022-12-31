package com.khadri.servlet.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPhoneDetails {

	public int insert(String name, Double cost) {
		Integer result = null;
		try {
			PreparedStatement statement = getStatement(name, cost);
			result = statement.executeUpdate();
		} catch (Exception e) {
		}
		return result;
	}

	private PreparedStatement getStatement(String name, Double cost) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022_batch", "root", "root");
		PreparedStatement ps = connection.prepareStatement("insert into phone_Details(pname,pcost) values(?,?)");

		ps.setString(1, name);
		ps.setDouble(2, cost);
		return ps;

	}
}
