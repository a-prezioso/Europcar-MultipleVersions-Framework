package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="HB_FORNITORE")
public class Fornitore {

	public static final String PROPERTY_idFornitore= "idfornitore";
	
	@Column(name = "idfornitore")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfornitore;
	
	@Column(name="ragionesociale")
	private String ragionesociale;

	@Column(name="indirizzo")
	private String indirizzo;
	
	@Column(name="citta")
	private String citta;

	@Column(name="cap")
	private String cap;
	
	@Column(name="provincia")
	private String provincia;

	@Column(name="partitaiva")
	private String partitaiva;

	public int getIdfornitore() {
		return idfornitore;
	}

	public void setIdfornitore(int idfornitore) {
		this.idfornitore = idfornitore;
	}

	public String getRagionesociale() {
		return ragionesociale;
	}

	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPartitaiva() {
		return partitaiva;
	}

	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}

}