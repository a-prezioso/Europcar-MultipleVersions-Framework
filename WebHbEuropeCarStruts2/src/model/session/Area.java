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
@Table(name = "GSPFE_Area")
public class Area {
	// Costanti
	public static final String PROPERTY_idArea = "idarea";
	public static final String PROPERTY_Venditore = "ovenditore";
	public static final String PROPERTY_codice = "codice";
	// Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idarea;
	@ManyToOne
	@JoinColumn(name = "idvenditore")
	private Venditore ovenditore;
	@Column(name = "Codice")
	private String codice;
	@Column(name = "Area")
	private String area;
	// Get e Set

	public Venditore getOvenditore() {
		return ovenditore;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getIdarea() {
		return idarea;
	}

	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}

	public void setOvenditore(Venditore ovenditore) {
		this.ovenditore = ovenditore;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	// Costruttori
	public Area() {
		this.inizializza();
	}

	private void inizializza() {
		this.idarea = 0;
		this.codice = null;
		this.setOvenditore(null);
	}
}
