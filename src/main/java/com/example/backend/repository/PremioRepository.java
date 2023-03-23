package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Premio;

public interface PremioRepository extends JpaRepository<Premio, Long>{

	List<Premio> findByExcluidoFalse();

}
