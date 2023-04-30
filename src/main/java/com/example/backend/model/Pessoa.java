package com.example.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Long id;
	
	@NotNull @NotBlank
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	
	@NotNull @NotBlank
	@Column(name = "sobrenome", nullable = false, length = 50)
	private String sobrenome;
	
	@NotNull @NotBlank
	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;
	
	@NotNull
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@NotNull @NotBlank
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@NotNull @NotBlank
	@Column(name = "email", nullable = false)
	private String email;
	
	private boolean excluido = false; 

	public Pessoa() {}
	
	public Pessoa(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, Endereco endereco,
			String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
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

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + "]";
	}
}
