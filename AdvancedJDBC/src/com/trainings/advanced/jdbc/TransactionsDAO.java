package com.trainings.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionsDAO {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stm;
		
		try{
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb","root","admin");
			stm = con.createStatement();
			
			con.setAutoCommit(false);
			stm.executeUpdate("update account set balance=balance+5000 where accno=5");
			stm.executeUpdate("update account set balance=balance-5000 where accno=6");
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		}

	}

}
