package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {

	@Id
	public String numeroMatricola;
	
	@Column(nullable = false)
	public String nome;
	
	@Column(nullable = false)
	public String cognome;
	
	@Column
	public LocalDate dataNascita;
	
	@Column
	public String luogoNascita;
	
	@Column(nullable = false)
	public String indirizzoMail;
	
	/**
	 * Viene scelto un fetch EAGER perché è una relazione molti ad uno
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	public Società società;
	
	/**
	 * Viene scelto un fetch LAZY perché in una relazione molti a molti sarebbe
	 * troppo dispendioso fare un fetch EAGER
	 */
	@ManyToMany(mappedBy = "allieviIscritti", fetch = FetchType.LAZY)
	public List<Corso> corsiSeguiti;

	public String getNumeroMatricola() {
		return numeroMatricola;
	}

	public void setNumeroMatricola(String numeroMatricola) {
		this.numeroMatricola = numeroMatricola;
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

	public String getIndirizzoMail() {
		return indirizzoMail;
	}

	public void setIndirizzoMail(String indirizzoMail) {
		this.indirizzoMail = indirizzoMail;
	}

	public Società getSocietà() {
		return società;
	}

	public void setSocietà(Società società) {
		this.società = società;
	}

	public List<Corso> getCorsiSeguiti() {
		return corsiSeguiti;
	}

	public void setCorsiSeguiti(List<Corso> corsiSeguiti) {
		this.corsiSeguiti = corsiSeguiti;
	}

	public Allievo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Allievo(String numeroMatricola, String nome, String cognome, LocalDate dataNascita, String luogoNascita,
			String indirizzoMail, Società società, List<Corso> corsiSeguiti) {
		super();
		this.numeroMatricola = numeroMatricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.indirizzoMail = indirizzoMail;
		this.società = società;
		this.corsiSeguiti = corsiSeguiti;
	}
	
	@Override
	public boolean equals(Object obj) {
		Allievo that = (Allievo) obj;
		return this.numeroMatricola.equals(that.getNumeroMatricola());
	}
	
	@Override
	public int hashCode() {
		return this.numeroMatricola.hashCode();
	}
}
