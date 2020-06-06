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
@Table(name = "HB_ORDINEDIACQUISTODETTAGLIO")
public class OrdineDiAcquistoDettaglio{
	
	public static final String PROPERTY_IDOrdineAcquisto = "oordineacquisto";

 @Column(name = "idordinediacquistodettaglio")
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int idordinediacquistodettaglio;
 
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "idordineacquisto")
 private OrdineAcquisto oordineacquisto;
 
 @ManyToOne
 @JoinColumn(name = "idspesainvestimento")
 private SpesaInvestimento ospesainvestimento;
 
 @ManyToOne
 @JoinColumn(name = "idprogetto")
 private Progetto oprogetto;
 
 @Column(name = "importo")
 private Float importo;
 
 @Column(name = "quantita")
 private int quantita;

public int getIdordinediacquistodettaglio() {
	return idordinediacquistodettaglio;
}

public void setIdordinediacquistodettaglio(int idordinediacquistodettaglio) {
	this.idordinediacquistodettaglio = idordinediacquistodettaglio;
}

public OrdineAcquisto getOordineacquisto() {
	return oordineacquisto;
}

public void setOordineacquisto(OrdineAcquisto oordineacquisto) {
	this.oordineacquisto = oordineacquisto;
}

public SpesaInvestimento getOspesainvestimento() {
	return ospesainvestimento;
}

public void setOspesainvestimento(SpesaInvestimento ospesainvestimento) {
	this.ospesainvestimento = ospesainvestimento;
}

public Progetto getOprogetto() {
	return oprogetto;
}

public void setOprogetto(Progetto oprogetto) {
	this.oprogetto = oprogetto;
}

public Float getImporto() {
	return importo;
}

public void setImporto(Float importo) {
	this.importo = importo;
}

public int getQuantita() {
	return quantita;
}

public void setQuantita(int quantita) {
	this.quantita = quantita;
}
 
 
 
}