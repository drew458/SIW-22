package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column
	public String indirizzo;
	
	@Column
	public String numeroCivico;
	
	@Column
	public String comune;
	
	@Column
	public String cap;
	
	@Column
	public String provincia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndirizzoSede() {
		return indirizzo;
	}

	public void setIndirizzoSede(String indirizzoSede) {
		this.indirizzo = indirizzoSede;
	}

	public String getNumeroCivicoSede() {
		return numeroCivico;
	}

	public void setNumeroCivicoSede(String numeroCivicoSede) {
		this.numeroCivico = numeroCivicoSede;
	}

	public String getComuneSede() {
		return comune;
	}

	public void setComuneSede(String comuneSede) {
		this.comune = comuneSede;
	}

	public String getCapSede() {
		return cap;
	}

	public void setCapSede(String capSede) {
		this.cap = capSede;
	}

	public String getProvinciaSede() {
		return provincia;
	}

	public void setProvinciaSede(String provinciaSede) {
		this.provincia = provinciaSede;
	}

	public Indirizzo() {
		super();
	}

	public Indirizzo(String indirizzoSede, String numeroCivicoSede, String comuneSede, String capSede,
			String provinciaSede) {
		super();
		this.indirizzo = indirizzoSede;
		this.numeroCivico = numeroCivicoSede;
		this.comune = comuneSede;
		this.cap = capSede;
		this.provincia = provinciaSede;
	}
	
	
}
