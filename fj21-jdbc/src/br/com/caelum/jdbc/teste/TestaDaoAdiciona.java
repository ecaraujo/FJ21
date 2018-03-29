package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDaoAdiciona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		Calendar dataNascimento = Calendar.getInstance();
		
		contato.setNome("Edson Araujo");
		contato.setEmail("teste@hotmail.com");
		contato.setEndereco("Rua de teste, 123");
		contato.setDataNascimento(Calendar.getInstance());

		dao.adiciona(contato);
		
		System.out.println("Gravado!");
		
	}

}
