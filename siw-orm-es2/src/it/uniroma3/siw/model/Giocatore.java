package it.uniroma3.siw.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Giocatore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private Year dataNascita;
	
	@Column
	private String ruolo;
	
	@Column
	private String altezza;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Squadra squadra;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Procuratore procuratore;
}
