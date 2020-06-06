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
@Table(name = "GSPFE_AreaInvestimento")
public class AreaInvestimento {
	// Costanti
	public static final String PROPERTY_idAreaInvestimento = "idAreaInvestimento";
	public static final String areainvestimento = "areainvestimento";
	public static final String PROPERTY_codice = "codice";
	// Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idarea;
	@Column(name = "Codice")
	private String codice;
	@Column(name = "AreaInvestimento")
	private String area;
	@ManyToOne
	@JoinColumn(name = "idannocontabile")
	private AnnoContabile oannocontabile;
	// Get e Set

	public String getCodice() {
		return codice;
	}

	public AnnoContabile getOannocontabile() {
		return oannocontabile;
	}

	public void setOannocontabile(AnnoContabile oannocontabile) {
		this.oannocontabile = oannocontabile;
	}

	public int getIdarea() {
		return idarea;
	}

	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
