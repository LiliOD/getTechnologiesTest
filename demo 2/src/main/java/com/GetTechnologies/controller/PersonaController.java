package com.GetTechnologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetTechnologies.model.Persona;
import com.GetTechnologies.service.Directorio;

@RestController
@RequestMapping(path="/api/personas/")
public class PersonaController {
	public final Directorio directorioService;
	
	@Autowired
	public PersonaController(Directorio directorioService) {
		this.directorioService = directorioService;
	}//constructor
	
	@GetMapping
	public List<Persona> findPersonas(){
		return directorioService.getPersonas();
	}//getPersonas
	
	@GetMapping(path="{personaId}")
	public Persona findPersona(@PathVariable("personaId")Long personaId) {
	return directorioService.getPersona(personaId);
	}//getPersona
	
	@DeleteMapping(path="{personaId}")
	public void deletePersona(@PathVariable("personaId")Long personaId){
		directorioService.deletePersona(personaId);	
	}//borrarPersona
	
	@PostMapping
	public void addPersona(@RequestBody Persona person) {
		directorioService.storePersona(person);
	}
}//class PersonaController
