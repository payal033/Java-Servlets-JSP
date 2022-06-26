package com.trainings.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

	public static void main(String[] args) {
		
		try(
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb","root","admin");
			Statement stm = con.createStatement();
			) {
			stm.addBatch("insert into account values (5,'kashap','meera', 60000)");
			stm.addBatch("insert into account values (8,'rathore','aryan', 100000)");
			stm.addBatch("insert into account values (6,'tripati','ameer', 9000)");
			int[] result = stm.executeBatch();
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
