package com.khadri.servlet.filter;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ScheduleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ScheduleFilter Invoked ");
		LocalDate currentDate = LocalDate.now().plusDays(5);
		System.out.println("Today Date: " + currentDate);

		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		System.out.println("Day of week: " + dayOfWeek.getValue());

		if (dayOfWeek.getValue() >= 1 && dayOfWeek.getValue() <= 5) {
			System.out.println("You should go office");
			chain.doFilter(request, response);
		} else {
			System.out.println("Enjoy Your weekend!!!!!!!!!!!!!!!");
		}

	}

}
