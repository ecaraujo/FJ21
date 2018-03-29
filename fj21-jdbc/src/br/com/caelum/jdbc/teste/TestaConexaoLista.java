package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;
import br.com.caelum.util.Util;

public class TestaConexaoLista {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ContatoDao dao = new ContatoDao();
		Util util = new Util();
		List<Contato> contatos = dao.getListName("ara");

		for (Contato contato : contatos) {
			System.out.println(
					"Contato ID: " + contato.getId() + " =======================================================");
			System.out.println("Nome:               " + contato.getNome());
			System.out.println("E-mail:             " + contato.getEmail());
			System.out.println("Endereço:           " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + util.format(contato.getDataNascimento().getTime(),"dd/MM/yyyy"));

		}
		System.out.println("=====================================================================");
	}

}
