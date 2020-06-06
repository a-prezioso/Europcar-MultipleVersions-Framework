package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="GSPFE_Venditore")
public class Venditore {
	//Costanti
	public static final String PROPERTY_id ="idvenditore";
	public static final String PROPERTY_Cognome ="cognome";
	public static final String PROPERTY_Nome ="nome";
	public static final String PROPERTY_Indirizzo ="indirizzo";
	public static final String PROPERTY_NumeroTelefono ="numerotelefono";
	public static final String PROPERTY_TipoVenditore ="tipovenditore";
	//Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idvenditore;
	@Column(name="Cognome")
	private String cognome;
	@Column(name="Nome")
	private String nome;
	@Column(name="Indirizzo")
	private String indirizzo;
	@Column(name="NumeroTelefono")
	private String numerotelefono;
	@ManyToOne
	@JoinColumn(name="IdTipoVenditore")
	private TipoVenditore otipovenditore;
	//Get e Set
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
	//Costanti
	public Venditore() {
		this.inizializza();
	}
	private void inizializza() {
		this.idvenditore=0;
		this.cognome=null;
		this.nome=null;
		this.indirizzo=null;
		this.numerotelefono=null;
		this.setOtipovenditore(null);
	}
}
