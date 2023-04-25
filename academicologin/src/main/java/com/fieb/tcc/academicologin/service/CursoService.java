package com.fieb.tcc.academicologin.service;

import java.util.Collection;
import java.util.Optional;

import com.fieb.tcc.academicologin.model.Curso;

public interface CursoService {
	
	Curso save(Curso curso);
	Collection<Curso> findAll();
	Optional<Curso>findById(Long id);

}
