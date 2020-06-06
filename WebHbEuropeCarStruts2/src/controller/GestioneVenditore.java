package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AreaInvestimentoService;
import model.dao.AreaService;
import model.dao.AziendaService;
import model.dao.PrevisioneDAO;
import model.dao.PrevisioneService;
import model.dao.SottoCategoriaService;
import model.dao.TipoVenditoreService;
import model.dao.VenditoreService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.Area;
import model.session.Azienda;
import model.session.Previsione;
import model.session.SottoCategoria;
import model.session.TipoVenditore;
import model.session.Utente;
import model.session.Venditore;

public class GestioneVenditore extends ActionSupport implements SessionAware {
	VenditoreService oVenditoreService = new VenditoreService();
	TipoVenditoreService oTipoVenditoreService = new TipoVenditoreService();
	PrevisioneService oPrevisioneService = new PrevisioneService();
	AreaService oAreaServcie = new AreaService();
	AziendaService oAziendaService = new AziendaService();
	// Attributi
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_LIST = "lista";
	public static final String KEY_TIPO = "listatipivenditori";
	public static final String KEY_OBJT = "oggettotipo";
	public static final String KEY_AREA = "listaaree";
	public static final String KEY_AZIENDA = "listaaziende";
	public static final String KEY_OBJ2 = "oggetto2";
	public static final String KEY_VENDITORE = "idvenditore";
	public static final String KEY_SOTTOCATEGORIA = "listasottocategorie";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_OGGETTOAZIENA = "oggettoazienda";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	private SessionMap<String, Object> sessionMap;
	public static final String KEY_OBJPR = "oggettopr";
	private boolean nuovomodifica;
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	private boolean nuovomodificaprev;
	public static final String KEY_LISTprev = "listaPrev";
	public static final String KEY_PAGINEprev = "pagineprev";
	public static final String KEY_PAGINACORRENTEprev = "paginacorrenteprev";
	public static final String KEY_INIZIOprev = "inizioprev";
	public static final String KEY_FINEprev = "fineprev";
	public static final String KEY_CONTROLLOprev = "controlloprev";
	public static final String KEY_CONTROLLOINDIETROprev = "controlloindietroprev";
	public static final String KEY_CONTROLLOFINEprev = "controllofineprev";
	public static final String KEY_CONTROLLONUOVOMODIFICAprev = "controllonuovomodificaprev";
	public static final String KEY_SIZEprev = "sizeprev";
	public static final String memoryvenditore = "memoryvenditore";
	List<Previsione> result = new ArrayList<Previsione>();
	private String idarea;
	private String idazienda;
	private String idsottocategoria;
	private String chiave;
	private String cognomev;
	private String nomev;
	private String indirizzov;
	private String numTel;
	private String idtipovenditore;
	private Venditore oVenditore;
	private String tipov;
	private String chiaveprevisionale;
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
	PrevisioneService opre = new PrevisioneService();
	// Get e Set

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public String getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(String idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getChiaveprevisionale() {
		return chiaveprevisionale;
	}

	public void setChiaveprevisionale(String chiaveprevisionale) {
		this.chiaveprevisionale = chiaveprevisionale;
	}

	public Date getDatavisita() {
		return datavisita;
	}

	public void setDatavisita(Date datavisita) {
		this.datavisita = datavisita;
	}

	public Date getAnnodiriferimento() {
		return annodiriferimento;
	}

	public void setAnnodiriferimento(Date annodiriferimento) {
		this.annodiriferimento = annodiriferimento;
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

	public String getChiave() {
		return chiave;
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

	public String getTipov() {
		return tipov;
	}

	public void setTipov(String tipov) {
		this.tipov = tipov;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getCognomev() {
		return cognomev;
	}

	public void setCognomev(String cognomev) {
		this.cognomev = cognomev;
	}

	public String getNomev() {
		return nomev;
	}

	public void setNomev(String nomev) {
		this.nomev = nomev;
	}

	public String getIndirizzov() {
		return indirizzov;
	}

	public void setIndirizzov(String indirizzov) {
		this.indirizzov = indirizzov;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getIdtipovenditore() {
		return idtipovenditore;
	}

	public void setIdtipovenditore(String idtipovenditore) {
		this.idtipovenditore = idtipovenditore;
	}

	public Venditore getoVenditore() {
		return oVenditore;
	}

	public void setoVenditore(Venditore oVenditore) {
		this.oVenditore = oVenditore;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		Utente oUtente = (Utente) sessionMap.get(KEY_OBJ2);
		if (oUtente.isAdmin())
			sessionMap.put(KEY_LIST, oVenditoreService.findAll());
		else
			sessionMap.put(KEY_LIST, oUtente.getOvenditore());
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LIST);
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
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String nuovoVenditore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> mapTipoVenditore = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Tipo di Venditore: ");
				List<TipoVenditore> elencoTipiVenditori = oTipoVenditoreService.findAll();
				for (int i = 0; i < elencoTipiVenditori.size(); i++) {
					put(String.valueOf(elencoTipiVenditori.get(i).getIdtipovenditore()),
							elencoTipiVenditori.get(i).getTipovenditore());
				}
			}
		};
		sessionMap.put(KEY_OBJ2, (Utente) sessionMap.get(KEY_OBJ2));
		sessionMap.put(KEY_TIPO, mapTipoVenditore);
		sessionMap.put(KEY_OBJ, new Venditore());
		String result = "nuovomodifica";
		return result;
	}

	public String modificaVenditore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			HashMap<String, String> mapTipoVenditore = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Tipo di Venditore: ");
					List<TipoVenditore> elencoTipiVenditori = oTipoVenditoreService.findAll();
					for (int i = 0; i < elencoTipiVenditori.size(); i++) {
						put(String.valueOf(elencoTipiVenditori.get(i).getIdtipovenditore()),
								elencoTipiVenditori.get(i).getTipovenditore());
					}
				}
			};
			sessionMap.put(KEY_OBJ2, (Utente) sessionMap.get(KEY_OBJ2));
			sessionMap.put(KEY_TIPO, mapTipoVenditore);
			sessionMap.put(KEY_OBJ, oVenditoreService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Selezionare un venditore per poterlo modificare:");
			return execute();
		}
	}

	public String eliminaVenditore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null)
			try {
				oVenditoreService.deleteOj(oVenditoreService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			} catch (PersistenceException e) {
				addActionError("Impossibile eliminare il venditore porchè presente in un'altra tabella! ");
			}
		else
			addActionError("Selezionare un venditore per eliminarlo");
		return execute();
	}

	public String annulla() {
		Venditore ovenditore = (Venditore) sessionMap.get(KEY_OBJ);
		this.chiave = String.valueOf(ovenditore.getIdvenditore());
		return execute();
	}

	public String registraVenditore() {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(this.numTel);
		if (!matcher.matches()) {
			addActionError("Inserire il carattere corretto nel campo numero di telefono");
			return "nuovomodifica";
		} else {
			Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);
			if (!this.nomev.equalsIgnoreCase(""))
				oVenditore.setNome(this.nomev);
			else
				addActionError("Inserire un nome per il venditore");
			if (!this.cognomev.equalsIgnoreCase(""))
				oVenditore.setCognome(this.cognomev);
			else
				addActionError("Inserire il cognome per il venditore");
			if (!this.indirizzov.equalsIgnoreCase(""))
				oVenditore.setIndirizzo(this.indirizzov);
			else
				addActionError("Inserire un indirizzo per il venditore");
			if (!this.numTel.equalsIgnoreCase(""))
				oVenditore.setNumerotelefono(this.numTel);
			else
				addActionError("Inserire un numero di telefono per il venditore");
			if (Integer.parseInt(this.idtipovenditore) != 0)
				oVenditore.setOtipovenditore(
						oTipoVenditoreService.findById(Integer.parseInt(this.idtipovenditore.replace("\'", ""))));
			else
				addActionError("Inserire un tipo per il venditore");
			if (getActionErrors().size() == 0) {
				sessionMap.put(KEY_SIZE, ((List<Venditore>) sessionMap.get(KEY_LIST)).size() - 1);
				oVenditoreService.persistOrUpdate(oVenditore);
				return execute();
			} else
				return "nuovomodifica";
		}
	}

	public String nuovoTipoVenditore() {
		sessionMap.put(KEY_OBJT, new TipoVenditore());
		Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);
		oVenditore.setCognome(this.cognomev);
		oVenditore.setIndirizzo(this.indirizzov);
		oVenditore.setNome(this.nomev);
		oVenditore.setNumerotelefono(this.numTel);
		oVenditore.setOtipovenditore(
				oTipoVenditoreService.findById(Integer.parseInt(this.idtipovenditore.replace("\'", ""))));
		String result = "nuovomodificatipo";
		return result;
	}

	public String modificaTipoVenditore() {
		sessionMap.put(KEY_OBJT,
				oTipoVenditoreService.findById(Integer.parseInt(this.idtipovenditore.replace("\'", ""))));
		String result = "nuovomodificatipo";
		return result;
	}

	public String eliminaTipoVenditore() {
		try {
			oTipoVenditoreService
					.deleteOj(oTipoVenditoreService.findById(Integer.parseInt(this.idtipovenditore.replace("\'", ""))));
		} catch (PersistenceException e) {
			addActionError("Impossibile eliminare il Tipo di venditore poichè presente in un'altra tabella");
		}
		String result = "nuovomodificatipo";
		return result;
	}

	public String registraTipoVenditore() {
		TipoVenditore oTipoVenditore = new TipoVenditore();
		if (!this.tipov.equalsIgnoreCase("")) {
			oTipoVenditore.setTipovenditore(this.tipov);
			oTipoVenditoreService.persistOrUpdate(oTipoVenditore);
			HashMap<String, String> mapTipoVenditore = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Tipo di Venditore: ");
					List<TipoVenditore> elencoTipiVenditori = oTipoVenditoreService.findAll();
					for (int i = 0; i < elencoTipiVenditori.size(); i++) {
						put(String.valueOf(elencoTipiVenditori.get(i).getIdtipovenditore()),
								elencoTipiVenditori.get(i).getTipovenditore());
					}
				}
			};
			sessionMap.put(KEY_TIPO, mapTipoVenditore);
			return "nuovomodifica";
		} else {
			addActionError("Inserire una descrizione per il nuovo tipo venditore");
			return "nuovomodificatipo";
		}
	}

	public String indietro2() {
		return "nuovomodifica";
	}

	public List<Previsione> elencoPrevisioni(Venditore ovenditore) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class).createAlias("ovenditore", "o")
				.add(Restrictions.eq("o.idvenditore", Integer.parseInt(this.chiave.replace("\'", ""))));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public String previsionalePerVenditore() {
		if (this.chiave != null) {
			HashMap<String, String> mapAzienda = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Azienda: ");
					List<Azienda> elencoAziende = oAziendaService.findAll();
					for (int i = 0; i < elencoAziende.size(); i++) {
						put(String.valueOf(elencoAziende.get(i).getIdazienda()),
								elencoAziende.get(i).getRagioneSociale());
					}
				}
			};
			HashMap<String, String> mapArea = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona Area: ");
					List<Area> elencoAree = oAreaServcie.findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			Venditore ovenditore = new VenditoreService().findById(Integer.parseInt(this.chiave.replace("\'", "")));
			sessionMap.put(KEY_AREA, mapArea);
			sessionMap.put(KEY_AZIENDA, mapAzienda);
			sessionMap.put(KEY_OBJ, ovenditore);
			sessionMap.put(KEY_OBJ2, sessionMap.get(KEY_OBJ2));
			List<Previsione> elenco = this.elencoPrevisioni(ovenditore);
			List<Previsione> result = new ArrayList<Previsione>();
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oAnnoContabile.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oAnnoContabile.getDatafine());
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getDataregistrazione().getTime() >= oAnnoContabile.getDatainizio().getTime()
						&& elenco.get(i).getDataregistrazione().getTime() <= oAnnoContabile.getDatafine().getTime()) {
					result.add(elenco.get(i));
				}
			}

			List<Previsione> ali = result;
			sessionMap.put(KEY_LISTprev, ali);
			int z = ali.size() - 1;
			sessionMap.put(KEY_INIZIOprev, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_CONTROLLOFINEprev, false);
			} else {
				sessionMap.put(KEY_FINEprev, 9);
				sessionMap.put(KEY_CONTROLLOFINEprev, true);
			}
			sessionMap.put(KEY_CONTROLLOprev, true);
			int k = (int) Math.ceil(z / 10.0);
			String a = String.valueOf(z);
			char b = a.charAt(a.length() - 1);
			if (b == '0') {
				k = k + 1;
			}
			sessionMap.put(KEY_PAGINEprev, k);
			int w = (int) sessionMap.get(KEY_INIZIOprev);
			sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
			if ((w / 10) + 1 == k) {
				sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_CONTROLLOFINEprev, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIOprev, w - 10);
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10));
			}
			if (sessionMap.get(KEY_SIZEprev) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZEprev);
				if (z > sizevecchia) {
					sessionMap.put(KEY_SIZEprev, null);
					String y = String.valueOf(z);
					char l = y.charAt(a.length() - 1);
					String x = String.valueOf(y.replace(l, '0'));
					sessionMap.put(KEY_INIZIOprev, Integer.parseInt(x));
					sessionMap.put(KEY_PAGINACORRENTEprev, k);
					sessionMap.put(KEY_FINEprev, z);
					sessionMap.put(KEY_CONTROLLOFINEprev, false);
					if(k>1)
					sessionMap.put(KEY_CONTROLLOINDIETROprev, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETROprev, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
				}
			}
			sessionMap.put(KEY_OGGETTOAREA, null);
			sessionMap.put(KEY_OGGETTOAZIENA, null);
			return "ricercapervenditore";
		} else {
			addActionError("Selezionare un venditore per poter visualizzare i previsionali per quel venditore");
			return "search";
		}
	}

	public String ricercaPerAreaAzienda() {
		HashMap<String, String> mapAzienda = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Azienda: ");
				List<Azienda> elencoAziende = oAziendaService.findAll();
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdazienda()), elencoAziende.get(i).getRagioneSociale());
				}
			}
		};
		HashMap<String, String> mapArea = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona Area: ");
				List<Area> elencoAree = oAreaServcie.findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_AREA, mapArea);
		sessionMap.put(KEY_AZIENDA, mapAzienda);
		Venditore ovenditore = (Venditore) sessionMap.get(KEY_OBJ);
		sessionMap.put(KEY_OBJ, ovenditore);
		sessionMap.put(KEY_OBJ2, sessionMap.get(KEY_OBJ2));
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		if (Integer.parseInt(this.idazienda) != 0 && Integer.parseInt(this.idarea) != 0) {
			List<Previsione> elenco = opre.elencoPrevisioniPerAreaAzienda(ovenditore, this.idarea, this.idazienda,
					oAnnoContabile.getIdannocontabile());
			sessionMap.put(KEY_LISTprev, elenco);
			Area oArea = oAreaServcie.findById(Integer.parseInt(this.idarea));
			Azienda oAzienda = oAziendaService.findById(Integer.parseInt(this.idazienda));
			sessionMap.put(KEY_OGGETTOAREA, oArea);
			sessionMap.put(KEY_OGGETTOAZIENA, oAzienda);
			sessionMap.put(KEY_PAGINACORRENTEprev, null);
			sessionMap.put(KEY_INIZIOprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOFINEprev, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, null);
			sessionMap.put(KEY_CONTROLLOINDIETROprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOprev, null);

		} else if (Integer.parseInt(this.idazienda) == 0 && Integer.parseInt(this.idarea) != 0) {
			List<Previsione> elenco = opre.elencoPrevisioniPerArea(ovenditore, this.idarea,
					oAnnoContabile.getIdannocontabile());
			sessionMap.put(KEY_LISTprev, elenco);

			sessionMap.put(KEY_OGGETTOAZIENA, null);
			Area oArea = oAreaServcie.findById(Integer.parseInt(this.idarea));
			sessionMap.put(KEY_OGGETTOAREA, oArea);
			sessionMap.put(KEY_PAGINACORRENTEprev, null);
			sessionMap.put(KEY_INIZIOprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOFINEprev, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, null);
			sessionMap.put(KEY_CONTROLLOINDIETROprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOprev, null);
		} else if (Integer.parseInt(this.idazienda) != 0 && Integer.parseInt(this.idarea) == 0) {
			List<Previsione> elenco = opre.elencoPrevisioniPerAzienda(ovenditore, this.idazienda,
					oAnnoContabile.getIdannocontabile());
			sessionMap.put(KEY_LISTprev, elenco);
			Azienda oAzienda = oAziendaService.findById(Integer.parseInt(this.idazienda));
			sessionMap.put(KEY_OGGETTOAZIENA, oAzienda);
			sessionMap.put(KEY_OGGETTOAREA, null);
			sessionMap.put(KEY_PAGINACORRENTEprev, null);
			sessionMap.put(KEY_INIZIOprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOFINEprev, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, null);
			sessionMap.put(KEY_CONTROLLOINDIETROprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOprev, null);
		} else {
			List<Previsione> elenco = opre.findPrevisionePerVenditore(ovenditore);
            for (int i = 0; i < elenco.size(); i++) {
                if (elenco.get(i).getDataregistrazione().getTime() >= oAnnoContabile.getDatainizio().getTime()
                        && elenco.get(i).getDataregistrazione().getTime() <= oAnnoContabile.getDatafine().getTime()) {
                    result.add(elenco.get(i));
                }
            }
            sessionMap.put(KEY_LISTprev, result);
			sessionMap.put(KEY_OGGETTOAZIENA, null);
			sessionMap.put(KEY_OGGETTOAREA, null);
			sessionMap.put(KEY_PAGINACORRENTEprev, null);
			sessionMap.put(KEY_INIZIOprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOFINEprev, null);
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, null);
			sessionMap.put(KEY_CONTROLLOINDIETROprev, null);
			sessionMap.put(KEY_FINEprev, null);
			sessionMap.put(KEY_CONTROLLOprev, null);
		}
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LISTprev);
		sessionMap.put(KEY_LISTprev, ali);
		int z = ali.size() - 1;
		sessionMap.put(KEY_INIZIOprev, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINEprev, z);
			sessionMap.put(KEY_CONTROLLOFINEprev, false);
		} else {
			sessionMap.put(KEY_FINEprev, 9);
			sessionMap.put(KEY_CONTROLLOFINEprev, true);
		}
		sessionMap.put(KEY_CONTROLLOprev, true);
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEprev, k);
		int w = (int) sessionMap.get(KEY_INIZIOprev);
		sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
			sessionMap.put(KEY_FINEprev, z);
			sessionMap.put(KEY_CONTROLLOFINEprev, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOprev, w - 10);
			sessionMap.put(KEY_FINEprev, z);
			sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10));
		}
		if (sessionMap.get(KEY_SIZEprev) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZEprev);
			if (z > sizevecchia) {
				sessionMap.put(KEY_SIZEprev, null);
				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOprev, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTEprev, k);
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_CONTROLLOFINEprev, false);
				if(k>1)
				sessionMap.put(KEY_CONTROLLOINDIETROprev, true);
			} else {
				sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
			}
		}
		return "ricercapervenditore";
	}

	public String registraPrevisionale() {
		Previsione oPrevisione = (Previsione) sessionMap.get(KEY_OBJPR);
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
		oPrevisione.setOvenditore((Venditore) sessionMap.get(KEY_OBJ));
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
			oPrevisione.setConfidenza(confidenza);
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
			sessionMap.put(KEY_SIZEprev, ((List<Previsione>) sessionMap.get(KEY_LISTprev)).size() - 1);
			oPrevisioneService.persistOrUpdate(oPrevisione);
			Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);

			this.chiave = Integer.toString(oVenditore.getIdvenditore());
			return avanti();
		} else
			return "nuovomodificaprevisione";

	}

	public String nuovoPrevisionale() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, true);
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oAnnoContabile.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oAnnoContabile.getDatafine());
		HashMap<String, String> mapArea = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Area: ");
				List<Area> elencoAree = new AreaService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		HashMap<String, String> mapAzienda = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Azienda: ");
				List<Azienda> elencoAziende = new AziendaService().findAll();
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdazienda()), elencoAziende.get(i).getRagioneSociale());
				}
			}
		};
		HashMap<String, String> mapSottoCat = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona la SottoCategoria: ");
				List<SottoCategoria> elenco = new SottoCategoriaService().findAll();
				List<SottoCategoria> elencoSottoCategorie = new ArrayList<SottoCategoria>();
				for (int i = 0; i < elenco.size(); i++) {
					if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= oAnnoContabile
							.getDatainizio().getTime()
							&& elenco.get(i).getOarea().getOannocontabile().getDatafine().getTime() <= oAnnoContabile
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
		sessionMap.put(KEY_SOTTOCATEGORIA, mapSottoCat);
		sessionMap.put(KEY_OBJ, sessionMap.get(KEY_OBJ));
		sessionMap.put(KEY_AREA, mapArea);
		sessionMap.put(KEY_AZIENDA, mapAzienda);
		sessionMap.put(KEY_OBJPR, new Previsione());
		sessionMap.put(KEY_LISTprev, sessionMap.get(KEY_LISTprev));
		String result = "nuovomodificaprevisione";
		return result;
	}

	public String modificaPrevisionale() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, true);
		if (this.chiaveprevisionale != null) {
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oAnnoContabile.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oAnnoContabile.getDatafine());
			HashMap<String, String> mapArea = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Area: ");
					List<Area> elencoAree = new AreaService().findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			HashMap<String, String> mapAzienda = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Azienda: ");
					List<Azienda> elencoAziende = new AziendaService().findAll();
					for (int i = 0; i < elencoAziende.size(); i++) {
						put(String.valueOf(elencoAziende.get(i).getIdazienda()),
								elencoAziende.get(i).getRagioneSociale());
					}
				}
			};
			HashMap<String, String> mapSottoCat = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona la SottoCategoria: ");
					List<SottoCategoria> elenco = new SottoCategoriaService().findAll();
					List<SottoCategoria> elencoSottoCategorie = new ArrayList<SottoCategoria>();
					for (int i = 0; i < elenco.size(); i++) {
						if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= oAnnoContabile
								.getDatainizio().getTime()
								&& elenco.get(i).getOarea().getOannocontabile().getDatafine()
										.getTime() <= oAnnoContabile.getDatafine().getTime()) {
							elencoSottoCategorie.add(elenco.get(i));
						}
					}
					for (int i = 0; i < elencoSottoCategorie.size(); i++) {
						put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
								elencoSottoCategorie.get(i).getSottocategoria());
					}
				}
			};
			sessionMap.put(KEY_SOTTOCATEGORIA, mapSottoCat);
			sessionMap.put(KEY_LISTprev, sessionMap.get(KEY_LISTprev));
			sessionMap.put(KEY_OBJ, sessionMap.get(KEY_OBJ));
			sessionMap.put(KEY_AREA, mapArea);
			sessionMap.put(KEY_AZIENDA, mapAzienda);
			sessionMap.put(KEY_OBJPR,
					oPrevisioneService.findById(Integer.parseInt(this.chiaveprevisionale.replace("\'", ""))));
			return "nuovomodificaprevisione";
		} else {
			addActionError("selezionare un previsionale per poterlo modificare");
			Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);
			this.chiave = Integer.toString(oVenditore.getIdvenditore());
			return avanti();
		}
	}

	public String eliminaPrevisionale() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, true);
		if (this.chiaveprevisionale != null) {
			try {
				oPrevisioneService.deleteOj(
						oPrevisioneService.findById(Integer.parseInt(this.chiaveprevisionale.replace("\'", ""))));
				sessionMap.put(KEY_SIZEprev, ((List<Previsione>) sessionMap.get(KEY_LISTprev)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Impossibile eliminare il previsionale poichè presente in un'altra tabella");

				return avanti();
			}
		} else
			addActionError("scegliere un previsionale per poterlo eliminare");
		Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);

		this.chiave = Integer.toString(oVenditore.getIdvenditore());
		return avanti();
	}

	public String prima() {
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LIST);
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
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LIST);
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
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LIST);
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

	public String indietroAlVenditore() {
		sessionMap.put(KEY_LISTprev, null);
		sessionMap.put(KEY_PAGINEprev, null);
		sessionMap.put(KEY_PAGINACORRENTEprev, null);
		sessionMap.put(KEY_INIZIOprev, null);
		sessionMap.put(KEY_FINEprev, null);
		sessionMap.put(KEY_CONTROLLOprev, null);
		sessionMap.put(KEY_CONTROLLOINDIETROprev, null);
		sessionMap.put(KEY_CONTROLLOFINEprev, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, null);
		sessionMap.put(KEY_SIZEprev, null);
		return "search";
	}

	public String avanti() {
		Venditore oVenditore = (Venditore) sessionMap.get(KEY_OBJ);
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<Previsione> elenco = new ArrayList<Previsione>();
		if (sessionMap.get(KEY_OGGETTOAREA) != null && sessionMap.get(KEY_OGGETTOAZIENA) != null) {
			elenco = opre.elencoPrevisioniPerAreaAzienda(oVenditore,
					String.valueOf((((Area) sessionMap.get(KEY_OGGETTOAREA)).getIdarea())),
					String.valueOf((((Azienda) sessionMap.get(KEY_OGGETTOAZIENA))).getIdazienda()),
					oanno.getIdannocontabile());
		} else if (sessionMap.get(KEY_OGGETTOAREA) == null && sessionMap.get(KEY_OGGETTOAZIENA) != null) {
			elenco = opre.elencoPrevisioniPerAzienda(oVenditore,
					String.valueOf((((Azienda) sessionMap.get(KEY_OGGETTOAZIENA))).getIdazienda()),
					oanno.getIdannocontabile());
		} else if (sessionMap.get(KEY_OGGETTOAREA) != null && sessionMap.get(KEY_OGGETTOAZIENA) == null) {
			elenco = opre.elencoPrevisioniPerArea(oVenditore,
					String.valueOf((((Area) sessionMap.get(KEY_OGGETTOAREA)).getIdarea())), oanno.getIdannocontabile());
		} else {
			elenco = opre.findPrevisionePerVenditore(oVenditore);
		}
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getDataregistrazione().getTime() <= oanno.getDatafine().getTime()
					&& elenco.get(i).getDataregistrazione().getTime() >= oanno.getDatainizio().getTime()) {
				result.add(elenco.get(i));
			}
		}
		List<Previsione> ali = result;
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICAprev) != null) {
			this.nuovomodificaprev = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICAprev);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTprev, ali);
		if (sessionMap.get(KEY_CONTROLLOprev) != null) {
			if (!nuovomodificaprev || sessionMap.get(KEY_CONTROLLONUOVOMODIFICAprev) == null) {
				int i = (int) sessionMap.get(KEY_INIZIOprev) + 19;
				int j = (int) sessionMap.get(KEY_FINEprev) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIOprev, j);
					sessionMap.put(KEY_FINEprev, i);
					sessionMap.put(KEY_CONTROLLOFINEprev, true);
					sessionMap.put(KEY_CONTROLLOINDIETROprev, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIOprev, j);
					sessionMap.put(KEY_FINEprev, z);
					sessionMap.put(KEY_CONTROLLOFINEprev, false);
					sessionMap.put(KEY_CONTROLLOINDIETROprev, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINEprev, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICAprev, false);
			}
		} else {
			sessionMap.put(KEY_INIZIOprev, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_CONTROLLOFINEprev, false);
			} else {
				sessionMap.put(KEY_FINEprev, 9);
				sessionMap.put(KEY_CONTROLLOFINEprev, true);
			}
			sessionMap.put(KEY_CONTROLLOprev, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEprev, k);
		int w = (int) sessionMap.get(KEY_INIZIOprev);
		sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
			sessionMap.put(KEY_FINEprev, z);
			sessionMap.put(KEY_CONTROLLOFINEprev, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOprev, w - 10);
			sessionMap.put(KEY_FINEprev, z);
			sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10));
		}
		if (sessionMap.get(KEY_SIZEprev) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZEprev);
			sessionMap.put(KEY_SIZEprev, null);
			if (z > sizevecchia) {
				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOprev, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTEprev, k);
				sessionMap.put(KEY_FINEprev, z);
				sessionMap.put(KEY_CONTROLLOFINEprev, false);
				if(k>1)
				sessionMap.put(KEY_CONTROLLOINDIETROprev, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROprev, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);
			}
		}

		return "ricercapervenditore";

	}

	public String indietroPrev() {
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LISTprev);
		sessionMap.put(KEY_LISTprev, ali);
		int i = (int) sessionMap.get(KEY_INIZIOprev) - 10;
		int j = (int) sessionMap.get(KEY_FINEprev) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIOprev, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINEprev, j);
				sessionMap.put(KEY_CONTROLLOFINEprev, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINEprev, j);
				sessionMap.put(KEY_CONTROLLOFINEprev, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETROprev, false);
				sessionMap.put(KEY_CONTROLLOFINEprev, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEprev, k);
		int w = (int) sessionMap.get(KEY_INIZIOprev);
		sessionMap.put(KEY_PAGINACORRENTEprev, (w / 10) + 1);

		return "ricercapervenditore";
	}

	public String primaPrev() {
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LISTprev);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEprev, k);
		sessionMap.put(KEY_PAGINACORRENTEprev, 1);

		sessionMap.put(KEY_INIZIOprev, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINEprev, z);
		} else {
			sessionMap.put(KEY_FINEprev, 9);
		}
		sessionMap.put(KEY_CONTROLLOprev, true);
		sessionMap.put(KEY_CONTROLLOFINEprev, true);
		sessionMap.put(KEY_CONTROLLOINDIETROprev, false);
		return "ricercapervenditore";
	}

	public String ultimaPrev() {
		List<Previsione> ali = (List<Previsione>) sessionMap.get(KEY_LISTprev);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEprev, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTEprev, q + 1);
		sessionMap.put(KEY_INIZIOprev, q * 10);
		sessionMap.put(KEY_FINEprev, z);
		sessionMap.put(KEY_CONTROLLOFINEprev, false);
		sessionMap.put(KEY_CONTROLLOINDIETROprev, true);

		return avanti();
	}

	public String annullaPrev() {
		return avanti();
	}

}
