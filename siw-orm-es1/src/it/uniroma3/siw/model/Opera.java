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
@NamedQuery(name = "FindAllOperas", query = "SELECT o FROM Opera o")
public class Opera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column
	private Year annoRealizzazione;
	
	@Column
	private String descrizione;
	
	@ManyToMany(mappedBy = "opereRealizzate", fetch = FetchType.LAZY)
	private List<Artista> artistiRealizzatori;
	
	public Opera() {
		
	}

	public Opera(Long id, String titolo, Year annoRealizzazione, String descrizione) {
		this.id = id;
		this.titolo = titolo;
		this.annoRealizzazione = annoRealizzazione;
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Year getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(Year annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public List<Artista> getArtistiRealizzatori() {
		return artistiRealizzatori;
	}

	public void setArtistiRealizzatori(List<Artista> artistiRealizzatori) {
		this.artistiRealizzatori = artistiRealizzatori;
	}

	@Override
	public boolean equals(Object obj) {
		Opera that = (Opera) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
