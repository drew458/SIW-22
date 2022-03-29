package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "FindAllCollezioni", query = "SELECT c FROM Collezione c")
public class Collezione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Curatore curatore;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REMOVE})
	private List<Opera> opere;

	public Collezione() {
		
	}

	public Collezione(Long id, String nome, Curatore curatore) {
		this.id = id;
		this.nome = nome;
		this.curatore = curatore;
	}

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

	public Curatore getCuratore() {
		return curatore;
	}

	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}
	
	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	@Override
	public boolean equals(Object obj) {
		Collezione that = (Collezione) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
