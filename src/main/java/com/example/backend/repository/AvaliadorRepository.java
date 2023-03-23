package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Avaliador;

public interface AvaliadorRepository extends JpaRepository<Avaliador, Long>{

	List<Avaliador> findByExcluidoFalse();

}
