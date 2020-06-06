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
@Table(name = "GSPFE_Azienda")
public class Azienda {
	// Costanti
	public static final String PROPERTY_id = "idazienda";
	public static final String PROPERTY_RagioneSociale = "ragioneSociale";
	public static final String PROPERTY_idgruppo = "ogruppo";
	public static final String PROPERTY_Indirizzo = "indirizzo";
	public static final String PROPERTY_ContractID = "contractID";
	// Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idazienda;
	@Column(name = "RagioneSociale")
	private String ragioneSociale;
	@ManyToOne
	@JoinColumn(name = "idgruppo")
	private Gruppo ogruppo;
	@Column(name = "Indirizzo")
	private String indirizzo;
	@Column(name = "ContractID")
	private String contractID;
	// Get e Set

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public int getIdazienda() {
		return idazienda;
	}

	public void setIdazienda(int idazienda) {
		this.idazienda = idazienda;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
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

	// Costruttori
	public Azienda() {
		this.inizializza();
	}

	private void inizializza() {
		this.idazienda = 0;
		this.indirizzo = null;
		this.ragioneSociale = null;
		this.contractID = null;
		this.setOgruppo(null);
	}
}
