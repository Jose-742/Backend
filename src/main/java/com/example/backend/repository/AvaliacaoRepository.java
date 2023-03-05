package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

	@Query("select a from Avaliacao a where a.nota > 6.0")
	List<Avaliacao> findByVencedores();

}
