package com.example.backend.DTO;

import java.time.LocalDate;

import com.example.backend.model.Avaliador;
import com.example.backend.model.Endereco;

public class AvaliadorDTO {
	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataNascimento;
	private Endereco endereco;
	private String telefone;
	private String email;
	private Long registro;
	private LocalDate dataAdmissao;
	public AvaliadorDTO(Avaliador avaliador) {
		this.id = avaliador.getId();
		this.nome = avaliador.getNome();
		this.sobrenome = avaliador.getSobrenome();
		this.cpf = avaliador.getCpf();
		this.dataNascimento = avaliador.getDataNascimento();
		this.endereco = avaliador.getEndereco();
		this.telefone = avaliador.getTelefone();
		this.email = avaliador.getEmail();
		this.registro = avaliador.getRegistro();
		this.dataAdmissao = avaliador.getDataAdmissao();
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
