package controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.components.ActionError;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AliquotaIvaService;
import model.session.AliquotaIva;

public class GestioneAliquotaIva extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "lista";
	public static final String KEY_OBJ = "oggetto";
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
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private AliquotaIva oaliquotaiva;
	private String descrizioneAli;
	private String aliquotaAli;

	AliquotaIvaService oAli = new AliquotaIvaService();

	// Get e set

	public String getChiave() {
		return chiave;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public AliquotaIva getOaliquotaiva() {
		return oaliquotaiva;
	}

	public void setOaliquotaiva(AliquotaIva oaliquotaiva) {
		this.oaliquotaiva = oaliquotaiva;
	}

	public String getDescrizioneAli() {
		return descrizioneAli;
	}

	public void setDescrizioneAli(String descrizioneAli) {
		this.descrizioneAli = descrizioneAli;
	}

	public String getAliquotaAli() {
		return aliquotaAli;
	}

	public void setAliquotaAli(String aliquotaAli) {
		this.aliquotaAli = aliquotaAli;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	
	
	public String execute() {
		List<AliquotaIva> ali = oAli.findAll();
		sessionMap.put(KEY_LIST, ali);
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
				if(k>1)
				sessionMap.put(KEY_CONTROLLOINDIETRO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETRO, false);
			}
			else if(z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	
	public String prima() {
		List<AliquotaIva> ali = oAli.findAll();
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
		List<AliquotaIva> ali = oAli.findAll();
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
		List<AliquotaIva> ali = oAli.findAll();
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
	
	
	public String modificaAliquota() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			sessionMap.put(KEY_OBJ, oAli.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante per effettuare modifiche");
			return execute();
		}
	}

	
	public String nuovaAliquota() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		sessionMap.put(KEY_OBJ, new AliquotaIva());
		return "nuovomodifica";
	}


	
	public String eliminaAliquota() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oAli.deleteOj(oAli.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<AliquotaIva>) sessionMap.get(KEY_LIST)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare l'aliquota poichè presente in altre tabelle");
				return execute();
			}
		} else
			addActionError("Valorizzare il pulsante per eliminare");
		return execute();
	}

	
	public String annulla() {
		return execute();
	}

//	public String specify() {
//		return "search"
//	}

	public String registra() {
		AliquotaIva oAliquotaIva = (AliquotaIva) sessionMap.get(KEY_OBJ);
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(this.aliquotaAli);
		if (!matcher.matches()) {
			addActionError("Inserire il carattere corretto nel campo aliquota");
			return "nuovomodifica";
		} else {
			if (this.aliquotaAli.equalsIgnoreCase("") || Integer.parseInt(this.aliquotaAli) == 0)
				addActionError("Aliquota Iva non inserita");
			else
				oAliquotaIva.setAliquota(Integer.parseInt(aliquotaAli));
			if (!descrizioneAli.equalsIgnoreCase(""))
				oAliquotaIva.setDescrizione(descrizioneAli);
			else
				addActionError("Descrizione non inserita");
			if (getActionErrors().size() == 0) {
				sessionMap.put(KEY_SIZE, ((List<AliquotaIva>) sessionMap.get(KEY_LIST)).size() - 1);
				oAli.persistOrUpdate(oAliquotaIva);
				return execute();
			} else
				return "nuovomodifica";
		}
	}
}