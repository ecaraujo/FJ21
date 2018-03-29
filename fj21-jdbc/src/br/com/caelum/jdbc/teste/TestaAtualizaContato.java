package br.com.caelum.jdbc.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAtualizaContato {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("11/05/1982");
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(d);

		contato.setId(2L);
		contato.setNome("Edson Carlos de Araujo");
		contato.setEmail("alterado@hotmail.com");
		contato.setEndereco("Av. testes 234");
		contato.setDataNascimento(dataNascimento);

		dao.altera(contato);

	}

}
