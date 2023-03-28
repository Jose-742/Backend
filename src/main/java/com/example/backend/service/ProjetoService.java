package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Projeto;
import com.example.backend.repository.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	@Transactional
	public void save(Projeto projeto) {
		repository.save(projeto);
	}
	
	@Transactional
	public void update(Projeto projeto) {
		repository.save(projeto);
	}
	
	public Projeto findById(Long id) {
		return repository.findByIdExcluidoFalse(id);
	}
	
	public List<Projeto> findByProjetoStatusEnviado(){
		return repository.findByProjetoStatusEnviado();
	}
	
	public List<Projeto> findAll(){
		return repository.findByExcluidoFalse();
	}

	public void delete(Projeto projeto) {
		repository.save(projeto);		
	}
}
