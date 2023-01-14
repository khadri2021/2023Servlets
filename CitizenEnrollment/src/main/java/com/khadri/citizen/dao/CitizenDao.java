package com.khadri.citizen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CitizenDao {

	public ArrayList<String> getCountries() {

		ArrayList<String> listCountries = null;

		try {
			Connection conn = getNewConnection();

			Statement st = conn.createStatement();

			ResultSet results = st.executeQuery("select name from country");

			listCountries = new ArrayList<>();

			while (results.next()) {
				listCountries.add(results.getString(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listCountries;

	}

	public ArrayList<String> getStatesByChoosenCountry(String choosenCountry) {

		ArrayList<String> listStates = null;

		try {
			Connection conn = getNewConnection();

			Statement st = conn.createStatement();

			ResultSet results = st.executeQuery("select sname from state where country_name='" + choosenCountry + "'");

			listStates = new ArrayList<>();

			while (results.next()) {
				listStates.add(results.getString(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listStates;

	}

	public ArrayList<String> getDistrictsByChoosenState(String choosenState) {

		ArrayList<String> listDistricts = null;

		try {
			Connection conn = getNewConnection();

			Statement st = conn.createStatement();

			ResultSet results = st.executeQuery("select dname from district where state_name='" + choosenState + "'");

			listDistricts = new ArrayList<>();

			while (results.next()) {
				listDistricts.add(results.getString(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listDistricts;

	}

	public ArrayList<String> getMandalsByChoosenDistrict(String choosenDistrict) {

		ArrayList<String> listMandals = null;

		try {
			Connection conn = getNewConnection();

			Statement st = conn.createStatement();

			ResultSet results = st
					.executeQuery("select mname from mandal where district_name='" + choosenDistrict + "'");

			listMandals = new ArrayList<>();

			while (results.next()) {
				listMandals.add(results.getString(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listMandals;

	}

	public ArrayList<String> getTownsByChoosenMandal(String choosenMandal) {

		ArrayList<String> listTowns = null;

		try {
			Connection conn = getNewConnection();

			Statement st = conn.createStatement();

			ResultSet results = st.executeQuery("select tname from town where mandal_name='" + choosenMandal + "'");

			listTowns = new ArrayList<>();

			while (results.next()) {
				listTowns.add(results.getString(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listTowns;

	}

	private Connection getNewConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
