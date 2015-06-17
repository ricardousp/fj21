package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemove {
	public static void main(String[] args) {
		try {
			ContatoDAO dao = new ContatoDAO();

			Contato caelum = new Contato();

			caelum.setId(1L);

			// instancia ContatoDAO

			dao.removeContato(caelum);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
