package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.AreaService;
import model.dao.AziendaService;
import model.dao.PrevisioneService;
import model.dao.SottoCategoriaService;
import model.dao.VenditoreService;
import model.session.AnnoContabile;
import model.session.Area;
import model.session.Azienda;
import model.session.Previsione;
import model.session.SottoCategoria;
import model.session.Utente;
import model.session.Venditore;
import util.UDate;

public class GestionePrevisionale extends ActionSupport implements SessionAware {
	PrevisioneService oPrevisioneService = new PrevisioneService();

	// Attributi
	private String chiave;
	private SessionMap<String, Object> sessionMap;
	public static final String KEY_OBJ2 = "oggetto2";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_LIST = "lista";
	public static final String KEY_LISTAREE = "listaaree";
	public static final String KEY_LISTAANNI = "listaanni";
	public static final String KEY_LISTAZIENDE = "listaaziende";
	public static final String KEY_LISTASOTTOCAT = "listasottocategorie";
	public static final String KEY_LISTVENDITORI = "listavenditori";
	public static final String KEY_OBJVEND = "oggettovenditore";
	public static final String KEY_IDANNO = "idanno";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_STRUTSANNO = "prova";
	public static final String memoryvenditore = "memoryvenditore";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	public static final String KEY_OGGETTOAZIENA = "oggettoazienda";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	private Previsione oprevisione;
	private String idarea;
	private String idazienda;
	private String idsottocategoria;
	private String idvenditore;
	private Date datavisita;
	private Date annodiriferimento;
	private Date dataregistrazione;
	private String confidenza;
	private String potenzialeeuropecar;
	private String potenzialeazienda;
	private String shareante;
	private String sharepost;
	private String shareavis;
	private String sharehertz;
	private String sharemaggiore;
	private String sharesixt;
	private Date datainizio;
	private Date datafine;
	private String idannocontabile;
	private List<AnnoContabile> elencoAnniContabili;
	AnnoContabileService oAnn = new AnnoContabileService();
	List<Previsione> result = new ArrayList<Previsione>();
	// Get e Set

	private boolean nuovomodifica;

	public List<Previsione> getResult() {
		return result;
	}

	public void setResult(List<Previsione> result) {
		this.result = result;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public String getChiave() {
		return chiave;
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

	public String getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(String idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public Date getDatainizio() {
		try {
			datainizio = UDate.ctrlData("01/07/" + Calendar.getInstance().get(Calendar.YEAR));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Date getDatafine() {
		datafine = Calendar.getInstance().getTime();
		return datafine;
	}

	public void setDatafine(Date datafine) {
		this.datafine = datafine;
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

	public Previsione getOprevisione() {
		return oprevisione;
	}

	public void setOprevisione(Previsione oprevisione) {
		this.oprevisione = oprevisione;
	}

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdazienda() {
		return idazienda;
	}

	public void setIdazienda(String idazienda) {
		this.idazienda = idazienda;
	}

	public String getIdvenditore() {
		return idvenditore;
	}

	public void setIdvenditore(String idvenditore) {
		this.idvenditore = idvenditore;
	}

	public Date getAnnodiriferimento() {
		return annodiriferimento;
	}

	public void setAnnodiriferimento(Date annodiriferimento) {
		this.annodiriferimento = annodiriferimento;
	}

	public Date getDatavisita() {
		return datavisita;
	}

	public void setDatavisita(Date datavisita) {
		this.datavisita = datavisita;
	}

	public Date getDataregistrazione() {
		return dataregistrazione;
	}

	public void setDataregistrazione(Date dataregistrazione) {
		this.dataregistrazione = dataregistrazione;
	}

	public String getConfidenza() {
		return confidenza;
	}

	public void setConfidenza(String confidenza) {
		this.confidenza = confidenza;
	}

	public String getPotenzialeeuropecar() {
		return potenzialeeuropecar;
	}

	public void setPotenzialeeuropecar(String potenzialeeuropecar) {
		this.potenzialeeuropecar = potenzialeeuropecar;
	}

	public String getPotenzialeazienda() {
		return potenzialeazienda;
	}

	public void setPotenzialeazienda(String potenzialeazienda) {
		this.potenzialeazienda = potenzialeazienda;
	}

	public String getShareante() {
		return shareante;
	}

	public void setShareante(String shareante) {
		this.shareante = shareante;
	}

	public String getSharepost() {
		return sharepost;
	}

	public void setSharepost(String sharepost) {
		this.sharepost = sharepost;
	}

	public String getShareavis() {
		return shareavis;
	}

	public void setShareavis(String shareavis) {
		this.shareavis = shareavis;
	}

	public String getSharehertz() {
		return sharehertz;
	}

	public void setSharehertz(String sharehertz) {
		this.sharehertz = sharehertz;
	}

	public String getSharemaggiore() {
		return sharemaggiore;
	}

	public void setSharemaggiore(String sharemaggiore) {
		this.sharemaggiore = sharemaggiore;
	}

	public String getSharesixt() {
		return sharesixt;
	}

	public void setSharesixt(String sharesixt) {
		this.sharesixt = sharesixt;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {

		Utente outente = (Utente) sessionMap.get(KEY_OBJ2);
		sessionMap.put(KEY_OBJ2, outente);
		if (outente.isAdmin()) {
			LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Venditore: ");
					List<Venditore> elencoGruppi = new VenditoreService().findAll();
					for (int i = 0; i < elencoGruppi.size(); i++) {
						put(String.valueOf(elencoGruppi.get(i).getIdvenditore()),
								elencoGruppi.get(i).getNome() + " " + elencoGruppi.get(i).getCognome());
					}
				}
			};
			sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
			// sessionMap.put(KEY_LIST, oPrevisioneService.findAll());
		} else {
			LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Venditore: ");
					Venditore ovenditore = new VenditoreService().findById(outente.getOvenditore().getIdvenditore());
					put(String.valueOf(ovenditore.getIdvenditore()),
							ovenditore.getNome() + " " + ovenditore.getCognome());

				}
			};
			sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
		}

		// sessionMap.put(KEY_LIST, this.findPrevisionePerVenditore(outente));
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		sessionMap.put(KEY_OGGETTOANNO, oAnnoContabile);
		return "search";
	}

	public String ricercaPerVenditore() {
		if (!this.idvenditore.equalsIgnoreCase("0") || this.idvenditore.equalsIgnoreCase("tutti")) {
			Utente outente = (Utente) sessionMap.get(KEY_OBJ2);
			sessionMap.put(KEY_OBJ2, outente);

			LinkedHashMap<String, String> mapArea = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona l'Area: ");
					List<Area> elencoAree = new AreaService().findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			LinkedHashMap<String, String> mapAzienda = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona l'Azienda: ");
					List<Azienda> elencoAziende = new AziendaService().findAll();
					for (int i = 0; i < elencoAziende.size(); i++) {
						put(String.valueOf(elencoAziende.get(i).getIdazienda()),
								elencoAziende.get(i).getRagioneSociale());
					}
				}
			};

			if (outente.isAdmin()) {

				LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
					{
						put(String.valueOf(0), "Seleziona il Venditore: ");
						List<Venditore> elencoGruppi = new VenditoreService().findAll();
						for (int i = 0; i < elencoGruppi.size(); i++) {
							put(String.valueOf(elencoGruppi.get(i).getIdvenditore()),
									elencoGruppi.get(i).getNome() + " " + elencoGruppi.get(i).getCognome());
						}
					}
				};
				sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
			}
			sessionMap.put(KEY_LISTAREE, mapArea);
			sessionMap.put(KEY_LISTAZIENDE, mapAzienda);
			sessionMap.put(KEY_IDANNO, this.idannocontabile);
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
			if (!this.idvenditore.equalsIgnoreCase("tutti")) {
				Venditore ovenditore = new VenditoreService()
						.findById(Integer.parseInt(this.idvenditore.replace("\'", "")));
				sessionMap.put(KEY_OBJVEND, ovenditore);

				List<Previsione> elenco = new PrevisioneService().findPrevisionePerVenditore(ovenditore);
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getDataregistrazione().getTime() <= oanno.getDatafine().getTime()
							&& elenco.get(i).getDataregistrazione().getTime() >= oanno.getDatainizio().getTime()) {
						result.add(elenco.get(i));
					}
				}
				sessionMap.put(KEY_LIST, result);

			} else {
				List<Previsione> elenco = new PrevisioneService().findAll();
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getDataregistrazione().getTime() <= oanno.getDatafine().getTime()
							&& elenco.get(i).getDataregistrazione().getTime() >= oanno.getDatainizio().getTime()) {
						result.add(elenco.get(i));
					}
				}
				sessionMap.put(KEY_LIST, result);
			}
			sessionMap.put(memoryvenditore, this.idvenditore);
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
			if (this.idvenditore != null)
				addActionError("Inserire un Venditore");
			return execute();
		}
	}

	public String prima() {
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LIST);
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
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LIST);
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

		return avanti();
	}

	public String cercaAreaAziendaData() {
		Utente outente = (Utente) sessionMap.get(KEY_OBJ2);
		LinkedHashMap<String, String> mapArea = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona l'Area: ");
				List<Area> elencoAree = new AreaService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		LinkedHashMap<String, String> mapAzienda = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona l'Azienda: ");
				List<Azienda> elencoAziende = new AziendaService().findAll();
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdazienda()), elencoAziende.get(i).getRagioneSociale());
				}
			}
		};
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		if (outente.isAdmin()) {
			LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Venditore: ");
					List<Venditore> elencoGruppi = new VenditoreService().findAll();
					for (int i = 0; i < elencoGruppi.size(); i++) {
						put(String.valueOf(elencoGruppi.get(i).getIdvenditore()),
								elencoGruppi.get(i).getNome() + " " + elencoGruppi.get(i).getCognome());
					}
				}
			};
			sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
		}
		sessionMap.put(KEY_OBJ2, outente);
		List<Previsione> listafiltrata = new ArrayList<Previsione>();
		List<Previsione> lista = new ArrayList<Previsione>();
		Venditore ovenditore = (Venditore) sessionMap.get(KEY_OBJVEND);
		if (Integer.parseInt(this.idazienda) != 0 && Integer.parseInt(this.idarea) != 0) {
			List<Previsione> elenco = oPrevisioneService.elencoPrevisioniPerAreaAzienda(ovenditore, this.idarea,
					this.idazienda, oanno.getIdannocontabile());
			sessionMap.put(KEY_LIST, elenco);
			Area oArea = new AreaService().findById(Integer.parseInt(this.idarea));
			Azienda oAzienda = new AziendaService().findById(Integer.parseInt(this.idazienda));
			sessionMap.put(KEY_OGGETTOAREA, oArea);
			sessionMap.put(KEY_OGGETTOAZIENA, oAzienda);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLO, null);

		} else if (Integer.parseInt(this.idazienda) == 0 && Integer.parseInt(this.idarea) != 0) {
			List<Previsione> elenco = oPrevisioneService.elencoPrevisioniPerArea(ovenditore, this.idarea,
					oanno.getIdannocontabile());
			sessionMap.put(KEY_LIST, elenco);

			sessionMap.put(KEY_OGGETTOAZIENA, null);
			Area oArea = new AreaService().findById(Integer.parseInt(this.idarea));
			sessionMap.put(KEY_OGGETTOAREA, oArea);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLO, null);
		} else if (Integer.parseInt(this.idazienda) != 0 && Integer.parseInt(this.idarea) == 0) {
			List<Previsione> elenco = oPrevisioneService.elencoPrevisioniPerAzienda(ovenditore, this.idazienda,
					oanno.getIdannocontabile());
			sessionMap.put(KEY_LIST, elenco);
			Azienda oAzienda = new AziendaService().findById(Integer.parseInt(this.idazienda));
			sessionMap.put(KEY_OGGETTOAZIENA, oAzienda);
			sessionMap.put(KEY_OGGETTOAREA, null);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLO, null);
		} else {
			sessionMap.put(KEY_LIST, oPrevisioneService.findPrevisionePerVenditore(ovenditore));
			sessionMap.put(KEY_OGGETTOAZIENA, null);
			sessionMap.put(KEY_OGGETTOAREA, null);
			sessionMap.put(KEY_PAGINACORRENTE, null);
			sessionMap.put(KEY_INIZIO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLOFINE, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
			sessionMap.put(KEY_CONTROLLOINDIETRO, null);
			sessionMap.put(KEY_FINE, null);
			sessionMap.put(KEY_CONTROLLO, null);
		}
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
	}

	public String avanti() {
		int id = Integer.parseInt((String) sessionMap.get(memoryvenditore));
		Venditore oVenditore = new VenditoreService().findById(id);
		List<Previsione> elenco = new ArrayList<Previsione>();
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		if (sessionMap.get(KEY_OGGETTOAREA) != null && sessionMap.get(KEY_OGGETTOAZIENA) != null) {
			elenco = oPrevisioneService.elencoPrevisioniPerAreaAzienda(oVenditore,
					String.valueOf((((Area) sessionMap.get(KEY_OGGETTOAREA)).getIdarea())),
					String.valueOf((((Azienda) sessionMap.get(KEY_OGGETTOAZIENA))).getIdazienda()),
					oanno.getIdannocontabile());
		} else if (sessionMap.get(KEY_OGGETTOAREA) == null && sessionMap.get(KEY_OGGETTOAZIENA) != null) {
			elenco = oPrevisioneService.elencoPrevisioniPerAzienda(oVenditore,
					String.valueOf((((Azienda) sessionMap.get(KEY_OGGETTOAZIENA))).getIdazienda()),
					oanno.getIdannocontabile());
		} else if (sessionMap.get(KEY_OGGETTOAREA) != null && sessionMap.get(KEY_OGGETTOAZIENA) == null) {
			elenco = oPrevisioneService.elencoPrevisioniPerArea(oVenditore,
					String.valueOf((((Area) sessionMap.get(KEY_OGGETTOAREA)).getIdarea())), oanno.getIdannocontabile());
		} else {
			elenco = oPrevisioneService.findPrevisionePerVenditore(oVenditore);
		}
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getDataregistrazione().getTime() <= oanno.getDatafine().getTime()
					&& elenco.get(i).getDataregistrazione().getTime() >= oanno.getDatainizio().getTime()) {
				result.add(elenco.get(i));
			}
		}
		List<Previsione> ali = result;
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
		return "cerca";

	}

	public String indietro() {
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LIST);
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

	public String nuovoPrevisionale() {
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());

		LinkedHashMap<String, String> mapArea = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Area: ");
				List<Area> elencoAree = new AreaService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		LinkedHashMap<String, String> mapAzienda = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Azienda: ");
				List<Azienda> elencoAziende = new AziendaService().findAll();
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdazienda()), elencoAziende.get(i).getRagioneSociale());
				}
			}
		};
		LinkedHashMap<String, String> mapSottoCat = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona la SottoCategoria: ");
				List<SottoCategoria> elenco = new SottoCategoriaService().findAll();
				List<SottoCategoria> elencoSottoCategorie = new ArrayList<SottoCategoria>();
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= oanno.getDatainizio()
							.getTime()
							&& elenco.get(i).getOarea().getOannocontabile().getDatafine().getTime() <= oanno
							.getDatafine().getTime()) {
						elencoSottoCategorie.add(elenco.get(i));
					}
				}
				for (int i = 0; i < elencoSottoCategorie.size(); i++) {
					put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
							elencoSottoCategorie.get(i).getSottocategoria());
				}
			}
		};
		LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Venditore: ");
				List<Venditore> elencoGruppi = new VenditoreService().findAll();
				for (int i = 0; i < elencoGruppi.size(); i++) {
					put(String.valueOf(elencoGruppi.get(i).getIdvenditore()),
							elencoGruppi.get(i).getNome() + " " + elencoGruppi.get(i).getCognome());
				}
			}
		};
		Utente outente = (Utente) sessionMap.get(KEY_OBJ2);
		sessionMap.put(KEY_OBJ2, outente);
		sessionMap.put(KEY_LISTAREE, mapArea);
		sessionMap.put(KEY_LISTAZIENDE, mapAzienda);
		sessionMap.put(KEY_LISTASOTTOCAT, mapSottoCat);
		sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (outente.isAdmin())
			sessionMap.put(KEY_OBJ, new Previsione());
		else
			sessionMap.put(KEY_OBJ, new Previsione(outente.getOvenditore()));
		String result = "nuovomodifica";
		return result;
	}

	public String modificaPrevisionale() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
			LinkedHashMap<String, String> mapArea = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Area: ");
					List<Area> elencoAree = new AreaService().findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			LinkedHashMap<String, String> mapAzienda = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Azienda: ");
					List<Azienda> elencoAziende = new AziendaService().findAll();
					for (int i = 0; i < elencoAziende.size(); i++) {
						put(String.valueOf(elencoAziende.get(i).getIdazienda()),
								elencoAziende.get(i).getRagioneSociale());
					}
				}
			};

			LinkedHashMap<String, String> mapVenditore = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Venditore: ");
					List<Venditore> elencoGruppi = new VenditoreService().findAll();
					for (int i = 0; i < elencoGruppi.size(); i++) {
						put(String.valueOf(elencoGruppi.get(i).getIdvenditore()),
								elencoGruppi.get(i).getNome() + " " + elencoGruppi.get(i).getCognome());
					}
				}
			};
			LinkedHashMap<String, String> mapSottoCat = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona la SottoCategoria: ");
					List<SottoCategoria> elenco = new SottoCategoriaService().findAll();
					List<SottoCategoria> elencoSottoCategorie = new ArrayList<SottoCategoria>();
					for (int i = 0; i < elenco.size(); i++) {
						if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= oanno
								.getDatainizio().getTime()
								&& elenco.get(i).getOarea().getOannocontabile().getDatafine().getTime() <= oanno
								.getDatafine().getTime()) {
							elencoSottoCategorie.add(elenco.get(i));
						}
					}
					for (int i = 0; i < elencoSottoCategorie.size(); i++) {
						put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
								elencoSottoCategorie.get(i).getSottocategoria());
					}
				}
			};
			Utente outente = (Utente) sessionMap.get(KEY_OBJ2);
			sessionMap.put(KEY_LISTAREE, mapArea);
			sessionMap.put(KEY_LISTAZIENDE, mapAzienda);
			sessionMap.put(KEY_LISTVENDITORI, mapVenditore);
			sessionMap.put(KEY_LISTASOTTOCAT, mapSottoCat);
			sessionMap.put(KEY_OBJ2, outente);
			sessionMap.put(KEY_OBJ, oPrevisioneService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			this.idvenditore = (String) sessionMap.get(memoryvenditore);
			addActionError("Valorizzare un previsionale per modificarlo");
			return avanti();
		}
	}

	public String annulla() {
		return "cerca";
	}

	public String eliminaPrevisionale() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oPrevisioneService
				.deleteOj(oPrevisioneService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare il previsionale poichè presente in altre tabelle");
				this.idvenditore = (String) sessionMap.get(memoryvenditore);
				return ricercaPerVenditore();
			}
		} else {
			this.idvenditore = (String) sessionMap.get(memoryvenditore);
			addActionError("Valorizzare un previsionale per eliminarlo");
		}

		return avanti();
	}

	public String registraPrevisionale() {

		Previsione oPrevisione = (Previsione) sessionMap.get(KEY_OBJ);
		if (Integer.parseInt(this.idarea) != 0)
			oPrevisione.setOarea(new AreaService().findById(Integer.parseInt(this.idarea)));
		else
			addActionError("Inserire un'area per il nuovo previsionale");
		if (Integer.parseInt(this.idsottocategoria) != 0)
			oPrevisione.setOsottocategoria(
					new SottoCategoriaService().findById(Integer.parseInt(this.idsottocategoria.replace("\'", ""))));
		else
			addActionError("Inserire una sottocategoria per il nuovo previsionale");
		if (Integer.parseInt(this.idazienda) != 0)
			oPrevisione.setOazienda(new AziendaService().findById(Integer.parseInt(this.idazienda)));
		else
			addActionError("Inserire un'azienda per il nuovo previsionale");
		if (((Utente) sessionMap.get(KEY_OBJ2)).isAdmin())
			if (Integer.parseInt(this.idvenditore) != 0)
				oPrevisione.setOvenditore(new VenditoreService().findById(Integer.parseInt(this.idvenditore)));
			else
				addActionError("Inserire un venditore per il previsionale");
		else
			oPrevisione.setOvenditore(((Utente) sessionMap.get(KEY_OBJ2)).getOvenditore());
		oPrevisione.setDatavisita(this.datavisita);
		if (this.annodiriferimento != null)
			oPrevisione.setAnnodiriferimento(this.annodiriferimento);
		else
			addActionError("Inserire un'anno di riferimento per il nuovo previsionale");
		if (this.dataregistrazione != null)
			oPrevisione.setDataregistrazione(this.dataregistrazione);
		else
			addActionError("Inserire una data di registrazione per il nuovo previsionale");
		if (!this.confidenza.equalsIgnoreCase(""))
			oPrevisione.setConfidenza(this.confidenza);
		else
			addActionError("Inserire il campo confidenza");
		Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
		Matcher matcher = pattern.matcher(this.potenzialeazienda);
		matcher = pattern.matcher(this.potenzialeeuropecar);
		matcher = pattern.matcher(this.shareante);
		matcher = pattern.matcher(this.shareavis);
		matcher = pattern.matcher(this.sharehertz);
		matcher = pattern.matcher(this.sharemaggiore);
		matcher = pattern.matcher(this.sharepost);
		matcher = pattern.matcher(this.sharesixt);

		if (!matcher.matches()) {
			addActionError("Inserire il carattere corretto nei campi potenziale e share");
			return "nuovomodifica";
		} else {
			if (!this.potenzialeazienda.equalsIgnoreCase("") && !this.potenzialeeuropecar.equalsIgnoreCase("")
					&& !this.shareante.equalsIgnoreCase("") && !this.shareavis.equalsIgnoreCase("")
					&& !this.sharehertz.equalsIgnoreCase("") && !this.sharemaggiore.equalsIgnoreCase("")
					&& !this.sharepost.equalsIgnoreCase("") && !this.sharesixt.equalsIgnoreCase("")) {
				if (!this.potenzialeazienda.equalsIgnoreCase("0.0") && !this.potenzialeeuropecar.equalsIgnoreCase("0.0")
						&& !this.shareante.equalsIgnoreCase("0.0") && !this.shareavis.equalsIgnoreCase("0.0")
						&& !this.sharehertz.equalsIgnoreCase("0.0") && !this.sharemaggiore.equalsIgnoreCase("0.0")
						&& !this.sharepost.equalsIgnoreCase("0.0") && !this.sharesixt.equalsIgnoreCase("0.0")) {
					oPrevisione.setPotenzialeeuropecar(Float.parseFloat(potenzialeeuropecar));
					oPrevisione.setPotenzialeazienda(Float.parseFloat(potenzialeazienda));
					oPrevisione.setShareante(Float.parseFloat(shareante));
					oPrevisione.setSharepost(Float.parseFloat(sharepost));
					oPrevisione.setShareavis(Float.parseFloat(shareavis));
					oPrevisione.setSharehertz(Float.parseFloat(sharehertz));
					oPrevisione.setSharemaggiore(Float.parseFloat(sharemaggiore));
					oPrevisione.setSharesixt(Float.parseFloat(sharesixt));
				} else
					addActionError("Riempire i campi potenziale e share per poter proseguire");
			} else
				addActionError("Riempire i campi potenziale e share per poter proseguire");
		}
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<Previsione>) sessionMap.get(KEY_LIST)).size() - 1);
			oPrevisioneService.persistOrUpdate(oPrevisione);
			return avanti();
		} else
			return "nuovomodifica";
	}

	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "previsionale");
		return "cambiaAnno";
	}
}
