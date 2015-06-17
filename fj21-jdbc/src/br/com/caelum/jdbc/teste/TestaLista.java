package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();

		System.out.println(">>>>>>>>>>>>>>>>>>> get Lista");
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " +contato.getDataNascimento().getTime() + "\n");
		}

		System.out.println(">>>>>>>>>>>>>>>>>>> get contato (where clause)");
		contatos = dao.getContato("Caelum");
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " +contato.getDataNascimento().getTime() + "\n");
		}

	}

}
