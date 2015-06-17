package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	private	Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
		List<Contato> result = new ArrayList<Contato>();

		try {
			String sql = "select * from contatos";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getLong("id"));				
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				// define data de nascimento usando Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				//adiciona contato
				result.add(c);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}
	
	public List<Contato> getContato(String nome) {
		List<Contato> result = new ArrayList<Contato>();

		try {
			String sql = "select * from contatos where nome like (?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getLong("id"));				
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				// define data de nascimento usando Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				//adiciona contato
				result.add(c);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}
	
	public void alteraContato(Contato c){
		try {
			String sql = "update contatos set "
					+ "nome=?,"
					+ "email=?,"
					+ "endereco=?,"
					+ "dataNascimento=?"
					+ "where id=?";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,c.getNome());
			stmt.setString(2,c.getEmail());
			stmt.setString(3,c.getEndereco());
			stmt.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5,c.getId());
			// executa
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void removeContato(Contato c) {
		try {
			String sql = "delete from contatos "
					+ "where id=?";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,c.getId());
			// executa
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
