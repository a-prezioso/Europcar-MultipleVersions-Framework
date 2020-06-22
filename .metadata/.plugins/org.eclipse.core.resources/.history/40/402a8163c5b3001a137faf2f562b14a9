package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="FORNITORE")
public class Fornitore {

	public static final String PROPERTY_idFornitore= "idfornitore";
	
	@Column(name = "idfornitore")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfornitore;
	
	@Column(name="ragionesociale")
	@NotBlank(message="il campo non può essere vuoto")
	private String ragionesociale;

	@Column(name="indirizzo")
	@NotBlank(message="il campo non può essere vuoto")
	private String indirizzo;
	
	@Column(name="citta")
	@NotBlank(message="il campo non può essere vuoto")
	private String citta;

	@Column(name="cap")
	@NotBlank(message="il campo non può essere vuoto")
	private String cap;
	
	@Column(name="provincia")
	@NotBlank(message="il campo non può essere vuoto")
	private String provincia;

	@Column(name="partitaiva")
	@NotBlank(message="il campo non può essere vuoto")
	private String partitaiva;

	public int getIdfornitore() {
		return idfornitore;
	}

	public void setIdfornitore(int idfornitore) {
		this.idfornitore = idfornitore;
	}

	public String getRagionesociale() {
		return ragionesociale;
	}

	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPartitaiva() {
		return partitaiva;
	}

	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}

}