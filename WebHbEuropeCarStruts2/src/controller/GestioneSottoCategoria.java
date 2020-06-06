package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AreaInvestimentoService;
import model.dao.AreaService;
import model.dao.SottoCategoriaService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.Area;
import model.session.AreaInvestimento;
import model.session.SottoCategoria;

public class GestioneSottoCategoria extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_MAP = "mappa";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
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
	private SottoCategoria osottocategoria;
	private String codice;
	private String sottocategoria;
	private float budget;
	private float budgetspeso;
	private String IDArea;
	private List<AreaInvestimento> elencoAree;

	SottoCategoriaService oSot = new SottoCategoriaService();
	AreaInvestimentoService oAre = new AreaInvestimentoService();

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

	public List<AreaInvestimento> getElencoAree() {
		return elencoAree;
	}

	public void setElencoAree(List<AreaInvestimento> elencoAree) {
		this.elencoAree = elencoAree;
	}

	public SottoCategoria getOsottocategoria() {
		return osottocategoria;
	}

	public void setOsottocategoria(SottoCategoria osottocategoria) {
		this.osottocategoria = osottocategoria;
	}

	public String getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(String sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public float getBudgetspeso() {
		return budgetspeso;
	}

	public void setBudgetspeso(float budgetspeso) {
		this.budgetspeso = budgetspeso;
	}

	public String getIDArea() {
		return IDArea;
	}

	public void setIDArea(String iDArea) {
		IDArea = iDArea;
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
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<SottoCategoria> ali = oSot.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
			} else {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String prima() {
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<SottoCategoria> ali = oSot.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
		List<SottoCategoria> ali = oSot.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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
		List<SottoCategoria> ali = oSot.findPerAnnoContabile(oAnnoContabile.getIdannocontabile());
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

	public String modificaSottoCategoria() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
//			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			HashMap<String, String> map = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona un'Area");
					elencoAree = oAre.findAll();
					List<AreaInvestimento> elenco = new ArrayList<AreaInvestimento>();
					for (int i = 0; i < elencoAree.size(); i++) {
						AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
						if (elencoAree.get(i).getOannocontabile().getDatainizio().getTime() >= oanno.getDatainizio().getTime() && elencoAree.get(i).getOannocontabile().getDatafine().getTime() <= oanno.getDatafine().getTime()) {
							elenco.add(elencoAree.get(i));
						}
					}
					for (int i = 0; i < elenco.size(); i++) {
						put(String.valueOf(elenco.get(i).getIdarea()),
								elenco.get(i).getArea() + " " + elenco.get(i).getCodice());
					}
				}
			};
			sessionMap.put(KEY_MAP, map);
			sessionMap.put(KEY_OBJ, oSot.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante per effettuare modifiche");
			return execute();
		}
	}

	public String nuovaSottoCategoria() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un'Area");
				elencoAree = oAre.findAll();
				List<AreaInvestimento> elenco = new ArrayList<AreaInvestimento>();
				for (int i = 0; i < elencoAree.size(); i++) {
					if (elencoAree.get(i).getOannocontabile().getDatainizio().getTime() >= oanno.getDatainizio()
							.getTime()
							&& elencoAree.get(i).getOannocontabile().getDatafine().getTime() <= oanno.getDatafine()
									.getTime()) {
						elenco.add(elencoAree.get(i));
					}
				}
				for (int i = 0; i < elenco.size(); i++) {
					put(String.valueOf(elenco.get(i).getIdarea()),
							elenco.get(i).getArea() + " " + elenco.get(i).getCodice());
				}
			}
		};
		sessionMap.put(KEY_MAP, map);
		sessionMap.put(KEY_OBJ, new SottoCategoria());
		return "nuovomodifica";
	}

	public String eliminaSottoCategoria() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oSot.deleteOj(oSot.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare la sottocategoria poichè presente in altre tabelle");
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
		SottoCategoria oSottoCategoria = (SottoCategoria) sessionMap.get(KEY_OBJ);

		if (!this.codice.equalsIgnoreCase(""))
			oSottoCategoria.setCodice(codice);
		else
			addActionError("Codice non inserito");
		if (!this.sottocategoria.equalsIgnoreCase(""))
			oSottoCategoria.setSottocategoria(sottocategoria);
		else
			addActionError("Descrizione non inserita");
		oSottoCategoria.setBudget(0.0f);
		oSottoCategoria.setBudgetspeso(0.0f);
		if (Integer.parseInt(this.IDArea) != 0)
			oSottoCategoria.setOarea(oAre.findById(Integer.parseInt(this.IDArea)));
		else
			addActionError("Inserire un'area per la sottocategoria");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<AliquotaIva>) sessionMap.get(KEY_LIST)).size() - 1);
			oSot.persistOrUpdate(oSottoCategoria);
			return execute();
		} else
			return "nuovomodifica";
	}

}