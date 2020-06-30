package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FATTURAPASSIVADETTAGLIO")
public class FatturaPassivaDettaglio {



	public static final String PROPERTY_IDFatturaPassiva = "ofatturapassiva";

	@Column(name = "idfatturapassivadettaglio")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfatturapassivadettaglio;

	@ManyToOne
	@JoinColumn(name = "idaliquotaiva")
	@NotNull(message="il campo non può essere nullo")
	private AliquotaIva oaliquota;

	@ManyToOne
	@JoinColumn(name = "idpreventivo")
	@NotNull(message="il campo non può essere nullo")
	private Preventivo opreventivo;

	@ManyToOne
	@JoinColumn(name = "idspesainvestimento")
	@NotNull(message="il campo non può essere nullo")
	private SpesaInvestimento ospesainvestimento;

	@Column(name = "dettagliofattura")
	@NotBlank(message="il campo non può essere vuoto")
	private String dettagliofattura;

	@Column(name = "importo")
	@NotNull(message="il campo non può essere vuoto")
	private Float importo;

	@Column(name="ImportoPagato")
	@NotNull(message="il campo non può essere vuoto")
	private Float importoPagato;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfatturapassiva")
	private FatturaPassiva ofatturapassiva;

	
	@Transient
	private int identifier;
	
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}


	
	
	public Float getImportoPagato() {
		return importoPagato;
	}

	public void setImportoPagato(Float importoPagato) {
		this.importoPagato = importoPagato;
	}

	public int getIdfatturapassivadettaglio() {
		return idfatturapassivadettaglio;
	}

	public void setIdfatturapassivadettaglio(int idfatturapassivadettaglio) {
		this.idfatturapassivadettaglio = idfatturapassivadettaglio;
	}

	public AliquotaIva getOaliquota() {
		return oaliquota;
	}

	public void setOaliquota(AliquotaIva oaliquota) {
		this.oaliquota = oaliquota;
	}

	public String getDettagliofattura() {
		return dettagliofattura;
	}

	public void setDettagliofattura(String dettagliofattura) {
		this.dettagliofattura = dettagliofattura;
	}

	public Float getImporto() {
		return importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public Preventivo getOpreventivo() {
		return opreventivo;
	}

	public void setOpreventivo(Preventivo opreventivo) {
		this.opreventivo = opreventivo;
	}

	public FatturaPassiva getOfatturapassiva() {
		return ofatturapassiva;
	}

	public void setOfatturapassiva(FatturaPassiva ofatturapassiva) {
		this.ofatturapassiva = ofatturapassiva;
	}

	public SpesaInvestimento getOspesainvestimento() {
		return ospesainvestimento;
	}

	public void setOspesainvestimento(SpesaInvestimento ospesainvestimento) {
		this.ospesainvestimento = ospesainvestimento;
	}

	public FatturaPassivaDettaglio() {
		this.inizializza();
	}

	public FatturaPassivaDettaglio(FatturaPassiva ofatturapassiva) {
		this.ofatturapassiva = ofatturapassiva;
	} 
	private void inizializza() {
		this.idfatturapassivadettaglio=0;
		this.dettagliofattura="";
		this.importo=0.0f;
		this.importoPagato=0.0f;
		this.setOfatturapassiva(null);
		this.setOaliquota(null);
		this.setOpreventivo(null);
		this.setOspesainvestimento(null);
	}

}