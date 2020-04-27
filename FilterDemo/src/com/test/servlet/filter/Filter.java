package com.test.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/filterDemo")
public class Filter implements javax.servlet.Filter {

	public void destroy() {
		System.out.println("**Filter Destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.getWriter().println("**Filter Pre");
		System.out.println("**Filter Pre");
		chain.doFilter(request, response);
		response.getWriter().println("**Filter Post");
		System.out.println("**Filter Post");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("**Filter init");
	}

}
