package com.example.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Projeto projeto;
	
	@OneToOne
	private Avaliador avaliador;
	
	@NotBlank
	private String parecer;
	
	@NotNull
	private double nota;
	
	@Column(name = "dt_avaliacao", nullable = false)
	private LocalDate dataAvaliacao;
	
	private boolean excluido = false; 

	public Avaliacao() {
		this.dataAvaliacao = LocalDate.now();
	}
	
	public Avaliacao(Long id, Projeto projeto, Avaliador avaliador,String parecer, double nota,
			LocalDate dataAvaliacao) {
		this.id = id;
		this.projeto = projeto;
		this.avaliador = avaliador;
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

	public boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}
}
