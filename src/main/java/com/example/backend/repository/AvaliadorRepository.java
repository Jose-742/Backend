package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Avaliador;

public interface AvaliadorRepository extends JpaRepository<Avaliador, Long>{

	List<Avaliador> findByExcluidoFalse();

	@Query("SELECT a FROM Avaliador a WHERE a.excluido = false and a.id = :id")
	Avaliador findByIdExcluidoFalse(Long id);

}
