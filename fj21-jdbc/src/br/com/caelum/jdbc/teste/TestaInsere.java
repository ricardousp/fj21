package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		// instancia contato
		Contato diego = new Contato();

		diego.setId(12345L);
		diego.setNome("Carlos Diego");
		diego.setDataNascimento(Calendar.getInstance());
		diego.setEmail("carlos.damasceno08@gmail.com");
		diego.setEndereco("ICMC - USP");

		// instancia ContatoDAO
		ContatoDAO dao = new ContatoDAO();
		
		dao.adiciona(diego);
		
		System.out.println("Gravado! :D");
	}
}
