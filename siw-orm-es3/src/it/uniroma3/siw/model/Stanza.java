package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stanza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<Ripiano> ripiani;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ripiano> getRipiani() {
		return ripiani;
	}

	public void setRipiani(List<Ripiano> ripiani) {
		this.ripiani = ripiani;
	}

	public Stanza() {
		
	}

	public Stanza(Long id, List<Ripiano> ripiani) {
		super();
		this.id = id;
		this.ripiani = ripiani;
	}
	
	@Override
	public boolean equals(Object obj) {
		Stanza that = (Stanza) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}	
}
