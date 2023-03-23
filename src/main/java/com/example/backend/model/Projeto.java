package com.example.backend.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.common.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;

@Transactional
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

	@OneToMany(mappedBy = "projeto")
	private List<Autor> autores;
	
	@Column(name = "dt_envio", nullable = false)
	private LocalDate dataEnvio;
	
	private Status status;
	
	@OneToOne
	private Premio premio;
	
	private boolean excluido = false; 

	public Projeto() {
		this.autores = new ArrayList<>();
		this.status = Status.ENVIADO;
		this.dataEnvio = LocalDate.now();
	}
	
	public Projeto(Long id, String area, String titulo, String resumo, List<Autor> autores,
			LocalDate dataEnvio, Status status, Premio premio) {
		this.id = id;
		this.area = area;
		this.titulo = titulo;
		this.resumo = resumo;
		this.autores = autores;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.premio = premio;
	}
	
	public void addAutor(Autor autor) {
		autores.add(autor);
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

	public void setAutor(List<Autor> autores) {
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

	public boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
