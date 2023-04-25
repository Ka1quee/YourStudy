package com.fieb.tcc.academicologin.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fieb.tcc.academicologin.model.Curso;
import com.fieb.tcc.academicologin.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Collection<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> findById(Long id) {
		return cursoRepository.findById(id);
	}

}
