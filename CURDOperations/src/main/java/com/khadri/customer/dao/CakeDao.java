package com.khadri.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.khadri.customer.util.MySqlDBConnection;

public class CakeDao {
	MySqlDBConnection sqlCon = new MySqlDBConnection();

	public int inserOrder(String cakeName, Double cakeCost, Integer phoneNumber) {

		try {
			// creating object here is not industry standard
			// MySqlDBConnection sqlCon = new MySqlDBConnection();

			Connection con = sqlCon.getNewConnection();

			PreparedStatement ps = con.prepareStatement("insert into customer_order(cake,cost,cust_id) values(?,?,?)");

			ps.setString(1, cakeName);
			ps.setDouble(2, cakeCost);
			ps.setInt(3, phoneNumber);

			int result = ps.executeUpdate();

			// System.out.println(result + " order placed sucessfuly!!!! ");

			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}

	public int updateOrder(String cakeName, Double cakeCost, Integer phoneNumber) {

		try {
			// creating object here is not industry standard
			// MySqlDBConnection sqlCon = new MySqlDBConnection();

			Connection con = sqlCon.getNewConnection();

			// update customer_order set cake='Honey Cake' where cust_Id=1111;
			PreparedStatement ps = con.prepareStatement("update customer_order set cake=?,cost=? where cust_id=?");

			ps.setString(1, cakeName);
			ps.setDouble(2, cakeCost);
			ps.setInt(3, phoneNumber);

			int result = ps.executeUpdate();

			// System.out.println(result + " order placed sucessfuly!!!! ");

			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}

	public ResultSet showOrders(Integer phoneNumber) {

		try {
			// creating object here is not industry standard
			// MySqlDBConnection sqlCon = new MySqlDBConnection();

			Connection con = sqlCon.getNewConnection();

			// update customer_order set cake='Honey Cake' where cust_Id=1111;
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery("select * from customer_order where cust_id=" + phoneNumber);

			return resultSet;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	
	public Integer deleteOrders(Integer phoneNumber) {

		try {
			// creating object here is not industry standard
			// MySqlDBConnection sqlCon = new MySqlDBConnection();

			Connection con = sqlCon.getNewConnection();

			// update customer_order set cake='Honey Cake' where cust_Id=1111;
			Statement st = con.createStatement();
			Integer result = st.executeUpdate("delete from customer_order where cust_id=" + phoneNumber);

			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

}
