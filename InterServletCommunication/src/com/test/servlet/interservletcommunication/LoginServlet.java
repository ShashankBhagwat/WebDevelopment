package com.test.servlet.interservletcommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");

			if (rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				request.setAttribute("message", "Welcome to this page - " + email);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd1 = request.getRequestDispatcher("login.html");
				rd1.include(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
