package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="HB_PROGETTO")
public class Progetto {

	@Column(name = "idprogetto")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprogetto;
	
	@Column(name="codice")
	private String codice;

	@Column(name="progetto")
	private String progetto;

	public int getIdprogetto() {
		return idprogetto;
	}

	public void setIdprogetto(int idprogetto) {
		this.idprogetto = idprogetto;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getProgetto() {
		return progetto;
	}

	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}




}