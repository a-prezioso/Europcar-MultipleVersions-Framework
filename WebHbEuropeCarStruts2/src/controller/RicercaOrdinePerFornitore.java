package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.FornitoreService;
import model.dao.OrdineDiAcquistoDettaglioDAO;
import model.dao.OrdineDiAcquistoDettaglioService;
import model.session.AnnoContabile;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;
import model.session.OrdineAcquisto;
import model.session.OrdineDiAcquistoDettaglio;
import model.session.Progetto;
import model.session.SpesaInvestimento;

public class RicercaOrdinePerFornitore extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_LISTA = "listaordini";
	public static final String KEY_OBJ = "oggetto";
	public static final String KEY_MAP = "mappa";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_SIZE = "size";
	public static final String KEY_OGGETTOFORNITORE = "oggettofornitore";
	private boolean nuovomodifica;
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private OrdineDiAcquistoDettaglio oordinediacquistodettaglio;
	private String IDOrdineAcquisto;
	private List<OrdineAcquisto> elencoOrdiniAcquisto;
	private String IDSpesaInvestimento;
	private List<SpesaInvestimento> elencoSpeseInvestimento;
	private String IDProgetto;
	private List<Progetto> elencoProgetti;
	private float importo;
	private int quantita;
	private String IDFornitore;
	private List<Fornitore> elencoFornitori;

	OrdineDiAcquistoDettaglioService oOrdDet = new OrdineDiAcquistoDettaglioService();
	FornitoreService oFor = new FornitoreService();

	// Get e set

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public OrdineDiAcquistoDettaglio getOordinediacquistodettaglio() {
		return oordinediacquistodettaglio;
	}

	public void setOordinediacquistodettaglio(OrdineDiAcquistoDettaglio oordinediacquistodettaglio) {
		this.oordinediacquistodettaglio = oordinediacquistodettaglio;
	}

	public String getIDOrdineAcquisto() {
		return IDOrdineAcquisto;
	}

	public void setIDOrdineAcquisto(String iDOrdineAcquisto) {
		IDOrdineAcquisto = iDOrdineAcquisto;
	}

	public List<OrdineAcquisto> getElencoOrdiniAcquisto() {
		return elencoOrdiniAcquisto;
	}

	public void setElencoOrdiniAcquisto(List<OrdineAcquisto> elencoOrdiniAcquisto) {
		this.elencoOrdiniAcquisto = elencoOrdiniAcquisto;
	}

	public String getIDSpesaInvestimento() {
		return IDSpesaInvestimento;
	}

	public void setIDSpesaInvestimento(String iDSpesaInvestimento) {
		IDSpesaInvestimento = iDSpesaInvestimento;
	}

	public List<SpesaInvestimento> getElencoSpeseInvestimento() {
		return elencoSpeseInvestimento;
	}

	public void setElencoSpeseInvestimento(List<SpesaInvestimento> elencoSpeseInvestimento) {
		this.elencoSpeseInvestimento = elencoSpeseInvestimento;
	}

	public String getIDProgetto() {
		return IDProgetto;
	}

	public void setIDProgetto(String iDProgetto) {
		IDProgetto = iDProgetto;
	}

	public List<Progetto> getElencoProgetti() {
		return elencoProgetti;
	}

	public void setElencoProgetti(List<Progetto> elencoProgetti) {
		this.elencoProgetti = elencoProgetti;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
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

	public String execute() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>() {
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

		return "search";
	}

	public List<OrdineDiAcquistoDettaglio> findOrdinePerFornitore() {
		OrdineDiAcquistoDettaglioDAO dao = oOrdDet.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineDiAcquistoDettaglio.class)
				.createAlias("oordineacquisto", "o").createAlias("o.ofornitore", "a")
				.add(Restrictions.eq("a.idfornitore", Integer.parseInt(this.IDFornitore)));
		List<OrdineDiAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public String cerca() {
		
		AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		if (Integer.parseInt(this.IDFornitore) != 0) {
			sessionMap.put(KEY_OGGETTOFORNITORE, this.IDFornitore);
			List<OrdineDiAcquistoDettaglio> elenco = this.findOrdinePerFornitore();
			List<OrdineDiAcquistoDettaglio> result = new ArrayList<OrdineDiAcquistoDettaglio>();
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getOordineacquisto().getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
						&& elenco.get(i).getOordineacquisto().getData().getTime() <= oAnnoContabile.getDatafine()
								.getTime()) {
					result.add(elenco.get(i));
				}
			}
			sessionMap.put(KEY_LISTA, result);
			List<OrdineDiAcquistoDettaglio> ali = result;
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
			return "cerca";
		} else {
			addActionError("Selezionare un Fornitore per procedere");
			return "search";
		}
	}
	
	public String avanti() {
		this.IDFornitore = (String) sessionMap.get(KEY_OGGETTOFORNITORE);
		return cerca();
	}

	public String prima() {
		List<OrdineDiAcquistoDettaglio> ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(KEY_LISTA);
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
		return "cerca";
	}

	public String ultima() {
		List<OrdineDiAcquistoDettaglio> ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(KEY_LISTA);
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
		List<OrdineDiAcquistoDettaglio> ali = (List<OrdineDiAcquistoDettaglio>) sessionMap.get(KEY_LISTA);
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

	public String annulla() {
		return execute();
	}

}