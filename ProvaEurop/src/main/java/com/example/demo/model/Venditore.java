package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Venditore")
public class Venditore {


	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idvenditore;
	
	@Column(name = "Cognome")
	@NotBlank(message="il campo non può essere vuoto")
	private String cognome;
	
	@Column(name = "Nome")
	@NotBlank(message="il campo non può essere vuoto")
	private String nome;
	
	@Column(name = "Indirizzo")
	@NotBlank(message="il campo non può essere vuoto")
	private String indirizzo;
	
	@Column(name = "NumeroTelefono")
	@NotBlank(message="il campo non può essere vuoto")
	private String numerotelefono;
	
	@ManyToOne
	@JoinColumn(name = "IdTipoVenditore")
//	@NotNull(message="il campo non può essere vuoto")
	private TipoVenditore otipovenditore;

	@Transient
	private String fullName;
	
	

	public String getFullName() {
		return this.nome + " " + this.cognome;
	}


	// Get e Set
	public int getIdvenditore() {
		return idvenditore;
	}

	public void setIdvenditore(int idvenditore) {
		this.idvenditore = idvenditore;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public TipoVenditore getOtipovenditore() {
		return otipovenditore;
	}

	public void setOtipovenditore(TipoVenditore otipovenditore) {
		this.otipovenditore = otipovenditore;
	}

	// Costanti
	public Venditore() {
		this.inizializza();
	}

	private void inizializza() {
		this.idvenditore = 0;
		this.cognome = null;
		this.nome = null;
		this.indirizzo = null;
		this.numerotelefono = null;
		this.setOtipovenditore(null);
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
