package controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

//import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class PianoInvestimentoAction extends ActionSupport implements SessionAware {
	
	private String scelta;
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_SIZE = "size";
	public static final String KEY_PAGINEANNO = "pagineAnno";
	public static final String KEY_PAGINACORRENTEANNO = "paginacorrenteAnno";
	public static final String KEY_INIZIOANNO = "inizioAnno";
	public static final String KEY_FINEANNO = "fineAnno";
	public static final String KEY_CONTROLLOANNO = "controlloAnno";
	public static final String KEY_CONTROLLOINDIETROANNO = "controlloindietroAnno";
	public static final String KEY_CONTROLLOFINEANNO = "controllofineAnno";
	public static final String KEY_CONTROLLONUOVOMODIFICAANNO = "controllonuovomodificaAnno";
	public static final String KEY_SIZEANNO = "sizeAnno";
	
	private SessionMap<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	private HashMap<String, String> map = new HashMap<String, String> () 
			{
		{
			put("ListaPianiRedirect", "Lista Piani");
			put("GeneraPianoRedirect", "Genera Piano d'Investimento");
		}
			};
			
	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
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
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		 sessionMap.put(KEY_PAGINEANNO, null);  
		 sessionMap.put(KEY_PAGINACORRENTEANNO, null);  
		 sessionMap.put(KEY_INIZIOANNO, null);  
		 sessionMap.put(KEY_FINEANNO, null);  
		 sessionMap.put(KEY_CONTROLLOANNO, null);  
		 sessionMap.put(KEY_CONTROLLOINDIETROANNO, null);  
		 sessionMap.put(KEY_CONTROLLOFINEANNO, null);  
		 sessionMap.put(KEY_CONTROLLONUOVOMODIFICAANNO, null);  
		 sessionMap.put(KEY_SIZEANNO, null); 
		if(StringUtils.isNotBlank(scelta)) {
			result = scelta;
			scelta = null;
		}
		return result;
	}
}
