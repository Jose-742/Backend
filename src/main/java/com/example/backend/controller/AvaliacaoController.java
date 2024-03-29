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

import com.example.backend.DTO.AvaliacaoDTO;
import com.example.backend.DTO.AvaliacaoVencedorDTO;
import com.example.backend.common.Status;
import com.example.backend.model.Avaliacao;
import com.example.backend.model.Avaliador;
import com.example.backend.model.Projeto;
import com.example.backend.service.AvaliacaoService;
import com.example.backend.service.AvaliadorService;
import com.example.backend.service.PremioService;
import com.example.backend.service.ProjetoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private AvaliadorService avaliadorService;
		
	@Autowired
	private PremioService premioService;
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> listarAvaliados(){
		List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
		avaliacaoService.findAll().forEach(avaliacao -> avaliacoes.add( new AvaliacaoDTO(avaliacao)));	
		return ResponseEntity.ok(avaliacoes);
	}
	
	@GetMapping("/vencedor")
	public ResponseEntity<List<AvaliacaoVencedorDTO>> listarVencedores(){
		List<AvaliacaoVencedorDTO> vencedores = new ArrayList<>();
		avaliacaoService.findByVencedores().forEach(avaliacao ->vencedores.add(new AvaliacaoVencedorDTO(avaliacao)));		
		return ResponseEntity.ok(vencedores);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Avaliacao avaliacao, BindingResult result){
		if(result.hasErrors())
			return ResponseEntity.status(422).build();
		Avaliador avaliador = avaliadorService.findById(avaliacao.getAvaliador().getId());
		Projeto projeto = projetoService.findById(avaliacao.getProjeto().getId());
		projeto.setStatus(Status.AVALIADO);
		if(avaliacao.getNota() >= 6)
			projeto.setPremio(premioService.findById(avaliacao.getProjeto().getPremio().getId()));	
		avaliacao.setProjeto(projeto);
		avaliacao.setAvaliador(avaliador);
		avaliacaoService.save(avaliacao);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Avaliacao avaliacao, BindingResult result){
		if(result.hasErrors())
			return ResponseEntity.status(422).build();
		Avaliador avaliador = avaliadorService.findById(avaliacao.getAvaliador().getId());
		Projeto projeto = projetoService.findById(avaliacao.getProjeto().getId());
		projeto.setStatus(Status.AVALIADO);
		if(avaliacao.getNota() >= 6) {
			projeto.setPremio(premioService.findById(avaliacao.getProjeto().getPremio().getId()));	
		}else {
			projeto.setPremio(null);}
		avaliacao.setProjeto(projeto);
		avaliacao.setAvaliador(avaliador);
		avaliacaoService.update(avaliacao);
		return ResponseEntity.status(201).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Avaliacao> findById(@PathVariable Long id){
		Avaliacao avaliacao = avaliacaoService.findById(id);
		if(avaliacao == null)
			return ResponseEntity.status(404).build();
		return ResponseEntity.ok(avaliacao);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Avaliacao avaliacao = avaliacaoService.findById(id);
		if(avaliacao == null)
			return ResponseEntity.status(404).build();
		avaliacao.setExcluido(true);
		avaliacaoService.delete(avaliacao);
		return ResponseEntity.status(204).build();
	}
	
}
