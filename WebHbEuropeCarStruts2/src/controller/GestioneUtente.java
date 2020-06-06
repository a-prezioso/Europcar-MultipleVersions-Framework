package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.UtenteService;
import model.dao.VenditoreService;
import model.session.Utente;
import model.session.Venditore;
import util.PasswordUtil;

public class GestioneUtente extends ActionSupport implements SessionAware {
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
	public static final String KEY_KEY = "chiave";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	private boolean nuovomodifica;

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

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
		List<Utente> ali = oUtenteService.findAll();
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LIST, ali);
		if (sessionMap.get(KEY_CONTROLLO) != null) {
			if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) == null) {
				int i = (int) sessionMap.get(KEY_INIZIO) + 19;
				int j = (int) sessionMap.get(KEY_FINE) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIO, j);
					sessionMap.put(KEY_FINE, i);
					sessionMap.put(KEY_CONTROLLOFINE, true);
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIO, j);
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_CONTROLLOFINE, false);
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINE, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, false);
			}
		} else {
			sessionMap.put(KEY_INIZIO, 0);
			if (9 > z) {
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else {
				sessionMap.put(KEY_FINE, 9);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
			sessionMap.put(KEY_CONTROLLO, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINE, k);
		int w = (int) sessionMap.get(KEY_INIZIO);
		sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			sessionMap.put(KEY_FINE, z);
			sessionMap.put(KEY_CONTROLLOFINE, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIO, w - 10);
			sessionMap.put(KEY_FINE, z);
			sessionMap.put(KEY_PAGINACORRENTE, (w / 10));
		}
		if (sessionMap.get(KEY_SIZE) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZE);
			sessionMap.put(KEY_SIZE, null);
			if (z > sizevecchia) {
				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIO, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTE, k);
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
				sessionMap.put(KEY_CONTROLLOINDIETRO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String prima() {
		List<Utente> ali = oUtenteService.findAll();
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINE, k);
		sessionMap.put(KEY_PAGINACORRENTE, 1);

		sessionMap.put(KEY_INIZIO, 0);
		if (9 > z) {
			sessionMap.put(KEY_FINE, z);
		} else {
			sessionMap.put(KEY_FINE, 9);
		}
		sessionMap.put(KEY_CONTROLLO, true);
		sessionMap.put(KEY_CONTROLLOFINE, true);
		sessionMap.put(KEY_CONTROLLOINDIETRO, false);
		return "search";
	}

	public String ultima() {
		List<Utente> ali = oUtenteService.findAll();
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINE, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTE, q + 1);
		sessionMap.put(KEY_INIZIO, q * 10);
		sessionMap.put(KEY_FINE, z);
		sessionMap.put(KEY_CONTROLLOFINE, false);
		sessionMap.put(KEY_CONTROLLOINDIETRO, true);
		return "search";
	}

	public String indietro() {
		List<Utente> ali = oUtenteService.findAll();
		sessionMap.put(KEY_LIST, ali);
		int i = (int) sessionMap.get(KEY_INIZIO) - 10;
		int j = (int) sessionMap.get(KEY_FINE) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIO, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINE, k);
		int w = (int) sessionMap.get(KEY_INIZIO);
		sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);

		return "search";
	}

	public String nuovoUtente() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> mapVenditore = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Venditore: ");
				List<Venditore> elencoVenditori = oVenditoreService.findAll();
				for (int i = 0; i < elencoVenditori.size(); i++) {
					put(String.valueOf(elencoVenditori.get(i).getIdvenditore()),
							elencoVenditori.get(i).getCognome() + " " + elencoVenditori.get(i).getNome());
				}
			}
		};
		sessionMap.put(KEY_VEND, mapVenditore);
		sessionMap.put(KEY_OBJU, new Utente());
		sessionMap.put(KEY_KEY, null);
		String result = "nuovomodifica";
		return result;
	}

	public String modificaUtente() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		String result;
		if (this.chiave != null) {
			HashMap<String, String> mapVenditore = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Venditore: ");
					List<Venditore> elencoVenditori = oVenditoreService.findAll();
					for (int i = 0; i < elencoVenditori.size(); i++) {
						put(String.valueOf(elencoVenditori.get(i).getIdvenditore()),
								elencoVenditori.get(i).getCognome() + " " + elencoVenditori.get(i).getNome());
					}
				}
			};
			sessionMap.put(KEY_VEND, mapVenditore);
			sessionMap.put(KEY_OBJU, oUtenteService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(KEY_KEY, this.chiave);
			result = "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante di un Utente per poterlo modificare! ");
			result = execute();
		}
		return result;
	}

	public String eliminaUtente() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oUtenteService.deleteOj(oUtenteService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<Utente>) sessionMap.get(KEY_LIST)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Impossibile eliminare l'utente poichè presente in un'altra tabella! ");
			}
		} else {
			addActionError("Valorizzare il pulsante di un Utente per poterlo eliminare");
		}
		return execute();
	}

	public String annulla() {

		return execute();
	}

	public String registraUtente() {
		if (sessionMap.get(KEY_KEY) == null) {
			if (this.pwnuova1.equalsIgnoreCase(this.pwnuova2)) {
				Utente oUtente = (Utente) sessionMap.get(KEY_OBJU);
				oUtente.setAdmin(Boolean.parseBoolean(this.adminv));
				if (!this.pwnuova1.equalsIgnoreCase(""))
					oUtente.setPassword(PasswordUtil.cryptWithMD5(this.pwnuova1));
				else
					addActionError("Password non inserita");
				if (!this.userv.equalsIgnoreCase(""))
					oUtente.setUsername(this.userv);
				else
					addActionError("Username non inserito");
				if (Integer.parseInt(this.idvenditore) != 0) {
					if ((new UtenteService().executeParamizedHQLQuery(
							"FROM Utente WHERE ovenditore.idvenditore=" + this.idvenditore + "", Utente.class))
									.size() == 0) {
						oUtente.setOvenditore(
								oVenditoreService.findById(Integer.parseInt(this.idvenditore.replace("\'", ""))));
					} else {
						addActionError("Esiste gia un Utente di questo Venditore");
					}
				} else
					addActionError("Selezionare un Venditore per poter proseguire");
				if (getActionErrors().size() == 0) {
					oUtenteService.persistOrUpdate(oUtente);
					return execute();
				} else
					return "nuovomodifica";
			} else {
				addActionError("Password inserite non corrispondenti");
				return "nuovomodifica";
			}
		} else {
			Utente oUtente = (Utente) sessionMap.get(KEY_OBJU);
			oUtente.setAdmin(Boolean.parseBoolean(this.adminv));
			if (!oUtente.isAdmin()) {
				if (Integer.parseInt(this.idvenditore) != 0)
					oUtente.setOvenditore(
							oVenditoreService.findById(Integer.parseInt(this.idvenditore.replace("\'", ""))));
				else
					addActionError("Selezionare un Venditore per poter proseguire");
			}
			if (getActionErrors().size() == 0) {
				sessionMap.put(KEY_SIZE, ((List<Utente>) sessionMap.get(KEY_LIST)).size() - 1);
				oUtenteService.persistOrUpdate(oUtente);
				return execute();
			} else
				return "nuovomodifica";
		}
	}

}