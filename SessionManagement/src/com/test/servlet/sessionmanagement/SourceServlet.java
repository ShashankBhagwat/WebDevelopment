package com.test.servlet.sessionmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName() + "-" + cookies[i].getValue());
			}
		}
		Cookie c = new Cookie("password", "Bhagwat");
		response.addCookie(c);

		String username = request.getParameter("username");
		HttpSession session = request.getSession();

		session.setAttribute("username", username);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<a href='targetServlet'>Click here to get Username</a>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
