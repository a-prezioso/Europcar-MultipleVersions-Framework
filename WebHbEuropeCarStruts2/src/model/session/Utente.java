package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="GSPFE_Utente")
public class Utente {
	//Costanti
	public static final String PROPERTY_id="idutente";
	public static final String PROPERTY_UserName="username";
	public static final String PROPERTY_Password="password";
	public static final String PROPERTY_idvenditore="ovenditore";
	//Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idutente;
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	@OneToOne
	@JoinColumn(name="idvenditore")
	private Venditore ovenditore;
	@Column(name="Admin")
	private boolean admin;
	//Get e Set
	
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
	
	//Costruttori
	public Utente() {
		this.inizializza();
	}
	private void inizializza() {
		this.idutente=0;
		this.username=null;
		this.password=null;
		this.setOvenditore(null);
	}
}
