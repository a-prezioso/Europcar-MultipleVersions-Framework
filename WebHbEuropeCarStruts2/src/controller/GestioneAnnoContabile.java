package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.session.AnnoContabile;

public class GestioneAnnoContabile extends ActionSupport implements SessionAware {
	AnnoContabileService oAnnoContabileService = new AnnoContabileService();
	// Attributi
	private String chiave;
	public static final String KEY_ANNO = "oggetto";
	public static final String KEY_ANNOOLD = "oggettovecchio";
	public static final String KEY_LISTANNI = "lista";
	public static final String KEY_PAGINE = "pagine";
	public static final String KEY_PAGINACORRENTE = "paginacorrente";
	public static final String KEY_INIZIO = "inizio";
	public static final String KEY_FINE = "fine";
	public static final String KEY_CONTROLLO = "controllo";
	public static final String KEY_CONTROLLOINDIETRO = "controlloindietro";
	public static final String KEY_CONTROLLOFINE = "controllofine";
	public static final String KEY_CONTROLLONUOVOMODIFICA = "controllonuovomodifica";
	public static final String KEY_SIZE = "size";
	public static final String KEY_A = "a";
	public static final String KEY_B = "b";
	private boolean nuovomodifica;
	private AnnoContabile oAnnoContabile;
	private SessionMap<String, Object> sessionMap;
	private String desrizionevar;
	private Date datainiziovar;
	private Date datafinevar;

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

	public AnnoContabile getoAnnoContabile() {
		return oAnnoContabile;
	}

	public void setoAnnoContabile(AnnoContabile oAnnoContabile) {
		this.oAnnoContabile = oAnnoContabile;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getDesrizionevar() {
		return desrizionevar;
	}

	public void setDesrizionevar(String desrizionevar) {
		this.desrizionevar = desrizionevar;
	}

	public Date getDatainiziovar() {
		return datainiziovar;
	}

	public void setDatainiziovar(Date datainiziovar) {
		this.datainiziovar = datainiziovar;
	}

	public Date getDatafinevar() {
		return datafinevar;
	}

	public void setDatafinevar(Date datafinevar) {
		this.datafinevar = datafinevar;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		List<AnnoContabile> ali = oAnnoContabileService.executeParamizedHQLQuery("FROM AnnoContabile ORDER BY datainizio ", AnnoContabile.class);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICA);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTANNI, ali);
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
			}
			else if(z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
			
		}
		for(int i=0; i<ali.size();i++) {
			Date data= ali.get(i).getDatafine();
			Date data2= ali.get(i).getDatainizio();
			 Calendar datainizio = Calendar.getInstance();
			 datainizio.setTime(ali.get(i).getDatainizio());
			 datainizio.set(Calendar.HOUR_OF_DAY, 0);
			 datainizio.set(Calendar.MINUTE, 0);
			 datainizio.set(Calendar.SECOND, 0);
			 datainizio.set(Calendar.MILLISECOND, 0);
			 
			 Calendar datafine = Calendar.getInstance();
			 datafine.setTime(ali.get(i).getDatafine());
			 datafine.set(Calendar.HOUR_OF_DAY, 0);
			 datafine.set(Calendar.MINUTE, 0);
			 datafine.set(Calendar.SECOND, 0);
			 datafine.set(Calendar.MILLISECOND, 0);
			 ali.get(i).setDatainizio(datainizio.getTime());
			 ali.get(i).setDatafine(datafine.getTime());		
		}
		for(int i=0; i<ali.size();i++) {
            Date data= ali.get(i).getDatafine();
            Date data2= ali.get(i).getDatainizio();
             Calendar datainizio = Calendar.getInstance();
             datainizio.setTime(ali.get(i).getDatainizio());
             datainizio.set(Calendar.HOUR_OF_DAY, 0);
             datainizio.set(Calendar.MINUTE, 0);
             datainizio.set(Calendar.SECOND, 0);
             datainizio.set(Calendar.MILLISECOND, 0);
             
             Calendar datafine = Calendar.getInstance();
             datafine.setTime(ali.get(i).getDatafine());
             datafine.set(Calendar.HOUR_OF_DAY, 0);
             datafine.set(Calendar.MINUTE, 0);
             datafine.set(Calendar.SECOND, 0);
             datafine.set(Calendar.MILLISECOND, 0);
             ali.get(i).setDatainizio(datainizio.getTime());
             ali.get(i).setDatafine(datafine.getTime());        
        }

		return "search";
	}

	public String prima() {
		List<AnnoContabile> ali = oAnnoContabileService.findAll();
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
		List<AnnoContabile> ali = oAnnoContabileService.findAll();
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
		List<AnnoContabile> ali = oAnnoContabileService.findAll();
		sessionMap.put(KEY_LISTANNI, ali);
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

	public String eliminaAnno() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			oAnnoContabileService.deleteOj(oAnnoContabileService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(KEY_SIZE, ((List<AnnoContabile>) sessionMap.get(KEY_LISTANNI)).size() - 1);

		} else
			addActionError("Selezionare un anno per poterlo eliminarlo");
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String nuovaAnno() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		AnnoContabile oAnnoContabile = new AnnoContabile();
		List<AnnoContabile> elenco = new AnnoContabileService().executeParamizedHQLQuery(
				"FROM AnnoContabile WHERE idannocontabile = (SELECT MAX(idannocontabile) FROM AnnoContabile)",
				AnnoContabile.class);
		AnnoContabile oAnnoContabileVecchio = elenco.get(0);
		Calendar data = Calendar.getInstance();
		data.setTime(oAnnoContabileVecchio.getDatafine());
		data.add(Calendar.YEAR, 1);
		Calendar data2 = Calendar.getInstance();
		data2.setTime(oAnnoContabileVecchio.getDatainizio());
		data2.add(Calendar.YEAR, 1);
		int a = data2.get(Calendar.YEAR);
		String b = String.valueOf(a);
		int c = data.get(Calendar.YEAR);
		String d = String.valueOf(c);
		oAnnoContabile.setDescrizione(b + "/" + d);
		oAnnoContabile.setDatainizio((data2.getTime()));
		oAnnoContabile.setDatafine(data.getTime()); 
		sessionMap.put(KEY_SIZE, ((List<AnnoContabile>) sessionMap.get(KEY_LISTANNI)).size() - 1);
		oAnnoContabileService.persistOrUpdate(oAnnoContabile);
		return execute();
		
	}
	
}
