package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AziendaService;
import model.dao.GruppoService;
import model.session.AliquotaIva;
import model.session.Azienda;
import model.session.Gruppo;

public class GestioneAzienda extends ActionSupport implements SessionAware {
	AziendaService oAziendaService = new AziendaService();
	GruppoService oGruppoService = new GruppoService();

	// Attributi
	private String chiave;
	private Azienda oAzienda;
	public static final String KEY_AZIENDA = "oggetto";
	public static final String KEY_GRUPPO = "listagruppi";
	public static final String KEY_LIST = "lista";
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
	private String ragSoc;
	private String indirizz;
	private String cid;
	private String idgruppo;
	AziendaService oAzi = new AziendaService();

	// Get e Set
	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public Azienda getoAzienda() {
		return oAzienda;
	}

	public void setoAzienda(Azienda oAzienda) {
		this.oAzienda = oAzienda;
	}

	public String getRagSoc() {
		return ragSoc;
	}

	public void setRagSoc(String ragSoc) {
		this.ragSoc = ragSoc;
	}

	public String getIndirizz() {
		return indirizz;
	}

	public void setIndirizz(String indirizz) {
		this.indirizz = indirizz;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getIdgruppo() {
		return idgruppo;
	}

	public void setIdgruppo(String idgruppo) {
		this.idgruppo = idgruppo;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		List<Azienda> ali = oAzi.findAll();
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
		List<Azienda> ali = oAzi.findAll();
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
		List<Azienda> ali = oAzi.findAll();
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
		List<Azienda> ali = oAzi.findAll();
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

	public String nuovaAzienda() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		HashMap<String, String> mapGruppo = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Gruppo: ");
				List<Gruppo> elencoGruppi = oGruppoService.findAll();
				for (int i = 0; i < elencoGruppi.size(); i++) {
					put(String.valueOf(elencoGruppi.get(i).getIdgruppo()), elencoGruppi.get(i).getNomeGruppo());
				}
			}
		};
		sessionMap.put(KEY_GRUPPO, mapGruppo);
		sessionMap.put(KEY_AZIENDA, new Azienda());
		String result = "nuovomodifica";
		return result;
	}

	public String modificaAzienda() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
			HashMap<String, String> mapGruppo = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona il Gruppo: ");
					List<Gruppo> elencoGruppi = oGruppoService.findAll();
					for (int i = 0; i < elencoGruppi.size(); i++) {
						put(String.valueOf(elencoGruppi.get(i).getIdgruppo()), elencoGruppi.get(i).getNomeGruppo());
					}
				}
			};
			sessionMap.put(KEY_AZIENDA, oAziendaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
			sessionMap.put(KEY_GRUPPO, mapGruppo);
			return "nuovomodifica";
		} else {
			addActionError("Valorizzare il pulsante per effettuare modifiche");
			return execute();
		}
	}

	public String annulla() {
		return execute();
	}

	public String eliminaAzienda() {
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, true);
		if (this.chiave != null) {
			try {
				oAziendaService.deleteOj(oAziendaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
				sessionMap.put(KEY_SIZE, ((List<Azienda>) sessionMap.get(KEY_LIST)).size() - 1);
			} catch (PersistenceException e) {
				addActionError("Non è possibile eliminare l'azienda poichè presente in altre tabelle");
				return execute();
			}
		} else
			addActionError("Valorizzare il pulsante per eliminare");
		return execute();
	}

	public String registraAzienda() {
		Azienda oAzienda = (Azienda) sessionMap.get(KEY_AZIENDA);
		if (!this.cid.equalsIgnoreCase(""))
			oAzienda.setContractID(this.cid);
		else
			addActionError("inserire il contractID");
		if (!this.indirizz.equalsIgnoreCase(""))
			oAzienda.setIndirizzo(this.indirizz);
		else
			addActionError("inserire il campo indirizzo");
		if (!this.ragSoc.equalsIgnoreCase(""))
			oAzienda.setRagioneSociale(this.ragSoc);
		else
			addActionError("inserire il campo indirizzo");
		if (Integer.parseInt(this.idgruppo) != 0)
			oAzienda.setOgruppo(oGruppoService.findById(Integer.parseInt(this.idgruppo.replace("\'", ""))));
		else
			addActionError("Inserire il gruppo per questa Azienda");
		if (getActionErrors().size() == 0) {
			sessionMap.put(KEY_SIZE, ((List<Azienda>) sessionMap.get(KEY_LIST)).size() - 1);
			oAziendaService.persistOrUpdate(oAzienda);
			return execute();
		} else
			return "nuovomodifica";
	}
}
