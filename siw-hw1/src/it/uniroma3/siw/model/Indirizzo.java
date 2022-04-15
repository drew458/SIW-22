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
	public String indirizzoSede;
	
	@Column
	public String numeroCivicoSede;
	
	@Column
	public String comuneSede;
	
	@Column
	public String capSede;
	
	@Column
	public String provinciaSede;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndirizzoSede() {
		return indirizzoSede;
	}

	public void setIndirizzoSede(String indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

	public String getNumeroCivicoSede() {
		return numeroCivicoSede;
	}

	public void setNumeroCivicoSede(String numeroCivicoSede) {
		this.numeroCivicoSede = numeroCivicoSede;
	}

	public String getComuneSede() {
		return comuneSede;
	}

	public void setComuneSede(String comuneSede) {
		this.comuneSede = comuneSede;
	}

	public String getCapSede() {
		return capSede;
	}

	public void setCapSede(String capSede) {
		this.capSede = capSede;
	}

	public String getProvinciaSede() {
		return provinciaSede;
	}

	public void setProvinciaSede(String provinciaSede) {
		this.provinciaSede = provinciaSede;
	}

	public Indirizzo() {
		super();
	}

	public Indirizzo(String indirizzoSede, String numeroCivicoSede, String comuneSede, String capSede,
			String provinciaSede) {
		super();
		this.indirizzoSede = indirizzoSede;
		this.numeroCivicoSede = numeroCivicoSede;
		this.comuneSede = comuneSede;
		this.capSede = capSede;
		this.provinciaSede = provinciaSede;
	}
	
	
}
