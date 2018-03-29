package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
//		long tempoInicial = System.currentTimeMillis();
		
//		chain.doFilter(req, res);
		
//		long tempoFinal = System.currentTimeMillis();
//		String uri = ((HttpServletRequest)req).getRequestURI();
//		String parametros = ((HttpServletRequest)req).getParameter("logica");
		
//		System.out.println("Tempo da requisição: "+ uri + "?logica=" + parametros + "demorou (ms): " + (tempoFinal - tempoInicial));

		
		try{
			Connection connection =  new ConnectionFactory().getConnection();
			req.setAttribute("conexao", connection);
			
			chain.doFilter(req, res);
			
			connection.close();
			
		}catch (SQLException e){
			throw new ServletException();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
