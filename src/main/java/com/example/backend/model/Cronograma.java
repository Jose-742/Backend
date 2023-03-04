package com.example.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cronograma implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dt_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@NotBlank
	private String descricao;
	
	@Column(name = "dt_fim", nullable = false)
	private LocalDate dataFim;

	public Cronograma() {}
	
	public Cronograma(Long id, LocalDate dataInicio, String descricao, LocalDate dataFim) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.descricao = descricao;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}	
}
