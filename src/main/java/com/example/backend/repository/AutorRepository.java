package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	//select p.titulo from bd_backend.autor a, bd_backend.projeto p where a.id_projeto_fk = p.id;
	@Query(value =  "select a from Autor a, Projeto p where a.projeto = p.id")
	List<Autor> findAllAutorProjeto();

}
