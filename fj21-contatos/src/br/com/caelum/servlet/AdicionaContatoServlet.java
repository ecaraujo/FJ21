package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/gravaContato")
public class AdicionaContatoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		Contato contato = new Contato();
		Calendar dataNascimento = Calendar.getInstance();
				
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dataNascimento"));
			dataNascimento.setTime(date);
			contato.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.saveContact(contato);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pw.println("Contato "+ contato.getNome() + " salvo com sucesso!");
	}
	

}
