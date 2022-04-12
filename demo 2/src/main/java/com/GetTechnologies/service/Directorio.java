package com.GetTechnologies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GetTechnologies.model.Persona;

@Service
public class Directorio {
	private final PersonaRepository personaRepository;

	@Autowired
	public Directorio(PersonaRepository personaRepository) {
		super();
		this.personaRepository = personaRepository;
	}//constructor
	
	public List<Persona> getPersonas(){
		return personaRepository.findAll();
	}//findPersonas
	
	public Persona getPersona (Long identificacion) {
		return personaRepository.findById(identificacion).orElseThrow(()-> new IllegalStateException ("La persona con la identificación " + identificacion + " no existe."));
	}//findPersona by identificacion
	
	public void deletePersona (Long identificacion) {
		if (personaRepository.existsById(identificacion)) {
			personaRepository.deleteById(identificacion);
		}//if 
	}//deletePersona by Identificacion
	
	public void storePersona (Persona pers) {
		Optional<Persona> persById = personaRepository.findById( pers.getId());
			if(persById.isPresent()) {
				throw new IllegalStateException("La persona con la identificación " + pers.getId() + " ya existe.");
		}else {
			personaRepository.save(pers);
		}
	}
	//storePersona
	
}//class PersonaService
