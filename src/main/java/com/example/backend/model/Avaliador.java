package com.example.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Transactional
@Entity
public class Avaliador extends Pessoa{
	private static final long serialVersionUID = 1L;

	//@Length(message = "São 11 números", max = 11, min = 11)
	private Long registro;
	
	@Column(name = "dt_admissao", nullable = false)
	private LocalDate dataAdmissao;

	public Avaliador() {}
	
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
