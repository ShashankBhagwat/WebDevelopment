package com.test.servlet.sessionmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName() + "-" + cookies[i].getValue());
			}
		}

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		response.setContentType("text/html");
		response.getWriter().println("User name is - " + username);

		// session.invalidate();
	}

}
