package model.session;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GSPFE_Previsione")
public class Previsione {
	
	public static final String PROPERTY_id = "idprevisione";
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprevisione;
	
	@ManyToOne
	@JoinColumn(name = "idarea")
	private Area oarea;
	
	@ManyToOne
	@JoinColumn(name = "idazienda")
	private Azienda oazienda;
	
	@ManyToOne
	@JoinColumn(name = "idvenditore")
	private Venditore ovenditore;
	
	@Column(name = "DataVisita")
	private Date datavisita;
	
	@ManyToOne
	@JoinColumn(name="IDSottocategoria")
	private SottoCategoria osottocategoria;
	
	@Column(name = "AnnoDiRiferimento")
	private Date annodiriferimento;
	

	@Column(name = "DataRegistrazione")
	private Date dataregistrazione;
	
	

	@Column(name = "Confidenza")
	private String confidenza;
	

	@Column(name = "PotenzialeEuropeCar")
	private float potenzialeeuropecar;
	
	@Column(name = "PotenzialeAzienda")
	private float potenzialeazienda;

	@Column(name = "ShareAnte")
	private float shareante;
	
	@Column(name = "SharePost")
	private float sharepost;
	
	@Column(name = "ShareAvis")
	private float shareavis;
	
	@Column(name = "ShareHertz")
	private float sharehertz;
	
	@Column(name = "ShareMaggiore")
	private float sharemaggiore;
	
	@Column(name = "ShareSixt")
	private float sharesixt;

	public int getIdprevisione() {
		return idprevisione;
	}

	public void setIdprevisione(int idprevisione) {
		this.idprevisione = idprevisione;
	}




	public Area getOarea() {
		return oarea;
	}

	public void setOarea(Area oarea) {
		this.oarea = oarea;
	}

	public Azienda getOazienda() {
		return oazienda;
	}

	public void setOazienda(Azienda oazienda) {
		this.oazienda = oazienda;
	}

	public Venditore getOvenditore() {
		return ovenditore;
	}

	public void setOvenditore(Venditore ovenditore) {
		this.ovenditore = ovenditore;
	}

	public Date getDatavisita() {
		return datavisita;
	}

	public void setDatavisita(Date datavisita) {
		this.datavisita = datavisita;
	}

	public int getAnnodiriferimento() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.annodiriferimento);
		return calendar.get(Calendar.YEAR);
	}

	public void setAnnodiriferimento(Date annodiriferimento) {
		this.annodiriferimento = annodiriferimento;
	}

	public Date getDataregistrazione() {
		return dataregistrazione;
	}

	public void setDataregistrazione(Date dataregistrazione) {
		this.dataregistrazione = dataregistrazione;
	}

	public String getConfidenza() {
		return confidenza;
	}

	public void setConfidenza(String confidenza) {
		this.confidenza = confidenza;
	}

	public float getPotenzialeeuropecar() {
		return potenzialeeuropecar;
	}

	public void setPotenzialeeuropecar(float potenzialeeuropecar) {
		this.potenzialeeuropecar = potenzialeeuropecar;
	}

	public float getPotenzialeazienda() {
		return potenzialeazienda;
	}

	public void setPotenzialeazienda(float potenzialeazienda) {
		this.potenzialeazienda = potenzialeazienda;
	}

	public float getShareante() {
		return shareante;
	}

	public void setShareante(float shareante) {
		this.shareante = shareante;
	}

	public float getSharepost() {
		return sharepost;
	}

	public void setSharepost(float sharepost) {
		this.sharepost = sharepost;
	}

	public float getShareavis() {
		return shareavis;
	}

	public void setShareavis(float shareavis) {
		this.shareavis = shareavis;
	}

	public float getSharehertz() {
		return sharehertz;
	}

	public void setSharehertz(float sharehertz) {
		this.sharehertz = sharehertz;
	}

	public float getSharemaggiore() {
		return sharemaggiore;
	}

	public void setSharemaggiore(float sharemaggiore) {
		this.sharemaggiore = sharemaggiore;
	}

	public float getSharesixt() {
		return sharesixt;
	}

	public void setSharesixt(float sharesixt) {
		this.sharesixt = sharesixt;
	}
	
	
	public SottoCategoria getOsottocategoria() {
		return osottocategoria;
	}

	public void setOsottocategoria(SottoCategoria osottocategoria) {
		this.osottocategoria = osottocategoria;
	}

	public Previsione(Venditore ovenditore) {
		this.setOvenditore(ovenditore);
	}
	
	public Previsione() {
		
	}
	

	
	
}
