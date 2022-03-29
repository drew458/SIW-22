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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Year getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Year dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getAltezza() {
		return altezza;
	}

	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public Procuratore getProcuratore() {
		return procuratore;
	}

	public void setProcuratore(Procuratore procuratore) {
		this.procuratore = procuratore;
	}

	public Giocatore() {
		
	}

	public Giocatore(Long id, String nome, String cognome, Year dataNascita, String ruolo, String altezza,
			Squadra squadra, Procuratore procuratore) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.ruolo = ruolo;
		this.altezza = altezza;
		this.squadra = squadra;
		this.procuratore = procuratore;
	}
	
	@Override
	public boolean equals(Object obj) {
		Giocatore that = (Giocatore) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
