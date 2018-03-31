package br.com.caelum.modelo;

import java.util.Calendar;

public class Contato {
	
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public String getEndereco(){
		return this.endereco;
	}	

	
	public void setDataNascimento(Calendar dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	public Calendar getDataNascimento(){
		return this.dataNascimento;
	}	

}
