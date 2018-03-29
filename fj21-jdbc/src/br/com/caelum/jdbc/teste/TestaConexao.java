package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;
import br.com.caelum.util.Util;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ContatoDao dao = new ContatoDao();
		Util util = new Util();

		Contato contato = new Contato();

		contato.setNome("Edson Araujo");
		contato.setEmail("edson.caraujo@claro.com.br");
		contato.setEndereco("Av. do Guacá");
		contato.setDataNascimento(util.format("05/11/1982","dd/MM/yyyy"));

		dao.saveContact(contato);
		dao.close();
		System.out.println("Contato " + contato.getNome() + " salvo com sucesso!");

	}

}
