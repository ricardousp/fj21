package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());// without htis line a mysql exception was being thrown 
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21", "root", "r00t");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}