package com.GetTechnologies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.GetTechnologies.model.Factura;

public class Ventas {
	private final FacturaRepository facturaRepository;
	
	@Autowired
	public Ventas(FacturaRepository facturaReposoitory) { 
		super();
		this.facturaRepository = facturaReposoitory;
	}//constructor
	
	public Factura getFactura (Long id) {
		return
				facturaRepository.findById(id).orElseThrow(()-> new IllegalStateException ("La factura con el id " + id + " no existe."));
	}//findFacturasByPersona
	
	
	public void storeFactura (Factura fac) {
		Optional<Factura> facById = facturaRepository.findById(fac.getId());
		if(facById.isPresent()) {
			throw new IllegalStateException("La factura con el id " + fac.getId() + " ya existe.");
		}else {
			facturaRepository.save(fac);
		}//if
	}//storeFactura

}//class ventas
