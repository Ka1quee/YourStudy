package com.fieb.tcc.academicologin.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue(value = "Aluno")
public class Aluno extends User {
	
	private String position;
	
	public Aluno() {
		
	}

	public Aluno(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super(firstName, lastName, email, password, roles);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@OneToMany
	@JoinColumn(name="user_id")
	@JsonIgnore
	private Collection<Favorito>favoritos;

}
