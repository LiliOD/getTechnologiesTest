package com.GetTechnologies.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GetTechnologies.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

	@Query("SELECT f FROM Factura f WHERE f.fecha=?1")
	Optional<Factura> findByFecha (Date fecha);
}//interface FacturaRepository
