package com.trainings.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement stm;
	
	public void init(ServletConfig config) {
		ServletContext context = config.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(context.getInitParameter("dbUrl"),context.getInitParameter("dbUser"),context.getInitParameter("dbPassword"));
			String query = "update product set price=? where id=?";
			stm = con.prepareStatement(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out;
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("product_id"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		try {
			stm.setInt(2, id);
			stm.setInt(1, price);
			int result = stm.executeUpdate();
			out = response.getWriter();
			if(result > 0) {
				out.print("<b>Product updated successfully!</b>");
			}else {
				out.print("<b>Product with id doesn't exist</b>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
