package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	
	@Query("select p from Projeto p where p.excluido = false and p.status = 0")
	List<Projeto> findByProjetoStatusEnviado();

	List<Projeto> findByExcluidoFalse();

	@Query("SELECT p FROM Projeto p WHERE p.excluido = false and p.id = :id")
	Projeto findByIdExcluidoFalse(Long id);
}
