package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AliquotaIvaService;
import model.dao.FatturaPassivaDAO;
import model.dao.FatturaPassivaDettaglioService;
import model.dao.FatturaPassivaService;
import model.dao.FornitoreService;
import model.dao.PreventivoService;
import model.dao.SpesaInvestimentoService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.DistintaPagamento;
import model.session.FatturaPassiva;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;
import model.session.OrdineAcquisto;
import model.session.OrdineDiAcquistoDettaglio;
import model.session.FatturaPassiva;
import model.session.FatturaPassivaDettaglio;
import model.session.Preventivo;
import model.session.SpesaInvestimento;
import util.UDate;

public class GestioneFattura extends ActionSupport implements SessionAware {
	public static final String listaFatture = "elenco";
	public static final String oggettoFattura = "oggetto";
	public static final String listaFornitori = "elencoFornitori";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_NUMERO = "numero";
	public static final String KEY_FORNITORE = "fornitore";
	public static final String KEY_DATA = "data";
	public static final String KEY_DESCRIZIONE = "descrizione";
	public static final String listaAliquota = "elencoAliquota";
	public static final String listaSpesa = "elencoSpesa";
	public static final String listaPreventivo = "elencoPreventivo";
	public static final String oggettoDettaglioFattura = "oggettoDettaglioFattura";
	public static final String listaDettagli = "elencoDettagli";
	public static final String KEY_STRUTSANNO = "prova";
	public static final String KEY_DETTAGLIDAELIMINARE = "dettdaeli";
	public static final String KEY_PROVAMODIFICA = "provamodifica";
	public static final String KEY_FATTURASENZADETTAGLI = "controlloregistra";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	public static final String KEY_OGGETTOFORNITORE ="oggettoFornitore";
	public static final String KEY_CHIAVEFORNITORE ="chiaveFornitore";
	FatturaPassivaService oFat = new FatturaPassivaService();
	FornitoreService oFor = new FornitoreService();

	FatturaPassivaDettaglioService oDet = new FatturaPassivaDettaglioService();
	SpesaInvestimentoService oSpe = new SpesaInvestimentoService();
	PreventivoService oPre = new PreventivoService();
	AliquotaIvaService oAli = new AliquotaIvaService();

	private String scelta;
	private String chiave;
	private String descrizionePar;
	private Date dataPar;
	private String numeroPar;
	private String fornitorePar;
	private boolean nuovomodifica;

	private String chiaveDettaglio;
	private String aliquotaDettaglio;
	private String dettaglioFatturaDettaglio;
	private String importoDettaglio;
	private String preventivoDettaglio;
	private String fatturaPassivaDettaglio;
	private String spesaDettaglio;
	List<FatturaPassivaDettaglio> elenco = new ArrayList<FatturaPassivaDettaglio>();

	private SessionMap<String, Object> sessionMap;

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getDescrizionePar() {
		return descrizionePar;
	}

	public void setDescrizionePar(String descrizionePar) {
		this.descrizionePar = descrizionePar;
	}

	public Date getDataPar() {
		return dataPar;
	}

	public void setDataPar(Date dataPar) {
		this.dataPar = dataPar;
	}

	public String getNumeroPar() {
		return numeroPar;
	}

	public void setNumeroPar(String numeroPar) {
		this.numeroPar = numeroPar;
	}

	public String getFornitorePar() {
		return fornitorePar;
	}

	public void setFornitorePar(String fornitorePar) {
		this.fornitorePar = fornitorePar;
	}

	public String getChiaveDettaglio() {
		return chiaveDettaglio;
	}

	public void setChiaveDettaglio(String chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}

	public String getAliquotaDettaglio() {
		return aliquotaDettaglio;
	}

	public void setAliquotaDettaglio(String aliquotaDettaglio) {
		this.aliquotaDettaglio = aliquotaDettaglio;
	}

	public String getDettaglioFatturaDettaglio() {
		return dettaglioFatturaDettaglio;
	}

	public void setDettaglioFatturaDettaglio(String dettaglioFatturaDettaglio) {
		this.dettaglioFatturaDettaglio = dettaglioFatturaDettaglio;
	}

	public String getImportoDettaglio() {
		return importoDettaglio;
	}

	public void setImportoDettaglio(String importoDettaglio) {
		this.importoDettaglio = importoDettaglio;
	}

	public String getPreventivoDettaglio() {
		return preventivoDettaglio;
	}

	public void setPreventivoDettaglio(String preventivoDettaglio) {
		this.preventivoDettaglio = preventivoDettaglio;
	}

	public String getFatturaPassivaDettaglio() {
		return fatturaPassivaDettaglio;
	}

	public void setFatturaPassivaDettaglio(String fatturaPassivaDettaglio) {
		this.fatturaPassivaDettaglio = fatturaPassivaDettaglio;
	}

	public String getSpesaDettaglio() {
		return spesaDettaglio;
	}

	public void setSpesaDettaglio(String spesaDettaglio) {
		this.spesaDettaglio = spesaDettaglio;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public void setSession(Map<String, Object> varsession) {
		this.sessionMap = (SessionMap<String, Object>) varsession;
	}

	public String avanti() {
		List ali;
		String scelta;
		if (sessionMap.get(listaDettagli) == null) {
			ali = (List<FatturaPassiva>) sessionMap.get(listaFatture);
			scelta = "search";
		} else {
			ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
			if (((FatturaPassiva) sessionMap.get(oggettoFattura)).getIdfatturapassiva() != 0) {
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
				if(k>1) {
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
			ali = (List<FatturaPassiva>) sessionMap.get(listaFatture);
			scelta = "search";
		} else {
			ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
			if (((FatturaPassiva) sessionMap.get(oggettoFattura)).getIdfatturapassiva() != 0) {
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
			ali = (List<FatturaPassiva>) sessionMap.get(listaFatture);
			scelta = "search";
		} else {
			ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
			if (((FatturaPassiva) sessionMap.get(oggettoFattura)).getIdfatturapassiva() != 0) {
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
			ali = (List<FatturaPassiva>) sessionMap.get(listaFatture);
			scelta = "search";
		} else {
			ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
			if (((FatturaPassiva) sessionMap.get(oggettoFattura)).getIdfatturapassiva() != 0) {
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
		HashMap<String, String> mapFor = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore ");
				put(String.valueOf(-1), "Tutti");
				List<Fornitore> elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());

				}
			}
		};
		sessionMap.put(listaFornitori, mapFor);
		sessionMap.put(oggettoDettaglioFattura, null);
		sessionMap.put(KEY_PROVAMODIFICA, false);
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<FatturaPassiva> ali = oFat.findPerAnnoContabile((AnnoContabile) sessionMap.get(KEY_OGGETTOANNO));
		sessionMap.put(listaFatture, ali);
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
				if(k>1) {
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				}
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		sessionMap.put(KEY_OGGETTOFORNITORE, null);
		return "search";
	}

	public String cerca() {
			
			
		HashMap<String, String> mapFor = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore ");
				put(String.valueOf(-1), "Tutti");
				List<Fornitore> elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());

				}
			}
		};
			List<FatturaPassiva> elenco = new ArrayList<FatturaPassiva>();
			List<FatturaPassiva> result = new ArrayList<FatturaPassiva>();
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			if(sessionMap.get(KEY_OGGETTOFORNITORE)!=null) {
				if((int)sessionMap.get(KEY_OGGETTOFORNITORE)==-2) {
				addActionError("Inserire un fornitore o tutti i fornitori per effettuare la ricerca");
				List<FatturaPassiva> ali = new ArrayList<FatturaPassiva>();
				sessionMap.put(listaFatture, ali);
				sessionMap.put(KEY_OGGETTOFORNITORE, -2);
				} 
			   else if((int)sessionMap.get(KEY_OGGETTOFORNITORE)==0){
				result = oFat.findPerAnnoContabile(oAnnoContabile);
				sessionMap.put(KEY_OGGETTOFORNITORE, 0);
			  }
			   else if((int)sessionMap.get(KEY_OGGETTOFORNITORE)>0) {
				   elenco = oFat.findWithCriteria(
							Restrictions.eq(FatturaPassiva.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
									(int)(sessionMap.get(KEY_OGGETTOFORNITORE))));
				   sessionMap.put(KEY_OGGETTOFORNITORE, sessionMap.get(KEY_OGGETTOFORNITORE));
			   }
			} else {	
				if((Integer.parseInt(this.fornitorePar)!=0 && Integer.parseInt(this.fornitorePar)!=-1)) {
					sessionMap.put(KEY_OGGETTOFORNITORE, (Integer.parseInt(this.fornitorePar)));
					} 
			if (Integer.parseInt(this.fornitorePar) == -1) {
				result = oFat.findPerAnnoContabile(oAnnoContabile);
				sessionMap.put(KEY_OGGETTOFORNITORE, 0);
			} else if(Integer.parseInt(this.fornitorePar)!=0) {
				elenco = oFat.findWithCriteria(
						Restrictions.eq(FatturaPassiva.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
								Integer.parseInt(this.fornitorePar)));
			}
				else {
					addActionError("Inserire un fornitore o tutti i fornitori per effettuare la ricerca");
					List<FatturaPassiva> ali2 = new ArrayList<FatturaPassiva>();
					sessionMap.put(listaFatture, ali2);
					sessionMap.put(KEY_OGGETTOFORNITORE, -2);
				}
			}
			if(elenco.size()!=0) {
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
							&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
						result.add(elenco.get(i));
					}
				}
				
			} 
			sessionMap.put(listaFatture, result);
			if(result.size()!=0) {
			
			
			sessionMap.put(listaFornitori, mapFor);
			sessionMap.put(oggettoDettaglioFattura, null);
			sessionMap.put(KEY_PROVAMODIFICA, false);
			List<FatturaPassiva> ali = (List<FatturaPassiva>) sessionMap.get(listaFatture);
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
			sessionMap.put(KEY_PAGINACORRENTE, 1);
			
			}
			
			
		
		return "search";
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
		sessionMap.put(KEY_OGGETTOFORNITORE, null);
		return cerca();
	}
	
	public String nuovo() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> mapFor = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore");
				List<Fornitore> elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(listaFornitori, mapFor);
		sessionMap.put(oggettoFattura, new FatturaPassiva());
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		sessionMap.put(KEY_FATTURASENZADETTAGLI, false);
		return "nuovo";
	}

	public String modifica() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if ((this.chiave) != null) {
			HashMap<String, String> mapFor = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Fornitore ");
					List<Fornitore> elencoFornitori = oFor.findAll();
					for (int i = 0; i < elencoFornitori.size(); i++) {
						put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
								elencoFornitori.get(i).getRagionesociale());
					}
				}
			};
			sessionMap.put(listaFornitori, mapFor);
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
			sessionMap.put(oggettoFattura, oFat.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			List <FatturaPassivaDettaglio> ali = oDet.findWithCriteria(Restrictions.eq(
					FatturaPassivaDettaglio.PROPERTY_IDFatturaPassiva + "."
							+ FatturaPassiva.PROPERTY_IDFatturaPassiva,
					Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(listaDettagli, ali);
			sessionMap.put(KEY_FATTURASENZADETTAGLI, true);
			sessionMap.put(KEY_CONTROLLO, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_PAGINE, null);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_SIZE, null);
			if(ali.size() != 0) {
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
				} }
			return "gestione";
		} else {
			addActionError("Valorizzare il campo fattura per poter effettuare delle modifiche");
			return "search";
		}
	}

	public String elimina() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if ((this.chiave) != null) {
			try {
				oFat.delete(Integer.parseInt(this.chiave.replace("\'", "")));
				sessionMap.put(KEY_SIZE, ((List<FatturaPassiva>) sessionMap.get(listaFatture)).size() - 1);
//				int id = (int) sessionMap.get(KEY_OGGETTOFORNITORE);
//				Fornitore oFornitore = new FornitoreService().findById(id);
//				List<FatturaPassiva> elenco = new ArrayList<FatturaPassiva>();
//				elenco = oFat.findWithCriteria(
//						Restrictions.eq(OrdineAcquisto.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
//								oFornitore.getIdfornitore()));
//				AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
//				List<FatturaPassiva> result = new ArrayList<FatturaPassiva>();
//				for (int i = 0; i < elenco.size(); i++) {
//					if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
//							&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
//						result.add(elenco.get(i));
//					}
//				}
//			sessionMap.put(listaFatture, result);
			sessionMap.put(oggettoDettaglioFattura, null); 
			} catch (PersistenceException e) {
				addActionError("Impossibile eliminare la fattura poichè presente in un'altra tabella");
				return annullaModifica();
			}
		} else
			addActionError("Valorizzare il campo fattura per poterne eliminare una");
		return annullaModifica();
	}

	public String nuovoDettaglioNuovo() {
		FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get(oggettoFattura));
		if (sessionMap.get(oggettoDettaglioFattura) == null) {
			oFatturaPassiva.setData(dataPar);
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher matcher = pattern.matcher(this.numeroPar);
			if (!matcher.matches()) {
				addActionError("Inserire il Campo Numero solo nel formato numerico");
			} else {
				oFatturaPassiva.setNumero(Integer.parseInt(this.numeroPar));
			}
			oFatturaPassiva.setOfornitore(oFor.findById(Integer.parseInt(this.fornitorePar)));
			oFatturaPassiva.setDescrizione(this.descrizionePar);
		}
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		HashMap<String, String> mapSpesa = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Spesa Investimento");
				List<SpesaInvestimento> elenco = oSpe.findAll();
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
		HashMap<String, String> mapPrev = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Preventivo");
				List<Preventivo> elencoPreventivo = oPre.findAll();
				for (int i = 0; i < elencoPreventivo.size(); i++) {
					put(String.valueOf(elencoPreventivo.get(i).getIdpreventivo()),
							elencoPreventivo.get(i).getCodice() + " " + elencoPreventivo.get(i).getPreventivo());
				}
			}
		};
		HashMap<String, String> mapAli = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona AliquotaIva");
				List<AliquotaIva> elencoAliquota = oAli.findAll();
				for (int i = 0; i < elencoAliquota.size(); i++) {
					put(String.valueOf(elencoAliquota.get(i).getIdaliquotaiva()),
							String.valueOf(elencoAliquota.get(i).getAliquota()));
				}
			}
		};
		sessionMap.put(listaDettagli, oFatturaPassiva.getDettagli());
		sessionMap.put(listaPreventivo, mapPrev);
		sessionMap.put(listaAliquota, mapAli);
		sessionMap.put(listaSpesa, mapSpesa);
		sessionMap.put(oggettoFattura, oFatturaPassiva);
		sessionMap.put(oggettoDettaglioFattura, new FatturaPassivaDettaglio());
		return "nuovoDettaglio";

	}

	public String registra() {
		FatturaPassiva oFattura = ((FatturaPassiva) sessionMap.get(oggettoFattura));
		if (oFattura.getDettagli().size() == 0) {
			addActionError("Inserire dei dettagli per poter creare una nuova fattura");
			if ((boolean) sessionMap.get(KEY_FATTURASENZADETTAGLI)) {
				return "gestione";
			} else {
				return "nuovo";
			}
		}
		if (this.dataPar != null)
			oFattura.setData(this.dataPar);
		else
			addActionError("Inserire la Data");
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(this.numeroPar);
		if (!matcher.matches()) {
			addActionError("Inserire il Campo Numero Fattura solo nel formato numerico");
		} else {
			if (this.numeroPar.equalsIgnoreCase("")) {
				addActionError("Numero campo obbligatorio");
			} else
				oFattura.setNumero(Integer.parseInt(numeroPar));
		}
		if (Integer.parseInt(this.fornitorePar) != 0)
			oFattura.setOfornitore(oFor.findById(Integer.parseInt(this.fornitorePar)));
		else
			addActionError("Scegliere un Fornitore per proseguire");
		if (!this.descrizionePar.equalsIgnoreCase("")) {
			oFattura.setDescrizione(this.descrizionePar);
		} else {
			addActionError("Inserire la descrizione della Fattura");
		}
		if (getActionErrors().size() == 0) {

			oFat.persistOrUpdate(oFattura);
			for (int i = 0; i < oFattura.getDettagli().size(); i++) {
				oDet.persistOrUpdate(oFattura.getDettagli().get(i));
			}
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
			sessionMap.put(KEY_SIZE, ((List<FatturaPassiva>) sessionMap.get(listaFatture)).size() - 1);
			oFattura.setOfornitore(null);
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			
			Fornitore oFornitore = new FornitoreService().findById(Integer.parseInt(this.fornitorePar));;
			List<FatturaPassiva> elenco = new ArrayList<FatturaPassiva>();
			elenco = oFat.findWithCriteria(
					Restrictions.eq(OrdineAcquisto.PROPERTY_IDFornitore + "." + Fornitore.PROPERTY_idFornitore,
							oFornitore.getIdfornitore()));
			List<FatturaPassiva> result = new ArrayList<FatturaPassiva>();
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
						&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
					result.add(elenco.get(i));
				}
			}
			sessionMap.put(listaFatture, result);
			sessionMap.put(KEY_CONTROLLO, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_PAGINE, null);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_SIZE, null);
			sessionMap.put(oggettoDettaglioFattura, null); 
			return annullaModifica();
		} else {
			if ((boolean) sessionMap.get(KEY_FATTURASENZADETTAGLI)) {
				return "gestione";
			} else {
				return "nuovoConDettagli";
			}
		}
	}

	public String registraModifica() {
		FatturaPassiva oFattura = ((FatturaPassiva) sessionMap.get(oggettoFattura));
		if (this.dataPar != null)
			oFattura.setData(this.dataPar);
		else
			addActionError("Inserire la Data");
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(this.numeroPar);
		if (!matcher.matches()) {
			addActionError("Inserire il Campo Numero Fattura solo nel formato numerico");
		} else {
			if (this.numeroPar.equalsIgnoreCase("")) {
				addActionError("Numero campo obbligatorio");
			} else
				oFattura.setNumero(Integer.parseInt(numeroPar));
		}
		if (Integer.parseInt(this.fornitorePar) != 0)
			oFattura.setOfornitore(oFor.findById(Integer.parseInt(this.fornitorePar)));
		else
			addActionError("Scegliere un Fornitore per proseguire");

		if (getActionErrors().size() == 0 && oFattura.getDettagli().size() != 0) {
			sessionMap.put(KEY_CONTROLLO, true);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
			oFat.persistOrUpdate(oFattura);
			oFattura.setOfornitore(null);
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
			addActionError("Impossibile salvare una Fattura senza un Dettaglio");
			return "gestione";
		}
	}

	public String annulla() {
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_SIZE, null);
		sessionMap.put(listaDettagli, null);
		sessionMap.put(oggettoDettaglioFattura, null); 
		if(sessionMap.get(KEY_OGGETTOFORNITORE)==null) {
			sessionMap.put(KEY_OGGETTOFORNITORE, 0);
		} 
		return cerca();

	}
	public String annullaModifica() {
		this.fornitorePar=null;
		sessionMap.put(oggettoDettaglioFattura, null); 
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_SIZE, null);
		sessionMap.put(listaDettagli, null);
		if(sessionMap.get(KEY_OGGETTOFORNITORE)==null) {
			sessionMap.put(KEY_OGGETTOFORNITORE, 0);
		} 
		return cerca();
		
	}
	
	public String memoriaDettaglio() {
		FatturaPassivaDettaglio oFatturaDettaglio = ((FatturaPassivaDettaglio) sessionMap
				.get("oggettoDettaglioFattura"));
		int chiave = 0;
		if ((boolean) sessionMap.get(KEY_PROVAMODIFICA)) {
			FatturaPassiva oFattura = (FatturaPassiva) sessionMap.get(oggettoFattura);
			List<FatturaPassivaDettaglio> elenco = oFattura.getDettagli();
			boolean trovato = false;
			for (int i = 0; i < elenco.size() && !trovato; i++) {
				if (elenco.get(i).getIdfatturapassivadettaglio() == oFatturaDettaglio.getIdfatturapassivadettaglio()) {
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
				oFatturaDettaglio.setImporto(Float.parseFloat(this.importoDettaglio));
		}
		if (Integer.parseInt(this.aliquotaDettaglio) != 0)
			oFatturaDettaglio.setOaliquota(oAli.findById(Integer.parseInt(aliquotaDettaglio)));
		else
			addActionError("Scegliere un'Aliquota");
		if (Integer.parseInt(this.preventivoDettaglio) != 0)
			oFatturaDettaglio.setOpreventivo(oPre.findById(Integer.parseInt(preventivoDettaglio)));
		else
			addActionError("Scegliee un Preventivo");
		if (!this.dettaglioFatturaDettaglio.equalsIgnoreCase(""))
			oFatturaDettaglio.setDettagliofattura(dettaglioFatturaDettaglio);
		else
			addActionError("Inserire la descrizione dettaglio");
		if (Integer.parseInt(this.spesaDettaglio) != 0)
			oFatturaDettaglio.setOspesainvestimento(oSpe.findById(Integer.parseInt(spesaDettaglio)));
		else
			addActionError("Scegliere una Spesa D'Investimento");
		if (getActionErrors().size() == 0) {
			if (sessionMap.get(oggettoFattura) != null) {
				if ((boolean) sessionMap.get(KEY_PROVAMODIFICA)) {
					((FatturaPassiva) sessionMap.get(oggettoFattura)).getDettagli().set(chiave, oFatturaDettaglio);

				} else {
					oFatturaDettaglio.setOfatturapassiva(((FatturaPassiva) sessionMap.get("oggetto")));
					((FatturaPassiva) sessionMap.get(oggettoFattura)).getDettagli().add(oFatturaDettaglio);
				}

				if (sessionMap.get(KEY_DETTAGLIDAELIMINARE) != null) {
					elenco = (List<FatturaPassivaDettaglio>) sessionMap.get(KEY_DETTAGLIDAELIMINARE);
				}
				elenco.add(oFatturaDettaglio);
				sessionMap.put(KEY_DETTAGLIDAELIMINARE, elenco);
				sessionMap.put(oggettoFattura, (FatturaPassiva) sessionMap.get(oggettoFattura));
				AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
				sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
				sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
				sessionMap.put(listaDettagli, ((FatturaPassiva) sessionMap.get(oggettoFattura)).getDettagli());

				if ((boolean) sessionMap.get(KEY_PROVAMODIFICA)) {
					return "gestione";
				} else {
					return nuovoDettaglioNuovo();
				}
			} else {
				addActionError("La fattura di riferimento non esiste");

				return "nuovo";
			}
		}
		return "nuovoDettaglio";
	}

	public String salvaDettagli() {
		HashMap<String, String> mapFor = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Fornitore");
				List<Fornitore> elencoFornitori = oFor.findAll();
				for (int i = 0; i < elencoFornitori.size(); i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()),
							elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(listaFornitori, mapFor);
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		sessionMap.put(oggettoFattura, (FatturaPassiva) sessionMap.get(oggettoFattura));
		sessionMap.put(oggettoDettaglioFattura, null);
		sessionMap.put(KEY_DETTAGLIDAELIMINARE, null);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		
		List <FatturaPassivaDettaglio> ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
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
		if (((FatturaPassiva) sessionMap.get(oggettoFattura)).getIdfatturapassiva() != 0) {
			return "gestione";
		} else {
			return "nuovoConDettagli";
		}
	}

	public String annullaDettaglio() {
		if ((List<FatturaPassivaDettaglio>) sessionMap.get(KEY_DETTAGLIDAELIMINARE) != null) {
			FatturaPassiva oFattura = (FatturaPassiva) sessionMap.get(oggettoFattura);
			List<FatturaPassivaDettaglio> elenco2 = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
			elenco = (List<FatturaPassivaDettaglio>) sessionMap.get(KEY_DETTAGLIDAELIMINARE);
			for (int i = 0; i < elenco.size(); i++) {
				// elenco.remove(i);
				oFattura.getDettagli().remove(elenco.get(i));
				elenco2.remove(elenco.get(i));

			}

			sessionMap.put(listaDettagli, elenco2);
			sessionMap.put(KEY_DETTAGLIDAELIMINARE, elenco);
		}
		if ((boolean) sessionMap.get(KEY_FATTURASENZADETTAGLI)) {
			return "gestione";
		} else {
			return "nuovoConDettagli";
		}
	}

	public String eliminaDettaglioNuovo() {
		boolean removed = false;
		if (this.chiaveDettaglio != null) {
			FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get("oggetto"));
			int i = 0;
			while (i < oFatturaPassiva.getDettagli().size() && !removed) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					oFatturaPassiva.getDettagli().remove(i);
					removed = true;

				}
				i++;
			}
			sessionMap.put(listaDettagli, oFatturaPassiva.getDettagli());
			sessionMap.put(oggettoFattura, oFatturaPassiva);
			sessionMap.put(KEY_PROVAMODIFICA, false);
			sessionMap.put(KEY_SIZE, ((List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli)).size() - 1);
			List <FatturaPassivaDettaglio> ali = oFatturaPassiva.getDettagli();
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

		} else {
			addActionError("Selezionare un Dettaglio per eliminarlo");
		}
		return "nuovoConDettagli";
	}

	public String annullaDettaglioModifica() {
		return "gestione";
	}

	public String eliminaDettaglio() {
		boolean removed = false;
		if (this.chiaveDettaglio != null) {
			boolean trovato = false;
			FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get("oggetto"));
			int i = 0;
			while (i < oFatturaPassiva.getDettagli().size() && !trovato) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					trovato = true;

				}
				i++;
			}
			FatturaPassivaDettaglio oDettaglio = oFatturaPassiva.getDettagli().get(i - 1);
			if ((oDet.executeParamizedHQLQuery(
					"FROM DistintaPagamento WHERE  ofatturapassivadettaglio.idfatturapassivadettaglio="
							+ oDettaglio.getIdfatturapassivadettaglio(),
					DistintaPagamento.class)).isEmpty()) {
				oFatturaPassiva.getDettagli().remove(i - 1);
				sessionMap.put(listaDettagli, oFatturaPassiva.getDettagli());
				sessionMap.put(KEY_SIZE, ((List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli)).size() - 1);
				List <FatturaPassivaDettaglio> ali = (List<FatturaPassivaDettaglio>) sessionMap.get(listaDettagli);
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
			} else {
				addActionError("Impossibile eliminare il Dettaglio perchè presente in una Distinta di pagamento");
			}
		} else {
			addActionError("Selezionare un Dettaglio per eliminarlo");
		}
		return "gestione";
	}

	public String nuovoDettaglio() {
		HashMap<String, String> mapSpesa = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Spesa Investimento");
				List<SpesaInvestimento> elencoSpesa = oSpe.findAll();
				for (int i = 0; i < elencoSpesa.size(); i++) {
					put(String.valueOf(elencoSpesa.get(i).getIdspesainvestimento()),
							elencoSpesa.get(i).getSpesainvestimento());
				}
			}
		};
		HashMap<String, String> mapPrev = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Preventivo");
				List<Preventivo> elencoPreventivo = oPre.findAll();
				for (int i = 0; i < elencoPreventivo.size(); i++) {
					put(String.valueOf(elencoPreventivo.get(i).getIdpreventivo()),
							elencoPreventivo.get(i).getCodice() + " " + elencoPreventivo.get(i).getPreventivo());
				}
			}
		};
		HashMap<String, String> mapAli = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona AliquotaIva");
				List<AliquotaIva> elencoAliquota = oAli.findAll();
				for (int i = 0; i < elencoAliquota.size(); i++) {
					put(String.valueOf(elencoAliquota.get(i).getIdaliquotaiva()),
							String.valueOf(elencoAliquota.get(i).getAliquota()));
				}
			}
		};
		sessionMap.put(listaAliquota, mapAli);
		sessionMap.put(listaPreventivo, mapPrev);
		sessionMap.put(listaSpesa, mapSpesa);
		sessionMap.put(oggettoDettaglioFattura, new FatturaPassivaDettaglio());
		sessionMap.put(KEY_PROVAMODIFICA, false);
		return "nuovoDettaglio";
	}

	public String modificaDettaglio() {

		HashMap<String, String> mapSpesa = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Spesa Investimento");
				List<SpesaInvestimento> elencoSpesa = oSpe.findAll();
				for (int i = 0; i < elencoSpesa.size(); i++) {
					put(String.valueOf(elencoSpesa.get(i).getIdspesainvestimento()),
							elencoSpesa.get(i).getSpesainvestimento());
				}
			}
		};
		HashMap<String, String> mapPrev = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Preventivo");
				List<Preventivo> elencoPreventivo = oPre.findAll();
				for (int i = 0; i < elencoPreventivo.size(); i++) {
					put(String.valueOf(elencoPreventivo.get(i).getIdpreventivo()),
							elencoPreventivo.get(i).getCodice() + " " + elencoPreventivo.get(i).getPreventivo());
				}
			}
		};
		HashMap<String, String> mapAli = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona AliquotaIva");
				List<AliquotaIva> elencoAliquota = oAli.findAll();
				for (int i = 0; i < elencoAliquota.size(); i++) {
					put(String.valueOf(elencoAliquota.get(i).getIdaliquotaiva()),
							String.valueOf(elencoAliquota.get(i).getAliquota()));
				}
			}
		};
		sessionMap.put(listaAliquota, mapAli);
		sessionMap.put(listaPreventivo, mapPrev);
		sessionMap.put(listaSpesa, mapSpesa);
		if (this.chiaveDettaglio != null) {
			boolean trovato = false;
			FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get("oggetto"));
			int i = 0;
			while (i < oFatturaPassiva.getDettagli().size() && !trovato) {
				if (i == Integer.parseInt(this.chiaveDettaglio)) {
					FatturaPassivaDettaglio oDettaglio = oFatturaPassiva.getDettagli().get(i);
					trovato = true;
					sessionMap.put(oggettoDettaglioFattura, oDettaglio);
					sessionMap.put(KEY_PROVAMODIFICA, true);
				}
				i++;
			}
			return "gestioneDettaglio";
		} else {
			addActionError("Selezionare un Dettaglio per modificarlo");
			return "gestione";
		}

	}

	

	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "gestionefattura");
		return "cambiaAnno";
	}

}
