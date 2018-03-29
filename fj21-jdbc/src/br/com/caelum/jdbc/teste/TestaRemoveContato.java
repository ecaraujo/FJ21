package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemoveContato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		
		contato.setId(1L);
		
		dao.remove(contato);
		
	}

}
