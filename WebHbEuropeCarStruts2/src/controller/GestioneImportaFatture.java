package controller;

import java.io.File;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import importerstrategy.ImporterStrategyFatturePassive;

public class GestioneImportaFatture extends ActionSupport implements SessionAware {

	// attributi
	public static final String KEY_MESSAGGIO = "messaggio";
	public static final String KEY_ECCEZIONE = "eccezione";
	private Date datainizio;
	private Date datafine;
	private File file;
	private SessionMap<String, Object> sessionMap;
	private String messaggio;
	

	public String getMessaggio() {
		return messaggio;
	}
	
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		sessionMap.put(KEY_MESSAGGIO, "");
		sessionMap.put(KEY_ECCEZIONE, "");
		return "search";
	}

	public String salvaFattura() {
		if (this.datainizio != null && this.file != null) {
			ImporterStrategyFatturePassive oImporto = new ImporterStrategyFatturePassive(this.file, this.datainizio,
					this.datafine);
			try {
				messaggio = oImporto.importaFatture();
				sessionMap.put(KEY_MESSAGGIO, messaggio);
			} catch (Exception e) {

				e.getMessage();
				sessionMap.put(KEY_ECCEZIONE, e.getMessage());
			}
			return "search";
		} else {
			
			return execute();
		}
	}
}