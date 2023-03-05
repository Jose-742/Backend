package com.example.backend.service;

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
}
