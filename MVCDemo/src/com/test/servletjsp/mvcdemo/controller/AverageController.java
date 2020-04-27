package com.test.servletjsp.mvcdemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.servletjsp.mvcdemo.model.AverageCalculator;

@WebServlet("/averageController")
public class AverageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int number1 = Integer.parseInt(req.getParameter("number1"));
		int number2 = Integer.parseInt(req.getParameter("number2"));

		AverageCalculator averageCalculator = new AverageCalculator();
		int result = averageCalculator.getAverage(number1, number2);

		req.setAttribute("average", result);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayAverage.jsp");
		requestDispatcher.forward(req, resp);

	}
}
