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
import model.dao.OrdineDiAcquistoDettaglioDAO;
import model.dao.OrdineDiAcquistoDettaglioService;
import model.dao.SottoCategoriaService;
import model.session.AnnoContabile;
import model.session.OrdineDiAcquistoDettaglio;
import model.session.SottoCategoria;

public class RiconciliazioneBudget extends ActionSupport implements SessionAware {
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	// Attributi
	private SessionMap<String, Object> sessionMap;
	public static final String KEY_LISTASOTTOCATEGORIE = "listasottocategoria";
	public static final String KEY_OGGETTOSOTTOCATEGORIA = "oggettosottocategoria";
	public static final String KEY_DATAINIZIO = "datain";
	public static final String KEY_DATAFINE = "datafi";
	public static final String KEY_BUNGETSPESO = "budgetspeso";
	public static final String KYE_OGGETTOANNO ="oggettoanno";
	private Date datainizio;
	private Date datafine;
	private String idsottocategoria;
	private SottoCategoria oSottoCategoria;
	public static final String KEY_LISTAANNI = "listaanni";
	private String idannocontabile;
	private List<AnnoContabile> elencoAnniContabili;
	AnnoContabileService oAnn = new AnnoContabileService();
	public static final String KEY_STRUTSANNO ="prova";
	// Get e Set

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
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
		AnnoContabile oanno = (AnnoContabile)sessionMap.get(KYE_OGGETTOANNO);
		HashMap<String, String> mapSottoCat = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona la SottoCategoria: ");
				List<SottoCategoria> elencoAziende = oSottoCategoriaService.findPerAnnoContabile(oanno.getIdannocontabile());
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdsottocategoria()),
							elencoAziende.get(i).getSottocategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, mapSottoCat);
		sessionMap.put(KEY_DATAINIZIO, oanno.getDatainizio());
		sessionMap.put(KEY_DATAFINE, oanno.getDatafine());
		sessionMap.put(KYE_OGGETTOANNO, oanno);
		return "search";
	}

	public String riconciliazione() {
		if(Integer.parseInt(this.idsottocategoria)==0) {
			addActionError("Selezionare una SottoCategoria per procedere");
		}
		if(this.datainizio==null) {
			addActionError("Inserire la Data da cui si vuole far partire la Riconciliazione");
		}
		if(this.datafine==null) {
			addActionError("Inserire la Data fino a cui si vuole Riconciliare");
		}
		if(getActionErrors().size()==0) {
		HashMap<String, String> mapSottoCat = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona la SottoCategoria: ");
				List<SottoCategoria> elencoAziende = oSottoCategoriaService.findAll();
				for (int i = 0; i < elencoAziende.size(); i++) {
					put(String.valueOf(elencoAziende.get(i).getIdsottocategoria()),
							elencoAziende.get(i).getSottocategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, mapSottoCat);
		sessionMap.put(KEY_OGGETTOSOTTOCATEGORIA,
				oSottoCategoriaService.findById(Integer.parseInt(this.idsottocategoria.replace("\'", ""))));
		SottoCategoria osottocategoria = oSottoCategoriaService
				.findById(Integer.parseInt(this.idsottocategoria.replace("\'", "")));
		List<OrdineDiAcquistoDettaglio> elenco = this.elencoOrdiniPerSottoCategoriaEData(osottocategoria);
		List<OrdineDiAcquistoDettaglio> result = new ArrayList<OrdineDiAcquistoDettaglio>();
		AnnoContabile oAnnoContabile = (AnnoContabile)sessionMap.get(KYE_OGGETTOANNO);
		for(int i=0; i<elenco.size();i++) {
			if(elenco.get(i).getOordineacquisto().getData().getTime()>=oAnnoContabile.getDatainizio().getTime()&&elenco.get(i).getOordineacquisto().getData().getTime()<=oAnnoContabile.getDatafine().getTime()) {
				result.add(elenco.get(i));
			}
		}
		float budgetspeso = 0;
		for (int i = 0; i < result.size(); i++) {
			budgetspeso = budgetspeso + result.get(i).getImporto();
		}
		osottocategoria.setBudgetspeso(budgetspeso);
		oSottoCategoriaService.persistOrUpdate(osottocategoria);
		return "riconciliazione";
		} else {
			return execute();
		}
	}

	public List<OrdineDiAcquistoDettaglio> elencoOrdiniPerSottoCategoriaEData(SottoCategoria osottocategoria) {
		OrdineDiAcquistoDettaglioDAO dao = new OrdineDiAcquistoDettaglioService().createDAO();
		dao.openCurrentSessionwithTransaction();
		AnnoContabile oanno = (AnnoContabile)sessionMap.get(KYE_OGGETTOANNO);
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineDiAcquistoDettaglio.class)
				.createAlias("ospesainvestimento", "o").createAlias("o.osottocategoria", "a")
				.add(Restrictions.eq("a.idsottocategoria", osottocategoria.getIdsottocategoria()));
		List<OrdineDiAcquistoDettaglio> result = criteria.list();
		List<OrdineDiAcquistoDettaglio> elenco = new ArrayList<OrdineDiAcquistoDettaglio>();
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getOordineacquisto().getData().getTime() >= oanno.getDatainizio().getTime()
					&& result.get(i).getOordineacquisto().getData().getTime() <= oanno.getDatafine().getTime())
				elenco.add(result.get(i));
		}
		dao.closeCurrentSessionwithTransaction();
		return elenco;
	}

	public String annulla() {
		String result = "annulla";
		return result;
	}
	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "riconciliazione");
		return "cambiaAnno";
	}
}
