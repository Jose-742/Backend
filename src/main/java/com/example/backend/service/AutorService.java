package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Autor;
import com.example.backend.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	public void save(Autor autor) {
		repository.save(autor);
	}
	
	public void update(Autor autor) {
		repository.save(autor);
	}
	
	public Autor findById(Long id) {
		return repository.findByIdExcluidoFalse(id);
	}
	
	public void delete(Autor autor) {
		repository.save(autor);
	}
	
	public List<Autor> findAll(){
		return repository.findByExcluidoFalse();
	}
}
