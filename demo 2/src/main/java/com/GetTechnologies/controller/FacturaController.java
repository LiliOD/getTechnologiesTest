package com.GetTechnologies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetTechnologies.model.Factura;
import com.GetTechnologies.service.Ventas;

@RestController
@RequestMapping(path="/api/facturas/")
public class FacturaController {
	public final Ventas ventasService;
	
	@Autowired
	public FacturaController(Ventas ventasService) {
		this.ventasService = ventasService;
	}//constructor
	
	@GetMapping(path = "{facturaId}")
	public Factura getFactura (@PathVariable("facturaId")Long facturaId) {
		return ventasService.getFactura(facturaId);
	}//getFactura
	
	@PostMapping
	public void addFactura (@RequestBody Factura fac) {
		ventasService.storeFactura(fac);
	}//addFactura
	

}//class Factura Controller
