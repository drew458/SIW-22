package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column
	public String nome;
	
	@Column
	public LocalDate dataInizio;
	
	@Column
	public int mesiDurata;
	
	/**
	 * Viene scelto un fetch LAZY perché in una relazione molti a molti sarebbe
	 * troppo dispendioso fare un fetch EAGER
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Allievo> allieviIscritti;
	
	/**
	 * Viene scelto un fetch EAGER perché è una relazione molti ad uno
	 * Vengono abilitate delle operazioni in cascata perché l'associazione esprime una composizione
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REMOVE})
	public Docente docenteDelCorso;

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

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getMesiDurata() {
		return mesiDurata;
	}

	public void setMesiDurata(int mesiDurata) {
		this.mesiDurata = mesiDurata;
	}

	public List<Allievo> getAllieviIscritti() {
		return allieviIscritti;
	}

	public void setAllieviIscritti(List<Allievo> allieviIscritti) {
		this.allieviIscritti = allieviIscritti;
	}

	public Docente getDocenteDelCorso() {
		return docenteDelCorso;
	}

	public void setDocenteDelCorso(Docente docenteDelCorso) {
		this.docenteDelCorso = docenteDelCorso;
	}

	public Corso() {
		super();
	}

	public Corso(Long id, String nome, LocalDate dataInizio, int mesiDurata, List<Allievo> allieviIscritti,
			Docente docenteDelCorso) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.mesiDurata = mesiDurata;
		this.allieviIscritti = allieviIscritti;
		this.docenteDelCorso = docenteDelCorso;
	}
	
	@Override
	public boolean equals(Object obj) {
		Corso that = (Corso) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
}
