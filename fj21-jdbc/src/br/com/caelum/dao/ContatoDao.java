package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.exception.DAOException;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	private String sql = "select * from contatos";

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveContact(Contato contato) {

		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			Date d = new Date(contato.getDataNascimento().getTimeInMillis());
			stmt.setDate(4, d);

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	public List<Contato> getListOne(Long id){
		this.sql += " WHERE ID = " + id;
		
		List<Contato> contato = this.getList();
		
		return contato;
		
	}

	public List<Contato> getListName(String name){
		this.sql += " WHERE upper(nome) like('%" + name.toUpperCase() + "%')";
		
		List<Contato> contato = this.getList();
		
		return contato;
		
	}	
	
	public List<Contato> getList(){
		
		try{
						
			List<Contato> contatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.connection.prepareStatement(this.sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));		
				contato.setDataNascimento(dataNascimento);
				
				contatos.add(contato);
			}
			
			return contatos;
			
		}catch (SQLException e){
			throw new DAOException(e);
		}
				
	}
}
