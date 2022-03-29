package it.uniroma3.siw.model;

import java.time.Year;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "FindAllArtisti", query = "SELECT a FROM Artista a")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nomeCognome;
	
	@Column
	private Year annoNascita;
	
	@Column
	private Year annoMorte;
	
	@Column
	private String nazionalita;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Opera> opereRealizzate;
	
	public Artista() {
		
	}

	public Artista(Long id, String nomeCognome, Year annoNascita, Year annoMorte, String nazionalita) {
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.annoNascita = annoNascita;
		this.annoMorte = annoMorte;
		this.nazionalita = nazionalita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCognome() {
		return nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	public Year getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Year annoNascita) {
		this.annoNascita = annoNascita;
	}

	public Year getAnnoMorte() {
		return annoMorte;
	}

	public void setAnnoMorte(Year annoMorte) {
		this.annoMorte = annoMorte;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public List<Opera> getOpereRealizzate() {
		return opereRealizzate;
	}

	public void setOpereRealizzate(List<Opera> opereRealizzate) {
		this.opereRealizzate = opereRealizzate;
	}

	@Override
	public boolean equals(Object obj) {
		Artista that = (Artista) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
