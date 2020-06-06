package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.SottoCategoriaService;
import model.dao.SpesaInvestimentoService;
import model.session.AliquotaIva;
import model.session.AnnoContabile;
import model.session.Previsione;
import model.session.SottoCategoria;
import model.session.SpesaInvestimento;

public class GestioneSpesaInvestimento extends ActionSupport implements SessionAware {
	SpesaInvestimentoService oSpesaInvestimentoService = new SpesaInvestimentoService();
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	// Attributi
	private String chiave;
	private SessionMap<String, Object> sessionMap;
	public String idsottocategoria;
	private SpesaInvestimento oSpesaInvestimento;
	private String spesainvvar;
	public static final String KEY_OGGETTOSPESA = "oggettospesa";
	public static final String KEY_OGGETTOSOTTOCAT = "oggettosottocategoria";
	public static final String KEY_LISTASPESE = "listaspese";
	public static final String KEY_LISTASOTTOCAT = "listasottocategorie";
	public static final String KEY_OGGETTOANNO = "oggettoanno";
	public static final String KEY_JSP = "jsp";
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

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(String idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public SpesaInvestimento getoSpesaInvestimento() {
		return oSpesaInvestimento;
	}

	public void setoSpesaInvestimento(SpesaInvestimento oSpesaInvestimento) {
		this.oSpesaInvestimento = oSpesaInvestimento;
	}

	public String getSpesainvvar() {
		return spesainvvar;
	}

	public void setSpesainvvar(String spesainvvar) {
		this.spesainvvar = spesainvvar;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		String result = "search";
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		LinkedHashMap<String, String> mapSotCat = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una sottocategoria");
				List<SottoCategoria> elencoSottoCategorie = oSottoCategoriaService
						.findPerAnnoContabile(oanno.getIdannocontabile());
				for (int i = 0; i < elencoSottoCategorie.size(); i++) {
					put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
							elencoSottoCategorie.get(i).getSottocategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCAT, mapSotCat);
		sessionMap.put(KEY_JSP, false);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_SIZE, null);
		return result;
	}

	public String cerca() {
		if (Integer.parseInt(this.idsottocategoria) != 0) {
			AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
			long datainizio = oanno.getDatainizio().getTime();
			long datafine =  oanno.getDatafine().getTime();
			List<SottoCategoria> elenco = oSottoCategoriaService.findAll();
			List<SottoCategoria> elencoSottoCategorie = new ArrayList<SottoCategoria>();
			for (int i = 0; i < elenco.size(); i++) {
				if (elenco.get(i).getOarea().getOannocontabile().getDatainizio().getTime() >= datainizio && elenco.get(i).getOarea().getOannocontabile().getDatafine().getTime() <= datafine) {
					elencoSottoCategorie.add(elenco.get(i));
				}
			}
			LinkedHashMap<String, String> mapSotCat = new LinkedHashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona una sottocategoria");
					for (int i = 0; i < elencoSottoCategorie.size(); i++) {
						put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
								elencoSottoCategorie.get(i).getSottocategoria());
					}
				}
			};
			sessionMap.put(KEY_LISTASOTTOCAT, mapSotCat);
			List<SpesaInvestimento> elencoSpese = oSpesaInvestimentoService.findWithCriteria(
					Restrictions.eq(SpesaInvestimento.PROPERTY_IDSOTCAT + "." + SottoCategoria.PROPERTY_ID,
							Integer.parseInt(this.idsottocategoria.replace("\'", ""))));
			List<SpesaInvestimento> result = new ArrayList<SpesaInvestimento>();
			for (int i = 0; i < elencoSpese.size(); i++) {
				if (elencoSpese.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatainizio().getTime() >= datainizio
						&& elencoSpese.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatafine()
								.getTime() <= datafine) {
					result.add(elencoSpese.get(i));
				}
			}
			sessionMap.put(KEY_JSP, true);

			sessionMap.put(KEY_OGGETTOSOTTOCAT,
					oSottoCategoriaService.findById(Integer.parseInt(this.idsottocategoria.replace("\'", ""))));
			List<SpesaInvestimento> ali = result;
			sessionMap.put(KEY_LISTASPESE, ali);
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
					if (k > 1)
						sessionMap.put(KEY_CONTROLLOINDIETRO, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETRO, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
				}
			}
			return "cerca";
		} else {
			addActionError("Selezionare una SottoCateogoria per proseguire");
			if ((boolean) sessionMap.get(KEY_JSP)) {
				return "cerca";
			} else {
				return execute();
			}
		}
	}

	public String avanti() {
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		List<SpesaInvestimento> elenco = oSpesaInvestimentoService.findWithCriteria(
				Restrictions.eq(SpesaInvestimento.PROPERTY_IDSOTCAT + "." + SottoCategoria.PROPERTY_ID,
						((SottoCategoria) sessionMap.get(KEY_OGGETTOSOTTOCAT)).getIdsottocategoria()));
		List<SpesaInvestimento> result = new ArrayList<SpesaInvestimento>();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatainizio().getTime() >= oanno
					.getDatainizio().getTime()
					&& elenco.get(i).getOsottocategoria().getOarea().getOannocontabile().getDatafine()
							.getTime() <= oanno.getDatafine().getTime()) {
				result.add(elenco.get(i));
			}
		}
		List<SpesaInvestimento> ali = result;
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTASPESE, ali);
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
				sessionMap.put(KEY_CONTROLLOINDIETRO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "cerca";
	}

	public String prima() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESE);
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

	public String indietro() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESE);
		sessionMap.put(KEY_LISTASPESE, ali);
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

	public String ultima() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESE);
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

	public String nuovaSpesaInvestimento() {
		AnnoContabile oanno = (AnnoContabile) sessionMap.get(KEY_OGGETTOANNO);
		LinkedHashMap<String, String> mapSotCat = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una sottocategoria");
				List<SottoCategoria> elencoSottoCategorie = oSottoCategoriaService
						.findPerAnnoContabile(oanno.getIdannocontabile());
				for (int i = 0; i < elencoSottoCategorie.size(); i++) {
					put(String.valueOf(elencoSottoCategorie.get(i).getIdsottocategoria()),
							elencoSottoCategorie.get(i).getSottocategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCAT, mapSotCat);
		sessionMap.put(KEY_OGGETTOSPESA, new SpesaInvestimento());
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		String result = "nuovomodifica";
		return result;
	}

	public String modificaSpesaInvestimento() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			sessionMap.put(KEY_OGGETTOSPESA,
					oSpesaInvestimentoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(KEY_OGGETTOSOTTOCAT, (SottoCategoria) sessionMap.get(KEY_OGGETTOSOTTOCAT));
			String result = "nuovomodifica";
			return result;
		} else {
			addActionError("Selezionare una Spesa Investimento per poterla modificare");

			return "cerca";
		}
	}

	public String eliminaSpesaInvestimento() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oSpesaInvestimentoService
						.deleteOj(oSpesaInvestimentoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			} catch (PersistenceException e) {
				addActionError("Impossibile eliminare la spesa d'investimento poichè presente in un'altra tabella! ");
			}
			return avanti();
		} else {
			addActionError("Selezionare una Spesa per poterla eliminare");
			return "cerca";
		}
	}

	public String annulla() {
		return "cerca";
	}

	public String registraSpesaInvestimento() {
		SpesaInvestimento oSpesaInvestimento = (SpesaInvestimento) sessionMap.get(KEY_OGGETTOSPESA);
		if (oSpesaInvestimento.getIdspesainvestimento() == 0) {
			if (Integer.parseInt(this.idsottocategoria) != 0)
				oSpesaInvestimento.setOsottocategoria(
						oSottoCategoriaService.findById(Integer.parseInt(this.idsottocategoria.replace("\'", ""))));
			else
				addActionError("Inserire una SottoCateogoria per poter salvare");
		} else
			oSpesaInvestimento.setOsottocategoria((SottoCategoria) sessionMap.get(KEY_OGGETTOSOTTOCAT));
		if (!this.spesainvvar.equalsIgnoreCase(""))
			oSpesaInvestimento.setSpesainvestimento(this.spesainvvar);
		else
			addActionError("Inserire la Descrizione della Spesa per poter salvare");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESE)).size() - 1);

			oSpesaInvestimentoService.persistOrUpdate(oSpesaInvestimento);

			return avanti();
		} else {
			return "nuovomodifica";
		}
	}

}
