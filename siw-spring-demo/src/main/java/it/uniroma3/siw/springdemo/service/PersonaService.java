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
	
	/* Spring boot si occupa di iniziare e chiudere la transazione */
	@Transactional
	public void save(Persona persona) {
		repository.save(persona);
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
}
