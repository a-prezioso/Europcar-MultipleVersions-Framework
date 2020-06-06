package controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.FornitoreService;
import model.session.Fornitore;

public class GestioneFornitore extends ActionSupport implements SessionAware {

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
	private Fornitore ofornitore;
	private String ragionesociale;
	private String indirizzo;
	private String citta;
	private String cap;
	private String provincia;
	private String partitaiva;

	FornitoreService oForn = new FornitoreService();

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

	public Fornitore getOfornitore() {
		return ofornitore;
	}

	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}

	public String getRagionesociale() {
		return ragionesociale;
	}

	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPartitaiva() {
		return partitaiva;
	}

	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		List<Fornitore> ali = oForn.findAll();
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
			}
			else if(z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTE, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String prima() {
		List<Fornitore> ali = oForn.findAll();
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
		List<Fornitore> ali = oForn.findAll();
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
		List<Fornitore> ali = oForn.findAll();
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

	public String modificaFornitore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			sessionMap.put(KEY_OBJ, oForn.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			return "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante per effettuare modifiche");
			return execute();
		}
	}

	public String nuovoFornitore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		sessionMap.put(KEY_OBJ, new Fornitore());
		return "nuovomodifica";
	}

	public String eliminaFornitore() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oForn.deleteOj(oForn.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<Fornitore>) sessionMap.get(KEY_LIST)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare il fornitore poichè presente in altre tabelle");
				return execute();
			}
		} else
			addActionError("Valorizzare il pulsante per eliminare");
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String registra() {
		Fornitore oFornitore = (Fornitore) sessionMap.get(KEY_OBJ);
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(this.cap);
		if (!matcher.matches()) {
			addActionError("Inserire un carattere numerico nel campo cap");
			return "nuovomodifica";
		}
		if (this.cap.equalsIgnoreCase(""))
			addActionError("inserire il campo cap");
		else {
			oFornitore.setCap(cap);
		}
		matcher = pattern.matcher(this.partitaiva);
		if (!matcher.matches()) {
			addActionError("Inserire un carattere numerico nel campo partita iva");
		}
		if (this.partitaiva.equalsIgnoreCase(""))
			addActionError("inserire il campo partita iva");
		else {
			oFornitore.setPartitaiva(partitaiva);
		}
		Pattern patternStr = Pattern.compile("[A-Za-z]*");
		matcher = patternStr.matcher(this.citta);
		if (!matcher.matches()) {
			addActionError("Impossibile usare un carattere numerico nel campo città");
		}
		if (this.citta.equalsIgnoreCase(""))
			addActionError("inserire il campo citta");
		else {
			oFornitore.setCitta(citta);
		}

		matcher = patternStr.matcher(this.provincia);
		if (!matcher.matches()) {
			addActionError("Impossibile usare un carattere numerico nel campo provincia");
		}

		if (this.provincia.equalsIgnoreCase(""))
			addActionError("Inserire il campo provincia");
		else {
			oFornitore.setProvincia(provincia);
		}
		if (!this.indirizzo.equalsIgnoreCase(""))
			oFornitore.setIndirizzo(indirizzo);
		else
			addActionError("Inserire il campo indirizzo");
		if (!this.ragionesociale.equalsIgnoreCase(""))
			oFornitore.setRagionesociale(ragionesociale);
		else
			addActionError("Inserire il campo ragione sociale");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<Fornitore>) sessionMap.get(KEY_LIST)).size() - 1);
			oForn.persistOrUpdate(oFornitore);
			return execute();
		} else
			return "nuovomodifica";
	}

}