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
@Table(name="HB_ORDINEACQUISTO")
public class OrdineAcquisto {
	
	public static final String PROPERTY_IDFornitore = "ofornitore";
	public static final String PROPERTY_IDOrdineAcquisto = "idordineacquisto";
	public static final String PROPERTY_DATA = "data";

	@Column(name = "idordineacquisto")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idordineacquisto;
	
	@Column(name="data")
	private Date data;

	@Column(name="importo")
	private float importo;

	@Column(name="ordineacquisto")
	private String ordineacquisto;
	
	@ManyToOne
	@JoinColumn(name = "idfornitore")
	private Fornitore ofornitore;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "oordineacquisto", orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	private List<OrdineDiAcquistoDettaglio> dettagli = new ArrayList<OrdineDiAcquistoDettaglio>();

	

	public List<OrdineDiAcquistoDettaglio> getDettagli() {
		return dettagli;
	}

	public void setDettagli(List<OrdineDiAcquistoDettaglio> dettagli) {
		this.dettagli = dettagli;
	}

	public int getIdordineacquisto() {
		return idordineacquisto;
	}

	public void setIdordineacquisto(int idordineacquisto) {
		this.idordineacquisto = idordineacquisto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	

	public String getOrdineacquisto() {
		return ordineacquisto;
	}

	public void setOrdineacquisto(String ordineacquisto) {
		this.ordineacquisto = ordineacquisto;
	}

	public Fornitore getOfornitore() {
		return ofornitore;
	}

	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}

	public OrdineAcquisto() {
		this.idordineacquisto = 0;
		this.data = null;
		this.importo = 0.0f;
		this.ofornitore = null;
		this.ordineacquisto = "";
		this.dettagli = new ArrayList<OrdineDiAcquistoDettaglio>();
	}

	

}