package com.example.demo.model;

import java.util.Calendar;
import java.util.Date;

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
@Table(name="Previsione")
public class Previsione {
	
	public static final String PROPERTY_id = "idprevisione";
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprevisione;
	
	@ManyToOne
	@JoinColumn(name = "idarea")
	@NotNull(message="il campo non può essere vuoto")
	private Area oarea;
	
	@ManyToOne
	@JoinColumn(name = "idazienda")
	@NotNull(message="il campo non può essere vuoto")
	private Azienda oazienda;
	
	@ManyToOne
	@JoinColumn(name = "idvenditore")
	@NotNull(message="il campo non può essere vuoto")
	private Venditore ovenditore;
	
	@Column(name = "DataVisita")
	@NotBlank(message="il campo non può essere vuoto")
	private String datavisita;
	
	@ManyToOne
	@JoinColumn(name="IDSottocategoria")
	@NotNull(message="il campo non può essere vuoto")
	private SottoCategoria osottocategoria;
	
	@Column(name = "AnnoDiRiferimento")
	@NotBlank(message="il campo non può essere vuoto")
	private String annodiriferimento;
	

	@Column(name = "DataRegistrazione")
	@NotBlank(message="il campo non può essere vuoto")
	private String dataregistrazione;
	
	@Column(name = "Confidenza")
	@NotBlank(message="il campo non può essere vuoto")
	private String confidenza;

	@Column(name = "PotenzialeEuropeCar")
	@NotBlank(message="il campo non può essere vuoto")
	private float potenzialeeuropecar;
	
	@Column(name = "PotenzialeAzienda")
	@NotBlank(message="il campo non può essere vuoto")
	private float potenzialeazienda;

	@Column(name = "ShareAnte")
	@NotBlank(message="il campo non può essere vuoto")
	private float shareante;
	
	@Column(name = "SharePost")
	@NotBlank(message="il campo non può essere vuoto")
	private float sharepost;
	
	@Column(name = "ShareAvis")
	@NotBlank(message="il campo non può essere vuoto")
	private float shareavis;
	
	@Column(name = "ShareHertz")
	@NotBlank(message="il campo non può essere vuoto")
	private float sharehertz;
	
	@Column(name = "ShareMaggiore")
	@NotBlank(message="il campo non può essere vuoto")
	private float sharemaggiore;
	
	@Column(name = "ShareSixt")
	@NotBlank(message="il campo non può essere vuoto")
	private float sharesixt;

	public int getIdprevisione() {
		return idprevisione;
	}

	public void setIdprevisione(int idprevisione) {
		this.idprevisione = idprevisione;
	}




	public Area getOarea() {
		return oarea;
	}

	public void setOarea(Area oarea) {
		this.oarea = oarea;
	}

	public Azienda getOazienda() {
		return oazienda;
	}

	public void setOazienda(Azienda oazienda) {
		this.oazienda = oazienda;
	}

	public Venditore getOvenditore() {
		return ovenditore;
	}

	public void setOvenditore(Venditore ovenditore) {
		this.ovenditore = ovenditore;
	}


	public String getDatavisita() {
		return datavisita;
	}

	public void setDatavisita(String datavisita) {
		this.datavisita = datavisita;
	}

	public String getAnnodiriferimento() {
		return annodiriferimento;
	}

	public void setAnnodiriferimento(String annodiriferimento) {
		this.annodiriferimento = annodiriferimento;
	}

	public String getDataregistrazione() {
		return dataregistrazione;
	}

	public void setDataregistrazione(String dataregistrazione) {
		this.dataregistrazione = dataregistrazione;
	}

	public String getConfidenza() {
		return confidenza;
	}

	public void setConfidenza(String confidenza) {
		this.confidenza = confidenza;
	}

	public float getPotenzialeeuropecar() {
		return potenzialeeuropecar;
	}

	public void setPotenzialeeuropecar(float potenzialeeuropecar) {
		this.potenzialeeuropecar = potenzialeeuropecar;
	}

	public float getPotenzialeazienda() {
		return potenzialeazienda;
	}

	public void setPotenzialeazienda(float potenzialeazienda) {
		this.potenzialeazienda = potenzialeazienda;
	}

	public float getShareante() {
		return shareante;
	}

	public void setShareante(float shareante) {
		this.shareante = shareante;
	}

	public float getSharepost() {
		return sharepost;
	}

	public void setSharepost(float sharepost) {
		this.sharepost = sharepost;
	}

	public float getShareavis() {
		return shareavis;
	}

	public void setShareavis(float shareavis) {
		this.shareavis = shareavis;
	}

	public float getSharehertz() {
		return sharehertz;
	}

	public void setSharehertz(float sharehertz) {
		this.sharehertz = sharehertz;
	}

	public float getSharemaggiore() {
		return sharemaggiore;
	}

	public void setSharemaggiore(float sharemaggiore) {
		this.sharemaggiore = sharemaggiore;
	}

	public float getSharesixt() {
		return sharesixt;
	}

	public void setSharesixt(float sharesixt) {
		this.sharesixt = sharesixt;
	}
	
	
	public SottoCategoria getOsottocategoria() {
		return osottocategoria;
	}

	public void setOsottocategoria(SottoCategoria osottocategoria) {
		this.osottocategoria = osottocategoria;
	}

	public Previsione(Venditore ovenditore) {
		this.setOvenditore(ovenditore);
	}
	
	public Previsione() {
		
	}
	

	
	
}
