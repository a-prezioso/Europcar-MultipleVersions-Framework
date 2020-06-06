package controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.UtenteService;
import model.session.Utente;
import util.PasswordUtil;
import util.SessionManager;

public class GestioneLogin extends ActionSupport implements SessionAware{
	UtenteService oUtenteService = new UtenteService();
	//Attributi
	private String chiave;
	private SessionMap<String,Object> sessionMap;
	public static final String KEY_OBJ2 = "oggetto2";
	public static final String KEY_STRUTSANNO ="prova";
	private String user;
	private String pw;
	//Get e Set

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	//Metodi
	public String execute() {
		sessionMap.put(KEY_OBJ2, new Utente());
		return "input";
	}
	public String login() {
		List<Utente> outentelist = new UtenteService().executeParamizedHQLQuery("From model.session.Utente o WHERE o.username =  '" + this.user + "' AND o.password='"+ PasswordUtil.cryptWithMD5(this.pw) + "'" , Utente.class);
		String result ="input";
		if(outentelist.size()!=0) {
			Utente outente = outentelist.get(0);
			SessionManager.getInstance().setUtente(outente);
			if(sessionMap.get(KEY_STRUTSANNO)==null) {
			result ="selectAnno";
			}
			else {
				sessionMap.put(KEY_STRUTSANNO, "Main");
				result = "cambiaAnno";
			}
			sessionMap.put(KEY_OBJ2, outente);
		}
		else
			addActionError("UserName o Password errati!");

		return result;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=(SessionMap<String,Object>) arg0;
	}
	
}
