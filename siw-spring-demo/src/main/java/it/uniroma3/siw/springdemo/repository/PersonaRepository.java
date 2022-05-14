package it.uniroma3.siw.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.springdemo.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

	
}
