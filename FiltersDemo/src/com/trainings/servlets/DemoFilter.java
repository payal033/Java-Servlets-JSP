package com.trainings.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter("/demoServlet")
public class DemoFilter implements Filter {

   
    public DemoFilter() {
    }

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("Pre Filter");
		chain.doFilter(request, response);
		out.println("Post Filter");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
