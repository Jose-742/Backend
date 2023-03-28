package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	List<Autor> findByExcluidoFalse();

	@Query("SELECT a FROM Autor a WHERE a.excluido = false and a.id = :id")
	Autor findByIdExcluidoFalse(Long id);

}
