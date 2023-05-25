package com.fieb.tcc.academicologin.model;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
	
	

}
