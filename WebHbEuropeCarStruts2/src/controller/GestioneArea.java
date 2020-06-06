package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AreaService;
import model.dao.VenditoreService;
import model.session.AliquotaIva;
import model.session.Area;
import model.session.Gruppo;
import model.session.Venditore;

public class GestioneArea extends ActionSupport implements SessionAware {
	AreaService oAreaService = new AreaService();
	VenditoreService oVenditoreService = new VenditoreService();
	// Attributi
	private String chiave;
	public static final String KEY_AREA = "oggetto";
	public static final String KEY_VENDITORE = "listavenditori";
	public static final String KEY_LIST = "lista";
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
	private Area oArea;
	private SessionMap<String, Object> sessionMap;
	private String areav;
	private String idvenditore;
	private String codex;
	// Get e Set

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public Area getoArea() {
		return oArea;
	}

	public void setoArea(Area oArea) {
		this.oArea = oArea;
	}

	public String getAreav() {
		return areav;
	}

	public void setAreav(String areav) {
		this.areav = areav;
	}

	public String getIdvenditore() {
		return idvenditore;
	}

	public void setIdvenditore(String idvenditore) {
		this.idvenditore = idvenditore;
	}

	public String getCodex() {
		return codex;
	}

	public void setCodex(String codex) {
		this.codex = codex;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		List<Area> ali = oAreaService.findAll();
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
			if (9 >= z) {
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
				if(k>1)
				sessionMap.put(KEY_CONTROLLOINDIETRO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			}
			else if(z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String prima() {
		List<Area> ali = oAreaService.findAll();
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
		if (9 >= z) {
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
		List<Area> ali = oAreaService.findAll();
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
		List<Area> ali = oAreaService.findAll();
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

	public String nuovaArea() {
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
		sessionMap.put(KEY_AREA, new Area());
		sessionMap.put(KEY_VENDITORE, mapVenditore);
		String result = "nuovomodifica";
		return result;
	}

	public String modificaArea() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
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
			sessionMap.put(KEY_VENDITORE, mapVenditore);
			sessionMap.put(KEY_AREA, oAreaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante per effettuare modifiche");
			return execute();
		}
	}

	public String eliminaArea() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oAreaService.deleteOj(oAreaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<Area>) sessionMap.get(KEY_LIST)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare l'area poichè presente in altre tabelle");
				return execute();
			}
		} else
			addActionError("Valorizzare il pulsante per eliminare");
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String registraArea() {
		Area oArea = (Area) sessionMap.get(KEY_AREA);
		if (!this.codex.equalsIgnoreCase(""))
			oArea.setCodice(this.codex);
		else
			addActionError("valorizzare il campo codice");
		if (Integer.parseInt(this.idvenditore) != 0)
			oArea.setOvenditore(oVenditoreService.findById(Integer.parseInt(this.idvenditore.replace("\'", ""))));
		else
			addActionError("Inserire il venditore per quest'area geografica");
		if (!this.areav.equalsIgnoreCase(""))
			oArea.setArea(this.areav);
		else
			addActionError("Inserire una descrizione per l'area");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<Area>) sessionMap.get(KEY_LIST)).size() - 1);
			oAreaService.persist(oArea);
			return execute();
		} else
			return "nuovomodifica";
	}
}
