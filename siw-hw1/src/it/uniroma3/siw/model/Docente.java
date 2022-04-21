package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(nullable = false)
	public String nome;
	
	@Column(nullable = false)
	public String cognome;
	
	@Column
	public LocalDate dataNascita;
	
	@Column
	public String luogoNascita;
	
	@Column(nullable = false)
	public String numeroPartitaIva;
	
	/**
	 * Viene scelto un fetch EAGER perché è una relazione uno a molti
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docenteDelCorso")
	public List<Corso> corsiTenuti;

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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNumeroPartitaIva() {
		return numeroPartitaIva;
	}

	public void setNumeroPartitaIva(String numeroPartitaIva) {
		this.numeroPartitaIva = numeroPartitaIva;
	}

	public List<Corso> getCorsiTenuti() {
		return corsiTenuti;
	}

	public void setCorsiTenuti(List<Corso> corsiTenuti) {
		this.corsiTenuti = corsiTenuti;
	}

	public Docente() {
		super();
	}

	public Docente(Long id, String nome, String cognome, LocalDate dataNascita, String luogoNascita,
			String numeroPartitaIva, List<Corso> corsiTenuti) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.numeroPartitaIva = numeroPartitaIva;
		this.corsiTenuti = corsiTenuti;
	}
	
	@Override
	public boolean equals(Object obj) {
		Docente that = (Docente) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
