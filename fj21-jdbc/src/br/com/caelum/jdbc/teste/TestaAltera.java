package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		try {
			ContatoDAO dao = new ContatoDAO();

			Contato diego = new Contato();

			diego.setId(4L);
			diego.setNome("Damasceno");
			diego.setDataNascimento(Calendar.getInstance());
			diego.setEmail("damascenodiego@usp.br");
			diego.setEndereco("SAO CARLOS");

			// instancia ContatoDAO

			dao.alteraContato(diego);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
