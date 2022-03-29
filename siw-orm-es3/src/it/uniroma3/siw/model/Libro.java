package it.uniroma3.siw.model;

import java.time.Year;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Libro {
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private Year annoPubblicazione;
	
	@Id
	private Long codiceCopia;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Autore> autori;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Year getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Year annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Long getCodiceCopia() {
		return codiceCopia;
	}

	public void setCodiceCopia(Long codiceCopia) {
		this.codiceCopia = codiceCopia;
	}

	public List<Autore> getAutori() {
		return autori;
	}

	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}

	public Libro() {
		
	}

	public Libro(String titolo, Year annoPubblicazione, Long codiceCopia, List<Autore> autori) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.codiceCopia = codiceCopia;
		this.autori = autori;
	}
	
	@Override
	public boolean equals(Object obj) {
		Libro that = (Libro) obj;
		return this.codiceCopia.equals(that.getCodiceCopia());
	}
	
	@Override
	public int hashCode() {
		return this.codiceCopia.hashCode();
	}
}
