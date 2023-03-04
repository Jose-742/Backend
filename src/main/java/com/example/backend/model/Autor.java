package com.example.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Transactional
@Entity
public class Autor extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	public Autor() {}
	
	public Autor(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, Endereco endereco,
			String telefone, String email) {
		super(id, nome, sobrenome, cpf, dataNascimento, endereco, telefone, email);
	}
}
