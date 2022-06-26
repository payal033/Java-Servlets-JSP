package com.trainings.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.util.Length;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login", initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost:3305/mydb"),
		@WebInitParam(name = "dbUser", value = "root"), @WebInitParam(name = "dbPassword", value = "admin") })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement stm;

	public void init(ServletConfig config) {
		String query = "select * from user where email= ? and password = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser"),
					config.getInitParameter("dbPassword"));
			System.out.println("Connection estabished");
			stm = con.prepareStatement(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet result = stm.executeQuery();
			RequestDispatcher rd;
			if (result.next()) {
				rd = request.getRequestDispatcher("home");
				request.setAttribute("message",
						"<h3>Welcome " + result.getString(1) + " " + result.getString(2) + "!</h3>");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
