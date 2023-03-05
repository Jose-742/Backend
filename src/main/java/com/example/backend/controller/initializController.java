package com.example.backend.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.common.Status;
import com.example.backend.model.Autor;
import com.example.backend.model.Avaliacao;
import com.example.backend.model.Avaliador;
import com.example.backend.model.Cronograma;
import com.example.backend.model.Endereco;
import com.example.backend.model.Premio;
import com.example.backend.model.Projeto;
import com.example.backend.service.AutorService;
import com.example.backend.service.AvaliacaoService;
import com.example.backend.service.AvaliadorService;
import com.example.backend.service.ProjetoService;

@RestController
@RequestMapping("/teste")
public class initializController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private AvaliadorService avaliadorService;
	
	
	@GetMapping("/save")
	public ResponseEntity<?> salvar(){
		//init();
		return ResponseEntity.notFound().build();
	}
	public void init() {
		Premio p = new Premio();
		p.setNome("Prêmio Bravo");
		p.setDescricao("Esse prêmio é o segundo mais importante desse sistema");
		p.setAno(2023);
		p.setCronograma( new Cronograma(null,LocalDate.parse("2023-04-04") , "Envio dos Projetos e Avaliação", LocalDate.parse("2023-03-03") ));
		
		Endereco e = new Endereco();//endereço do avaliador
		e.setBairro("Plano Diretor sul");
		e.setCep("77021-090");
		e.setLocalidade("Palmas");
		e.setLogradouro("Quadra AE SE 34 Avenida NS 10");
		e.setUf("TO");
		
		Endereco e2 = new Endereco(); //endereço do autor Guilherme
		e2.setBairro("Plano Diretor sul");
		e2.setCep("77020-122");
		e2.setLocalidade("Palmas");
		e2.setLogradouro("ARSE 13 Alameda 11");
		e2.setUf("TO");
		
		Endereco e3 = new Endereco();//endereço do autor Mauricio
		e3.setBairro("Plano Diretor Norte");
		e3.setCep("77000-1562");
		e3.setLocalidade("Palmas");
		e3.setLogradouro("407 Norte Alameda 6");
		e3.setUf("TO");
		
		Endereco e4 = new Endereco();//endereço do autor José Carlos
		e4.setBairro("Plano Diretor Norte");
		e4.setCep("77001-366");
		e4.setLocalidade("Palmas");
		e4.setLogradouro("305 Norte Arno 32 s/n");
		e4.setUf("TO");		
		
		Avaliador a = new Avaliador();
		a.setNome("Marcus");
		a.setSobrenome("Oliveira");
		a.setDataNascimento(LocalDate.parse("1970-09-07"));
		a.setCpf("962.013.060-05");
		a.setEmail("marcus@gmail.com");		
		a.setTelefone("(63)99359-8294");
		a.setDataAdmissao(LocalDate.parse("2018-03-04"));
		a.setRegistro(86545612332L);
		a.setEndereco(e);
		//salvando avaliador e endereço
		avaliadorService.save(a);
		
		Autor au = new Autor();
		au.setNome("Guilherme");
		au.setSobrenome("Figueiredo");
		au.setDataNascimento(LocalDate.parse("1993-02-10"));
		au.setCpf("902.218.171-58");
		au.setEmail("guilherme@gmail.com");
		au.setTelefone("(63)98175-8669");
		au.setEndereco(e2);
		//salvando autor e endereco 2
		autorService.save(au);
		
		
		Autor au2 = new Autor();
		au2.setNome("Mauricio");
		au2.setSobrenome("Alves");
		au2.setDataNascimento(LocalDate.parse("1995-06-11"));
		au2.setCpf("080.218.171-28");
		au2.setEmail("mauricio@gmail.com");
		au2.setTelefone("(63)99258-5654");
		au2.setEndereco(e3);
		//salvando autor 2 e endereco 3
		autorService.save(au2);
		
		Autor au3 = new Autor();
		au3.setNome("José Carlos");
		au3.setSobrenome("Bento");
		au3.setDataNascimento(LocalDate.parse("1992-03-05"));
		au3.setCpf("042.111.188-50");
		au3.setEmail("carolos@gmail.com");
		au3.setTelefone("(63)98443-8829");
		au3.setEndereco(e4);
		//salvando autor 3 e endereco 4
		autorService.save(au3);
		
		Projeto prod = new Projeto();
		prod.setArea("Desenvolvimento de Software");
		prod.setDataEnvio(LocalDate.parse("2023-03-15"));
		prod.setResumo("Desenvolvimento de um aplicativo de gerenciamento de finanças pessoais");
		prod.setStatus(Status.ENVIADO);
		prod.setTitulo("Finanças Pessoais");
		au.setProjeto(prod);
		prod.addAutor(au);
		//salvando projeto e adicionando autor
		projetoService.save(prod);
		
		Projeto prod2 = new Projeto();
		prod2.setArea("Desenvolvimento de Software");
		prod2.setDataEnvio(LocalDate.parse("2023-03-17"));
		prod2.setResumo("Desenvolvimento de um sistema web de uma clinica medica");
		prod2.setStatus(Status.ENVIADO);
		prod2.setTitulo("Clinica Medica");
		au2.setProjeto(prod2);
		prod2.addAutor(au2);
		
		//salvando projeto e adicionando autor 2
		projetoService.save(prod2);
		
		Projeto prod3 = new Projeto();
		prod3.setArea("Desenvolvimento de Software");
		prod3.setDataEnvio(LocalDate.parse("2023-03-20"));
		prod3.setResumo("Sistema de cadastro de eventos para uma escola");
		prod3.setStatus(Status.ENVIADO);
		prod3.setTitulo("EGEFAZ");
		au3.setProjeto(prod3);
		prod3.addAutor(au3);
		//salvando projeto e adicionando autor 3
		projetoService.save(prod3);

		Avaliacao av = new Avaliacao();
		av.setDataAvaliacao(LocalDate.parse("2023-03-18"));
		av.setNota(9.6);
		av.setParecer("Os principais aspectos sao arquitetura, desempenho e facilidade de uso");
		av.setAvaliador(a);
		av.setProjeto(prod);
		//salvando avalicao e adicionando avaliador e projeto
		avaliacaoService.save(av);
		
		Avaliacao av2 = new Avaliacao();
		av2.setDataAvaliacao(LocalDate.parse("2023-03-19"));
		av2.setNota(5.5);
		av2.setParecer("Foi encontrado algumas falhas nas notificações dos eventos");
		av2.setAvaliador(a);
		av2.setProjeto(prod2);
		//salvando avalicao e adicionando avaliador e projeto 2
		avaliacaoService.save(av2);
		
	}
	

}

