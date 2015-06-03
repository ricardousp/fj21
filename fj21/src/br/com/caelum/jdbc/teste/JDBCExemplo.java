package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCExemplo {
	public static void main(String[] args) throws SQLException {
//		Connection conexao = DriverManager.getConnection(
//				"jdbc:mysql://localhost/fj21");
		Connection conexao = ConnectionFactory.getConnection();
		System.out.println("Conectado!");
		conexao.close();
	}
}
