package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GSPFE_TipoVenditore")
public class TipoVenditore {
	//Attributi
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idtipovenditore;
	@Column(name="TipoVenditore")
	private String tipovenditore;
	//Get e Set
	public int getIdtipovenditore() {
		return idtipovenditore;
	}
	public void setIdtipovenditore(int idtipovenditore) {
		this.idtipovenditore = idtipovenditore;
	}
	public String getTipovenditore() {
		return tipovenditore;
	}
	public void setTipovenditore(String tipovenditore) {
		this.tipovenditore = tipovenditore;
	}
	
	//Costruttori
	public TipoVenditore() {
		this.inizializza();
	}
	private void inizializza() {
		this.idtipovenditore=0;
		this.tipovenditore="";
	}
}
