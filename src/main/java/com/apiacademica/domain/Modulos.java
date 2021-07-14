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

@Entity
public class Modulos {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IDmodulos;
	public long getIDmodulos() {
		return IDmodulos;
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false, 
			columnDefinition = "varchar(36) not null")
    private String uuid;
	
	public Modulos() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}
	
	public void setIDmodulos(long iDmodulos) {
		IDmodulos = iDmodulos;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	private String RA;
	private String disciplina;
	private String data_inicio;
	private String data_fim;
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
