package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	List<Autor> findByExcluidoFalse();

	@Query("SELECT a FROM Autor a WHERE a.excluido = false and a.id = :id")
	Autor findByIdExcluidoFalse(Long id);

	@Modifying
	@Query("UPDATE Autor a SET a.projeto = :valor WHERE a.projeto.id = :idProjeto")
	void cleanIdProjeto(String valor, Long idProjeto);

}
