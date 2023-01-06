package com.khadri.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public ResultSet checkValidUser(String username, String password) {
		PreparedStatement ps;
		ResultSet result = null;
		Connection conn = getNewConnection();

		try {
			ps = conn.prepareStatement("select count(*) from credentials where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			result = ps.executeQuery();// 1 or 0

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Connection getNewConnection() {
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("############ Invalid DB Connection ##################");
		}
		return conn;
	}
}
