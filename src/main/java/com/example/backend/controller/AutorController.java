package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.AutorProjetoDTO;
import com.example.backend.model.Autor;
import com.example.backend.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	
	@GetMapping
	public ResponseEntity<List<AutorProjetoDTO>> listarAutoresProjetos(){
		// Listar autores e projetos (Geral);
		List<AutorProjetoDTO> autores = new ArrayList<>();
		autorService.findAllAutorProjeto().forEach(a-> 
			autores.add( new AutorProjetoDTO(a.getId(), a.getNome(), a.getSobrenome(), a.getCpf(), a.getDataNascimento(),a.getEndereco()
					, a.getTelefone(), a.getEmail(), a.getProjeto()))
		);
		return ResponseEntity.ok(autores);
	}
	
	@PostMapping
	public ResponseEntity<?> save(Autor autor){
		System.out.println(autor.toString());
		
		return ResponseEntity.ok().build();
	}
}
