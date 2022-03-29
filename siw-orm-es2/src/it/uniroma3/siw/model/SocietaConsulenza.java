package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SocietaConsulenza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String partitaIva;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REMOVE})
	private List<Procuratore> procuratoriImpiegati;

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

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Procuratore> getProcuratoriImpiegati() {
		return procuratoriImpiegati;
	}

	public void setProcuratoriImpiegati(List<Procuratore> procuratoriImpiegati) {
		this.procuratoriImpiegati = procuratoriImpiegati;
	}

	public SocietaConsulenza() {
		
	}

	public SocietaConsulenza(Long id, String nome, String partitaIva, List<Procuratore> procuratoriImpiegati) {
		super();
		this.id = id;
		this.nome = nome;
		this.partitaIva = partitaIva;
		this.procuratoriImpiegati = procuratoriImpiegati;
	}
	
	@Override
	public boolean equals(Object obj) {
		SocietaConsulenza that = (SocietaConsulenza) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
