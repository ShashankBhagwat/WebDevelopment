package com.test.jdbcandservlet.preparedStatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement st;

	public void init() {
		try {
			System.out.println("init");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			st = conn.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("**Do Post");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		int result = 0;
		try {
			st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, description);
			st.setInt(4, price);
			result = st.executeUpdate();
		} catch (SQLException e) {
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
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
