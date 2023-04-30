package com.example.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Transactional
@Entity
public class Avaliador extends Pessoa{
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long registro;
	
	@Column(name = "dt_admissao", nullable = false)
	private LocalDate dataAdmissao;
	
	public Avaliador() {
		this.dataAdmissao = LocalDate.now();
	}
	
	public Avaliador(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, Endereco endereco,
			String telefone, String email,Long registro, LocalDate dataAdmissao) {
		super(id, nome, sobrenome, cpf, dataNascimento, endereco, telefone, email);
		this.registro = registro;
		this.dataAdmissao = dataAdmissao;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
