package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.AreaInvestimentoService;
import model.dao.OrdineDiAcquistoDettaglioService;
import model.dao.SottoCategoriaDAO;
import model.dao.SottoCategoriaService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.AreaInvestimento;
import model.session.OrdineDiAcquistoDettaglio;
import model.session.SottoCategoria;

public class AvanzamentoBudget extends ActionSupport implements SessionAware {
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	AreaInvestimentoService oAreaInvestimentoService = new AreaInvestimentoService();
	// Attributi
	public static final String KEY_LISTAAREE = "listaaree";
	public static final String KEY_OGGETTOSOTTOCATEGORIA = "oggettosottocategoria";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_LISTABS = "listabudgets";
	public static final String KEY_LISTAAVANZ = "listaavanzamenti";
	public static final String KEY_LISTASOTTOCATEGORIE = "listasottocategorie";
	public static final String KEY_STRUTSANNO = "prova";
	public static final String KEY_JSP = "jsp";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_INIZIOB = "iniziobudget";
	public static final String KEY_INIZIOA = "inizioavanzamento";
	public static final String KEY_FINE = "fine";
	public static final String KEY_FINEB = "finebudget";
	public static final String KEY_FINEA = "fineavanzamento";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	private boolean nuovomodifica;
	private SessionMap<String, Object> sessionMap;
	private Date datainizio;
	private Date datafine;
	private String idsottocategoria;
	private SottoCategoria oSottoCategoria;
	private String idarea;
	public static final String KEY_LISTAANNI = "listaanni";
	private String idannocontabile;
	private List<AnnoContabile> elencoAnniContabili;
	AnnoContabileService oAnn = new AnnoContabileService();
	// Get e Set

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public String getIdannocontabile() {
		return idannocontabile;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
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

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
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

	public String getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(String idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public SottoCategoria getoSottoCategoria() {
		return oSottoCategoria;
	}

	public void setoSottoCategoria(SottoCategoria oSottoCategoria) {
		this.oSottoCategoria = oSottoCategoria;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		HashMap<String, String> mapAree = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona L'AreaInvestimento: ");
				List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_LISTAAREE, mapAree);
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		sessionMap.put(KEY_OGGETTOANNO, oanno);
		sessionMap.put(KEY_JSP, false);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_INIZIOA, null);
		sessionMap.put(KEY_INIZIOB, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_FINEA, null);
		sessionMap.put(KEY_FINEB, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return "search";
	}

	public String avanzamento() {
		HashMap<String, String> mapAree = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona L'AreaInvestimento: ");
				List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_LISTAAREE, mapAree);
		if (Integer.parseInt(this.idarea) == 0) {
			addActionError("Valorizzare un'Area per poter proseguire");
		}
		if (this.datainizio == null) {
			addActionError("Inserire la Data inizio");
		}
		if (this.datafine == null) {
			addActionError("Inserire la Data fine");
		}
		if (getActionErrors().size() == 0) {
			AreaInvestimento oare;
			if (sessionMap.get(KEY_OGGETTOAREA) != null) {
				oare = (AreaInvestimento) sessionMap.get(KEY_OGGETTOAREA);
				if (oare.getIdarea() != Integer.parseInt(this.idarea)) {

					sessionMap.put(KEY_CONTROLLO, null);
					sessionMap.put(KEY_CONTROLLOFINE, null);
					sessionMap.put(KEY_CONTROLLOINDIETRO, null);
					sessionMap.put(KEY_INIZIO, null);
					sessionMap.put(KEY_INIZIOA, null);
					sessionMap.put(KEY_INIZIOB, null);
					sessionMap.put(KEY_FINE, null);
					sessionMap.put(KEY_FINEA, null);
					sessionMap.put(KEY_FINEB, null);
					sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
					sessionMap.put(KEY_PAGINE, null);
					sessionMap.put(KEY_PAGINACORRENTE, null);
					sessionMap.put(KEY_SIZE, null);
				}
			}

			sessionMap.put(KEY_OGGETTOAREA,
					oAreaInvestimentoService.findById(Integer.parseInt(this.idarea.replace("\'", ""))));
			AreaInvestimento oAreaInvestimento = oAreaInvestimentoService
					.findById(Integer.parseInt(this.idarea.replace("\'", "")));
			List<SottoCategoria> elenco = this.elencoSottoCategoriePerAreaInvestimento(oAreaInvestimento);
			List<SottoCategoria> result = new ArrayList<SottoCategoria>();
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= oAnnoContabile
						.getDatainizio().getTime()
						&& elenco.get(i).getOarea().getOannocontabile().getDatafine().getTime() <= oAnnoContabile
								.getDatafine().getTime()) {
					result.add(elenco.get(i));
				}
			}
			List<Float> listaBS = new ArrayList<Float>();
			List<Float> listaAvanzamenti = new ArrayList<Float>();
			for (int i = 0; i < result.size(); i++) {
				float budgetSpeso = 0;
				float budgetSpesoTot = 0;
				float avanzamento = 0;
				List<OrdineDiAcquistoDettaglio> lista = new OrdineDiAcquistoDettaglioService().executeParamizedHQLQuery(
						"FROM OrdineDiAcquistoDettaglio WHERE ospesainvestimento.osottocategoria.idsottocategoria="
								+ result.get(i).getIdsottocategoria(),
						OrdineDiAcquistoDettaglio.class);
				avanzamento = result.get(i).getBudget();
				for (int j = 0; j < lista.size(); j++) {
					if (lista.get(j).getOordineacquisto().getData().getTime() >= this.datainizio.getTime()
							&& lista.get(j).getOordineacquisto().getData().getTime() <= this.datafine.getTime()) {
						budgetSpeso = lista.get(j).getImporto() * lista.get(j).getQuantita();
						budgetSpesoTot = budgetSpesoTot + budgetSpeso;
						avanzamento = (avanzamento - budgetSpeso);
					}

				}
				listaBS.add(budgetSpesoTot);
				listaAvanzamenti.add(avanzamento);
			}
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
			sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
			sessionMap.put(KEY_LISTABS, listaBS);
			sessionMap.put(KEY_LISTAAVANZ, listaAvanzamenti);
			sessionMap.put(KEY_LISTASOTTOCATEGORIE, result);
			sessionMap.put(KEY_JSP, true);

			if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
				this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
			}
			List<SottoCategoria> ali = result;
			int z = ali.size() - 1;
			if (sessionMap.get(KEY_CONTROLLO) != null) {
				if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) == null) {
					int i = (int) sessionMap.get(KEY_INIZIO) + 19;
					int j = (int) sessionMap.get(KEY_FINE) + 1;
					if (i <= z) {
						sessionMap.put(KEY_INIZIO, j);
						sessionMap.put(KEY_INIZIOB, j);
						sessionMap.put(KEY_INIZIOA, j);
						sessionMap.put(KEY_FINE, i);
						sessionMap.put(KEY_FINEB, i);
						sessionMap.put(KEY_FINEA, i);
						sessionMap.put(KEY_CONTROLLOFINE, true);
						sessionMap.put(KEY_CONTROLLOINDIETRO, true);
					} else if (j <= z) {
						sessionMap.put(KEY_INIZIO, j);
						sessionMap.put(KEY_INIZIOB, j);
						sessionMap.put(KEY_INIZIOA, j);
						sessionMap.put(KEY_FINE, z);
						sessionMap.put(KEY_FINEB, z);
						sessionMap.put(KEY_FINEA, z);
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
				sessionMap.put(KEY_INIZIOB, 0);
				sessionMap.put(KEY_INIZIOA, 0);
				if (9 >= z) {
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_FINEB, z);
					sessionMap.put(KEY_FINEA, z);
					sessionMap.put(KEY_CONTROLLOFINE, false);
				} else {
					sessionMap.put(KEY_FINE, 9);
					sessionMap.put(KEY_FINEB, 9);
					sessionMap.put(KEY_FINEA, 9);
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
				sessionMap.put(KEY_FINEB, z);
				sessionMap.put(KEY_FINEA, z);
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIO, w - 10);
				sessionMap.put(KEY_INIZIOB, w - 10);
				sessionMap.put(KEY_INIZIOA, w - 10);
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_FINEB, z);
				sessionMap.put(KEY_FINEA, z);
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
					sessionMap.put(KEY_INIZIOB, Integer.parseInt(x));
					sessionMap.put(KEY_INIZIOA, Integer.parseInt(x));
					sessionMap.put(KEY_PAGINACORRENTE, k);
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_FINEB, z);
					sessionMap.put(KEY_FINEA, z);
					sessionMap.put(KEY_CONTROLLOFINE, false);
					if(k >1)
					sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETRO, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
				}
			}
			return "avanzamento";

		} else {
			if (((boolean) sessionMap.get(KEY_JSP)) == true) {
				return "avanzamento";
			} else {
				sessionMap.put(KEY_JSP, false);
				return execute();
			}
		}

	}
	
	public String cerca() {
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_INIZIOA, null);
		sessionMap.put(KEY_INIZIOB, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_FINEA, null);
		sessionMap.put(KEY_FINEB, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return avanzamento();
	}

	public String prima() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
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
		sessionMap.put(KEY_INIZIOB, 0);
		sessionMap.put(KEY_INIZIOA, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINE, z);
			sessionMap.put(KEY_FINEA, z);
			sessionMap.put(KEY_FINEB, z);
		} else {
			sessionMap.put(KEY_FINE, 9);
			sessionMap.put(KEY_FINEA, 9);
			sessionMap.put(KEY_FINEB, 9);
		}
		sessionMap.put(KEY_CONTROLLO, true);
		sessionMap.put(KEY_CONTROLLOFINE, true);
		sessionMap.put(KEY_CONTROLLOINDIETRO, false);
		return "avanzamento";
	}

	public String ultima() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
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
		sessionMap.put(KEY_INIZIOB, q * 10);
		sessionMap.put(KEY_INIZIOA, q * 10);
		sessionMap.put(KEY_FINE, z);
		sessionMap.put(KEY_FINEA, z);
		sessionMap.put(KEY_FINEB, z);
		sessionMap.put(KEY_CONTROLLOFINE, false);
		sessionMap.put(KEY_CONTROLLOINDIETRO, true);
		return "avanzamento";
	}

	public String indietro() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
		int i = (int) sessionMap.get(KEY_INIZIO) - 10;
		int j = (int) sessionMap.get(KEY_FINE) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIO, i);
			sessionMap.put(KEY_INIZIOB, i);
			sessionMap.put(KEY_INIZIOA, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_FINEA, j);
				sessionMap.put(KEY_FINEB, j);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_FINEA, j);
				sessionMap.put(KEY_FINEB, j);
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

		return "avanzamento";
	}

	public List<SottoCategoria> elencoSottoCategoriePerAreaInvestimento(AreaInvestimento oAreaInvestimento) {
		SottoCategoriaDAO dao = oSottoCategoriaService.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class).createAlias("oarea", "o")
				.add(Restrictions.eq("o.idarea", oAreaInvestimento.getIdarea()));
		List<SottoCategoria> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "avanzamento");
		return "cambiaAnno";
	}

	public String indietroCerca() {
		return execute();
	}
}
