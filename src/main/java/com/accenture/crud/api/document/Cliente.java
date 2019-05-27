package com.accenture.crud.api.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4252492367802336966L;
	@Id
	private String Id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String cep;
	public Cliente(String nome, String cpf, String telefone, String endereco, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String toString() {
		return "Dados do cliente inseridos: \n"+
				"Nome: "+nome+"\n" + 
				"CPF: "+cpf+"\n" + 
				"Telefone: "+telefone+"\n" + 
				"Endereco: "+endereco+"\n" + 
				"CEP: "+cep+"";
	}
	
	public String toStringAlter() {
		return "Dados do cliente Alterados: \n"+
				"Nome: "+nome+"\n" + 
				"CPF: "+cpf+"\n" + 
				"Telefone: "+telefone+"\n" + 
				"Endereco: "+endereco+"\n" + 
				"CEP: "+cep+"";
	}
}
