package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ANNOCONTABILE")
public class AnnoContabile {
	@Column(name = "idannocontabile")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int idannocontabile;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "datainizio")
	private Date datainizio;
	
	@Column(name = "datafine")
	private Date datafine;

	public int getIdannocontabile() {
		return idannocontabile;
	}

	public void setIdannocontabile(int idannocontabile) {
		this.idannocontabile = idannocontabile;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Date getDatafine() {
		return datafine;
	}

	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}

}
