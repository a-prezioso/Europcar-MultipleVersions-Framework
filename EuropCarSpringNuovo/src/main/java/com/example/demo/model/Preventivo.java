package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="PREVENTIVO")
public class Preventivo {
	
	public static final String PROPERTY_IDFornitore = "ofornitore";

	@Column(name = "idpreventivo")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpreventivo;
	
	@Column(name="codice")
	@NotBlank(message="il campo non può essere vuoto")
	private String codice;

	@Column(name="preventivo")
	@NotBlank(message="il campo non può essere vuoto")
	private String preventivo;

	@ManyToOne
	@JoinColumn(name = "idfornitore")
	@NotNull(message="il campo non può essere vuoto")
	private Fornitore ofornitore;

	public int getIdpreventivo() {
		return idpreventivo;
	}

	public void setIdpreventivo(int idpreventivo) {
		this.idpreventivo = idpreventivo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getPreventivo() {
		return preventivo;
	}

	public void setPreventivo(String preventivo) {
		this.preventivo = preventivo;
	}

	public Fornitore getOfornitore() {
		return ofornitore;
	}

	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}

	

}