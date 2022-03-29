package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nomeCognome;
	
	@Column(nullable = false)
	private LocalDate dataNascita;
	
	@Column
	private LocalDate dataMorte;
	
	@ManyToMany(mappedBy = "autori", fetch = FetchType.LAZY)
	private List<Libro> libriScritti;

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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public LocalDate getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Libro> getLibriScritti() {
		return libriScritti;
	}

	public void setLibriScritti(List<Libro> libriScritti) {
		this.libriScritti = libriScritti;
	}

	public Autore() {
		
	}

	public Autore(String nomeCognome, LocalDate dataNascita, LocalDate dataMorte, List<Libro> libriScritti) {
		super();
		this.nomeCognome = nomeCognome;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
		this.libriScritti = libriScritti;
	}
	
	@Override
	public boolean equals(Object obj) {
		Autore that = (Autore) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
