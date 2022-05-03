package it.uniroma3.siw.controller.validator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PersonaValidator {

	public static boolean validate(HttpServletRequest request) {
		
		Map<String, String> messaggiErrore = new HashMap<>();
		boolean datiValidi = true;
		
		if(request.getParameter("nome").isEmpty() || request.getParameter("nome").matches(".*\\d.*")) {
			datiValidi = false;
			messaggiErrore.put("nome", "Errore! Formato del nome errato");
			
		}
		
		if(request.getParameter("cognome").isEmpty() || request.getParameter("cognome").matches(".*\\d.*")) {
			datiValidi = false;
			messaggiErrore.put("cognome", "Errore! Formato del cognome errato");
		}
		
		request.setAttribute("messaggiErrore", messaggiErrore);
		
		return datiValidi;
	}
}
