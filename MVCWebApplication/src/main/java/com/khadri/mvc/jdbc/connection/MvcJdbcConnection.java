package com.khadri.mvc.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MvcJdbcConnection {

	public Connection getNewCOnnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");

		return connection;
	}
}
