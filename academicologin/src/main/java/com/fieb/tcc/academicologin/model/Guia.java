package com.fieb.tcc.academicologin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Guia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id; 
	

	@NotBlank(message = "O nome nao pode ser vazio.")
	private String titulo;
	private String descricao;
	private String conteudoEscrito;
	private String conclusao;
	
	//Getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConteudoEscrito() {
		return conteudoEscrito;
	}
	public void setConteudoEscrito(String conteudoEscrito) {
		this.conteudoEscrito = conteudoEscrito;
	}
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	
	
	
}

