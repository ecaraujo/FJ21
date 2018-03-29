package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDaoListaContatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContatoDao dao = new ContatoDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data Nascimento: " + sdf.format(contato.getDataNascimento().getTime()));
			System.out.println("=========================================================================== \n");
		}

	}

}
