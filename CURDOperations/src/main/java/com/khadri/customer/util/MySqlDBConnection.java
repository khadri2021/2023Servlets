package com.khadri.customer.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {

	private Connection con;

	{
		System.out.println("Its Instance Block");
		
	}
	
	 public MySqlDBConnection(){
		System.out.println("Its MySqlDBConnection constructor");
	}

	public Connection getNewConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");
		} catch (Exception e) {
			e.getStackTrace();
		}
		return this.con;
	}
}
