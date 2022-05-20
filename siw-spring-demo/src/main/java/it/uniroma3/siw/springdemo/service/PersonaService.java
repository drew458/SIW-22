package it.uniroma3.siw.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.springdemo.model.Persona;
import it.uniroma3.siw.springdemo.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	/* Spring boot si occupa di iniziare e chiudere la transazione, e di implementare il metodo save nella classe repository */
	@Transactional
	public void save(Persona persona) {
		repository.save(persona);
	}
	
	@Transactional
	public void delete(Persona persona) {
		repository.delete(persona);
	}
	
	public Persona findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Persona> findAll() {
		List<Persona> persone = new ArrayList<>();
		
		for(Persona p : repository.findAll()) {
			persone.add(p);
		}
		return persone;
	}
	
	public boolean alreadyExists(Persona persona) {
		return repository.existsByNomeAndCognomeAndEta(persona.getNome(), persona.getCognome(), persona.getEta());
	}
	
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
