package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Avaliacao;
import com.example.backend.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;
		
	public void save(Avaliacao avaliacao) {
		repository.save(avaliacao);
	}
	
	public void update(Avaliacao avaliacao) {
		repository.save(avaliacao);
	}
	
	public Avaliacao findById(Long id) {
		return repository.findByIdExcluidoFalse(id);
	}
	
	public void delete(Avaliacao avaliacao) {
		repository.save(avaliacao);
	}
	
	public List<Avaliacao> findAll(){
		return repository.findByExcluidoFalse();
	}
	
	public List<Avaliacao> findByVencedores(){
		return repository.findByVencedores();
	}
}
