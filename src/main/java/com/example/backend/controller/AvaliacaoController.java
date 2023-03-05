package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.AvaliacaoDTO;
import com.example.backend.DTO.AvaliacaoVencedorDTO;
import com.example.backend.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> listarAvaliados(){
		// Listar Projetos avaliados (visualizar dados projetos e dados da avaliação);
		List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
		avaliacaoService.findAll().forEach(a -> 
			avaliacoes.add( new AvaliacaoDTO(a.getId(), a.getProjeto(),
					a.getAvaliador(), a.getParecer(), a.getNota(), a.getDataAvaliacao()))
		);
		
		return ResponseEntity.ok(avaliacoes);
	}
	
	@GetMapping("/vencedor")
	public ResponseEntity<List<AvaliacaoVencedorDTO>> listarVencedores(){
		// Listar Projetos vencedores por ordem de notas maiores (visualizar dados projetos);
		List<AvaliacaoVencedorDTO> vencedores = new ArrayList<>();
		avaliacaoService.findByVencedores().forEach(v ->
			vencedores.add(new AvaliacaoVencedorDTO(v.getId(), v.getProjeto(), 
					v.getParecer(), v.getNota(), v.getDataAvaliacao()))
	    );
		
		return ResponseEntity.ok(vencedores);
	}
}
