package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Società {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(nullable = false)
	public String ragioneSociale;
	
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
	
	@Column(nullable = false)
	public String numeroTelefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getViaSede() {
		return indirizzoSede;
	}

	public void setViaSede(String indirizzoSede) {
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

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public Società() {
		super();
	}

	public Società(Long id, String ragioneSociale, String viaSede, String numeroCivicoSede, String comuneSede,
			String capSede, String provinciaSede, String numeroTelefono) {
		super();
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.indirizzoSede = viaSede;
		this.numeroCivicoSede = numeroCivicoSede;
		this.comuneSede = comuneSede;
		this.capSede = capSede;
		this.provinciaSede = provinciaSede;
		this.numeroTelefono = numeroTelefono;
	}
	
	@Override
	public boolean equals(Object obj) {
		Società that = (Società) obj;
		return this.id.equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
}
