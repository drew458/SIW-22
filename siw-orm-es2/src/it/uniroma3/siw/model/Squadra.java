package it.uniroma3.siw.model;

import java.time.Year;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Squadra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private Year annoFondazione;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REMOVE})
	private List<Giocatore> giocatori;

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

	public Year getAnnoFondazione() {
		return annoFondazione;
	}

	public void setAnnoFondazione(Year annoFondazione) {
		this.annoFondazione = annoFondazione;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public Squadra() {
		
	}

	public Squadra(Long id, String nome, Year annoFondazione, List<Giocatore> giocatori) {
		super();
		this.id = id;
		this.nome = nome;
		this.annoFondazione = annoFondazione;
		this.giocatori = giocatori;
	}
	
	@Override
	public boolean equals(Object obj) {
		Squadra that = (Squadra) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
