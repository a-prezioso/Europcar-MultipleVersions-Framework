package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HB_FATTURAPASSIVADETTAGLIO")
public class FatturaPassivaDettaglio {



	public static final String PROPERTY_IDFatturaPassiva = "ofatturapassiva";

	@Column(name = "idfatturapassivadettaglio")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idfatturapassivadettaglio;

	@ManyToOne
	@JoinColumn(name = "idaliquotaiva")
	private AliquotaIva oaliquota;

	@Column(name = "dettagliofattura")
	private String dettagliofattura;

	@Column(name = "importo")
	private Float importo;

	@ManyToOne
	@JoinColumn(name = "idpreventivo")
	private Preventivo opreventivo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfatturapassiva")
	private FatturaPassiva ofatturapassiva;

	@ManyToOne
	@JoinColumn(name = "idspesainvestimento")
	private SpesaInvestimento ospesainvestimento;
	@Column(name="ImportoPagato")
	private Float importoPagato;
	
	
	
	public Float getImportoPagato() {
		return importoPagato;
	}

	public void setImportoPagato(Float importoPagato) {
		this.importoPagato = importoPagato;
	}

	public int getIdfatturapassivadettaglio() {
		return idfatturapassivadettaglio;
	}

	public void setIdfatturapassivadettaglio(int idfatturapassivadettaglio) {
		this.idfatturapassivadettaglio = idfatturapassivadettaglio;
	}

	public AliquotaIva getOaliquota() {
		return oaliquota;
	}

	public void setOaliquota(AliquotaIva oaliquota) {
		this.oaliquota = oaliquota;
	}

	public String getDettagliofattura() {
		return dettagliofattura;
	}

	public void setDettagliofattura(String dettagliofattura) {
		this.dettagliofattura = dettagliofattura;
	}

	public Float getImporto() {
		return importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public Preventivo getOpreventivo() {
		return opreventivo;
	}

	public void setOpreventivo(Preventivo opreventivo) {
		this.opreventivo = opreventivo;
	}

	public FatturaPassiva getOfatturapassiva() {
		return ofatturapassiva;
	}

	public void setOfatturapassiva(FatturaPassiva ofatturapassiva) {
		this.ofatturapassiva = ofatturapassiva;
	}

	public SpesaInvestimento getOspesainvestimento() {
		return ospesainvestimento;
	}

	public void setOspesainvestimento(SpesaInvestimento ospesainvestimento) {
		this.ospesainvestimento = ospesainvestimento;
	}

	public FatturaPassivaDettaglio() {
		this.inizializza();
	}

	public FatturaPassivaDettaglio(FatturaPassiva ofatturapassiva) {
		this.ofatturapassiva = ofatturapassiva;
	} 
	private void inizializza() {
		this.idfatturapassivadettaglio=0;
		this.dettagliofattura="";
		this.importo=0.0f;
		this.importoPagato=0.0f;
		this.setOfatturapassiva(null);
		this.setOaliquota(null);
		this.setOpreventivo(null);
		this.setOspesainvestimento(null);
	}

}