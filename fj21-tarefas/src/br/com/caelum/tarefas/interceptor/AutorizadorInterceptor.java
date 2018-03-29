package br.com.caelum.tarefas.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object COntroller) throws IOException{
		
		String uri = req.getRequestURI();
		
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.endsWith("resources")){
			return true;
		}
		
		if(req.getSession().getAttribute("usuarioLogado") != null){
			return true;
		}
		
		res.sendRedirect("loginForm");
		return false;
		
	}
	
}
