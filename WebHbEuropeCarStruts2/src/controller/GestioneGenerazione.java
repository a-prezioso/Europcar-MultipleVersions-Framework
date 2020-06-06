package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.DistintaPagamentoService;
import model.dao.FatturaPassivaDettaglioService;
import model.session.AnnoContabile;
import model.session.DistintaPagamento;
import model.session.FatturaPassivaDettaglio;

public class GestioneGenerazione extends ActionSupport implements SessionAware {
	DistintaPagamentoService oDistintaPagamentoService = new DistintaPagamentoService();
	// Attributi
	private String iddettagliofattura;
	private SessionMap<String, Object> sessionMap;
	private DistintaPagamento oDistinta;
	private Date datainizio;
	private Date datafine;
	public static final String KEY_LISTAFATTURE = "listafatture";
	public static final String KEY_OGGETTOFATTURA = "oggettofattura";
	public static final String KEY_OGGETTODISTINTA = "oggettodistinta";
	public static final String KEY_DATAINIZIO = "datainizio";
	public static final String KEY_DATAFINE = "datafine";
	public static final String KEY_OGGETTOANNO ="oggettoanno";

	// Get e Set

	public String getIddettagliofattura() {
		return iddettagliofattura;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Date getDatafine() {
		return datafine;
	}

	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}

	public void setIddettagliofattura(String iddettagliofattura) {
		this.iddettagliofattura = iddettagliofattura;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public DistintaPagamento getoDistinta() {
		return oDistinta;
	}

	public void setoDistinta(DistintaPagamento oDistinta) {
		this.oDistinta = oDistinta;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		AnnoContabile oanno = (AnnoContabile)sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		String result = "search";
		return result;
	}

	public String generazione() {
		if(this.datainizio!= null && this.datafine != null) {
		List<FatturaPassivaDettaglio> elenco = this.elencoFatturePagate();
		for (int i = 0; i < elenco.size(); i++) {
			DistintaPagamento oDistinta = new DistintaPagamento();
			oDistinta.setOfatturapassivadettaglio(elenco.get(i));
			oDistintaPagamentoService.persistOrUpdate(oDistinta);
			addActionError("Generazione effettuata");
		}
		String result = "search";
	
		return result;
		} else {
			addActionError("Inserire una data inizio e una data fine");
			return execute();
		}
	}

	public List<FatturaPassivaDettaglio> elencoFatturePagate() {
		List<FatturaPassivaDettaglio> elenco = new FatturaPassivaDettaglioService().executeParamizedHQLQuery(
				"FROM FatturaPassivaDettaglio WHERE importoPagato > 0", FatturaPassivaDettaglio.class);
		List<FatturaPassivaDettaglio> lista = new ArrayList<FatturaPassivaDettaglio>();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getOfatturapassiva().getData().getTime() >= this.datainizio.getTime()
					&& elenco.get(i).getOfatturapassiva().getData().getTime() <= this.datafine.getTime()) {
				List<DistintaPagamento> listab = oDistintaPagamentoService.executeParamizedHQLQuery(
						"FROM DistintaPagamento WHERE ofatturapassivadettaglio.idfatturapassivadettaglio ="
								+ elenco.get(i).getIdfatturapassivadettaglio(),
						DistintaPagamento.class);
				if (listab.isEmpty()) {
					lista.add(elenco.get(i));
				}
			}
		}
		return lista;
	}

	public String chiudi() {
		String result = "chiudi";
		return result;
	}

}
