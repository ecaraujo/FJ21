package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String className = req.getParameter("logica");
		className = "br.com.caelum.mvc.logica." + className;
		
		try{
			Class clazz = Class.forName(className);
			
			Logica logica = (Logica) clazz.newInstance();
			String pagina = logica.executa(req, res);
			
			req.getRequestDispatcher(pagina).forward(req, res);
			
		}catch(Exception e){
			throw new ServletException("A lógica de negocios causou uma excecão: ", e);
		}
		
	}

}
