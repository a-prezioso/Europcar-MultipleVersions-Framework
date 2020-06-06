
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.Restrictions;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.FatturaPassivaDettaglioService;
import model.dao.FornitoreService;
import model.dao.OrdineAcquistoService;
import model.dao.OrdineDiAcquistoDettaglioService;
import model.dao.ProgettoService;
import model.dao.SpesaInvestimentoService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.FatturaPassiva;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;
import model.session.OrdineAcquisto;
import model.session.OrdineDiAcquistoDettaglio;
import model.session.Progetto;
import model.session.SpesaInvestimento;

public class GestioneOrdine extends ActionSupport implements SessionAware {
	public static final String listaOrdini = "elenco";
	public static final String oggettoOrdine = "oggetto";
	public static final String listaFornitori = "elencoFornitori";
	public static final String listaFornitoriOrdini = "elencoFornitoriOrdini";
	public static final String KEY_ORDINESENZADETTAGLI = "controlloregistra";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_OGGETTOFORNITORE = "oggettoFornitore";
	public static final String KEY_OGGETTOFORNITOREORDINE = "oggettoFornitoreOrdine";
	public static final String listaSpesa = "elencoSpesa";
	public static final String listaProgetti = "elencoProgetti";
	public static final String oggettoDettaglio = "oggettoDettaglio";
	public static final String listaDettagli = "elencoDettagli";
	public static final String KEY_STRUTSANNO = "prova";
	public static final String DATAINIZIO = "datain";
	public static final String DATAFINE = "datafi";
	public static final String dettagliElimina = "dettagliElimina";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";

	List<OrdineDiAcquistoDettaglio> listaDett = new ArrayList<OrdineDiAcquistoDettaglio>();
	OrdineAcquistoService oOrdineSer = new OrdineAcquistoService();
	FornitoreService oFornitoreSer = new FornitoreService();

	OrdineDiAcquistoDettaglioService oDettaglioSer = new OrdineDiAcquistoDettaglioService();
	SpesaInvestimentoService oSpesaSer = new SpesaInvestimentoService();
	ProgettoService oProgettoSer = new ProgettoService();

	private String scelta;
	private String chiave;
	private String importoPar;
	private String ordineAcquistoPar;
	private Date dataPar;
	private String fornitorePar;
	private boolean nuovomodifica;

	private String chiaveDettaglio;
	private String spesaDettaglio;
	private String progettoDettaglio;
	private String quantitaDettaglio;
	private String importoDettaglio;
	public static final String KEY_PROVAMODIFICAORDINE = "provamodificaordine";
	private SessionMap<String, Object> sessionMap;
	AnnoContabileService oanno = new AnnoContabileService();

	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}

	public List<OrdineDiAcquistoDettaglio> getListaDett() {
		return listaDett;
	}

	public void setListaDett(List<OrdineDiAcquistoDettaglio> listaDett) {
		this.listaDett = listaDett;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getImportoPar() {
		return importoPar;
	}

	public void setImportoPar(String importoPar) {
		this.importoPar = importoPar;
	}

	public String getOrdineAcquistoPar() {
		return ordineAcquistoPar;
	}

	public void setOrdineAcquistoPar(String ordineAcquistoPar) {
		this.ordineAcquistoPar = ordineAcquistoPar;
	}

	public Date getDataPar() {
		return dataPar;
	}

	public void setDataPar(Date dataPar) {
		this.dataPar = dataPar;
	}

	public String getFornitorePar() {
		return fornitorePar;
	}

	public void setFornitorePar(String fornitorePar) {
		this.fornitorePar = fornitorePar;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getChiaveDettaglio() {
		return chiaveDettaglio;
	}

	public void setChiaveDettaglio(String chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}

	public String getSpesaDettaglio() {
		return spesaDettaglio;
	}

	public void setSpesaDettaglio(String spesaDettaglio) {
		this.spesaDettaglio = spesaDettaglio;
	}

	public String getProgettoDettaglio() {
		return progettoDettaglio;
	}

	public void setProgettoDettaglio(String progettoDettaglio) {
		this.progettoDettaglio = progettoDettaglio;
	}

	public String getQuantitaDettaglio() {
		return quantitaDettaglio;
	}

	public void setQuantitaDettaglio(String quantitaDettaglio) {
		this.quantitaDettaglio = quantitaDettaglio;
	}

	public String getImportoDettaglio() {
		return importoDettaglio;
	}

	public void setImportoDettaglio(String importoDettaglio) {
		this.importoDettaglio = importoDettaglio;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public void setSession(Map<String, Object> varsession) {
		this.sessionMap = (SessionMap<String, Object>) varsession;
	}

	
	
	
	public String avanti() {
		List ali;
		String scelta;
		if (sessionMap.get(listaDettagli) == null) {
			ali = (List<OrdineAcquisto>) sessionMap.get(listaOrdini);
			scelta = "search";
		} else {
			ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
			if (((OrdineAcquisto) sessionMap.get(oggettoOrdine)).getIdordineacquisto() != 0) {
				scelta = "gestione";
			} else {
				scelta = "nuovoConDettagli";
			}
		}
		int z = ali.size() - 1;
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
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
				if (k > 1) {
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				}
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return scelta;
	}

	public String prima() {
		List ali;
		String scelta;
		if (sessionMap.get(listaDettagli) == null) {
			ali = (List<OrdineAcquisto>) sessionMap.get(listaOrdini);
			scelta = "search";
		} else {
			ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
			if (((OrdineAcquisto) sessionMap.get(oggettoOrdine)).getIdordineacquisto() != 0) {
				scelta = "gestione";
			} else {
				scelta = "nuovoConDettagli";
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
		return scelta;
	}

	public String ultima() {
		List ali;
		String scelta;
		if (sessionMap.get(listaDettagli) == null) {
			ali = (List<OrdineAcquisto>) sessionMap.get(listaOrdini);
			scelta = "search";
		} else {
			ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
			if (((OrdineAcquisto) sessionMap.get(oggettoOrdine)).getIdordineacquisto() != 0) {
				scelta = "gestione";
			} else {
				scelta = "nuovoConDettagli";
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
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTE, q + 1);
		sessionMap.put(KEY_INIZIO, q * 10);
		sessionMap.put(KEY_FINE, z);
		sessionMap.put(KEY_CONTROLLOFINE, false);
		sessionMap.put(KEY_CONTROLLOINDIETRO, true);
		return scelta;
	}

	public String indietro() {
		List ali;
		String scelta;
		if (sessionMap.get(listaDettagli) == null) {
			ali = (List<OrdineAcquisto>) sessionMap.get(listaOrdini);
			scelta = "search";
		} else {
			ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
			if (((OrdineAcquisto) sessionMap.get(oggettoOrdine)).getIdordineacquisto() != 0) {
				scelta = "gestione";
			} else {
				scelta = "nuovoConDettagli";
			}
		}
		int z = ali.size() - 1;
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
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINE, k);
		int w = (int) sessionMap.get(KEY_INIZIO);
		sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);

		return scelta;
	}

	public String execute() {
		LinkedHashMap<String, String> mapFor = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore ");
				put(String.valueOf(-1), "Tutti");
				List<Fornitore> elencoFornitori = oFornitoreSer.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(listaFornitoriOrdini, mapFor);
		List<OrdineAcquisto> ali = oOrdineSer.findPerAnnoContabile((AnnoContabile) sessionMap.get(KEY_OGGETTOANNO));
		sessionMap.put(listaOrdini, ali);
		sessionMap.put(KEY_PROVAMODIFICAORDINE, false);
		int z = ali.size() - 1;
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
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
				if (k > 1) {
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				}
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String cerca() {
		if (Integer.parseInt(this.fornitorePar) != 0) {
			LinkedHashMap<String, String> mapFor = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Fornitore ");
					put(String.valueOf(-1), "Tutti");
					List<Fornitore> elencoFornitori = oFornitoreSer.findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(listaFornitoriOrdini, mapFor);
			sessionMap.put(KEY_OGGETTOFORNITOREORDINE, new FornitoreService().findById(Integer.parseInt(this.fornitorePar)));
			List<OrdineAcquisto> result = new ArrayList<OrdineAcquisto>();
			List<OrdineAcquisto> elenco = new ArrayList<OrdineAcquisto>();
			if (Integer.parseInt(this.fornitorePar) == -1) {
				result = oOrdineSer.findPerAnnoContabile((AnnoContabile) sessionMap.get(KEY_OGGETTOANNO));
			} else {
				elenco = oOrdineSer.findWithCriteria(
						Restrictions.eq(OrdineAcquisto.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
								Integer.parseInt(this.fornitorePar)));
				AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
							&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
						result.add(elenco.get(i));
					}
				}
			}
			sessionMap.put(listaOrdini, result);
			sessionMap.put(KEY_PROVAMODIFICAORDINE, false);
			List<OrdineAcquisto> ali = result;
			int z = ali.size() - 1;
			sessionMap.put(KEY_SIZE, z);
			sessionMap.put(KEY_INIZIO, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else {
				sessionMap.put(KEY_FINE, 9);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
			int k = (int) Math.ceil(z / 10.0);
			String a = String.valueOf(z);
			char b = a.charAt(a.length() - 1);
			if (b == '0') {
				k = k + 1;
			}
			sessionMap.put(KEY_PAGINE, k);
			if (k == 0) {
				sessionMap.put(KEY_PAGINACORRENTE, 0);
			} else {
				sessionMap.put(KEY_PAGINACORRENTE, 1);
			}
			return "search";
		} else {
			addActionError("Inserire un fornitore o tutti i fornitori per effettuare la ricerca");
			List<OrdineAcquisto> ali = new ArrayList<OrdineAcquisto>();
			sessionMap.put(listaOrdini, ali);
			return "search";
		}
	}

	public String ricerca() {
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return cerca();
	}

	public String nuovo() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		LinkedHashMap<String, String> mapFor = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore");
				List<Fornitore> elencoFornitori = oFornitoreSer.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(listaFornitori, mapFor);
		sessionMap.put(oggettoOrdine, new OrdineAcquisto());
		AnnoContabile oAnno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(DATAINIZIO, oAnno.getDatainizio());
		sessionMap.put(DATAFINE, oAnno.getDatafine());
		sessionMap.put(KEY_ORDINESENZADETTAGLI, false);
		return "nuovo";
	}

	public String modifica() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			LinkedHashMap<String, String> mapFor = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Fornitore ");
					List<Fornitore> elencoFornitori = oFornitoreSer.findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(listaFornitori, mapFor);
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(oggettoOrdine, oOrdineSer.findById(Integer.parseInt(this.chiave.replace("\'", ""))));

			sessionMap.put(DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(DATAFINE, oanno.getDatafine());
			List<OrdineDiAcquistoDettaglio> ali = oDettaglioSer.findWithCriteria(Restrictions.eq(
					OrdineDiAcquistoDettaglio.PROPERTY_IDOrdineAcquisto + "."
							+ OrdineAcquisto.PROPERTY_IDOrdineAcquisto,
					Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(listaDettagli, ali);
			sessionMap.put(KEY_ORDINESENZADETTAGLI, true);
			sessionMap.put(KEY_CONTROLLO, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_PAGINE, null);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_SIZE, null);

			if (ali.size() != 0) {
				int z = ali.size() - 1;

				sessionMap.put(KEY_INIZIO, 0);
				if (9 >= z) {
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_CONTROLLOFINE, false);
				} else {
					sessionMap.put(KEY_FINE, 9);
					sessionMap.put(KEY_CONTROLLOFINE, true);
				}
				sessionMap.put(KEY_CONTROLLO, true);
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
			}
			return "gestione";
		} else {
			addActionError("Selezionare un ordine d'acquisto per poterlo modificare");
			return "search";
		}
	}

	public String elimina() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oOrdineSer.delete(Integer.parseInt(this.chiave.replace("\'", "")));
				sessionMap.put(KEY_SIZE, ((List<OrdineAcquisto>) sessionMap.get(listaOrdini)).size() - 1);
//				Fornitore oFornitore = (Fornitore) sessionMap.get(KEY_OGGETTOFORNITOREORDINE);
//				List<OrdineAcquisto> elenco = new ArrayList<OrdineAcquisto>();
//				elenco = oOrdineSer.findWithCriteria(
//						Restrictions.eq(OrdineAcquisto.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
//								oFornitore.getIdfornitore()));
//				AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
//				List<OrdineAcquisto> result = new ArrayList<OrdineAcquisto>();
//				for (int i = 0; i < elenco.size(); i++) {
//					if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
//							&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
//						result.add(elenco.get(i));
//					}
//				}
//				sessionMap.put(listaOrdini, result);
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare l'ordine poichè presente in altre tabelle");
				return execute();
			}
		} else {
			addActionError("selezionare un ordine d'acquisto per poterlo eliminare");
		}
		return annullaModifica();
	}

	public String nuovaSpesa() {

		OrdineAcquisto oOrdineAcquisto = ((OrdineAcquisto) sessionMap.get(oggettoOrdine));
		if (this.dataPar != null && this.importoPar != null && this.fornitorePar != null
				&& !this.importoPar.equalsIgnoreCase("") && !this.ordineAcquistoPar.equalsIgnoreCase("")) {
			Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
			Matcher matcher = pattern.matcher(this.importoPar);
			if (!matcher.matches()) {
				addActionError("Inserire il Campo Importo solo nel formato numerico");
				return "nuovo";
			}
			oOrdineAcquisto.setData(dataPar);
			oOrdineAcquisto.setImporto(Float.parseFloat(importoPar));
			oOrdineAcquisto.setOfornitore(oFornitoreSer.findById(Integer.parseInt(fornitorePar)));
			oOrdineAcquisto.setOrdineacquisto(ordineAcquistoPar);
		}
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		LinkedHashMap<String, String> mapSpesa = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Spesa Investimento");
				List<SpesaInvestimento> elenco = oSpesaSer.findAll();
				List<SpesaInvestimento> elencoSpesa = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatainizio()
							.getTime() >= oanno.getDatainizio().getTime()
							&& elenco.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatafine()
									.getTime() <= oanno.getDatafine().getTime()) {
						elencoSpesa.add(elenco.get(i));
					}
				}
				for (int i = 0; i < elencoSpesa.size(); i++) {
					put(String.valueOf(elencoSpesa.get(i).getIdspesainvestimento()),
							elencoSpesa.get(i).getSpesainvestimento());
				}
			}
		};
		LinkedHashMap<String, String> mapProge = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Progetto");
				List<Progetto> elencoProgetto = oProgettoSer.findAll();
				for (int i = 0; i < elencoProgetto.size(); i++) {
					put(String.valueOf(elencoProgetto.get(i).getIdprogetto()),
							elencoProgetto.get(i).getCodice() + " " + elencoProgetto.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(listaDettagli, oOrdineAcquisto.getDettagli());
		sessionMap.put(listaProgetti, mapProge);
		sessionMap.put(listaSpesa, mapSpesa);
		sessionMap.put(oggettoOrdine, oOrdineAcquisto);
		sessionMap.put(oggettoDettaglio, new OrdineDiAcquistoDettaglio());
		return "nuovaSpesa";
	}

	public String registra() {
		OrdineAcquisto oOrdine = ((OrdineAcquisto) sessionMap.get(oggettoOrdine));
		if (oOrdine.getDettagli().size() == 0) {
			addActionError("inserire dei dettagli per poter creare un nuovo ordine d'acquisto");
			if ((boolean) sessionMap.get(KEY_ORDINESENZADETTAGLI)) {
				return "gestione";
			} else {
				return "nuovo";
			}
		} else {
			if (this.dataPar != null) {
				oOrdine.setData(this.dataPar);
			} else {
				addActionError("Inserirre il campo data! ");
			}
			if (!this.ordineAcquistoPar.equalsIgnoreCase(""))
				oOrdine.setOrdineacquisto(this.ordineAcquistoPar);
			else
				addActionError("inserire una descrizione per l'ordine d'acquisto");
			if (Integer.parseInt(this.fornitorePar) != 0)
				oOrdine.setOfornitore(oFornitoreSer.findById(Integer.parseInt(this.fornitorePar)));
			else
				addActionError("inserire un fornitore per l'ordine d'acquisto");
			Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
			Matcher matcher = pattern.matcher(this.importoPar);
			if (!matcher.matches()) {
				addActionError("Inserire il Campo Importo solo nel formato numerico");
			} else {

				if (!this.importoPar.equalsIgnoreCase("") && Float.parseFloat(this.importoPar) != 0.0)
					oOrdine.setImporto(Float.parseFloat(this.importoPar));
				else
					addActionError("inserire l'importo per l'ordine di acquisto");

			}
			if (oOrdine.getDettagli().size() == 0)
				addActionError("Inserire dei dettagli per l'ordine d'acquisto corrente");
			if (getActionErrors().size() == 0) {
				sessionMap.put(listaDettagli, null);
				oOrdineSer.persistOrUpdate(oOrdine);
				for (int i = 0; i < oOrdine.getDettagli().size(); i++) {
					oDettaglioSer.persistOrUpdate(oOrdine.getDettagli().get(i));
				}
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
				sessionMap.put(KEY_SIZE, ((List<OrdineAcquisto>) sessionMap.get(listaOrdini)).size() - 1);
				oOrdine.setOfornitore(null);
				// sessionMap.put(listaOrdini,
				// oOrdineSer.findPerAnnoContabile((AnnoContabile)
				// sessionMap.get(KEY_OGGETTOANNO)));
//				Fornitore oFornitore = (Fornitore) sessionMap.get(KEY_OGGETTOFORNITOREORDINE);
//				List<OrdineAcquisto> elenco = new ArrayList<OrdineAcquisto>();
//				elenco = oOrdineSer.findWithCriteria(
//						Restrictions.eq(OrdineAcquisto.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
//								oFornitore.getIdfornitore()));
//				AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
//				List<OrdineAcquisto> result = new ArrayList<OrdineAcquisto>();
//				for (int i = 0; i < elenco.size(); i++) {
//					if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
//							&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
//						result.add(elenco.get(i));
//					}
//				}
//				sessionMap.put(listaOrdini, result);
//				sessionMap.put(KEY_CONTROLLO, null);
//				sessionMap.put(KEY_CONTROLLOFINE, null);
//				sessionMap.put(KEY_CONTROLLOINDIETRO, null);
//				sessionMap.put(KEY_INIZIO, null);
//				sessionMap.put(KEY_FINE, null);
//				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
//				sessionMap.put(KEY_PAGINE, null);
//				sessionMap.put(KEY_PAGINACORRENTE, null);
//				sessionMap.put(KEY_SIZE, null);
				return annullaModifica();
			} else {
				if ((boolean) sessionMap.get(KEY_ORDINESENZADETTAGLI)) {
					return "gestione";
				} else {
					return "nuovoConDettagli";
				}
			}
		}
	}

	public String registraModifica() {
		OrdineAcquisto oOrdine = ((OrdineAcquisto) sessionMap.get(oggettoOrdine));
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (oOrdine.getDettagli().size() == 0) {
			addActionError("inserisci dei dettagli per poter modificare l'ordine di acquisto");
			return "gestione";
		} else {
			oOrdine.setData(this.dataPar);
			if (!this.ordineAcquistoPar.equalsIgnoreCase(""))
				oOrdine.setOrdineacquisto(this.ordineAcquistoPar);
			else
				addActionError("inserire una descrizione per l'ordine d'acquisto");
			if (Integer.parseInt(this.fornitorePar) != 0)
				oOrdine.setOfornitore(oFornitoreSer.findById(Integer.parseInt(this.fornitorePar)));
			else
				addActionError("inserire un fornitore per l'ordine d'acquisto");
			if (getActionErrors().size() == 0) {
				sessionMap.put(KEY_CONTROLLO, true);
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
				oOrdineSer.persistOrUpdate(oOrdine);
				sessionMap.put(listaDettagli, null);
				oOrdine.setOfornitore(null);
				sessionMap.put(KEY_CONTROLLO, null);
				sessionMap.put(KEY_CONTROLLOFINE, null);
				sessionMap.put(KEY_CONTROLLOINDIETRO, null);
				sessionMap.put(KEY_INIZIO, null);
				sessionMap.put(KEY_FINE, null);
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
				sessionMap.put(KEY_PAGINE, null);
				sessionMap.put(KEY_PAGINACORRENTE, null);
				sessionMap.put(KEY_SIZE, null);
				return execute();
			} else {
				oOrdine.setOfornitore(null);
				return "gestione";
			}
		}
	}

	public String annulla() {

		
		sessionMap.put(listaDettagli, null);
		return "search";
	}

	public String annullaModifica() {
		List<OrdineAcquisto> ali = (List<OrdineAcquisto>) sessionMap.get(listaOrdini);
		if (ali.size() != 0) {
			int z = ali.size() - 1;

			sessionMap.put(KEY_INIZIO, 0);
			if (9 > z) {
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else {
				sessionMap.put(KEY_FINE, 9);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
			sessionMap.put(KEY_CONTROLLO, true);
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
		}
		sessionMap.put(listaDettagli, null);
		return "search";
	}

	public String memoriaDettaglio() {
		OrdineAcquisto oordineacquisto = ((OrdineAcquisto) sessionMap.get("oggetto"));
		OrdineDiAcquistoDettaglio oOrdineDettaglio = ((OrdineDiAcquistoDettaglio) sessionMap.get("oggettoDettaglio"));
		int chiave = 0;
		if ((boolean) sessionMap.get(KEY_PROVAMODIFICAORDINE)) {
			List<OrdineDiAcquistoDettaglio> elenco = oordineacquisto.getDettagli();
			boolean trovato = false;
			for (int i = 0; i < elenco.size() && !trovato; i++) {
				if (elenco.get(i).getIdordinediacquistodettaglio() == oOrdineDettaglio
						.getIdordinediacquistodettaglio()) {
					trovato = true;
					chiave = i;
				}
			}
		}
		Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
		Matcher matcher = pattern.matcher(this.importoDettaglio);
		if (!matcher.matches()) {
			addActionError("Inserire il Campo importoDettaglio solo nel formato numerico");
		} else {
			if (this.importoDettaglio.equalsIgnoreCase(""))
				addActionError("Inserire il Campo importoDettaglio ");
			else
				oOrdineDettaglio.setImporto(Float.parseFloat(this.importoDettaglio));
		}

		if (Integer.parseInt(this.progettoDettaglio) != 0)
			oOrdineDettaglio.setOprogetto(oProgettoSer.findById(Integer.parseInt(progettoDettaglio)));
		else
			addActionError("inserire un progetto");
		pattern = Pattern.compile("[0-9]*");
		matcher = pattern.matcher(this.quantitaDettaglio);
		if (!matcher.matches()) {
			addActionError("Inserire il Campo quantità Dettaglio solo nel formato numerico");
		} else {
			if (!this.quantitaDettaglio.equalsIgnoreCase("") && Integer.parseInt(this.quantitaDettaglio) != 0)
				oOrdineDettaglio.setQuantita(Integer.parseInt(quantitaDettaglio));
			else
				addActionError("inserire il campo quantita");
		}
		if (Integer.parseInt(this.spesaDettaglio) != 0)
			oOrdineDettaglio.setOspesainvestimento(oSpesaSer.findById(Integer.parseInt(spesaDettaglio)));
		else
			addActionError("inserire una spesa investimento");
		if (getActionErrors().size() == 0) {
			if (oordineacquisto != null) {
				if ((boolean) sessionMap.get(KEY_PROVAMODIFICAORDINE)) {
					oordineacquisto.getDettagli().set(chiave, oOrdineDettaglio);
				} else {
					oOrdineDettaglio.setOordineacquisto(((OrdineAcquisto) sessionMap.get("oggetto")));

					oordineacquisto.getDettagli().add(oOrdineDettaglio);
				}
			}
			sessionMap.put(oggettoOrdine, oordineacquisto);
			this.listaDett = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(dettagliElimina);
			if (listaDett != null) {
				this.listaDett.add(oOrdineDettaglio);
			} else {
				listaDett = new ArrayList<OrdineDiAcquistoDettaglio>();
				this.listaDett.add(oOrdineDettaglio);
			}
			sessionMap.put(dettagliElimina, listaDett);
			sessionMap.put(listaDettagli, oordineacquisto.getDettagli());
			if (oOrdineDettaglio.getIdordinediacquistodettaglio() != 0) {
				return "gestione";
			} else {
				if ((boolean) sessionMap.get(KEY_PROVAMODIFICAORDINE)) {
					return "gestione";
				} else {
					return nuovaSpesa();
				}
			}

		} else {
			return "nuovaSpesa";
		}
	}

	public String salvaDettagli() {

		LinkedHashMap<String, String> mapFor = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore");
				List<Fornitore> elencoFornitori = oFornitoreSer.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(listaFornitori, mapFor);
		sessionMap.put(oggettoOrdine, (OrdineAcquisto) sessionMap.get("oggetto"));
		sessionMap.put(dettagliElimina, null);
		//
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);

		List<OrdineDiAcquistoDettaglio> ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
		int z = ali.size() - 1;

		sessionMap.put(KEY_INIZIO, 0);
		if (9 > z) {
			sessionMap.put(KEY_FINE, z);
			sessionMap.put(KEY_CONTROLLOFINE, false);
		} else {
			sessionMap.put(KEY_FINE, 9);
			sessionMap.put(KEY_CONTROLLOFINE, true);
		}
		sessionMap.put(KEY_CONTROLLO, true);
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
		if (((OrdineAcquisto) sessionMap.get(oggettoOrdine)).getIdordineacquisto() != 0) {
			return "gestione";
		} else {
			return "nuovoConDettagli";
		}

	}

	public String annullaDettaglio() {
		if (listaDett != null) {
			OrdineAcquisto oord = (OrdineAcquisto) sessionMap.get(oggettoOrdine);
			this.listaDett = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(dettagliElimina);
			if (listaDett != null) {
				for (int i = 0; i < listaDett.size(); i++) {
					oord.getDettagli().remove(listaDett.get(i));
				}
			}
		}
		if ((boolean) sessionMap.get(KEY_ORDINESENZADETTAGLI)) {
			return "gestione";
		} else {
			return "nuovoConDettagli";
		}
	}

	public String annullaDettaglioModifica() {
		return "gestione";
	}

	public String eliminaSpesa() {
		boolean removed = false;
		if (this.chiaveDettaglio != null) {
			OrdineAcquisto oOrdineAcquisto = ((OrdineAcquisto) sessionMap.get("oggetto"));
			int i = 0;
			while (i < oOrdineAcquisto.getDettagli().size() && !removed) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					oOrdineAcquisto.getDettagli().remove(i);
					removed = true;
				} else {
					i++;
				}
			}
			sessionMap.put(listaDettagli, ((OrdineAcquisto) sessionMap.get("oggetto")).getDettagli());
			sessionMap.put(KEY_SIZE, ((List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli)).size() - 1);
			return "nuovoConDettagli";
		} else {
			addActionError("scegliere un dettaglio per poterlo eliminare");
			return "nuovoConDettagli";
		}
	}

	public String nuovoDettaglio() {

		LinkedHashMap<String, String> mapSpesa = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Spesa Investimento");
				List<SpesaInvestimento> elencoSpesa = oSpesaSer.findAll();
				for (int i = 0; i < elencoSpesa.size(); i++) {
					put(String.valueOf(elencoSpesa.get(i).getIdspesainvestimento()),
							elencoSpesa.get(i).getSpesainvestimento());
				}
			}
		};
		LinkedHashMap<String, String> mapProge = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Progetto");
				List<Progetto> elencoProgetto = oProgettoSer.findAll();
				for (int i = 0; i < elencoProgetto.size(); i++) {
					put(String.valueOf(elencoProgetto.get(i).getIdprogetto()),
							elencoProgetto.get(i).getCodice() + " " + elencoProgetto.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(listaProgetti, mapProge);
		sessionMap.put(listaSpesa, mapSpesa);
		sessionMap.put(oggettoDettaglio, new OrdineDiAcquistoDettaglio());
		sessionMap.put(KEY_PROVAMODIFICAORDINE, false);
//		this.listaDett = new ArrayList<OrdineDiAcquistoDettaglio>();
//		sessionMap.put(dettagliElimina, listaDett);
		return "nuovaSpesa";

	}

	public String modificaDettaglio() {
		if (this.chiaveDettaglio != null) {
			LinkedHashMap<String, String> mapSpesa = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Spesa Investimento");
					List<SpesaInvestimento> elencoSpesa = oSpesaSer.findAll();
					for (int i = 0; i < elencoSpesa.size(); i++) {
						put(String.valueOf(elencoSpesa.get(i).getIdspesainvestimento()),
								elencoSpesa.get(i).getSpesainvestimento());
					}
				}
			};
			LinkedHashMap<String, String> mapProge = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Progetto");
					List<Progetto> elencoProgetto = oProgettoSer.findAll();
					for (int i = 0; i < elencoProgetto.size(); i++) {
						put(String.valueOf(elencoProgetto.get(i).getIdprogetto()),
								elencoProgetto.get(i).getCodice() + " " + elencoProgetto.get(i).getProgetto());
					}
				}
			};
			sessionMap.put(listaProgetti, mapProge);
			sessionMap.put(listaSpesa, mapSpesa);
			boolean trovato = false;
			int i = 0;
			OrdineAcquisto oOrdine = (OrdineAcquisto) sessionMap.get(oggettoOrdine);
			while (i < oOrdine.getDettagli().size() && !trovato) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					OrdineDiAcquistoDettaglio oDettaglio = oOrdine.getDettagli().get(i);
					trovato = true;
					sessionMap.put(oggettoDettaglio, oDettaglio);
					sessionMap.put(KEY_PROVAMODIFICAORDINE, true);
				}
				i++;
			}

			return "gestioneDettaglio";
		} else {
			addActionError("selezionare un dettaglio per poterlo modificare");
			return "gestione";
		}
	}

	public String eliminaDettaglio() {
		boolean removed = false;
		if (this.chiaveDettaglio != null) {
			boolean trovato = false;
			OrdineAcquisto oOrdine = ((OrdineAcquisto) sessionMap.get("oggetto"));
			int i = 0;
			while (i < oOrdine.getDettagli().size() && !trovato) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					trovato = true;

				}
				i++;
			}
			OrdineDiAcquistoDettaglio oDettaglio = oOrdine.getDettagli().get(i - 1);
			oOrdine.getDettagli().remove(i - 1);
			sessionMap.put(listaDettagli, oOrdine.getDettagli());
			sessionMap.put(KEY_SIZE, ((List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli)).size() - 1);
			List<OrdineDiAcquistoDettaglio> ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(listaDettagli);
			int z = ali.size() - 1;

			sessionMap.put(KEY_INIZIO, 0);
			if (9 > z) {
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else {
				sessionMap.put(KEY_FINE, 9);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			}
			sessionMap.put(KEY_CONTROLLO, true);
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
		} else {
			addActionError("Selezionare un Dettaglio per eliminarlo");
		}
		return "gestione";
	}

	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "gestioneordine");
		return "cambiaAnno";
	}
}