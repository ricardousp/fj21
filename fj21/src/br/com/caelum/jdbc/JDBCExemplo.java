package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo {
	public static void main(String[] args) throws SQLException {
//		Connection conexao = DriverManager.getConnection(
//				"jdbc:mysql://localhost/fj21");
		Connection conexao = ConnectionFactory.getConnection();
		System.out.println("Conectado!");
		conexao.close();
	}
}
