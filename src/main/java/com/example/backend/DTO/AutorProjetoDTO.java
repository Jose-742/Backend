package com.example.backend.DTO;

import java.time.LocalDate;

import com.example.backend.model.Autor;
import com.example.backend.model.Endereco;

public class AutorProjetoDTO {
    private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String telefone;
	private String email;
	private ProjetoDTO projetoDTO;
	
	
	public AutorProjetoDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.sobrenome = autor.getSobrenome();
		this.cpf = autor.getCpf();
		this.dataNascimento = autor.getDataNascimento();
		this.endereco = autor.getEndereco();
		this.telefone = autor.getTelefone();
		this.email = autor.getEmail();
		if(autor.getProjeto() != null)
			this.projetoDTO = new ProjetoDTO(autor.getProjeto());
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
	public ProjetoDTO getProjeto() {
		return projetoDTO;
	}
	public void setProjeto(ProjetoDTO projeto) {
		this.projetoDTO = projeto;
	}
}
