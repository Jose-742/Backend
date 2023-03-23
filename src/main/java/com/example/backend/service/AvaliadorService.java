package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Avaliador;
import com.example.backend.repository.AvaliadorRepository;

@Service
public class AvaliadorService {

	@Autowired
	private AvaliadorRepository repository;
		
	public void save(Avaliador avaliador) {
		repository.save(avaliador);
	}
	
	public void update(Avaliador avaliador) {
		repository.save(avaliador);
	}
	
	public Avaliador  findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void delete(Avaliador avaliador) {
		repository.save(avaliador);
	}
	
	public List<Avaliador> findAll(){
		return repository.findByExcluidoFalse();
	}
}
