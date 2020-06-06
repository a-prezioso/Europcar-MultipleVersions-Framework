package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.DistintaPagamentoService;
import model.dao.FatturaPassivaDettaglioService;
import model.dao.FatturaPassivaService;
import model.dao.FornitoreService;
import model.dao.PrevisioneService;
import model.dao.VenditoreService;
import model.session.AnnoContabile;
import model.session.DistintaPagamento;
import model.session.FatturaPassiva;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;
import model.session.Gruppo;
import model.session.Previsione;
import model.session.Venditore;

public class RicercaDistinte extends ActionSupport implements SessionAware {

	DistintaPagamentoService odistintaservice = new DistintaPagamentoService();
	private String chiave;
	private SessionMap<String, Object> sessionMap;
	public static final String KEY_OBJ = "oggettodistinta";
	public static final String KEY_LIST = "listadistinte";
	public static final String KEY_LISTFATTURE = "listafatture";
	public static final String KEY_LISTFORNITORI = "listafornitori";
	public static final String KEY_LISTDETTAGLI = "listadettagli";
	public static final String KEY_STATO = "stato";
	public static final String KEY_MAP = "mappa";
	public static final String KEY_IDANNO = "idanno";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_FATTURA = "idfattura";
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
	private String idfatturapassiva;
	private String idfornitore;
	private String idfattura;
	private String stato;
	private String iddistinta;
	private Date datainizio;
	private Date datafine;
	private String idannocontabile;
	private List<AnnoContabile> elencoAnniContabili;
	List<FatturaPassiva> elencoFatture;
	List<Fornitore> elencoFornitori;
	List<FatturaPassivaDettaglio> elencoDettagli;
	AnnoContabileService oAnn = new AnnoContabileService();

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public List<Fornitore> getElencoFornitori() {
		return elencoFornitori;
	}

	public String getIdannocontabile() {
		return idannocontabile;
	}

	public void setIdannocontabile(String idannocontabile) {
		this.idannocontabile = idannocontabile;
	}

	public List<AnnoContabile> getElencoAnniContabili() {
		return elencoAnniContabili;
	}

	public void setElencoAnniContabili(List<AnnoContabile> elencoAnniContabili) {
		this.elencoAnniContabili = elencoAnniContabili;
	}

	public String getIdfattura() {
		return idfattura;
	}

	public void setIdfattura(String idfattura) {
		this.idfattura = idfattura;
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

	public String getIddistinta() {
		return iddistinta;
	}

	public void setIddistinta(String iddistinta) {
		this.iddistinta = iddistinta;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getIdfornitore() {
		return idfornitore;
	}

	public void setIdfornitore(String idfornitore) {
		this.idfornitore = idfornitore;
	}

	public void setElencoFornitori(List<Fornitore> elencoFornitori) {
		this.elencoFornitori = elencoFornitori;
	}

	public List<FatturaPassivaDettaglio> getElencoDettagli() {
		return elencoDettagli;
	}

	public void setElencoDettagli(List<FatturaPassivaDettaglio> elencoDettagli) {
		this.elencoDettagli = elencoDettagli;
	}

	public String getIdfatturapassiva() {
		return idfatturapassiva;
	}

	public void setIdfatturapassiva(String idfatturapassiva) {
		this.idfatturapassiva = idfatturapassiva;
	}

	public List<FatturaPassiva> getElencoFatture() {
		return elencoFatture;
	}

	public void setElencoFatture(List<FatturaPassiva> elencoFatture) {
		this.elencoFatture = elencoFatture;
	}

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

	public String execute() {
		HashMap<String, String> mapFatture = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona la Fattura: ");
				List<FatturaPassiva> elencoFatture = new FatturaPassivaService().findAll();
				for (int i = 0; i < elencoFatture.size(); i++) {
					put(String.valueOf(elencoFatture.get(i).getIdfatturapassiva()),
							elencoFatture.get(i).getDescrizione());
				}
			}
		};
		sessionMap.put(KEY_LISTFATTURE, mapFatture);
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
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_OGGETTOANNO, oAnnoContabile);
		sessionMap.put(KEY_MAP, map);
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

	public String ricercaPerFatture() {
		if (!this.idfatturapassiva.equalsIgnoreCase("0")) {
			HashMap<String, String> mapFornitori = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Fornitore: ");
					List<Fornitore> elencoFornitori = new FornitoreService().findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(KEY_LISTFORNITORI, mapFornitori);

			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_IDANNO, oanno);
			sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
			FatturaPassiva ofatturapassiva = new FatturaPassivaService()
					.findById(Integer.parseInt(this.idfatturapassiva.replace("\'", "")));
			List<DistintaPagamento> elenco = new DistintaPagamentoService().findDistintaPerFattura(ofatturapassiva);
			List<DistintaPagamento> result = new ArrayList<DistintaPagamento>();
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getOfatturapassivadettaglio().getOfatturapassiva().getData().getTime() >= oanno
						.getDatainizio().getTime()
						&& elenco.get(i).getOfatturapassivadettaglio().getOfatturapassiva().getData().getTime() <= oanno
								.getDatafine().getTime()) {
					result.add(elenco.get(i));
				}
			}
			sessionMap.put(KEY_LIST, result);
			sessionMap.put(KEY_FATTURA, this.idfatturapassiva);
			List<String> statoFattura = new ArrayList<String>();
			statoFattura.add("Pagate");
			statoFattura.add("InPagamento");
			sessionMap.put(KEY_STATO, statoFattura);
			List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LIST);
			sessionMap.put(KEY_LIST, ali);
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
			if (sessionMap.get(KEY_SIZE) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZE);
				if (z > sizevecchia) {
					sessionMap.put(KEY_SIZE, null);
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
			return "cerca";
		} else {
			addActionError("Selezionare una fattura per andare avanti");
			return execute();
		}
	}

	public String ricercaDettagliata() {
		if (this.datainizio != null && this.datafine != null) {
			HashMap<String, String> mapFornitori = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Fornitore: ");
					List<Fornitore> elencoFornitori = new FornitoreService().findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(KEY_LISTFORNITORI, mapFornitori);
			HashMap<String, String> mapDettagli = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Dettaglio: ");
					List<FatturaPassivaDettaglio> elencoDettagli = new FatturaPassivaDettaglioService().findAll();
					for (int i = 0; i < elencoDettagli.size(); i++) {
						put(String.valueOf(elencoDettagli.get(i).getIdfatturapassivadettaglio()),
								elencoDettagli.get(i).getDettagliofattura());
					}
				}
			};
			sessionMap.put(KEY_LISTDETTAGLI, mapDettagli);
			List<DistintaPagamento> lista = new ArrayList<DistintaPagamento>();
			String idfattura = (String) sessionMap.get(KEY_FATTURA);
			List<DistintaPagamento> listafiltrata = new ArrayList<DistintaPagamento>();
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			if (Integer.parseInt(this.idfornitore) == 0) {
				if (this.stato != null) {
					lista = odistintaservice.findDistintaPerStato(this.stato, idfattura, oanno.getIdannocontabile());
					sessionMap.put(KEY_PAGINACORRENTE, null);
					sessionMap.put(KEY_INIZIO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLOFINE, null);
					sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
					sessionMap.put(KEY_CONTROLLOINDIETRO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLO, null);
				} else
					lista = (List<DistintaPagamento>) sessionMap.get(KEY_LIST);
			} else if (Integer.parseInt(this.idfornitore) != 0) {
				if (this.stato == null) {
					lista = odistintaservice.findDistintaPerFornitore(this.idfornitore, idfattura,
							oanno.getIdannocontabile());
					sessionMap.put(KEY_PAGINACORRENTE, null);
					sessionMap.put(KEY_INIZIO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLOFINE, null);
					sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
					sessionMap.put(KEY_CONTROLLOINDIETRO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLO, null);
				} else {
					lista = odistintaservice.findDistintaPerFornitoreStato(this.idfornitore, this.stato, idfattura,
							oanno.getIdannocontabile());
					sessionMap.put(KEY_PAGINACORRENTE, null);
					sessionMap.put(KEY_INIZIO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLOFINE, null);
					sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
					sessionMap.put(KEY_CONTROLLOINDIETRO, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_CONTROLLO, null);
				}
			}
			for (int i = 0; i < lista.size(); i++) {
				if (this.datainizio != null && this.datafine != null) {
					FatturaPassiva ofatturapassiva = new FatturaPassivaService().findById(Integer.parseInt(idfattura));
					if (ofatturapassiva.getData().getTime() >= this.datainizio.getTime()
							&& ofatturapassiva.getData().getTime() <= this.datafine.getTime()) {
						listafiltrata.add(lista.get(i));
					}
				}
			}
			if (this.datainizio != null)
				sessionMap.put(KEY_LIST, listafiltrata);
			else
				sessionMap.put(KEY_LIST, lista);
			List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LIST);
			sessionMap.put(KEY_LIST, ali);
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
			if (sessionMap.get(KEY_SIZE) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZE);
				if (z > sizevecchia) {
					sessionMap.put(KEY_SIZE, null);
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
				    }
				    else if(z == sizevecchia) {
				     sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
				    }
			}
			return "cerca";
		} else {
			addActionError("inserire data inizio e data fine per poter proseguire");
			this.idfatturapassiva = (String) sessionMap.get(KEY_FATTURA);
			return ricercaPerFatture();
		}
	}
	public String avanti() {
		List<DistintaPagamento> lista = (List<DistintaPagamento>) sessionMap.get(KEY_LIST);
		List<DistintaPagamento> ali = lista;
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
			    }
			    else if(z == sizevecchia) {
			     sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			    }
		} return "cerca";
	}
	public String prima() {
		List<DistintaPagamento> ali = (List<DistintaPagamento>)sessionMap.get(KEY_LIST);
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
		List<DistintaPagamento> ali = (List<DistintaPagamento>)sessionMap.get(KEY_LIST);
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
		List<DistintaPagamento> ali = (List<DistintaPagamento>)sessionMap.get(KEY_LIST);
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

	
}
