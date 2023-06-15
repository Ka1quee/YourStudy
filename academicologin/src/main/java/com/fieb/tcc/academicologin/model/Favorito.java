package com.fieb.tcc.academicologin.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

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
	
	@OneToMany
	@JoinColumn(name="favorito_id")
	@JsonIgnore
	
	
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name="favoritos_guias",
			  joinColumns = @JoinColumn(name="favorito_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name="guia_id", referencedColumnName = "id")
			)
	private Collection<Guia>guias;


	
	
}
