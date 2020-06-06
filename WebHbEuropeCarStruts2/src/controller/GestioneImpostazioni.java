package controller;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.UtenteService;
import model.dao.VenditoreService;
import model.session.Utente;
import util.PasswordUtil;

public class GestioneImpostazioni extends ActionSupport implements SessionAware {
	UtenteService oUtenteService = new UtenteService();
	VenditoreService oVenditoreService = new VenditoreService();

	// Attributi
	private String chiave;
	private String adminv;
	private String userv;
	private String pw;
	private String pwvecchia;
	private String pwnuova1;
	private String pwnuova2;
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ2 = "oggetto2";
	public static final String KEY_OBJU = "oggettou";
	public static final String KEY_VEND = "listavenditori";
	private SessionMap<String, Object> sessionMap;
	private Utente oUtente;
	private String idvenditore;

	// Get e Set

	public String getChiave() {
		return chiave;
	}

	public String getPwvecchia() {
		return pwvecchia;
	}

	public void setPwvecchia(String pwvecchia) {
		this.pwvecchia = pwvecchia;
	}

	public String getPwnuova1() {
		return pwnuova1;
	}

	public void setPwnuova1(String pwnuova1) {
		this.pwnuova1 = pwnuova1;
	}

	public String getPwnuova2() {
		return pwnuova2;
	}

	public void setPwnuova2(String pwnuova2) {
		this.pwnuova2 = pwnuova2;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getAdminv() {
		return adminv;
	}

	public void setAdminv(String adminv) {
		this.adminv = adminv;
	}

	public String getUserv() {
		return userv;
	}

	public void setUserv(String userv) {
		this.userv = userv;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Utente getoUtente() {
		return oUtente;
	}

	public void setoUtente(Utente oUtente) {
		this.oUtente = oUtente;
	}

	public String getIdvenditore() {
		return idvenditore;
	}

	public void setIdvenditore(String idvenditore) {
		this.idvenditore = idvenditore;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		String result = "search";
		Utente oUtente = (Utente) sessionMap.get(KEY_OBJ2);
		sessionMap.put(KEY_LIST, oUtente);
		return result;
	}

	public String modificaUtente() {
		if (this.chiave != null) {
			sessionMap.put(KEY_OBJ2, oUtenteService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Selezionare un utente per poterlo modificare");
			return execute();
		}
	}

	public String annulla() {
		return "nuovomodifica";
	}

	public String annullauser() {
		return execute();
	}

	public String cambiaPassword() {
		sessionMap.put(KEY_OBJ2, sessionMap.get(KEY_OBJ2));
		return "modificapw";
	}

	public String registraPassword() {
		String result = null;
		Utente oUtente = (Utente) sessionMap.get(KEY_OBJ2);
		if ((PasswordUtil.cryptWithMD5(this.pwvecchia)).equalsIgnoreCase(oUtente.getPassword())) {
			if (this.pwnuova1.equalsIgnoreCase(this.pwnuova2)) {
				if (!this.pwnuova1.equalsIgnoreCase(this.pwvecchia)) {
					if (!this.pwnuova1.equalsIgnoreCase("") && !this.pwnuova2.equalsIgnoreCase("")) {
						oUtente.setPassword(PasswordUtil.cryptWithMD5(this.pwnuova1));
						oUtenteService.update(oUtente);
						addActionMessage("Password cambiata correttamente");
						result = "search";
					} else {
						addActionError("Riempire i campi password per poter proseguire");
						result = "modificapw";
					}
				} else {
					addActionError("Password uguale alla precedente! ");
					result = "modificapw";
				}
			} else {
				addActionError("Password inserite non corrispondenti");
				result = "modificapw";
			}
		} else {
			addActionError("Vecchia Password errata! ");
			result = "modificapw";
		}
		return result;
	}

	public String registraUtente() {
		if (!this.userv.equalsIgnoreCase("")) {
			oUtente = (Utente) sessionMap.get(KEY_OBJ2);
			oUtente.setUsername(this.userv);
			new UtenteService().persistOrUpdate(oUtente);
			return execute();
		} else {
			addActionError("Riempire il campo Username per poter proseguire");
			return "nuovomodifica";
		}

	}
}
