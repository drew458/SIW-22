package it.uniroma3.siw.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.springdemo.controller.validator.PersonaValidator;
import it.uniroma3.siw.springdemo.model.Persona;
import it.uniroma3.siw.springdemo.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@Autowired
	private PersonaValidator validator;
	
	/* Convenzione: get per le operazioni di lettura e post per le operazioni di scrittura
	 * Il path è associato alle classi del dominio
	 */
	
	//bindingResult associa ciò che c'è dentro ai parametri HTTP con gli attributi dell'oggetto 
	@PostMapping("/persona")
	public String addPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult bindingResult, Model model) {
		validator.validate(persona, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.service.save(persona);
			model.addAttribute("persona", persona);
			return "persona.html";
		}
		return "personaForm.html";
	}
	
	//TODO
	@PostMapping("/toDeletePersona/{id}")
	public String toDeletePersona(@PathVariable("id") Long id, Model model) {
		
	}
	
	// richiede tutte le persone
	@GetMapping("/persona")
	public String getPersone(Model model) {
		List<Persona> persone = service.findAll();
		model.addAttribute("persona", persone);
		return "persona.html";
	}
	
	// richiede le persone con lo specifico id
	@GetMapping("/persona/{id}")
	public String getPersona(@PathVariable("id") Long id, Model model) {
		Persona persona = service.findById(id);
		model.addAttribute("persona" ,persona);
		return "persona.html";
	}
	
	@GetMapping("/personaForm")
	public String getPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "personaForm.html";
	}
}
