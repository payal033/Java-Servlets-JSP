package com.trainings.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
//@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}
		
		response.addCookie(new Cookie("securityToken","123456"));
		
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "targetServlet?sessionId=123";
		out.print("<a href='"+url+"'>Click here to get Username</a>");
				
	}

}
