package controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.session.AnnoContabile;

public class GestioneSelezioneAnno extends ActionSupport implements SessionAware{
	
	//Attributi
	private String chiave;
	private SessionMap<String,Object> sessionMap;

	public static final String KEY_LISTAANNI = "listaanni";

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

	//GEt e Set
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	
	//Metodi
	public String execute() {
		LinkedHashMap<String, String> mapAnni = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Anno Contabile: ");
				List<AnnoContabile> elencoAnni = new AnnoContabileService().executeParamizedHQLQuery("FROM AnnoContabile ORDER BY datainizio ", AnnoContabile.class);
				for (int i = 0; i < elencoAnni.size(); i++) {
					put(String.valueOf(elencoAnni.get(i).getIdannocontabile()),
							elencoAnni.get(i).getDescrizione());
				}
			}
		};
		sessionMap.put(KEY_LISTAANNI, mapAnni);
		return "input";
	}
	public String selezioneAnno() {
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		String result="";
		if(Integer.parseInt(this.chiave)!=0) {
		AnnoContabile oAnnoContabile = new AnnoContabileService().findById(Integer.parseInt(this.chiave.replace("\'",""))); 
		sessionMap.put(KEY_OGGETTOANNO, oAnnoContabile); 
		if((sessionMap.get(KEY_STRUTSANNO))==null) {
		 result ="Main";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("gestionearea")) {
			result ="AreaInvestimentoAct";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("Main")) {
			result ="Main";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("avanzamento")) {
			result ="AvanzamentoAction";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("definizione")) {
			result ="DefinizioneAction";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("riconciliazione")) {
			result ="RiconciliazioneAction";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("previsionale")) {
			result ="PrevisionaleAction";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("gestionefattura")) {
			result ="GestioneFatAct";
		}
		else if(String.valueOf(sessionMap.get(KEY_STRUTSANNO)).equalsIgnoreCase("gestioneordine")) {
			result ="GestioneOrdAct";
		}
		return result;
		} else {
			addActionError("Inserire un anno contabile");
			return execute();
		}
	} 
	
		
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=(SessionMap<String,Object>) arg0;
	}
}
