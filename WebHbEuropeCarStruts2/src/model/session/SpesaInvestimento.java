package model.session;

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
@Table(name="HB_SPESAINVESTIMENTO")
public class SpesaInvestimento {
	//
	public static final String PROPERTY_id = "idspesainvestimento";
	public static final String PROPERTY_SPESA ="spesainvestimento";
	public static final String PROPERTY_IDSOTCAT ="osottocategoria";
	//

	@Column(name = "idspesainvestimento")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idspesainvestimento;
	
	@Column(name="spesainvestimeto")
	private String spesainvestimento;

	@ManyToOne
	@JoinColumn(name="idsottocategoria")
	private SottoCategoria osottocategoria;

	public int getIdspesainvestimento() {
		return idspesainvestimento;
	}

	public void setIdspesainvestimento(int idspesainvestimento) {
		this.idspesainvestimento = idspesainvestimento;
	}

	public String getSpesainvestimento() {
		return spesainvestimento;
	}

	public void setSpesainvestimento(String spesainvestimento) {
		this.spesainvestimento = spesainvestimento;
	}

	public SottoCategoria getOsottocategoria() {
		return osottocategoria;
	}

	public void setOsottocategoria(SottoCategoria osottocategoria) {
		this.osottocategoria = osottocategoria;
	}

	
	

}