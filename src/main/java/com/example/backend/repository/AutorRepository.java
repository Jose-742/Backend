package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	List<Autor> findByExcluidoFalse();

}
