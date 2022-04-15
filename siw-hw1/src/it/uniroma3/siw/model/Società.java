package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Società {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(nullable = false)
	public String ragioneSociale;
	
	@Column(nullable = false)
	public String numeroTelefono;
	
	/**
	 * Viene scelta una strategia di fetch eager perche è una relazione uno ad uno
	 * Vengono abilitate delle operazioni in cascata perché l'associazione esprime una composizione
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	public Indirizzo indirizzo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Società() {
		super();
	}
	
	public Società(Long id, String ragioneSociale, String numeroTelefono, Indirizzo indirizzo) {
		super();
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.numeroTelefono = numeroTelefono;
		this.indirizzo = indirizzo;
	}

	@Override
	public boolean equals(Object obj) {
		Società that = (Società) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}	
}
