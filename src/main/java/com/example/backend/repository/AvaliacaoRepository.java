package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

	@Query("SELECT a FROM Avaliacao a WHERE a.nota > 6.0 ORDER BY a.nota DESC")
	List<Avaliacao> findByVencedores();

}
