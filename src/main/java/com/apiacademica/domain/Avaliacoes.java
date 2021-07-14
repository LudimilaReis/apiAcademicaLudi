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
public class Avaliacoes {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDavaliacoes;
	@NotNull
	private String RA;
	@NotNull
	private String curso;
	@NotNull
	private String disciplina;
	@NotNull
	private String data;
	public Long getIDavaliacoes() {
		return IDavaliacoes;
		
		
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false, 
			columnDefinition = "varchar(36) not null")
    private String uuid;
	
	public Avaliacoes() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}
	public void setIDavaliacoes(Long iDavaliacoes) {
		IDavaliacoes = iDavaliacoes;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public  String  getUuid () {
		return uuid;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
