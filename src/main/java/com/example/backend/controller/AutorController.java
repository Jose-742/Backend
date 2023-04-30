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

import com.example.backend.DTO.AutorProjetoDTO;
import com.example.backend.model.Autor;
import com.example.backend.service.AutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping
	public ResponseEntity<List<AutorProjetoDTO>> listarAutoresProjetos() {
		List<AutorProjetoDTO> autores = new ArrayList<>();
		autorService.findAll().forEach(a -> autores.add(new AutorProjetoDTO(a)));
		return ResponseEntity.ok(autores);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Autor autor, BindingResult result) {
		if (result.hasErrors()) 
			return ResponseEntity.status(422).build();
		autorService.save(autor);
		return ResponseEntity.status(201).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Autor autor, BindingResult result) {
		if (result.hasErrors()) 
			return ResponseEntity.status(422).build();
		autorService.update(autor);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> findById(@PathVariable Long id) {
		Autor autor = autorService.findById(id);
		if (autor == null) 
			return ResponseEntity.status(404).build();
		return ResponseEntity.ok(autor);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Autor> delete(@PathVariable Long id) {
		Autor autor = autorService.findById(id);
		if (autor == null) 
			return ResponseEntity.status(404).build();
		autor.setExcluido(true);
		autorService.delete(autor);
		return ResponseEntity.status(204).build();
	}
}
