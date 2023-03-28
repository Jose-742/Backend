package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Premio;
import com.example.backend.repository.PremioRepository;

@Service
public class PremioService {

	@Autowired
	private PremioRepository repository;
	
	public void save(Premio premio) {
		repository.save(premio);
	}
	
	public void update(Premio premio) {
		repository.save(premio);
	}
	
	public Premio findById(Long id) {
		return repository.findByIdExcluidoFalse(id);
	}
	
	public List<Premio> findAll(){
		return repository.findByExcluidoFalse();
	}

	public void delete(Premio premio) {
		repository.save(premio);		
	}
}
