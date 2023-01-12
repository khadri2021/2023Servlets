package com.khadri.mvc.signup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.khadri.mvc.jdbc.connection.MvcJdbcConnection;
import com.khadri.mvc.signup.pojo.SignUp;

public class SignUpDao {

	private MvcJdbcConnection jdbcConnection;

	public SignUpDao() {
		jdbcConnection = new MvcJdbcConnection();
	}

	public int[] createAccount(SignUp signUp) {

		Connection newCOnnection;
		int[] executeBatch = null;

		try {
			newCOnnection = jdbcConnection.getNewCOnnection();

			Statement st = newCOnnection.createStatement();

			String sql_account = "insert into user_account values('" + signUp.getName() + "','" + signUp.getUserName()
					+ "','" + signUp.getPassword() + "')";
			String sql_login = "insert into login values('" + signUp.getPassword() + "','" + signUp.getUserName()
					+ "')";

			st.addBatch(sql_account);
			st.addBatch(sql_login);

			executeBatch = st.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return executeBatch;

	}

}
