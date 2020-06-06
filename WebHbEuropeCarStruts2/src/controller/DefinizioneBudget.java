package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AreaInvestimentoService;
import model.dao.PrevisioneDAO;
import model.dao.PrevisioneService;
import model.dao.SottoCategoriaDAO;
import model.dao.SottoCategoriaService;
import model.session.AreaInvestimento;
import model.session.Previsione;
import model.session.SottoCategoria;

public class DefinizioneBudget extends ActionSupport implements SessionAware {
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();

	// Attributi
	private String chiave;
	private SessionMap<String, Object> sessionMap;
	private SottoCategoria oSottoCategoria;
	public static final String KEY_LISTAREE = "listaaree";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	public static final String KEY_IDAREA = "mapidarea";
	public static final String KEY_LISTASOTTOCAT = "listasottocategorie";
	public static final String KEY_OGGETTOSOTTOCAT = "oggettosottocategoria";
	public static final String KEY_OGGETTOTOTALE = "totale";
	public static final String KEY_TOTALEPREV = "totaleprev";
	public static final String KEY_VALPREVISIONALE = "elencoprevisionali";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_INIZIOP = "inizioprev";
	public static final String KEY_FINE = "fine";
	public static final String KEY_FINEP = "fineprev";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	private boolean nuovomodifica;
	private String idarea;
	private String budjetvar;
	public static final String KEY_STRUTSANNO = "prova";
	public static final String KEY_JSP = "jsp";

	// Get e Set
	
	

	public String getChiave() {
		return chiave;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public String getBudjetvar() {
		return budjetvar;
	}

	public void setBudjetvar(String budjetvar) {
		this.budjetvar = budjetvar;
	}

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
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
		String result = "search";
		HashMap<String, String> mapAreaInvestimento = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il AreaInvestimento: ");
				List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_LISTAREE, mapAreaInvestimento);
		sessionMap.put(KEY_JSP, false);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_INIZIOP, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_FINEP, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return result;
	}

	public String cercaSottoCategoriePerArea() {
		if (Integer.parseInt(this.idarea) != 0) {
			sessionMap.put(KEY_OGGETTOAREA,
					new AreaInvestimentoService().findById(Integer.parseInt(this.idarea.replace("\'", ""))));
			sessionMap.put(KEY_IDAREA, this.idarea);
			SottoCategoriaDAO dao = oSottoCategoriaService.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class)
					.createAlias("oarea", "o")
					.add(Restrictions.eq("o.idarea", Integer.parseInt(this.idarea.replace("\'", ""))));
			List<SottoCategoria> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			HashMap<String, String> mapAreaInvestimento = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il AreaInvestimento: ");
					List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			List<Float> elencoValori = new ArrayList<Float>();
			PrevisioneDAO daoo = new PrevisioneService().createDAO();
            daoo.openCurrentSessionwithTransaction();
            for(int i=0; i<result.size();i++) {
                
                Criteria criteria2 = daoo.getCurrentSession().createCriteria(Previsione.class)
                        .createAlias("osottocategoria", "o")
                        .add(Restrictions.eq("o.idsottocategoria", result.get(i).getIdsottocategoria()));
                List<Previsione> elenco = criteria2.list();
                Float previsionale=0.0f;
                for(int j=0;j<elenco.size();j++) {
                    previsionale = previsionale +(elenco.get(j).getPotenzialeeuropecar()+elenco.get(j).getShareante()-elenco.get(j).getSharepost());
                }
                elencoValori.add(previsionale);
            }
            daoo.closeCurrentSessionwithTransaction();
            float totale =0;
            for(int i=0; i<result.size();i++) {
                totale = totale + result.get(i).getBudget();
            }
            float totalePrev = 0;
            for(int i=0; i<elencoValori.size();i++) {
                totalePrev = totalePrev + elencoValori.get(i);
            }
			sessionMap.put(KEY_OGGETTOTOTALE, totale);
			sessionMap.put(KEY_TOTALEPREV, totalePrev);
			sessionMap.put(KEY_LISTAREE, mapAreaInvestimento);
			sessionMap.put(KEY_LISTASOTTOCAT, result);
			sessionMap.put(KEY_VALPREVISIONALE, elencoValori);
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
						sessionMap.put(KEY_INIZIOP, j);
						sessionMap.put(KEY_FINE, i);
						sessionMap.put(KEY_FINEP, i);
					
						sessionMap.put(KEY_CONTROLLOFINE, true);
						sessionMap.put(KEY_CONTROLLOINDIETRO, true);
					} else if (j <= z) {
						sessionMap.put(KEY_INIZIO, j);
						sessionMap.put(KEY_INIZIOP, j);
						
						sessionMap.put(KEY_FINE, z);
						sessionMap.put(KEY_FINEP, z);
					
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
				sessionMap.put(KEY_INIZIOP, 0);
			
				if (9 >= z) {
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_FINEP, z);
				
					sessionMap.put(KEY_CONTROLLOFINE, false);
				} else {
					sessionMap.put(KEY_FINE, 9);
					sessionMap.put(KEY_FINEP, 9);
					
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
				sessionMap.put(KEY_FINEP, z);
			
				sessionMap.put(KEY_CONTROLLOFINE, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIO, w - 10);
				sessionMap.put(KEY_INIZIOP, w - 10);
			
				sessionMap.put(KEY_FINE, z);
				sessionMap.put(KEY_FINEP, z);
			
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10));
			}
			if (sessionMap.get(KEY_SIZE) != null) {
				sessionMap.put(KEY_SIZE, null);
				int sizevecchia = (int) sessionMap.get(KEY_SIZE);
				if (z > sizevecchia) {
					String y = String.valueOf(z);
					char l = y.charAt(a.length() - 1);
					String x = String.valueOf(y.replace(l, '0'));
					sessionMap.put(KEY_INIZIO, Integer.parseInt(x));
					sessionMap.put(KEY_INIZIOP, Integer.parseInt(x));
				
					sessionMap.put(KEY_PAGINACORRENTE, k);
					sessionMap.put(KEY_FINE, z);
					sessionMap.put(KEY_FINEP, z);
					
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
			return "ricerca";
		} else {
			addActionError("Selezionare un'Area per poter proseguire");
			if ((boolean) sessionMap.get(KEY_JSP)) {
				return "ricerca";
			} else
				return execute();
		}
	}

	public String definizione() {
		if ((this.chiave) != null) {
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
			sessionMap.put(KEY_OGGETTOAREA, (AreaInvestimento) sessionMap.get(KEY_OGGETTOAREA));
			sessionMap.put(KEY_OGGETTOSOTTOCAT,
					new SottoCategoriaService().findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "definizione";
		} else {
			addActionError("Valorizzare una SottoCategoria per potervi definire un Budget");
			return "ricerca";
		}
	}
	
	
	
	public String prima() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCAT);
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
		sessionMap.put(KEY_INIZIOP, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINE, z);
			sessionMap.put(KEY_FINEP, z);
		} else {
			sessionMap.put(KEY_FINE, 9);
			sessionMap.put(KEY_FINEP, 9);
		}
		sessionMap.put(KEY_CONTROLLO, true);
		sessionMap.put(KEY_CONTROLLOFINE, true);
		sessionMap.put(KEY_CONTROLLOINDIETRO, false);
		return "ricerca";
	}

	public String ultima() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCAT);
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
		sessionMap.put(KEY_INIZIOP, q*10);
		sessionMap.put(KEY_FINE, z);
		sessionMap.put(KEY_FINEP, z);
		sessionMap.put(KEY_CONTROLLOFINE, false);
		sessionMap.put(KEY_CONTROLLOINDIETRO, true);
		return "ricerca";
	}

	public String indietro() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCAT);
		int i = (int) sessionMap.get(KEY_INIZIO) - 10;
		int j = (int) sessionMap.get(KEY_FINE) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIO, i);
			sessionMap.put(KEY_INIZIOP, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_FINEP, j);
				sessionMap.put(KEY_CONTROLLOFINE, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINE, j);
				sessionMap.put(KEY_FINEP, j);
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

		return "ricerca";
	}

	public String cerca() {
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return cercaSottoCategoriePerArea();
	}

	public String registra() {
		Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
		Matcher matcher = pattern.matcher(this.budjetvar);
		if (!matcher.matches()) {
			addActionError("Impossibile inserire altri caratteri oltrei i numeri nel campo Budget");
		} else {
			if (Float.parseFloat(this.budjetvar) == 0.0) {
				addActionError("Impossibile definire un Budget a 0 ");
			}

		}

		if (getActionErrors().size() == 0) {
			SottoCategoria oSottoCategoria = (SottoCategoria) sessionMap.get(KEY_OGGETTOSOTTOCAT);
			oSottoCategoria.setBudget(Float.parseFloat(this.budjetvar));
			oSottoCategoriaService.persistOrUpdate(oSottoCategoria);
			HashMap<String, String> mapAreaInvestimento = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il AreaInvestimento: ");
					List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findAll();
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			sessionMap.put(KEY_LISTAREE, mapAreaInvestimento);
			sessionMap.put(KEY_OGGETTOAREA, (AreaInvestimento) sessionMap.get(KEY_OGGETTOAREA));
			SottoCategoriaDAO dao = oSottoCategoriaService.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class).createAlias("oarea", "o")
					.add(Restrictions.eq("o.idarea", ((AreaInvestimento) sessionMap.get(KEY_OGGETTOAREA)).getIdarea()));
			List<SottoCategoria> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			sessionMap.put(KEY_LISTASOTTOCAT, result);
			float totale = 0;
			for (int i = 0; i < result.size(); i++) {
				totale = totale + result.get(i).getBudget();
			}
			sessionMap.put(KEY_OGGETTOTOTALE, totale);
			return "ricerca";
		} else {
			return "definizione";
		}
	}

	public String chiudi() {
		return "gestionebudget";
	}

	public String annulla() {
		return "ricerca";
	}

	public String elencoSottoCategorie() {
		return "sottocategoria";
	}

	public String cambiaAnno() {
		sessionMap.put(KEY_STRUTSANNO, "definizione");
		return "cambiaAnno";
	}

}
