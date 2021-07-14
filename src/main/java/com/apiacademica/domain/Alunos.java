package com.apiacademica.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
public class Alunos {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDalunos;
	
	private String RA;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpf;
	@NotNull	
	private String endereco;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false, 
			columnDefinition = "varchar(36) not null")
    private String uuid;
	
	public Alunos() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}
	
	
	public Long getIDalunos() {
		return IDalunos;
	}
	public void setIDalunos(Long iDalunos) {
		IDalunos = iDalunos;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public  String  getUuid () {
		return uuid;
	}


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
