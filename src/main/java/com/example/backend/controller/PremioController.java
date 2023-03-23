package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.PremioDTO;
import com.example.backend.model.Premio;
import com.example.backend.service.PremioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/premio")
public class PremioController {

	@Autowired
	private PremioService premioService;
	
	@GetMapping
	public ResponseEntity<List<PremioDTO>> list(ModelMap model) {
		List<PremioDTO> premios = new ArrayList<>();
		premioService.findAll().forEach(premio->premios.add(new PremioDTO(premio)));
		return  ResponseEntity.ok(premios);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Premio premio, BindingResult result){
		if(result.hasErrors()) 
			return  ResponseEntity.status(422).build();
		premioService.save(premio);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Premio premio, BindingResult result){
		if(result.hasErrors()) 
			return ResponseEntity.status(422).build();
		premioService.update(premio);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Premio premio = premioService.findById(id);
		if(premio == null)
			return ResponseEntity.status(404).build();
		premio.setExcluido(true);
		premioService.delete(premio);
		return ResponseEntity.status(204).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Premio> findById(@PathVariable Long id){
		Premio premio = premioService.findById(id);
		if(premio == null)
			return ResponseEntity.status(404).build();
		return ResponseEntity.ok(premio);
	}
	
}
