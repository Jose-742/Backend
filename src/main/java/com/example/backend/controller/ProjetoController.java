package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.backend.DTO.ProjetoAutorDTO;
import com.example.backend.model.Autor;
import com.example.backend.model.Projeto;
import com.example.backend.service.AutorService;
import com.example.backend.service.ProjetoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<ProjetoAutorDTO> > listarProjetosAutores(){
		List<ProjetoAutorDTO> projetos = new ArrayList<>();
		projetoService.findAll().forEach(projeto -> projetos.add(new ProjetoAutorDTO(projeto)));
		return ResponseEntity.ok(projetos);
	}
	
	@GetMapping("/enviado")
	public ResponseEntity<List<ProjetoAutorDTO>> listarProjetosEnviados(){
		List<ProjetoAutorDTO> projetos = new ArrayList<>();
		projetoService.findByProjetoStatusEnviado().forEach(projeto -> projetos.add(new ProjetoAutorDTO(projeto)));
		return ResponseEntity.ok(projetos);
	}
		
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Projeto projeto, BindingResult result){
		if(result.hasErrors())
			return ResponseEntity.status(422).build();
		List<Autor> autores =autorService.vincularAutorProjeto(projeto);	
		projeto.setAutor(autores);
		projetoService.save(projeto);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Projeto projeto, BindingResult result){
		if(result.hasErrors())
			return ResponseEntity.status(422).build();
		autorService.cleanIdProjeto(projeto.getId());
		List<Autor> autores = autorService.vincularAutorProjeto(projeto);
		projeto.setAutores(autores);
		projetoService.update(projeto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> findById(@PathVariable Long id){
		Projeto projeto = projetoService.findById(id);
		if(projeto == null)
			return ResponseEntity.status(404).build();
		return ResponseEntity.ok(projeto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		HttpStatus status = projetoService.delete(id);
		return ResponseEntity.status(status).build();
	}
}
