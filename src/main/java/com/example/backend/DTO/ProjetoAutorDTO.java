package com.example.backend.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.backend.common.Status;
import com.example.backend.model.Autor;
import com.example.backend.model.Premio;

public class ProjetoAutorDTO {
	
	private Long id;
	private String area;
	private String titulo;
	private String resumo;
	private List<Autor> autores;
	private LocalDate dataEnvio;
	private Status status;
	private Premio premio;
	
	public ProjetoAutorDTO(Long id, String area, String titulo, String resumo, List<Autor> autores, LocalDate dataEnvio,
			Status status, Premio premio) {
		this.id = id;
		this.area = area;
		this.titulo = titulo;
		this.resumo = resumo;
		this.autores = autores;
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
