package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Procuratore {
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Id
	private String codiceFederale;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Giocatore> giocatoriSeguiti;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SocietaConsulenza datoreLavoro;

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

	public String getCodiceFederale() {
		return codiceFederale;
	}

	public void setCodiceFederale(String codiceFederale) {
		this.codiceFederale = codiceFederale;
	}

	public List<Giocatore> getGiocatoriSeguiti() {
		return giocatoriSeguiti;
	}

	public void setGiocatoriSeguiti(List<Giocatore> giocatoriSeguiti) {
		this.giocatoriSeguiti = giocatoriSeguiti;
	}

	public SocietaConsulenza getDatoreLavoro() {
		return datoreLavoro;
	}

	public void setDatoreLavoro(SocietaConsulenza datoreLavoro) {
		this.datoreLavoro = datoreLavoro;
	}

	public Procuratore() {
		
	}

	public Procuratore(Long id, String nome, String cognome, String codiceFederale, List<Giocatore> giocatoriSeguiti,
			SocietaConsulenza datoreLavoro) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFederale = codiceFederale;
		this.giocatoriSeguiti = giocatoriSeguiti;
		this.datoreLavoro = datoreLavoro;
	}
	
	@Override
	public boolean equals(Object obj) {
		Procuratore that = (Procuratore) obj;
		return this.codiceFederale.equals(that.getCodiceFederale());
	}
	
	@Override
	public int hashCode() {
		return this.codiceFederale.hashCode();
	}
}
