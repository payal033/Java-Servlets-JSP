
package com.trainings.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet(urlPatterns="/addUser",initParams= {
		@WebInitParam(name="dbUrl",value="jdbc:mysql://localhost:3305/mydb"),
		@WebInitParam(name="dbUser",value="root"),
		@WebInitParam(name="dbPassword",value="admin")
})
public class AddUserServlet extends HttpServlet {
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
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			String query = "insert into user values('"+fname+"','"+lname+"','"+email+"','"+password+"')";
			int rows = statement.executeUpdate(query);
			if(rows > 0) {
				out = response.getWriter();
				out.print("<h2>User added successfully!</h2>");
			}else {
				out.print("<h2>Error in adding user :(</h2>");
			}
			System.out.println("User Added!");
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
