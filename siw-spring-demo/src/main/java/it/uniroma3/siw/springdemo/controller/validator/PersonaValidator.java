package it.uniroma3.siw.springdemo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.springdemo.model.Persona;
import it.uniroma3.siw.springdemo.service.PersonaService;

public class PersonaValidator implements Validator{
	
	@Autowired
	private PersonaService service;

	@Override
	public boolean supports(Class<?> pClass) {
		return Persona.class.equals(pClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(this.service.alreadyExists((Persona) target)){
			errors.reject("persona.duplicato");
		}		
	}

	
}
