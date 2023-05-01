package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Autor;
import com.example.backend.model.Projeto;
import com.example.backend.repository.AutorRepository;

import jakarta.transaction.Transactional;

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
	
	@Transactional
	public void cleanIdProjeto(Long idProjeto) {
		repository.cleanIdProjeto(null, idProjeto);
	}

	public List<Autor> vincularAutorProjeto(Projeto projeto) {
		List<Autor> autores = new ArrayList<>();
		projeto.getAutores().forEach(a -> {	
			Autor autor = findById(a.getId());
			autor.setProjeto(projeto);
			autores.add(autor);
		});
		return autores;
	}
}
