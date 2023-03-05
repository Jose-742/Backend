package com.example.backend.DTO;

import java.time.LocalDate;

import com.example.backend.model.Endereco;
import com.example.backend.model.Projeto;

public class AutorDTO {
    private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String telefone;
	private String email;
	private Projeto projeto;
	
	
	public AutorDTO(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, Endereco endereco,
			String telefone, String email, Projeto projeto) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.projeto = projeto;
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
