package com.trainings.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataDAO {

	public static void main(String[] args) {
		
		try(
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb","root","admin");
			Statement stm = con.createStatement();
			) {
			ResultSet rs = stm.executeQuery("select * from account");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
