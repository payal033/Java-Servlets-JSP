package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		if(req.getParameter("num1") != null && req.getParameter("num2") != null) {
			int number1 = Integer.parseInt(req.getParameter("num1"));
			int number2 = Integer.parseInt(req.getParameter("num2"));
			
			int sum = number1 + number2;
			
			PrintWriter out = res.getWriter();
			out.println("Addition is: "+ sum);
		}
	}

}
