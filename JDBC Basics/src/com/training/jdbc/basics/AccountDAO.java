package com.training.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccountDAO {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb","root","admin");
		System.out.println("Connection Established!");
		String query = "insert into account values (3, 'Jim', 'Kashap', 79000)";
		Statement stm = con.createStatement();
		int rows = stm.executeUpdate(query);
		System.out.println(rows + "row(s) affected");
		ResultSet rs = stm.executeQuery("select * from account");
		while(rs.next()) {
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.println(rs.getInt(4));
		}
	}
}
