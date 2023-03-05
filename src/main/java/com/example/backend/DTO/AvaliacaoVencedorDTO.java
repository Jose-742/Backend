package com.example.backend.DTO;

import java.time.LocalDate;

import com.example.backend.model.Projeto;

public class AvaliacaoVencedorDTO {
	
	private Long id;
	private Projeto projeto;
	private String parecer;
	private double nota;
	private LocalDate dataAvaliacao;
	
	public AvaliacaoVencedorDTO(Long id, Projeto projeto, String parecer, double nota, LocalDate dataAvaliacao) {
		this.id = id;
		this.projeto = projeto;
		this.parecer = parecer;
		this.nota = nota;
		this.dataAvaliacao = dataAvaliacao;
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
