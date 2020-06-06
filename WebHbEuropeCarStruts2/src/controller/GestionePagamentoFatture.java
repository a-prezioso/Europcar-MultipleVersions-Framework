package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.FatturaPassivaDettaglioService;
import model.dao.FornitoreService;
import model.session.AnnoContabile;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;

public class GestionePagamentoFatture extends ActionSupport implements SessionAware{
	FatturaPassivaDettaglioService oFatturaPassivaDettaglioService = new FatturaPassivaDettaglioService();
	//Attributi
	public static final String KEY_LISTAFATTURE ="listafatture";
	public static final String KEY_OGGETTOFATTURA ="oggettofattura";
	public static final String KEY_LISTAFORNITORI ="listafornitori";
	public static final String KEY_OGGETTOANNO ="oggettoanno";
	public static final String KEY_IDFORNITORE="idfornitore";
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private String importovar;
	private String importopagatovar;
	private String idfornitorevar;
	private String descrizionevar;
	private FatturaPassivaDettaglio ofattura;
	
	
	//Get eSet
	
	public String getChiave() {
		return chiave;
	}
	public String getDescrizionevar() {
		return descrizionevar;
	}
	public void setDescrizionevar(String descrizionevar) {
		this.descrizionevar = descrizionevar;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getImportovar() {
		return importovar;
	}
	public void setImportovar(String importovar) {
		this.importovar = importovar;
	}
	public String getImportopagatovar() {
		return importopagatovar;
	}
	public void setImportopagatovar(String importopagatovar) {
		this.importopagatovar = importopagatovar;
	}
	public String getIdfornitorevar() {
		return idfornitorevar;
	}
	public void setIdfornitorevar(String idfornitorevar) {
		this.idfornitorevar = idfornitorevar;
	}
	public FatturaPassivaDettaglio getOfattura() {
		return ofattura;
	}
	public void setOfattura(FatturaPassivaDettaglio ofattura) {
		this.ofattura = ofattura;
	}
	
	
	//Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	public String execute() {
		String result ="search";
		HashMap<String, String> mapFornitori = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Fornitore: ");
				List<Fornitore> elencoFornitori = new FornitoreService().findAll();
				for(int i=0; i < elencoFornitori.size();i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()), elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(KEY_LISTAFATTURE, null);
		sessionMap.put(KEY_LISTAFORNITORI, mapFornitori);
		
		return result;
	}
	public String cerca() {
		if(!this.idfornitorevar.equalsIgnoreCase("0")) {
			sessionMap.put(KEY_IDFORNITORE, this.idfornitorevar);
		AnnoContabile oanno = (AnnoContabile)sessionMap.get(KEY_OGGETTOANNO);
		HashMap<String, String> mapFornitori = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona il Fornitore: ");
				List<Fornitore> elencoFornitori = new FornitoreService().findAll();
				for(int i=0; i < elencoFornitori.size();i++) {
					put(String.valueOf(elencoFornitori.get(i).getIdfornitore()), elencoFornitori.get(i).getRagionesociale());
				}
			}
		};
		sessionMap.put(KEY_LISTAFORNITORI, mapFornitori);
		Fornitore oFornitore = new FornitoreService().findById(Integer.parseInt(this.idfornitorevar.replace("\'","")));
		List<FatturaPassivaDettaglio> elencoFatture =oFatturaPassivaDettaglioService.elencoFatturaPassivaDettaglioPerFornitore(oFornitore);
		List<FatturaPassivaDettaglio> elenco = new ArrayList<FatturaPassivaDettaglio>();
		for(int i=0; i<elencoFatture.size();i++) {
			if(elencoFatture.get(i).getOspesainvestimento().getOsottocategoria().getOarea().getOannocontabile().getDatainizio().getTime()>=oanno.getDatainizio().getTime()&&elencoFatture.get(i).getOspesainvestimento().getOsottocategoria().getOarea().getOannocontabile().getDatafine().getTime()<=oanno.getDatafine().getTime()) {
				elenco.add(elencoFatture.get(i));
			}
		}
		sessionMap.put(KEY_LISTAFATTURE, elenco);
		return "search";
		}
		else {
			addActionError("Inserire un fornitore per poter proseguire");
			return execute();
		}
	}
	public String pagamento() {
		if(this.chiave!=null) {
		sessionMap.put(KEY_OGGETTOFATTURA, oFatturaPassivaDettaglioService.findById(Integer.parseInt(this.chiave.replace("\'",""))));
		return "pagamento"; }
		else {
			addActionError("Selezionare una fattura per poter effettuare un pagamento");
			this.idfornitorevar = (String) sessionMap.get(KEY_IDFORNITORE);
			return cerca(); }
	}
	public String registra() {
		if(!this.importopagatovar.equalsIgnoreCase("")) {
		String result;
		FatturaPassivaDettaglio oFatturaPassivaDettaglio =(FatturaPassivaDettaglio)sessionMap.get(KEY_OGGETTOFATTURA);
		if((Float.parseFloat(this.importopagatovar)+oFatturaPassivaDettaglio.getImportoPagato())<=oFatturaPassivaDettaglio.getImporto()) {
			oFatturaPassivaDettaglio.setImportoPagato(Float.parseFloat(this.importopagatovar)+oFatturaPassivaDettaglio.getImportoPagato());
			oFatturaPassivaDettaglioService.persistOrUpdate(oFatturaPassivaDettaglio);
			addActionMessage("Fattura Pagata correttamente");
			result ="search";
		}
		else {
			if(Float.parseFloat(this.importopagatovar)>oFatturaPassivaDettaglio.getImporto()) {
				addActionError("Importo inserito superiore all'importo della fattura");
				result ="pagamento";
			}
			else {
				addActionError("Fattura già parzialmente pagata! Importo restante da pagare:"+" "+(oFatturaPassivaDettaglio.getImporto()-oFatturaPassivaDettaglio.getImportoPagato()));
				result ="pagamento";
			}
		}
		sessionMap.put(KEY_LISTAFATTURE, null);
		return result; }
		else {
			addActionError("inserire un importo nel campo vuoto");
			return "pagamento";
		}
	}
	public String annulla() {
		return execute();
	}
	public String indietro() {
		String result ="chiudi";
		return result;
	}
	

}
