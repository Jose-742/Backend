package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.ProjetoAutorDTO;
import com.example.backend.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping
	public ResponseEntity<List<ProjetoAutorDTO> > listarProjetosAutores(){
		// Listar projetos e autores (Geral);
		List<ProjetoAutorDTO> projetos = new ArrayList<>();
		projetoService.findAll().forEach(p -> 
			projetos.add(new ProjetoAutorDTO(p.getId(), p.getArea(), p.getTitulo(), 
					p.getResumo(), p.getAutores(), p.getDataEnvio(), p.getStatus(), p.getPremio()))
		);
		return ResponseEntity.ok(projetos);
	}
	
	@GetMapping("/enviado")
	public ResponseEntity<List<ProjetoAutorDTO>> listarProjetosEnviados(){
		// Listar projetos enviado não avaliado (visualizar dados dos projetos, inclusive autores);
		List<ProjetoAutorDTO> projetos = new ArrayList<>();
		projetoService.findByProjetoStatusEnviado().forEach(p ->
			projetos.add(new ProjetoAutorDTO(p.getId(), p.getArea(), p.getTitulo(), 
					p.getResumo(),p.getAutores(), p.getDataEnvio(), p.getStatus(), p.getPremio()))
		);
		return ResponseEntity.ok(projetos);
	}
}
