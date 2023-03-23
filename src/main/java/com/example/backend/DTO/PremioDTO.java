package com.example.backend.DTO;

import com.example.backend.model.Cronograma;
import com.example.backend.model.Premio;

public class PremioDTO {

	private Long id;
	
	private String nome;

	private String descricao;

	private Cronograma cronograma;
	
	public PremioDTO() {
		
	}

	public PremioDTO(Premio premio) {
		this.id = premio.getId();
		this.nome = premio.getNome();
		this.descricao = premio.getDescricao();
		this.cronograma = premio.getCronograma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}
}
