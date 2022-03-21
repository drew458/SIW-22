package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllProfessori", query = "SELECT p FROM Professore p")
public class Professore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@ManyToMany(mappedBy = "commissioneEsame")
	private List<Corso> corsi;
	
	@OneToMany(mappedBy = "titolare")
	private List<Corso> titolareCorsi;
}
