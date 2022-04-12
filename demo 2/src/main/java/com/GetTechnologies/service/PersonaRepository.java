package com.GetTechnologies.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GetTechnologies.model.Persona;



public interface PersonaRepository extends JpaRepository<Persona, Long>{
	@Query("SELECT p FROM Persona p WHERE p.identificacion=?1")
	Optional<Persona>findByIdentificacion (int identificacion);
	
}

	
