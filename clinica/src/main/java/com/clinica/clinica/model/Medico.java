package com.clinica.clinica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	private String crm;
	
	@Column(name = "nome", nullable = false, length = 80)
	private String nome;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEspecialidade", 
	referencedColumnName = "codEspecialidade")
	@JsonIgnoreProperties("especialidade")
	private Especialidade especialidade;


	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Especialidade getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
}