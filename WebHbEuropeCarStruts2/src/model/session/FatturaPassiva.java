package model.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "HB_FATTURAPASSIVA")
public class FatturaPassiva {

	public static final String PROPERTY_IDFornitore = "ofornitore";
	public static final String PROPERTY_IDFatturaPassiva = "idfatturapassiva";

	@Column(name = "idfatturapassiva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfatturapassiva;

	@Column(name = "data")
	private Date data;

	@Column(name = "numero")
	private int numero;

	@Column(name = "descrizione")
	private String descrizione;

	@ManyToOne
	@JoinColumn(name = "idfornitore")
	private Fornitore ofornitore;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ofatturapassiva", orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	private List<FatturaPassivaDettaglio> dettagli = new ArrayList<FatturaPassivaDettaglio>();

	public List<FatturaPassivaDettaglio> getDettagli() {
		return dettagli;
	}

	public void setDettagli(List<FatturaPassivaDettaglio> dettagli) {
		this.dettagli = dettagli;
	}

	public int getIdfatturapassiva() {
		return idfatturapassiva;
	}

	public void setIdfatturapassiva(int idfatturapassiva) {
		this.idfatturapassiva = idfatturapassiva;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Fornitore getOfornitore() {
		return ofornitore;
	}

	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}

}