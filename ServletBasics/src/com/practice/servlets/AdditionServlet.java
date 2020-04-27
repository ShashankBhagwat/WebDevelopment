package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		if (request.getParameter("number1") != null && request.getParameter("number2") != null) {
			Long i1 = Long.parseLong(request.getParameter("number1"));
			Long i2 = Long.parseLong(request.getParameter("number2"));
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Result is - " + (i1 + i2));
		}
	}

}
