package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Projeto;
import com.example.backend.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	public void save(Projeto projeto) {
		repository.save(projeto);
	}
	
	public List<Projeto> findByProjetoStatusEnviado(){
		return repository.findByProjetoStatusEnviado();
	}
	
	public List<Projeto> findAll(){
		return repository.findAll();
	}
}
