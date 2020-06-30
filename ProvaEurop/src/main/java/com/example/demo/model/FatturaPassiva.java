package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="FATTURAPASSIVA")
public class FatturaPassiva {
	
	public static final String PROPERTY_IDFornitore = "ofornitore";
	public static final String PROPERTY_IDFatturaPassiva = "idfatturapassiva";

	@Column(name = "idfatturapassiva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfatturapassiva;
	
	@Column(name="data")
	@NotBlank(message="il campo non può essere vuoto")
	private String data;

	@Column(name="numero")
	@NotNull(message="il campo non può essere vuoto")
	private int numero;

	@Column(name="descrizione")
	@NotBlank(message="il campo non può essere vuoto")
	private String descrizione;
	
	@ManyToOne
	@JoinColumn(name = "idfornitore")
	@NotNull(message="il campo non può essere nullo")
	private Fornitore ofornitore;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ofatturapassiva", orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	private List<FatturaPassivaDettaglio> dettagli = new ArrayList<FatturaPassivaDettaglio>();
	


	public List<FatturaPassivaDettaglio> getDettagli() {
		return dettagli;
	}

	public void setDettagli(List<FatturaPassivaDettaglio> dettagli) {
		this.dettagli = dettagli;
	}

	public int getIdfatturapassiva() {
		return idfatturapassiva;
	}

	public void setIdfatturapassiva(int idfatturapassiva) {
		this.idfatturapassiva = idfatturapassiva;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Fornitore getOfornitore() {
		return ofornitore;
	}

	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}
	
	


	






}