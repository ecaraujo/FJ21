package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MostraHora", urlPatterns = {"/hoje", "/hora"})
public class MostraHora extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		
		pw.println("<html><body><h1>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		Calendar c = Calendar.getInstance();
		
		pw.println(sdf.format(c.getTime()));
		
		pw.println(req.getParameter("nome"));
		
		pw.println("</h1></body></html>");
		
	}
	
}
