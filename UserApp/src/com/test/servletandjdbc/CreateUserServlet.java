package com.test.servletandjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	public void init(ServletConfig config) {
		try {
			System.out.println("init");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(config.getInitParameter("dburl"), config.getInitParameter("user"),
					config.getInitParameter("password"));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int result = 0;
		try {
			System.out.println("***connection:-" + conn);
			Statement st = conn.createStatement();
			result = st.executeUpdate("INSERT INTO USER VALUES('" + firstName + "','" + lastName + "','" + email + "','"
					+ password + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		if (result > 0) {
			writer.println("User record Inserted");
		} else {
			writer.println("User record Not Inserted");
		}

	}

	public void destroy() {
		try {
			System.out.println("destroy");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
