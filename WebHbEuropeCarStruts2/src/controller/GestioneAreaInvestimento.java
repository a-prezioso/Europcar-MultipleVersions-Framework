package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.AreaInvestimentoService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.AreaInvestimento;
import model.session.Gruppo;

public class GestioneAreaInvestimento extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_MAP = "mappa";
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
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private AreaInvestimento oArea;
	private String codice;
	private String area;
	private String idannocontabile;
	private List<AnnoContabile> elencoAnniContabili;
	public static final String KEY_STRUTSANNO = "prova";
	AreaInvestimentoService oAre = new AreaInvestimentoService();
	AnnoContabileService oAnn = new AnnoContabileService();

	// Get e set

	public String getChiave() {
		return chiave;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public List<AnnoContabile> getElencoAnniContabili() {
		return elencoAnniContabili;
	}

	public void setElencoAnniContabili(List<AnnoContabile> elencoAnniContabili) {
		this.elencoAnniContabili = elencoAnniContabili;
	}

	public String getIdannocontabile() {
		return idannocontabile;
	}

	public void setIdannocontabile(String idannocontabile) {
		this.idannocontabile = idannocontabile;
	}

	public AreaInvestimento getoArea() {
		return oArea;
	}

	public void setoArea(AreaInvestimento oArea) {
		this.oArea = oArea;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<AreaInvestimento> ali = oAre.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<AreaInvestimento> ali = oAre.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<AreaInvestimento> ali = oAre.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<AreaInvestimento> ali = oAre.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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

	public String modificaArea() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			HashMap<String, String> map = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona un AnnoContabile");
					elencoAnniContabili = oAnn.findAll();
					for (int i = 0; i < elencoAnniContabili.size(); i++) {
						put(String.valueOf(elencoAnniContabili.get(i).getIdannocontabile()),
								elencoAnniContabili.get(i).getDescrizione());
					}
				}
			};
			sessionMap.put(KEY_MAP, map);
			sessionMap.put(KEY_OBJ, oAre.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else
			addActionError("Valorizzare l'oggetto da modificare");
		return execute();
	}

	public String nuovaArea() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un AnnoContabile");
				elencoAnniContabili = oAnn.findAll();
				for (int i = 0; i < elencoAnniContabili.size(); i++) {
					put(String.valueOf(elencoAnniContabili.get(i).getIdannocontabile()),
							elencoAnniContabili.get(i).getDescrizione());
				}
			}
		};
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_OBJ, new AreaInvestimento());
		return "nuovomodifica";
	}

	public String eliminaArea() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oAre.deleteOj(oAre.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<AreaInvestimento>) sessionMap.get(KEY_LIST)).size() - 1);
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

	public String registra() {

		AreaInvestimento oArea = (AreaInvestimento) sessionMap.get(KEY_OBJ);
		if (!this.codice.equalsIgnoreCase(""))
			oArea.setCodice(codice);
		else
			addActionError("Il codice non è inserito");
		if (!this.area.equalsIgnoreCase(""))
			oArea.setArea(area);
		else
			addActionError("Il campo area non è inserito");
		if (Integer.parseInt(idannocontabile) != 0)
			oArea.setOannocontabile(new AnnoContabileService().findById(Integer.parseInt(this.idannocontabile)));
		else
			addActionError("Non è stato inserito nessun anno contabile");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<AreaInvestimento>) sessionMap.get(KEY_LIST)).size() - 1);
			oAre.persistOrUpdate(oArea); 
			return execute();
		} else
			return "nuovomodifica";
	}



}