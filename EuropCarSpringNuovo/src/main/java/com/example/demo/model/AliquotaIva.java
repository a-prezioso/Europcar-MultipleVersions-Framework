package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="ALIQUOTAIVA")
public class AliquotaIva {

	@Column(name = "idaliquotaiva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idaliquotaiva;
	
	@Column(name="aliquota")
	@NotNull(message="Il campo non può essere vuoto")
	private float aliquota;

	@Column(name="descrizione")
	@NotBlank(message="Il campo non può essere vuoto")
	private String descrizione;

	public int getIdaliquotaiva() {
		return idaliquotaiva;
	}

	public void setIdaliquotaiva(int idaliquotaiva) {
		this.idaliquotaiva = idaliquotaiva;
	}

	public float getAliquota() {
		return aliquota;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	






}