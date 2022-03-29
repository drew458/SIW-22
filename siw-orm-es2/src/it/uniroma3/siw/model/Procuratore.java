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
}
