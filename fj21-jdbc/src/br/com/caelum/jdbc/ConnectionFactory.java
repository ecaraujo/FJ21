package br.com.caelum.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	
	public Connection getConnection(){
				
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
}
