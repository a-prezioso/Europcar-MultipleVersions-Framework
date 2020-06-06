package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GSPFE_Gruppo")
public class Gruppo {
	//Costanti
	public static final String PROPERTY_idGruppo ="idgruppo";
	public static final String PROPERTY_nomeGruppo ="nomeGruppo";
	public static final String PROPERTY_codice ="codice";
	//Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idgruppo;
	@Column(name="NomeGruppo")
	private String nomeGruppo;
	@Column(name="Codice")
	private String codice;
	//Get e Set
	
	public String getNomeGruppo() {
		return nomeGruppo;
	}
	public int getIdgruppo() {
		return idgruppo;
	}
	public void setIdgruppo(int idgruppo) {
		this.idgruppo = idgruppo;
	}
	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	//Costruttori
	public Gruppo() {
		this.inizializza();
	}
	private void inizializza() {
		this.idgruppo=0;
		this.codice=null;
		this.nomeGruppo=null;
	}
}
