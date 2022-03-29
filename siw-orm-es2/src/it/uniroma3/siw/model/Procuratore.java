package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Procuratore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String codiceFederale;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Giocatore> giocatoriSeguiti;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SocietaConsulenza datoreLavoro;

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
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFederale = codiceFederale;
		this.giocatoriSeguiti = giocatoriSeguiti;
		this.datoreLavoro = datoreLavoro;
	}
	
	@Override
	public boolean equals(Object obj) {
		Procuratore that = (Procuratore) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
