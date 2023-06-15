package com.fieb.tcc.academicologin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

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
	
	
	@OneToMany(mappedBy = "guia", cascade = CascadeType.ALL)
	private List<GuiaFavorito> guiasFavoritos = new ArrayList<GuiaFavorito>();
	
	
	

	public List<GuiaFavorito> getGuiasFavoritos() {
		return guiasFavoritos;
	}
	public void setGuiasFavoritos(List<GuiaFavorito> guiasFavoritos) {
		this.guiasFavoritos = guiasFavoritos;
	}
	
	
	
	
}

