package com.example.backend.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Premio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@OneToOne
	private Cronograma cronograma;
	
	@NotBlank
	private int ano;

	public Premio() {}
	
	public Premio(Long id, String nome, String descricao, Cronograma cronograma,
			  int ano) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cronograma = cronograma;
		this.ano = ano;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}
