package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		Connection conn = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(conn);
		
		
//		recebe uma string do request e converte para long que é o tipo do atributo da Classe Contato.
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		dao.exclui(contato);
		
		return "mvc?logica=ListaContatosLogic";
	}

}
