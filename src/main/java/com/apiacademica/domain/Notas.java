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
public class Notas {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IDnotas;
	@NotNull
	private String RA;
	@NotNull
	private String nota1;
	@NotNull
	private String nota2;
	@NotNull
	private String notafinal;
	public long getIDnotas() {
		return IDnotas;
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false, 
			columnDefinition = "varchar(36) not null")
    private String uuid;
	
	public Notas() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}
	
	public void setIDnotas(long iDnotas) {
		IDnotas = iDnotas;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public String getNota1() {
		return nota1;
	}
	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}
	public String getNota2() {
		return nota2;
	}
	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
	public String getNotafinal() {
		return notafinal;
	}
	public void setNotafinal(String notafinal) {
		this.notafinal = notafinal;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
