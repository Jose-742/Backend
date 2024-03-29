package com.example.backend.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.backend.common.Status;
import com.example.backend.model.Autor;
import com.example.backend.model.Premio;
import com.example.backend.model.Projeto;

public class ProjetoAutorDTO {
	
	private Long id;
	private String area;
	private String titulo;
	private String resumo;
	private List<Autor> autores;
	private LocalDate dataEnvio;
	private Status status;
	private Premio premio;
	
	public ProjetoAutorDTO(Projeto projeto) {
		this.id = projeto.getId();
		this.area = projeto.getArea();
		this.titulo = projeto.getTitulo();
		this.resumo = projeto.getResumo();
		this.autores = projeto.getAutores();
		this.dataEnvio = projeto.getDataEnvio();
		this.status = projeto.getStatus();
		this.premio = projeto.getPremio();
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
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
