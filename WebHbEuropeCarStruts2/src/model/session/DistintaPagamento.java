package model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HB_DISTINTAPAGAMENTO")
public class DistintaPagamento {

	@Column(name = "iddistintapagamento")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int iddistintapagamento;

	@OneToOne
	@JoinColumn(name = "idfatturapassivadettaglio")
	private FatturaPassivaDettaglio ofatturapassivadettaglio;

	public int getIddistintapagamento() {
		return iddistintapagamento;
	}

	public void setIddistintapagamento(int iddistintapagamento) {
		this.iddistintapagamento = iddistintapagamento;
	}

	public FatturaPassivaDettaglio getOfatturapassivadettaglio() {
		return ofatturapassivadettaglio;
	}

	public void setOfatturapassivadettaglio(FatturaPassivaDettaglio ofatturapassivadettaglio) {
		this.ofatturapassivadettaglio = ofatturapassivadettaglio;
	}

}
