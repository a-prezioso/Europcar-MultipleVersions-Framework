package controller;


import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.AreaInvestimentoService;
import model.dao.SottoCategoriaService;
import model.dao.SpesaInvestimentoService;
import model.session.AnnoContabile;
import model.session.AreaInvestimento;
import model.session.SottoCategoria;
import model.session.SpesaInvestimento;


public class GestionePianoInvestimento extends ActionSupport implements SessionAware {

	//Attributi
	private String idanno;
	private SessionMap<String, Object> sessionMap;
	public final static String KEY_OK ="ok";
	public final static String KEY_LISTAANNI ="listaanni";
	public final static String KEY_ANNO ="anno";
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
	
	
	
	//Get e Set

	public String getIdanno() {
		return idanno;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public void setIdanno(String idanno) {
		this.idanno = idanno;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	

	
	
	public String execute() {
		List<AnnoContabile> ali =new AnnoContabileService().executeParamizedHQLQuery("FROM AnnoContabile ORDER BY datainizio ", AnnoContabile.class);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTAANNI, ali);
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
			} else {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		sessionMap.put(KEY_OK, false);
		String result ="search";
		return result;
	}
	
	public String prima() {
		List<AnnoContabile> ali = new AnnoContabileService().findAll();
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
		List<AnnoContabile> ali = new AnnoContabileService().findAll();
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
		List<AnnoContabile> ali = new AnnoContabileService().findAll();
		sessionMap.put(KEY_LISTAANNI, ali);
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

	
	
	public String generaPiano() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if(this.idanno!=null) {
		AnnoContabile oAnno = new AnnoContabileService().findById(Integer.parseInt(this.idanno.replace("\'","")));
		List<AreaInvestimento> elencoAree = new AreaInvestimentoService().findPerAnnoContabile(oAnno.getIdannocontabile());
		for(int i=0; i<elencoAree.size();i++) {
			int k=i+1;
			boolean trovato = false;
			while(k<elencoAree.size() && !trovato) {
				if(elencoAree.get(i).getArea().equalsIgnoreCase(elencoAree.get(k).getArea()) && elencoAree.get(i).getCodice().equalsIgnoreCase(elencoAree.get(k).getCodice())) {
					trovato = true;
				}
				k++;
			}
			if(!trovato)  {
				AreaInvestimento oArea = new AreaInvestimento();
				List<SottoCategoria> elencoSottoCat = new SottoCategoriaService().findPerAreaInvestimento(elencoAree.get(i).getIdarea());
				oArea = elencoAree.get(i);
				new AreaInvestimentoService().persist(oArea);
				for(int j=0; j<elencoSottoCat.size();j++) {
					
					
						SottoCategoria oSottoCategoria = new SottoCategoria();
						List<SpesaInvestimento> elencoSpese = new SpesaInvestimentoService().findPerSottoCategoria(elencoSottoCat.get(j).getIdsottocategoria());
						oSottoCategoria = elencoSottoCat.get(j);
						oSottoCategoria.setOarea(oArea);
						new SottoCategoriaService().persist(oSottoCategoria);
						for(int z=0; z<elencoSpese.size();z++) {
								SpesaInvestimento oSpesa = new SpesaInvestimento();
								oSpesa = elencoSpese.get(z);
								oSpesa.setOsottocategoria(oSottoCategoria);
								new SpesaInvestimentoService().persist(oSpesa);
							}
						}
					
				}
			}
		
		sessionMap.put(KEY_OK, true);
		String result ="search";
		return result;
		} else {
			addActionError("Selezionare un Piano D'Investimento per proseguire");
			String result ="search";
			return result;
		}
	}
	
}
