package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Premio;

public interface PremioRepository extends JpaRepository<Premio, Long>{

	List<Premio> findByExcluidoFalse();

	@Query("SELECT p FROM Premio p WHERE p.excluido = false and p.id = :id")
	Premio findByIdExcluidoFalse(Long id);

}
