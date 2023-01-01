package com.khadri.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.khadri.customer.util.MySqlDBConnection;

public class CakeDao {
	MySqlDBConnection sqlCon = new MySqlDBConnection();

	public int inserOrder(String cakeName, Double cakeCost) {

		try {
			// creating object here is not industry standard
			// MySqlDBConnection sqlCon = new MySqlDBConnection();

			Connection con = sqlCon.getNewConnection();

			PreparedStatement ps = con.prepareStatement("insert into customer_order(cake,cost) values(?,?)");

			ps.setString(1, cakeName);
			ps.setDouble(2, cakeCost);

			int result = ps.executeUpdate();

			// System.out.println(result + " order placed sucessfuly!!!! ");

			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}

}
