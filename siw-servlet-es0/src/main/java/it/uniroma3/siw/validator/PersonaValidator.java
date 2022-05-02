package it.uniroma3.siw.validator;

import javax.servlet.http.HttpServletRequest;

public class PersonaValidator {

	public static boolean validate(HttpServletRequest request) {
		
		if(request.getParameter("nome").isEmpty() || request.getParameter("nome").matches(".*\\d.*") || 
				request.getParameter("cognome").isEmpty() || request.getParameter("cognome").matches(".*\\d.*")) 
		{
			return false;
		}
		
		return true;
	}
}
