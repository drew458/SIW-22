package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.siw.validator.PersonaValidator;

@WebServlet("/persona")
public class PersonaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestione della RICHIESTA
		
		String nome;
		String cognome;
		Map<String, String> messaggiErrore = new HashMap<>();
		boolean valid = false;
		
		if(PersonaValidator.validate(request)) {
			nome = request.getParameter("nome").toUpperCase();
			cognome = request.getParameter("cognome").toUpperCase();
			valid = true;
		}
		else {
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			messaggiErrore.put("nome", "Formato del nome errato");
			messaggiErrore.put("cognome", "Formato del cognome errato");
		}
		
		// leggo (alcune) intestazioni http della richiesta
		String address = request.getRemoteAddr();
		String userAgent = request.getHeader("User-Agent");
		
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		request.setAttribute("messaggiErrore", messaggiErrore);
		
		// gestione della RISPOSTA
		
		ServletContext application = getServletContext();
		RequestDispatcher rd;
		if(valid) {
			rd = application.getRequestDispatcher("/persona.jsp");
		}
		else {
			rd = application.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
		return;		
	}
}
