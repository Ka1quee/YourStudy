package com.fieb.tcc.academicologin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fieb.tcc.academicologin.model.Guia;

public interface GuiaRepository extends JpaRepository<Guia, Long> {
	
/*
	public List<Guia> findByNomeContainingIgnoreCase(String titulo); 
	*/

}
