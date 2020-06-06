package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

//import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import model.session.AnnoContabile;

public class MainAction extends ActionSupport implements SessionAware{

	private String scelta;
	private SessionMap<String, Object> sessionMap;
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_STRUTSANNO ="prova";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_SIZE = "size";
	public static String listaDettagli = "elencoDettagli";
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
	private LinkedHashMap<String, String> map = new LinkedHashMap<String, String> () 
	{
		{
			put("ArchivioRedirect", "Archivio"); 
			put("BudgetRedirect", "Budget");
			put("PreventivoRedirect", "Preventivo");
			put("OrdineAcquistoRedirect", "Ordine D'Acquisto");
			put("FatturaPassivaRedirect", "Fattura Passiva");
			put("PrevisioneRedirect", "Gestione Previsione");
			put("VenditoreRedirect", "Gestione Venditore");
			put("UtenteRedirect", "Gestione Utente");
			put("ImportoRedirect", "Importa Fatture");
			put("PagamentoRedirect", "Messa in pagamento");
			put("ImpostazioniRedirect", "Impostazioni");
			put("PianoInvestimentoRedirect", "Piano Investimento");
			put("DefinizionePianoRedirect", "Definizione Piano d'Investimento");
		}
	};
	private LinkedHashMap<String, String> map2 = new LinkedHashMap<String, String> () 
	{
		{
			put("ArchivioRedirect", "Archivio"); 
			put("BudgetRedirect", "Budget");
			put("PreventivoRedirect", "Preventivo");
			put("OrdineAcquistoRedirect", "Ordine D'Acquisto");
			put("FatturaPassivaRedirect", "Fattura Passiva");
			put("PrevisioneRedirect", "Gestione Previsione");
			put("VenditoreRedirect", "Gestione Venditore");
			put("ImportoRedirect", "Importa Fatture");
			put("PagamentoRedirect", "Messa in pagamento");
			put("ImpostazioniRedirect", "Impostazioni");
			put("PianoInvestimentoRedirect", "Piano Investimento");
		}
	};

	public LinkedHashMap<String, String> getMap2() {
		return map2;
	}

	public void setMap2(LinkedHashMap<String, String> map2) {
		this.map2 = map2;
	}

	public LinkedHashMap<String, String> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<String, String> map) {
		this.map = map;
	}


	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}

	public String execute() throws Exception {
		String result = INPUT;

		if(StringUtils.isNotBlank(scelta)) {
			result = scelta;
			scelta = null;
		}
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_OGGETTOANNO, oanno);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		sessionMap.put(listaDettagli, null);
		return result;
	}
	
	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "Main");
		return "cambiaAnno";
	}

}
