package com.example.backend.DTO;

import java.time.LocalDate;

import com.example.backend.model.Avaliacao;
import com.example.backend.model.Avaliador;
import com.example.backend.model.Projeto;

public class AvaliacaoDTO {

	private Long id;
	private Projeto projeto;
	private Avaliador avaliador;
	private String parecer;
	private double nota;
	private LocalDate dataAvaliacao;
	
	public AvaliacaoDTO(Avaliacao avaliacao) {
		this.id = avaliacao.getId();
		this.projeto = avaliacao.getProjeto();
		this.avaliador = avaliacao.getAvaliador();
		this.parecer = avaliacao.getParecer();
		this.nota = avaliacao.getNota();
		this.dataAvaliacao = avaliacao.getDataAvaliacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
}
