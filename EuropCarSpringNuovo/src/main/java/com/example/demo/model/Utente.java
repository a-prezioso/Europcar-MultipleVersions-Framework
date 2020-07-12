package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Utente")
public class Utente {
	// Costanti
	public static final String PROPERTY_id = "idutente";
	public static final String PROPERTY_UserName = "username";
	public static final String PROPERTY_Password = "password";
	public static final String PROPERTY_idvenditore = "ovenditore";
	// Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idutente;

	@Column(name = "Username")
	@NotBlank(message = "il campo non può essere vuoto")
	private String username;

	@Column(name = "Password")
	@NotBlank(message = "il campo non può essere vuoto")
	private String password;

	@OneToOne
	@JoinColumn(name = "idvenditore")
	private Venditore ovenditore;

	@Column(name = "Admin")
	@NotNull(message = "il campo non può essere vuoto")
	private boolean admin;
	
	@NotBlank(message = "il campo non può essere vuoto")
	@Transient
	private String passwordConfirm;
	
	
	
	// Get e Set

	public String getPasswordConfirm() {
		if(this.passwordConfirm == null) {
			this.passwordConfirm = "";
		}
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public int getIdutente() {
		return idutente;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Venditore getOvenditore() {
		return ovenditore;
	}

	public void setOvenditore(Venditore ovenditore) {
		this.ovenditore = ovenditore;
	}

	// Costruttori
	public Utente() {
		this.inizializza();
	}

	private void inizializza() {
		this.idutente = 0;
		this.username = null;
		this.password = null;
		this.setOvenditore(null);
	}
}
