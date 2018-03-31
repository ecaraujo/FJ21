package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements Logica{


	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection conn = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(conn);	
		Contato contato = new Contato();
		try{
			contato.setId(Long.parseLong(req.getParameter("id")));
		}catch(NumberFormatException e){
			System.out.println("error: " + e);
		}
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		
		Date c = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataNascimento = Calendar.getInstance();
		c = sdf.parse(req.getParameter("dataNascimento"));
		
		dataNascimento.setTime(c);
		
		contato.setDataNascimento(dataNascimento);
		
		if(contato.getId() == null){
			dao.adiciona(contato);
		}else{
			dao.atualiza(contato);			
		}
		
		return "mvc?logica=ListaContatosLogic";
		
	}
	

}
