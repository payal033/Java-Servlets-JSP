
package com.trainings.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddUserServlet
 */
public class ReadUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PrintWriter out;
	
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"),config.getInitParameter("dbUser"),config.getInitParameter("dbPassword"));
			System.out.println("Connection established!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try {
			Statement statement = connection.createStatement();
			String query = "select * from user";
			ResultSet rs = statement.executeQuery(query);
			
			out= response.getWriter();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.print("First Name");
			out.print("</th>");
			out.print("<th>");
			out.print("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.print("Email");
			out.print("</th>");
			out.print("</tr>");

			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>");
				out.print(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			System.out.println("User data!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
