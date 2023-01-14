package com.khadri.citizen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CitizenServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choosenCountry = (String) req.getAttribute("countrySelected");
		
		ArrayList<String> states = (ArrayList) req.getAttribute("states");
		
		ArrayList<String> districts = (ArrayList) req.getAttribute("districts");
		
		ArrayList<String> mandals = (ArrayList) req.getAttribute("mandals");
		
		ArrayList<String> towns = (ArrayList) req.getAttribute("towns");

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action='hit' method='post'>");
		pw.println("<table border=4>");

		pw.println("<tr>");
		pw.println("<td>Adhaar No : </td>");
		pw.println("<td><input type='text' name='no'></td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>Citizen Name : </td>");
		pw.println("<td><input type='text' name='name'></td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td>Country : </td>");
		pw.println("<td>");
		pw.println("<select>");
			pw.println("<option>");
			pw.println(choosenCountry);
			pw.println("</option>");
			pw.println("<br>");
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		
		pw.println("<tr>");
		pw.println("<td>State : </td>");
		pw.println("<td>");
		pw.println("<select>");
			
			Iterator<String> iteratorStates = states.iterator();
			while (iteratorStates.hasNext()) {
				String value = (String) iteratorStates.next();
				pw.println("<option>");
				pw.println(value);
				pw.println("</option>");
			}
	       
	       pw.println("<br>");
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>Districts : </td>");
		pw.println("<td>");
		pw.println("<select>");
		
		Iterator<String> iteratorDistricts= districts.iterator();
		while (iteratorDistricts.hasNext()) {
			String value = (String) iteratorDistricts.next();
			pw.println("<option>");
			pw.println(value);
			pw.println("</option>");
		}
		
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>Mandals : </td>");
		pw.println("<td>");
		pw.println("<select>");
		
		Iterator<String> iteratorMandals= mandals.iterator();
		while (iteratorMandals.hasNext()) {
			String value = (String) iteratorMandals.next();
			pw.println("<option>");
			pw.println(value);
			pw.println("</option>");
		}
		
		pw.println("<br>");
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>Town/Post : </td>");
		pw.println("<td>");
		pw.println("<select>");
		
		Iterator<String> iteratorTowns= towns.iterator();
		while (iteratorTowns.hasNext()) {
			String value = (String) iteratorTowns.next();
			pw.println("<option>");
			pw.println(value);
			pw.println("</option>");
		}
		
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td></td>");
		pw.println("<td><input type='submit' value='Enrol Citizenship'></td>");
	 
		pw.println("</tr>");

		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();

	}

}
