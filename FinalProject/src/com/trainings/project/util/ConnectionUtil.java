package com.trainings.project.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			javax.sql.DataSource dataSource = (javax.sql.DataSource) context.lookup("java:comp/env/myds");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
