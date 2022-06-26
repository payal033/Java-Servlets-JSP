package com.trainings.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreInitializationDemo
 */

//preinitialization using web annotations
//@WebServlet(urlPatterns="/PreInitializationDemo", loadOnStartup = 0)
public class PreInitializationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("Inside init");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("From pre init servlet");
	}


}
