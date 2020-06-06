package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AreaService;
import model.dao.FornitoreService;
import model.dao.PreventivoService;
import model.session.Preventivo;
import model.session.AliquotaIva;
import model.session.Area;
import model.session.Fornitore;

public class GestionePreventivo extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_LISTA = "listapreventivi";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_OBJFOR = "oggettofornitore";
	public static final String KEY_MAP = "mappa";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private Preventivo opreventivo;
	private String codice;
	private String preventivo;
	private String IDFornitore;
	private List<Fornitore> elencoFornitori;
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

	PreventivoService oPre = new PreventivoService();
	FornitoreService oFor = new FornitoreService();

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

	public Preventivo getOpreventivo() {
		return opreventivo;
	}

	public void setOpreventivo(Preventivo opreventivo) {
		this.opreventivo = opreventivo;
	}

	public String getPreventivo() {
		return preventivo;
	}

	public void setPreventivo(String preventivo) {
		this.preventivo = preventivo;
	}

	public String getIDFornitore() {
		return IDFornitore;
	}

	public void setIDFornitore(String iDFornitore) {
		IDFornitore = iDFornitore;
	}

	public List<Fornitore> getElencoFornitori() {
		return elencoFornitori;
	}

	public void setElencoFornitori(List<Fornitore> elencoFornitori) {
		this.elencoFornitori = elencoFornitori;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	
	
	public String execute() {
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Fornitore");
				put(String.valueOf(-1), "Tutti");
				elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_OBJFOR, null);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return "search";
	}

	public String cerca() {
		String result = "";
		if (sessionMap.get(KEY_OBJFOR) == null) {
			if (Integer.parseInt(this.IDFornitore) != 0) {
				if (Integer.parseInt(this.IDFornitore) == -1) {
					List<Preventivo> elenco = oPre.findAll();
					sessionMap.put(KEY_LISTA, elenco);
					sessionMap.put(KEY_OBJFOR, this.IDFornitore);
					result = "cerca";
				} else {
					List<Preventivo> elenco = oPre.findWithCriteria(
							Restrictions.eq(Preventivo.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
									Integer.parseInt(this.IDFornitore)));
					sessionMap.put(KEY_LISTA, elenco);
					sessionMap.put(KEY_OBJFOR, this.IDFornitore);
					result = "cerca";
				}
			} else {
				addActionError("Scegliere il Fornitore di cui si vogliono vedere i Preventivi per proseguire");
				return execute();
			}
		} else {
			if (Integer.parseInt((String) sessionMap.get(KEY_OBJFOR)) != 0) {
				if (Integer.parseInt((String) sessionMap.get(KEY_OBJFOR)) == -1) {
					List<Preventivo> elenco = oPre.findAll();
					sessionMap.put(KEY_LISTA, elenco);
					sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
					result = "cerca";
				} else {
					List<Preventivo> elenco = oPre.findWithCriteria(
							Restrictions.eq(Preventivo.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
									Integer.parseInt((String) sessionMap.get(KEY_OBJFOR))));
					sessionMap.put(KEY_LISTA, elenco);
					sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
					result = "cerca";
				}
			} else {
				addActionError("Scegliere il Fornitore di cui si vogliono vedere i Preventivi per proseguire");
				result = execute();
			}
		}
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
		List<Preventivo> ali = (List<Preventivo>) sessionMap.get(KEY_LISTA);
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
				if(k >1)
				sessionMap.put(KEY_CONTROLLOINDIETRO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			}
			else if(z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "cerca";
	}
	
	public String prima() {
		List<Preventivo> ali = (List<Preventivo>) sessionMap.get(KEY_LISTA);
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
		return "cerca";
	}

	public String ultima() {
		List<Preventivo> ali = (List<Preventivo>) sessionMap.get(KEY_LISTA);
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
		return "cerca";
	}

	public String indietro() {
		List<Preventivo> ali = (List<Preventivo>) sessionMap.get(KEY_LISTA);
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

		return "cerca";
	}

	public String modificaPreventivo() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			HashMap<String, String> map = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona un Fornitore");
					elencoFornitori = oFor.findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(KEY_MAP, map);
			sessionMap.put(KEY_OBJ, oPre.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
			return "nuovomodifica";
		} else {
			addActionError("Selezionare un Preventivo per poterlo modificare");
			sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
			return "cerca";
		}

	}

	public String nuovoPreventivo() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Fornitore");
				elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};

		sessionMap.put(KEY_OBJ, new Preventivo());
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
		return "nuovomodifica";
	}

	public String eliminaPreventivo() {
		if (this.chiave != null) {
			try {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
				oPre.deleteOj(oPre.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
				sessionMap.put(KEY_SIZE, ((List<Preventivo>) sessionMap.get(KEY_LIST)).size() - 1);
				return cerca();
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare il preventivo poichè presente in altre tabelle");
				return "cerca";
			}
		} else {
			addActionError("Selezionare un Preventivo per poterlo eliminare");
			return "cerca";
		}
	}

	public String annulla() {

		sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
		return cerca();
	}

	public String registra() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		Preventivo oPreventivo = (Preventivo) sessionMap.get(KEY_OBJ);
		if (!this.codice.equalsIgnoreCase(""))
			oPreventivo.setCodice(codice);
		else
			addActionError("Inserire il codice per proseguire");
		if (!this.preventivo.equalsIgnoreCase(""))
			oPreventivo.setPreventivo(preventivo);
		else
			addActionError("Inserire il Preventivo per proseguire");
		if (Integer.parseInt(this.IDFornitore) != 0)
			oPreventivo.setOfornitore(oFor.findById(Integer.parseInt(this.IDFornitore)));
		else
			addActionError("Scegliere un Fornitore per proseguire");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<Preventivo>) sessionMap.get(KEY_LISTA)).size() - 1);
			oPre.persistOrUpdate(oPreventivo);
			oPreventivo.setOfornitore(null);
			sessionMap.put(KEY_OBJFOR, sessionMap.get(KEY_OBJFOR));
			return cerca();
		} else {
			return "nuovomodifica";
		}
	}

	public String indietropagina() {
		return execute();
	}

}