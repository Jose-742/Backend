package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.AvaliadorDTO;
import com.example.backend.model.Avaliador;
import com.example.backend.service.AvaliadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliador")
public class AvaliadorController {
	@Autowired
	private AvaliadorService avaliadorService;

	@GetMapping
	public ResponseEntity<List<AvaliadorDTO>> listarAutoresProjetos() {
		List<AvaliadorDTO> avaliadores = new ArrayList<>();
		avaliadorService.findAll().forEach(avaliador -> avaliadores.add(new AvaliadorDTO(avaliador)));
		return ResponseEntity.ok(avaliadores);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Avaliador avaliador, BindingResult result) {
		if (result.hasErrors()) 
			return ResponseEntity.status(422).build();
		avaliadorService.save(avaliador);
		return ResponseEntity.status(201).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Avaliador avaliador, BindingResult result) {
		if (result.hasErrors()) 
			return ResponseEntity.status(422).build();
		avaliadorService.update(avaliador);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Avaliador> findById(@PathVariable Long id) {
		Avaliador avaliador = avaliadorService.findById(id);
		if (avaliador == null) 
			return ResponseEntity.status(404).build();
		return ResponseEntity.ok(avaliador);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Avaliador avaliador = avaliadorService.findById(id);
		if (avaliador == null) 
			return ResponseEntity.status(404).build();
		avaliador.setExcluido(true);
		avaliadorService.delete(avaliador);
		return ResponseEntity.status(204).build();
	}
}
