package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="HB_AliquotaIva")
public class AliquotaIva {

	@Column(name = "idaliquotaiva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idaliquotaiva;


	
	@Column(name="aliquota")
	private int aliquota;

	@Column(name="descrizione")
	private String descrizione;

	public int getIdaliquotaiva() {
		return idaliquotaiva;
	}

	public void setIdaliquotaiva(int idaliquotaiva) {
		this.idaliquotaiva = idaliquotaiva;
	}

	public int getAliquota() {
		return aliquota;
	}

	public void setAliquota(int aliquota) {
		this.aliquota = aliquota;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	






}