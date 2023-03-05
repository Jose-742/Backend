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
	
	public List<Autor> findAll(){
		return repository.findAll();
	}
	
	public List<Autor> findAllAutorProjeto(){
		return repository.findAllAutorProjeto();
	}
}
