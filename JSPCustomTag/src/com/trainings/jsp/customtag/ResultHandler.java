package com.trainings.jsp.customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {

	Connection con;
	PreparedStatement stmt;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb", "root", "admin");
			String query = "select * from user where email = ?";
			stmt = con.prepareStatement(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doStartTag() throws JspException {

		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("email");
		try {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			JspWriter out = pageContext.getOut();
			if (rs.next()) { 
				out.print("<h2>User Details are:<h2>First Name: ");
				out.print(rs.getString(1));
				out.print("<br/>Last Name: ");
				out.print(rs.getString(2));
			} else {
				out.print("Invalid email entered!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Tag.SKIP_BODY;
	}

	@Override
	public void release() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}