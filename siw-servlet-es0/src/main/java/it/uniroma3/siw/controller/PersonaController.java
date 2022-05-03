package it.uniroma3.siw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.siw.controller.validator.PersonaValidator;
import it.uniroma3.siw.model.Persona;
import it.uniroma3.siw.service.PersonaService;

@WebServlet("/persona")
public class PersonaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestione della RICHIESTA
		
		String nome;
		String cognome;
		String paginaSuccessiva = "/persona.jsp";
		
		if(PersonaValidator.validate(request)) {
			nome = request.getParameter("nome").toUpperCase();
			cognome = request.getParameter("cognome").toUpperCase();
			Persona p = new Persona();
			p.setNome(nome);
			p.setCognome(cognome);
			PersonaService.save(p);
		}
		else {
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			paginaSuccessiva = "/index.jsp";
		}
		
		// leggo (alcune) intestazioni http della richiesta
		String address = request.getRemoteAddr();
		String userAgent = request.getHeader("User-Agent");
		
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		
		// gestione della RISPOSTA
		
		ServletContext application = getServletContext();
		RequestDispatcher rd;
		rd = application.getRequestDispatcher(paginaSuccessiva);
		rd.forward(request, response);
		return;		
	}
}
