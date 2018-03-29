package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	
	public void adiciona(Funcionario funcionario){
		
		String sql = "insert into funcionario(nome, usuario,senha) values (?, ?, ?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());		
			
			stmt.execute();
			
			System.out.println("Registro inserido!");
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
