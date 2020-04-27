package com.test.jsp.customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {

	private static final long serialVersionUID = 1L;

	Connection conn;
	PreparedStatement ps;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			ps = conn.prepareStatement("select * from login where email=?");
		} catch (SQLException | ClassNotFoundException e) {

		}
	}

	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("email");
		try {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			JspWriter out = pageContext.getOut();
			if (rs.next()) {
				out.print(rs.getString(1));
				out.print(rs.getString(2));
			} else {
				out.print("Invalid Email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	@Override
	public void release() {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {

		}
	}
}
