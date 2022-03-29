package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "FindAllCuratori", query = "SELECT c FROM Curatore c")
public class Curatore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nomeCognome;
	
	@Column
	private String numeroMatricola;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Collezione> collezioniAssociate;

	public Curatore() {
		
	}

	public Curatore(Long id, String nomeCognome, String numeroMatricola) {
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.numeroMatricola = numeroMatricola;
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

	public String getNumeroMatricola() {
		return numeroMatricola;
	}

	public void setNumeroMatricola(String numeroMatricola) {
		this.numeroMatricola = numeroMatricola;
	}
	
	public List<Collezione> getCollezioniAssociate() {
		return collezioniAssociate;
	}

	public void setCollezioniAssociate(List<Collezione> collezioniAssociate) {
		this.collezioniAssociate = collezioniAssociate;
	}

	@Override
	public boolean equals(Object obj) {
		Curatore that = (Curatore) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
