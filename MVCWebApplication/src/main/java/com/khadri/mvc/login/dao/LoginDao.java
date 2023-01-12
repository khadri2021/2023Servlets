package com.khadri.mvc.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.khadri.mvc.jdbc.connection.MvcJdbcConnection;
import com.khadri.mvc.login.pojo.Login;

public class LoginDao {
	private MvcJdbcConnection jdbcConnection;

	public LoginDao() {
		jdbcConnection = new MvcJdbcConnection();
	}

	public int validateCredentials(Login login) {

		int result = 0;

		try {
			String sql = "select count(*) from login where username='" + login.getUserName() + "' and password='"
					+ login.getPassword() + "'";
			Connection con = jdbcConnection.getNewCOnnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;

	}

}
