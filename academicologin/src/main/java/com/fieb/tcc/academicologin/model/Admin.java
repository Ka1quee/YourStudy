package com.fieb.tcc.academicologin.model;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends User {
	
	private int score;
	
	private String professionalLevel;

	public Admin() {
	}

	public Admin(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super(firstName, lastName, email, password, roles);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getProfessionalLevel() {
		return professionalLevel;
	}

	public void setProfessionalLevel(String professionalLevel) {
		this.professionalLevel = professionalLevel;
	}
	
	
	
	

}
