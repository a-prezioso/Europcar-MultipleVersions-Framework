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
@Table(name="Azienda")
public class Azienda {
	//Costanti
	public static final String PROPERTY_id="idazienda";
	public static final String PROPERTY_RagioneSociale="ragioneSociale";
	public static final String PROPERTY_idgruppo="ogruppo";
	public static final String PROPERTY_Indirizzo="indirizzo";
	public static final String PROPERTY_ContractID="contractID";
	
	//Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idazienda;
	
	@Column(name="RagioneSociale")
	@NotBlank(message="il campo non può essere vuoto")
	private String ragionesociale;
	
	@ManyToOne
	@JoinColumn(name="idgruppo")
	@NotNull(message="il campo non può essere nullo")
	private Gruppo ogruppo;
	
	@Column(name="Indirizzo")
	@NotBlank(message="il campo non può essere vuoto")
	private String indirizzo;
	
	@Column(name="ContractID")
	@NotBlank(message="il campo non può essere vuoto")
	private String contractID;
	
	
	//Get e Set
	

	public int getIdazienda() {
		return idazienda;
	}
	public String getRagionesociale() {
		return ragionesociale;
	}
	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}
	public void setIdazienda(int idazienda) {
		this.idazienda = idazienda;
	}
	public Gruppo getOgruppo() {
		return ogruppo;
	}
	public void setOgruppo(Gruppo ogruppo) {
		this.ogruppo = ogruppo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	
	//Costruttori
	public Azienda() {
		this.inizializza();
	}
	private void inizializza() {
		this.idazienda=0;
		this.indirizzo=null;
		this.ragionesociale=null;
		this.contractID=null;
		this.setOgruppo(null);
	}
}
