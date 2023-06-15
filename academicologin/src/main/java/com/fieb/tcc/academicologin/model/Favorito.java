package com.fieb.tcc.academicologin.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "favoritos")
public class Favorito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id; 
	
	@CreationTimestamp
	private LocalDateTime data;
	
	
	@ManyToOne
	@JoinColumn(name="user_id") // Fk
	private Aluno aluno;
	
	
	
	
	@OneToMany(mappedBy = "favorito", cascade = CascadeType.ALL)
	private List<GuiaFavorito> guiasFavoritos = new ArrayList<GuiaFavorito>();



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDateTime getData() {
		return data;
	}



	public void setData(LocalDateTime data) {
		this.data = data;
	}



	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public List<GuiaFavorito> getGuiasFavoritos() {
		return guiasFavoritos;
	}



	public void setGuiasFavoritos(List<GuiaFavorito> guiasFavoritos) {
		this.guiasFavoritos = guiasFavoritos;
	}






	
	
}
