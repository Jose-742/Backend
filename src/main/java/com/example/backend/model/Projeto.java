package com.example.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.backend.common.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String area;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String resumo;
	
	@OneToOne
	private Autor autor;
	
	@Column(name = "dt_envio", nullable = false)
	private LocalDate dataEnvio;
	
	
	private Status status;
	
	@OneToOne
	private Premio premio;

	public Projeto() {}
	
	public Projeto(Long id, String area, String titulo, String resumo, Autor autor,
			LocalDate dataEnvio, Status status, Premio premio) {
		this.id = id;
		this.area = area;
		this.titulo = titulo;
		this.resumo = resumo;
		this.autor = autor;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.premio = premio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}
}
