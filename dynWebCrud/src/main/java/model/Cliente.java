package model;

import java.sql.Date;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private Date data_de_nascimento;
	private Date data_de_registro;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	public Date getData_de_registro() {
		return data_de_registro;
	}
	public void setData_de_registro(Date data_de_registro) {
		this.data_de_registro = data_de_registro;
	}
}
