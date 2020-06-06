
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.dao.AnnoContabileService;
import model.dao.AreaInvestimentoService;
import model.dao.AreaService;
import model.dao.PrevisioneService;
import model.dao.SottoCategoriaService;
import model.dao.SpesaInvestimentoService;
import model.session.AnnoContabile;
import model.session.AreaInvestimento;
import model.session.Fornitore;
import model.session.SottoCategoria;
import model.session.SpesaInvestimento;

public class DefinizionePiano extends ActionSupport implements SessionAware {
	public static final String KEY_ANNI = "listapiani";
	public static final String KEY_AREE = "listaaree";
	public static final String KEY_AREENUOVE = "listaareenuove";
	public static final String KEY_SOTTOCATEGORIE = "listasottocategorie";
	public static final String KEY_SOTTOCATEGORIENUOVE = "listasottocategorienuove";
	public static final String KEY_SOTTOCATEGORIENUOVE2 = "listasottocategorienuove2";
	public static final String KEY_SPESEINVESTIMENTO = "listaspeseinvestimento";
	public static final String KEY_SPESEINVESTIMENTONUOVE = "listaspeseinvestimentonuove";
	public static final String KEY_SPESEINVESTIMENTONUOVE2 = "listaspeseinvestimentonuove2";
	public static final String KEY_PIANOVECCHIO = "pianovecchio";
	public static final String KEY_PIANODADEFINIRE = "pianodadefinire";
	public static final String KEY_MAPAREE = "mapAree";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	public static final String KEY_LISTOLDSOTC = "listoldsotc";
	public static final String KEY_LISTOLDSPES = "listoldspes";
	public static final String KEY_MAPSOTCAT = "mapStocat";
	public static final String KEY_OGGETTOSOTTOCAT = "oggettosottocat";
	public static final String KEY_AREEELIMINATE = "listaareeeliminate";
	public static final String KEY_SOTTOCATEGORIEELIMINATE = "listasottocategorieeliminate";
	public static final String KEY_SPESEELIMINATE = "listaspeseeliminate";
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
	public static final String KEY_PAGINENUOVO = "paginenuovo";
	public static final String KEY_PAGINACORRENTENUOVO = "paginacorrentenuovo";
	public static final String KEY_INIZIONUOVO = "inizionuovo";
	public static final String KEY_FINENUOVO = "finenuovo";
	public static final String KEY_CONTROLLONUOVO = "controllonuovo";
	public static final String KEY_CONTROLLOINDIETRONUOVO = "controlloindietronuovo";
	public static final String KEY_CONTROLLOFINENUOVO = "controllofinenuovo";
	public static final String KEY_CONTROLLONUOVOMODIFICANUOVO = "controllonuovomodificanuovo";
	public static final String KEY_SIZENUOVO = "sizenuovo";
	private boolean nuovomodificanuovo;

	public static final String KEY_SOTTOELIMINATEVECCHIE = "listasottoeliminatevecchie";
	public static final String KEY_SOTTOELIMINATENUOVE = "listasottoeliminatenuove";
	public static final String KEY_SPESEELIMINATEVECCHIE = "listaspeseeliminatevecchie";
	public static final String KEY_SPESEELIMINATENUOVE = "listaspeseeliminatenuove";
	public static final String KEY_RIMUOVISOTTODEFINITEVECCHIE = "rimuovisottodefinitevecchie";
	public static final String KEY_RIMUOVISPESEDEFINITEVECCHIE = "rimuovispesedefinitevecchie";
	public static final String KEY_AGGIUNGISOTTODEFINITENUOVE = "aggiungisottodefinitenuove";
	public static final String KEY_AGGIUNGISPESEDEFINITENUOVE = "aggiungispedefinitenuove";
	public static final String KEY_TOGLISOTTODEFINITENUOVE = "toglisottodefinitenuove";
	public static final String KEY_TOGLISPESENUOVE = "toglispesenuove";
	public static final String KEY_AUMENTASOTTODEFINITEVECCHIE = "aumentasottodefinitevecchie";
	public static final String KEY_AUMENTASPESEVECCHIE = "aumentaspesevecchie";

	private String pianovecchio;
	private String pianodadefinire;
	private List<String> chiaveAree;
	private String chiavearea;
	private List<String> chiaveSottocategorie;
	private List<String> chiaveAreeNuove;
	private List<String> chiaveSottocategorienuove;
	private String chiavesottocategoria;
	private List<String> chiaveSpese;
	private List<String> chiaveSpesenuove;
	private String chiavespesa;

	public boolean isNuovomodifica() {
		return nuovomodifica;
	}

	public void setNuovomodifica(boolean nuovomodifica) {
		this.nuovomodifica = nuovomodifica;
	}

	public boolean isNuovomodificanuovo() {
		return nuovomodificanuovo;
	}

	public void setNuovomodificanuovo(boolean nuovomodificanuovo) {
		this.nuovomodificanuovo = nuovomodificanuovo;
	}

	public List<String> getChiaveSpese() {
		return chiaveSpese;
	}

	public void setChiaveSpese(List<String> chiaveSpese) {
		this.chiaveSpese = chiaveSpese;
	}

	public List<String> getChiaveSpesenuove() {
		return chiaveSpesenuove;
	}

	public void setChiaveSpesenuove(List<String> chiaveSpesenuove) {
		this.chiaveSpesenuove = chiaveSpesenuove;
	}

	public List<String> getChiaveAreeNuove() {
		return chiaveAreeNuove;
	}

	public void setChiaveAreeNuove(List<String> chiaveAreeNuove) {
		this.chiaveAreeNuove = chiaveAreeNuove;
	}

	public List<String> getChiaveSottocategorienuove() {
		return chiaveSottocategorienuove;
	}

	public void setChiaveSottocategorienuove(List<String> chiaveSottocategorienuove) {
		this.chiaveSottocategorienuove = chiaveSottocategorienuove;
	}

	public String getChiavespesa() {
		return chiavespesa;
	}

	public void setChiavespesa(String chiavespesa) {
		this.chiavespesa = chiavespesa;
	}

	public String getChiavesottocategoria() {
		return chiavesottocategoria;
	}

	public void setChiavesottocategoria(String chiavesottocategoria) {
		this.chiavesottocategoria = chiavesottocategoria;
	}

	public List<String> getChiaveSottocategorie() {
		return chiaveSottocategorie;
	}

	public void setChiaveSottocategorie(List<String> chiaveSottocategorie) {
		this.chiaveSottocategorie = chiaveSottocategorie;
	}

	public String getChiavearea() {
		return chiavearea;
	}

	public void setChiavearea(String chiavearea) {
		this.chiavearea = chiavearea;
	}

	public String getPianovecchio() {
		return pianovecchio;
	}

	public void setPianovecchio(String pianovecchio) {
		this.pianovecchio = pianovecchio;
	}

	public String getPianodadefinire() {
		return pianodadefinire;
	}

	public void setPianodadefinire(String pianodadefinire) {
		this.pianodadefinire = pianodadefinire;
	}

	private SessionMap<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}

	public List<String> getChiaveAree() {
		return chiaveAree;
	}

	public void setChiaveAree(List<String> chiaveAree) {
		this.chiaveAree = chiaveAree;
	}

	
	public String execute() {
		LinkedHashMap<String, String> mapAnni = new LinkedHashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Anno Contabile: ");
				List<AnnoContabile> elencoAnni = new AnnoContabileService()
						.executeParamizedHQLQuery("FROM AnnoContabile ORDER BY datainizio ", AnnoContabile.class);
				for (int i = 0; i < elencoAnni.size(); i++) {
					put(String.valueOf(elencoAnni.get(i).getIdannocontabile()), elencoAnni.get(i).getDescrizione());
				}
			}
		};
		sessionMap.put(KEY_ANNI, mapAnni);
		sessionMap.put(KEY_AREE, null);
		sessionMap.put(KEY_AREENUOVE, null);
		sessionMap.put(KEY_SOTTOCATEGORIE, null);
		sessionMap.put(KEY_SOTTOCATEGORIENUOVE, null);
		sessionMap.put(KEY_SOTTOCATEGORIENUOVE2, null);
		sessionMap.put(KEY_SPESEINVESTIMENTO, null);
		sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, null);
		sessionMap.put(KEY_SPESEINVESTIMENTONUOVE2, null);
		sessionMap.put(KEY_PIANODADEFINIRE, null);
		sessionMap.put(KEY_PIANOVECCHIO, null);
		sessionMap.put(KEY_MAPAREE, null);
		sessionMap.put(KEY_OGGETTOAREA, null);
		sessionMap.put(KEY_OGGETTOSOTTOCAT, null);
		sessionMap.put(KEY_SOTTOCATEGORIENUOVE2, null);
		sessionMap.put(KEY_LISTOLDSOTC, null);
		sessionMap.put(KEY_LISTOLDSPES, null);
		sessionMap.put(KEY_MAPSOTCAT, null);
		sessionMap.put(KEY_AREEELIMINATE, null);
		sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, null);
		sessionMap.put(KEY_SPESEELIMINATE, null);

		sessionMap.put(KEY_SOTTOELIMINATEVECCHIE, null);
		sessionMap.put(KEY_SOTTOELIMINATENUOVE, null);
		sessionMap.put(KEY_SPESEELIMINATEVECCHIE, null);
		sessionMap.put(KEY_SPESEELIMINATENUOVE, null);
		sessionMap.put(KEY_RIMUOVISOTTODEFINITEVECCHIE, null);
		sessionMap.put(KEY_RIMUOVISPESEDEFINITEVECCHIE, null);
		sessionMap.put(KEY_AGGIUNGISOTTODEFINITENUOVE, null);
		sessionMap.put(KEY_AGGIUNGISPESEDEFINITENUOVE, null);
		sessionMap.put(KEY_TOGLISOTTODEFINITENUOVE, null);
		sessionMap.put(KEY_TOGLISPESENUOVE, null);
		sessionMap.put(KEY_AUMENTASOTTODEFINITEVECCHIE, null);
		sessionMap.put(KEY_AUMENTASPESEVECCHIE, null);
		return "search";
	}

	public String definizione() {
		if (Integer.parseInt(this.pianodadefinire) == 0) {
			addActionError("Selezionare il Piano d'investimento da definire");
		}
		if (Integer.parseInt(this.pianovecchio) == 0) {
			addActionError("Selezionare il Piano d'investimento da cui partire");
		}
		if ((Integer.parseInt(this.pianodadefinire) == Integer.parseInt(this.pianovecchio))
				&& Integer.parseInt(this.pianodadefinire) != 0 && Integer.parseInt(this.pianovecchio) != 0) {
			addActionError("Selezionare due Piani d'investimento differenti");
		}
	
		
		if (getActionErrors().size() == 0) {
			AnnoContabile oAnnovecchio = new AnnoContabileService().findById(Integer.parseInt(this.pianovecchio));
			AnnoContabile oAnno = new AnnoContabileService().findById(Integer.parseInt(this.pianodadefinire));
			sessionMap.put(KEY_PIANOVECCHIO, oAnnovecchio);
			sessionMap.put(KEY_PIANODADEFINIRE, oAnno);

			if (sessionMap.get(KEY_AREEELIMINATE) == null) {
				if (sessionMap.get(KEY_AREE) == null) {
					List<AreaInvestimento> aree = new AreaInvestimentoService()
							.executeParamizedHQLQuery("" + "FROM AreaInvestimento WHERE idarea in (SELECT oarea.idarea "
									+ "FROM SottoCategoria WHERE idsottocategoria not in "
									+ "(SELECT osottocategoria.idsottocategoria FROM Previsione) "
									+ "AND idsottocategoria in (SELECT osottocategoria.idsottocategoria "
									+ "FROM SpesaInvestimento WHERE idspesainvestimento not in "
									+ "(SELECT ospesainvestimento.idspesainvestimento FROM FatturaPassivaDettaglio) "
									+ "AND idspesainvestimento not in (SELECT ospesainvestimento.idspesainvestimento "
									+ "FROM OrdineDiAcquistoDettaglio))) AND oannocontabile.idannocontabile = "
									+ oAnnovecchio.getIdannocontabile(), AreaInvestimento.class);
					List<AreaInvestimento> areedaaggiungere = new AreaInvestimentoService()
							.executeParamizedHQLQuery("FROM AreaInvestimento "
									+ "WHERE idarea not in (SELECT oarea.idarea FROM SottoCategoria) AND oannocontabile.idannocontabile = "
									+ oAnnovecchio.getIdannocontabile(), AreaInvestimento.class);
					for (int i = 0; i < areedaaggiungere.size(); i++) {
						aree.add(areedaaggiungere.get(i));
					}
					List<AreaInvestimento> areedaaggiungere2 = new AreaInvestimentoService()
							.executeParamizedHQLQuery("FROM AreaInvestimento "
									+ "WHERE idarea in (SELECT oarea.idarea FROM SottoCategoria WHERE idsottocategoria not in (SELECT osottocategoria.idsottocategoria "
									+ "FROM SpesaInvestimento)) AND oannocontabile.idannocontabile = "
									+ oAnnovecchio.getIdannocontabile(), AreaInvestimento.class);
					for (int i = 0; i < areedaaggiungere2.size(); i++) {
						aree.add(areedaaggiungere2.get(i));
					}
				
					for(int i=0; i<aree.size()-1;i++) {
                        for(int j=i+1;j<aree.size();j++) {
                            if(aree.get(i).getArea().equalsIgnoreCase(aree.get(j).getArea()) && aree.get(i).getCodice().equalsIgnoreCase(aree.get(j).getCodice())) {
                            	aree.remove(j);
                            }
                        }
                    }
				
					sessionMap.put(KEY_AREE, aree);
					List<AreaInvestimento> areenuove = new AreaInvestimentoService().executeParamizedHQLQuery(""
							+ "FROM AreaInvestimento" + " WHERE idarea in " + "(SELECT oarea.idarea "
							+ "FROM SottoCategoria " + "WHERE idsottocategoria not in "
							+ "(SELECT osottocategoria.idsottocategoria " + "FROM Previsione) "
							+ "AND idsottocategoria in " + "(SELECT osottocategoria.idsottocategoria "
							+ "FROM SpesaInvestimento " + "WHERE idspesainvestimento not in "
							+ "(SELECT ospesainvestimento.idspesainvestimento " + "FROM FatturaPassivaDettaglio) "
							+ "AND idspesainvestimento not in" + " (SELECT ospesainvestimento.idspesainvestimento "
							+ "FROM OrdineDiAcquistoDettaglio))) " + "AND oannocontabile.idannocontabile = "
							+ oAnno.getIdannocontabile(), AreaInvestimento.class);
					List<AreaInvestimento> areenuovedaaggiungere = new AreaInvestimentoService()
							.executeParamizedHQLQuery("FROM AreaInvestimento "
									+ "WHERE idarea not in (SELECT oarea.idarea FROM SottoCategoria) AND oannocontabile.idannocontabile = "
									+ oAnno.getIdannocontabile(), AreaInvestimento.class);
					for (int j = 0; j < areenuovedaaggiungere.size(); j++) {
						areenuove.add(areenuovedaaggiungere.get(j));
					}
					List<AreaInvestimento> areenuovedaaggiungere2 = new AreaInvestimentoService()
							.executeParamizedHQLQuery("FROM AreaInvestimento "
									+ "WHERE idarea in (SELECT oarea.idarea FROM SottoCategoria WHERE idsottocategoria not in (SELECT osottocategoria.idsottocategoria "
									+ "FROM SpesaInvestimento)) AND oannocontabile.idannocontabile = "
									+ oAnno.getIdannocontabile(), AreaInvestimento.class);
					for (int i = 0; i < areenuovedaaggiungere2.size(); i++) {
						areenuove.add(areenuovedaaggiungere2.get(i));
					}
					sessionMap.put(KEY_AREENUOVE, areenuove);
				}

			} sessionMap.get(KEY_AREE);
			return "definizione";
		} else {
			return "search";
		}

	}
	
	public String definisciAree() {
		if (this.chiaveAree != null) {
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_PIANODADEFINIRE);
			List<AreaInvestimento> aree = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
			List<AreaInvestimento> areenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
			for (int i = 0; i < this.chiaveAree.size(); i++) {
				AreaInvestimento oArea = new AreaInvestimentoService()
						.findById(Integer.parseInt(this.chiaveAree.get(i).replace("\'", "")));
				oArea.setOannocontabile(oAnnoContabile);
				areenuove.add(oArea);
				boolean trovato = false;
				for (int j = 0; j < aree.size() && !trovato; j++) {
					if (aree.get(j).getIdarea() == oArea.getIdarea()) {
						aree.remove(j);
						trovato = true;
					}
				}
			}
			sessionMap.put(KEY_AREE, aree);
			sessionMap.put(KEY_AREENUOVE, areenuove);
		} else {
			addActionError("Selezionare almeno un Area per poterla trasferire nel nuovo Piano d'investimento");

		}
		return "definizione";
	}

	public String togliDefinisciAree() {
		if (this.chiaveAreeNuove != null) {
			AnnoContabile oAnnoContabile = (AnnoContabile) sessionMap.get(KEY_PIANOVECCHIO);
			List<AreaInvestimento> aree = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
			List<AreaInvestimento> areenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
			for (int i = 0; i < this.chiaveAreeNuove.size(); i++) {
				AreaInvestimento oArea = new AreaInvestimentoService()
						.findById(Integer.parseInt(this.chiaveAreeNuove.get(i).replace("\'", "")));
				oArea.setOannocontabile(oAnnoContabile);
				aree.add(oArea);
				boolean trovato = false;
				for (int j = 0; j < areenuove.size() && !trovato; j++) {
					if (areenuove.get(j).getIdarea() == oArea.getIdarea()) {
						areenuove.remove(j);
						trovato = true;
					}
				}
			}
			sessionMap.put(KEY_AREE, aree);
			sessionMap.put(KEY_AREENUOVE, areenuove);
		} else {
			addActionError("Selezionare almeno un Area per poterla trasferire nel nuovo Piano d'investimento");

		}
		return "definizione";
	}

	public String rimuoviAree() {
		if (this.chiaveAree != null || this.chiaveAreeNuove != null) {
			if (this.chiaveAree != null && this.chiaveAreeNuove == null) {
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_AREEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_AREEELIMINATE);
				}
				List<AreaInvestimento> areevecchie = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
				for (int i = 0; i < chiaveAree.size(); i++) {
					chiaviVecchieEliminate.add(chiaveAree.get(i).replace("\'", ""));
					for (int j = 0; j < areevecchie.size(); j++) {
						if (areevecchie.get(j).getIdarea() == Integer.parseInt(chiaveAree.get(i).replace("\'", ""))) {
							areevecchie.remove(j);
						}
					}
				}
				sessionMap.put(KEY_AREEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_AREE, areevecchie);
			} else if (this.chiaveAree == null && this.chiaveAreeNuove != null) {
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_AREEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_AREEELIMINATE);
				}
				List<AreaInvestimento> areenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
				for (int i = 0; i < chiaveAreeNuove.size(); i++) {
					chiaviVecchieEliminate.add(chiaveAreeNuove.get(i).replace("\'", ""));
					for (int j = 0; j < areenuove.size(); j++) {
						if (areenuove.get(j).getIdarea() == Integer
								.parseInt(chiaveAreeNuove.get(i).replace("\'", ""))) {
							areenuove.remove(j);
						}
					}
				}
				sessionMap.put(KEY_AREEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_AREENUOVE, areenuove);
			} else {
				List<String> chiavieliminate = new ArrayList<String>();
				for (int i = 0; i < chiaveAree.size(); i++) {
					chiavieliminate.add(chiaveAree.get(i).replace("\'", ""));
				}
				for (int j = 0; j < chiaveAreeNuove.size(); j++) {
					chiavieliminate.add(chiaveAreeNuove.get(j).replace("\'", ""));
				}
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_AREEELIMINATE) == null) {
					sessionMap.put(KEY_AREEELIMINATE, chiavieliminate);
				} else {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_AREEELIMINATE);
					for (int i = 0; i < chiavieliminate.size(); i++) {
						chiaviVecchieEliminate.add(chiavieliminate.get(i));
					}
					sessionMap.put(KEY_AREEELIMINATE, chiavieliminate);
				}
				List<AreaInvestimento> areenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
				for (int i = 0; i < chiaveAreeNuove.size(); i++) {
					for (int j = 0; j < areenuove.size(); j++) {
						if (areenuove.get(j).getIdarea() == Integer
								.parseInt(chiaveAreeNuove.get(i).replace("\'", ""))) {
							areenuove.remove(j);
						}
					}
				}
				sessionMap.put(KEY_AREENUOVE, areenuove);
				List<AreaInvestimento> areevecchie = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
				for (int i = 0; i < chiaveAree.size(); i++) {
					for (int j = 0; j < areevecchie.size(); j++) {
						if (areevecchie.get(j).getIdarea() == Integer.parseInt(chiaveAree.get(i).replace("\'", ""))) {
							areevecchie.remove(j);
						}
					}
				}
				sessionMap.put(KEY_AREE, areevecchie);
			}
			List<String> areedaeliminare = (List<String>) sessionMap.get(KEY_AREEELIMINATE);
			List<String> sottocategoriedaeliminare = new ArrayList<String>();
			if (sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE) != null)
				sottocategoriedaeliminare = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
			for (int i = 0; i < areedaeliminare.size(); i++) {
				List<SottoCategoria> sottocategorie = new SottoCategoriaService().findPerAreaInvestimento(Integer.parseInt(areedaeliminare.get(i)));
				for (int j = 0; j < sottocategorie.size(); j++) {
					sottocategoriedaeliminare.add(String.valueOf(sottocategorie.get(j).getIdsottocategoria()));
				}
			}
			sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, sottocategoriedaeliminare);
			//////////
		
			List<String> spesedaeliminare = new ArrayList<String>();
			if (sessionMap.get(KEY_SPESEELIMINATE) != null)
				spesedaeliminare = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
			for (int i = 0; i < sottocategoriedaeliminare.size(); i++) {
				List<SpesaInvestimento> speseinvestimento = new SpesaInvestimentoService().findPerSottoCategoria(Integer.parseInt(sottocategoriedaeliminare.get(i)));
				for (int j = 0; j < speseinvestimento.size(); j++) {
					spesedaeliminare.add(String.valueOf(speseinvestimento.get(j).getIdspesainvestimento()));
				}
			}
			sessionMap.put(KEY_SPESEELIMINATE, spesedaeliminare);
		} else {
			addActionError("Seleziona un'area per poterla eliminare");
		}
		return "definizione";
	}

			
	
	public String definizioneSottoCategoria() {
		List<AreaInvestimento> elencoAreenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
		if (elencoAreenuove.size() > 0) {
			
			HashMap<String, String> mapAree = new HashMap<String, String>() {
				{
					put(String.valueOf(0), "Seleziona L'Area");
					List<AreaInvestimento> elencoAree = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
					for (int i = 0; i < elencoAree.size(); i++) {
						put(String.valueOf(elencoAree.get(i).getIdarea()), elencoAree.get(i).getArea());
					}
				}
			};
			AnnoContabile oAnnovecchio = (AnnoContabile) sessionMap.get(KEY_PIANOVECCHIO);
			AnnoContabile oAnno = (AnnoContabile) sessionMap.get(KEY_PIANODADEFINIRE);
			List<AreaInvestimento> elencoAreeVecchie = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
			List<SottoCategoria> sottocategorie = new ArrayList<SottoCategoria>();
			List<SottoCategoria> elencoProvvisorioVecchio = new ArrayList<SottoCategoria>();
			List<SottoCategoria> elencoProvvisorio = new ArrayList<SottoCategoria>();
			for (int w = 0; w < elencoAreeVecchie.size(); w++) {
				elencoProvvisorioVecchio = new SottoCategoriaService()
						.findPerAreaInvestimento(elencoAreeVecchie.get(w).getIdarea());

				for (int z = 0; z < elencoProvvisorioVecchio.size(); z++) {
					sottocategorie.add(elencoProvvisorioVecchio.get(z));
				}
			}


			List<SottoCategoria> sottocategorienuove = new ArrayList<SottoCategoria>();
			for (int i = 0; i < elencoAreenuove.size(); i++) {
				elencoProvvisorio = new SottoCategoriaService().findPerAreaInvestimento(elencoAreenuove.get(i).getIdarea());

				for (int j = 0; j < elencoProvvisorio.size(); j++) {
					sottocategorienuove.add(elencoProvvisorio.get(j));
				}
			}

			List<SottoCategoria> sottocategorienuove2 = new ArrayList<SottoCategoria>();
			for (int i = 0; i < sottocategorienuove.size(); i++) {
				sottocategorienuove2.add(sottocategorienuove.get(i));
			}
			List<SottoCategoria> elenco = new ArrayList<SottoCategoria>();
			sessionMap.put(KEY_LISTOLDSOTC, elenco);
			sessionMap.put(KEY_MAPAREE, mapAree);
			
			/////////// dichiarazione array  eliminati, rimossi e aggiunti per la lista di sinistra
			List<String> rimuovisottodefinitevecchie = (List<String>) sessionMap.get(KEY_RIMUOVISOTTODEFINITEVECCHIE);
			List<String> aumentasottodefinitevecchie= (List<String>) sessionMap.get(KEY_AUMENTASOTTODEFINITEVECCHIE);
			List<String> sottoeliminatevecchie = (List<String>) sessionMap.get(KEY_SOTTOELIMINATEVECCHIE);
			List<SottoCategoria> sizesottocategorie = new ArrayList<SottoCategoria>();
			for(int i = 0; i < sottocategorie.size(); i++) {
				sizesottocategorie.add(sottocategorie.get(i));
			}
			//////// gestione lista di sinistra
			if(sottoeliminatevecchie != null) {
			for (int i = 0; i < sizesottocategorie.size(); i++) {
				for(int j = 0; j < sottoeliminatevecchie.size(); j++) {
					if(sizesottocategorie.get(i).getIdsottocategoria() == Integer.parseInt(sottoeliminatevecchie.get(j).replace("\'", ""))) {
						sottocategorie.remove(sizesottocategorie.get(i));
					}
				}
			} }
			if(rimuovisottodefinitevecchie != null) {
			for (int i = 0; i < sizesottocategorie.size(); i++) {
				for(int j = 0; j < rimuovisottodefinitevecchie.size(); j++) {
					if(sizesottocategorie.get(i).getIdsottocategoria() == Integer.parseInt(rimuovisottodefinitevecchie.get(j).replace("\'", ""))) {
						sottocategorie.remove(sizesottocategorie.get(i));
					}
				}
			} }
			if (aumentasottodefinitevecchie != null) {
				for (int i = 0; i < aumentasottodefinitevecchie.size(); i++) {
					for (int j = 0; j < sizesottocategorie.size(); j++) {
						if (sizesottocategorie.get(j).getIdsottocategoria() != Integer
								.parseInt(aumentasottodefinitevecchie.get(i).replace("\'", ""))) {
							if (j == sizesottocategorie.size()-1) {
								sottocategorie.add(new SottoCategoriaService().findById(
										Integer.parseInt(aumentasottodefinitevecchie.get(i).replace("\'", ""))));
							}
						}
					}
				}
			}
			/////////// dichiarazione array  eliminati, rimossi e aggiunti per la lista di destra
			List<SottoCategoria> aggiungisottodefinitenuove = (List<SottoCategoria>) sessionMap.get(KEY_AGGIUNGISOTTODEFINITENUOVE);
			List<String> toglisottodefinitenuove = (List<String>) sessionMap.get(KEY_TOGLISOTTODEFINITENUOVE);
			List<String> sottoeliminatenuove= (List<String>) sessionMap.get(KEY_SOTTOELIMINATENUOVE);
		List<SottoCategoria> sizesottocategorienuove = new ArrayList<SottoCategoria>();
			for(int i = 0; i < sottocategorienuove.size(); i++) {
 				sizesottocategorienuove.add(sottocategorienuove.get(i));
			}
			////////// gestione lista di destra
			if(sottoeliminatenuove != null) {

			for (int i = 0; i < sizesottocategorienuove.size(); i++) {
				for(int j = 0; j < sottoeliminatenuove.size(); j++) {
					if(sizesottocategorienuove.get(i).getIdsottocategoria() == Integer.parseInt(sottoeliminatenuove.get(j).replace("\'", ""))) {
						sottocategorienuove.remove(sizesottocategorienuove.get(i));

						
					}
				}
			} }
			if(toglisottodefinitenuove != null ) {
			for (int i = 0; i < sizesottocategorienuove.size(); i++) {
				for(int j = 0; j < toglisottodefinitenuove.size(); j++) {
					if(sizesottocategorienuove.get(i).getIdsottocategoria() == Integer.parseInt(toglisottodefinitenuove.get(j).replace("\'", ""))) {
						sottocategorienuove.remove(sizesottocategorienuove.get(i));
					}
				}
			} }
			if (aggiungisottodefinitenuove != null) {
				for (int i = 0; i < aggiungisottodefinitenuove.size(); i++) {
					for (int j = 0; j < sizesottocategorienuove.size(); j++) {
						if (sizesottocategorienuove.get(j).getIdsottocategoria() != aggiungisottodefinitenuove.get(i).getIdsottocategoria()) {
							if (j == sizesottocategorienuove.size()-1) {
								sottocategorienuove.add(aggiungisottodefinitenuove.get(i));
							}
						}
					}
				}
			}
			/////
				sessionMap.put(KEY_SOTTOCATEGORIE, sottocategorie);
				sessionMap.put(KEY_SOTTOCATEGORIENUOVE, sottocategorienuove);
			
			sessionMap.put(KEY_SOTTOCATEGORIENUOVE2, sottocategorienuove2);
			
			
			return "definizioneSottoCategoria";
		} else {
			addActionError("Definire delle aree per il piano d'investimento per poter continuare");
			return "definizione";
		}
	}

	public String definisciSottocategoria() {
		if (this.chiaveSottocategorie != null) {
	
			if (Integer.parseInt(this.chiavearea) != 0) {
				////////// gestione liste
				List<String> rimuovisottodefinitevecchie = new ArrayList<String>();
				
				if (sessionMap.get(KEY_RIMUOVISOTTODEFINITEVECCHIE) != null) {
					rimuovisottodefinitevecchie = (List<String>) sessionMap.get(KEY_RIMUOVISOTTODEFINITEVECCHIE);
					for (int i = 0; i < this.chiaveSottocategorie.size(); i++) {
						rimuovisottodefinitevecchie.add(this.chiaveSottocategorie.get(i));
					}
					sessionMap.put(KEY_RIMUOVISOTTODEFINITEVECCHIE, rimuovisottodefinitevecchie);
				} else {
					sessionMap.put(KEY_RIMUOVISOTTODEFINITEVECCHIE, this.chiaveSottocategorie);
				}
			
			
			//////
				List<SottoCategoria> elenco = (List<SottoCategoria>) sessionMap.get(KEY_LISTOLDSOTC);
				AreaInvestimento oArea = new AreaInvestimentoService().findById(Integer.parseInt(this.chiavearea));
				sessionMap.put(KEY_OGGETTOAREA, oArea);
				List<SottoCategoria> sottocategorie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
				List<SottoCategoria> sottocategorienuove = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
				List<SottoCategoria> aggiungisottodefinitenuove = new ArrayList<SottoCategoria>();
				for (int i = 0; i < this.chiaveSottocategorie.size(); i++) {
					SottoCategoria oSottoCategoria = new SottoCategoriaService()
							.findById(Integer.parseInt(this.chiaveSottocategorie.get(i).replace("\'", "")));
					SottoCategoria oSottoCat = new SottoCategoriaService()
							.findById(Integer.parseInt(this.chiaveSottocategorie.get(i).replace("\'", "")));
					elenco.add(oSottoCat);
					oSottoCategoria.setOarea(oArea);
					sottocategorienuove.add(oSottoCategoria);
					
					if (sessionMap.get(KEY_AGGIUNGISOTTODEFINITENUOVE) != null) {
						aggiungisottodefinitenuove = (List<SottoCategoria>) sessionMap.get(KEY_AGGIUNGISOTTODEFINITENUOVE);
						aggiungisottodefinitenuove.add(oSottoCategoria);
					} else {
						aggiungisottodefinitenuove.add(oSottoCategoria);
					}
					
					boolean trovato = false;
					for (int j = 0; j < sottocategorie.size() && !trovato; j++) {
						if (sottocategorie.get(j).getIdsottocategoria() == oSottoCategoria.getIdsottocategoria()) {
							sottocategorie.remove(j);
							trovato = true;
						}
					}

				}
				sessionMap.put(KEY_LISTOLDSOTC, elenco);
				sessionMap.put(KEY_SOTTOCATEGORIE, sottocategorie);
				sessionMap.put(KEY_SOTTOCATEGORIENUOVE, sottocategorienuove);
				sessionMap.put(KEY_AGGIUNGISOTTODEFINITENUOVE, aggiungisottodefinitenuove);
			} else {
				addActionError(
						"Valorizzare l'area del nuovo anno contabile per la quale si vuole inserire la sottocategoria");
			}
		} else {
			addActionError(
					"Selezionare almeno una Sottocategoria per poterla trasferire nel nuovo Piano d'investimento");
		}
		return "definizioneSottoCategoria";
	}

	public String togliDefinisciSottocategoria() {
		if (this.chiaveSottocategorienuove != null) {
		
			List<SottoCategoria> elenco = (List<SottoCategoria>) sessionMap.get(KEY_LISTOLDSOTC);
			List<SottoCategoria> sottocategorie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
			List<SottoCategoria> sottocategorienuove = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
			List<SottoCategoria> sottocategorienuove2 = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE2);
			for (int i = 0; i < this.chiaveSottocategorienuove.size(); i++) {
				SottoCategoria oSottoCat = new SottoCategoriaService()
						.findById(Integer.parseInt(this.chiaveSottocategorienuove.get(i).replace("\'", "")));
	
				for (int l = 0; l < sottocategorienuove2.size(); l++) {
					if (sottocategorienuove2.get(l).getIdsottocategoria() == oSottoCat.getIdsottocategoria()) {
						addActionError("impossibili inserire la sottocategoria:" + " " + oSottoCat.getSottocategoria()
						+ "nel vecchio piano d'investimento");
					}
				}
				if (getActionErrors().size() == 0) {
					boolean trovato = false;
					for (int k = 0; k < elenco.size() && !trovato; k++) {
						if (oSottoCat.getIdsottocategoria() == elenco.get(k).getIdsottocategoria()) {
							oSottoCat.setOarea(elenco.get(k).getOarea());
							trovato = true;
							elenco.remove(k);

						}
					}
					sottocategorie.add(oSottoCat);
					trovato = false;
					for (int j = 0; j < sottocategorienuove.size() && !trovato; j++) {
						if (sottocategorienuove.get(j).getIdsottocategoria() == oSottoCat.getIdsottocategoria()) {
							sottocategorienuove.remove(j);
							trovato = true;
						}
					}
					/////////////////
					List<String> toglisottodefinitenuove = new ArrayList<String>();
					List<String> aumentasottodefinitevecchie = new ArrayList<String>();
					if (sessionMap.get(KEY_TOGLISOTTODEFINITENUOVE) != null) {
						toglisottodefinitenuove = (List<String>) sessionMap.get(KEY_TOGLISOTTODEFINITENUOVE);
						for (i = 0; i < this.chiaveSottocategorienuove.size(); i++) {
							toglisottodefinitenuove.add(this.chiaveSottocategorienuove.get(i));
						}
						sessionMap.put(KEY_TOGLISOTTODEFINITENUOVE, toglisottodefinitenuove);
					} else {
						sessionMap.put(KEY_TOGLISOTTODEFINITENUOVE, this.chiaveSottocategorienuove);
					}
					if (sessionMap.get(KEY_AUMENTASOTTODEFINITEVECCHIE) != null) {
						aumentasottodefinitevecchie = (List<String>) sessionMap.get(KEY_AUMENTASOTTODEFINITEVECCHIE);
						for (i = 0; i < this.chiaveSottocategorienuove.size(); i++) {
							aumentasottodefinitevecchie.add(this.chiaveSottocategorienuove.get(i));
						}
						sessionMap.put(KEY_AUMENTASOTTODEFINITEVECCHIE, aumentasottodefinitevecchie);
					} else {
						sessionMap.put(KEY_AUMENTASOTTODEFINITEVECCHIE, this.chiaveSottocategorienuove);
					}
				///////////
				} else {
					return "definizioneSottoCategoria";
				}
			}
			sessionMap.put(KEY_LISTOLDSOTC, elenco);
			sessionMap.put(KEY_SOTTOCATEGORIE, sottocategorie);
			sessionMap.put(KEY_SOTTOCATEGORIENUOVE, sottocategorienuove);
		} else {
			addActionError("Selezionare almeno un Area per poterla trasferire nel vecchio Piano d'investimento");

		}
		return "definizioneSottoCategoria";
	}

	public String rimuoviSottoCategorie() {
		if (this.chiaveSottocategorie != null || this.chiaveSottocategorienuove != null) {
			if (this.chiaveSottocategorie != null && this.chiaveSottocategorienuove == null) {
				////////
				if(sessionMap.get(KEY_SOTTOELIMINATEVECCHIE) != null) {
					List<String> sottoeliminatevecchie = (List<String>) sessionMap.get(KEY_SOTTOELIMINATEVECCHIE);
					for(int i = 0; i < this.chiaveSottocategorie.size(); i++) {
						sottoeliminatevecchie.add(this.chiaveSottocategorie.get(i));
					}
					sessionMap.put(KEY_SOTTOELIMINATEVECCHIE, sottoeliminatevecchie);
				} else {
					sessionMap.put(KEY_SOTTOELIMINATEVECCHIE, this.chiaveSottocategorie);
				}
				///////
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
				}
				List<SottoCategoria> sottocategorievecchie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
				List<SottoCategoria> sizesottocategorievecchie = new ArrayList<SottoCategoria>();
				for(int i = 0; i < sottocategorievecchie.size(); i++) {
					sizesottocategorievecchie.add(sottocategorievecchie.get(i));
				}
				for (int i = 0; i < chiaveSottocategorie.size(); i++) {
					chiaviVecchieEliminate.add(chiaveSottocategorie.get(i).replace("\'", ""));
					for (int j = 0; j < sizesottocategorievecchie.size(); j++) {
						if (sizesottocategorievecchie.get(j).getIdsottocategoria() == Integer
								.parseInt(chiaveSottocategorie.get(i).replace("\'", ""))) {
							sottocategorievecchie.remove(sizesottocategorievecchie.get(j));
						}
					}
				}
				sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_SOTTOCATEGORIE, sottocategorievecchie);
			} else if (this.chiaveSottocategorie == null && this.chiaveSottocategorienuove != null) {
				///////
				if(sessionMap.get(KEY_SOTTOELIMINATENUOVE) != null) {
					List<String> sottoeliminatenuove = (List<String>) sessionMap.get(KEY_SOTTOELIMINATENUOVE);
					for(int i = 0; i < this.chiaveSottocategorienuove.size(); i++) {
						sottoeliminatenuove.add(this.chiaveSottocategorienuove.get(i));
					}
					sessionMap.put(KEY_SOTTOELIMINATENUOVE, sottoeliminatenuove);
				} else {
					sessionMap.put(KEY_SOTTOELIMINATENUOVE, this.chiaveSottocategorienuove);
				}
				/////////
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
				}
				List<SottoCategoria> sottocategorienuove = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
				List<SottoCategoria> sizesottocategorienuove = new ArrayList<SottoCategoria>();
				for(int i = 0; i < sottocategorienuove.size(); i++) {
					sizesottocategorienuove.add(sottocategorienuove.get(i));
				}
				for (int i = 0; i < chiaveSottocategorienuove.size(); i++) {
					chiaviVecchieEliminate.add(chiaveSottocategorienuove.get(i).replace("\'", ""));
					for (int j = 0; j < sizesottocategorienuove.size(); j++) {
						if (sizesottocategorienuove.get(j).getIdsottocategoria() == Integer
								.parseInt(chiaveSottocategorienuove.get(i).replace("\'", ""))) {
							sottocategorienuove.remove(sizesottocategorienuove.get(j));
						}
					}
				}
				sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_SOTTOCATEGORIENUOVE, sottocategorienuove);
			} else {
				///////
				if(sessionMap.get(KEY_SOTTOELIMINATENUOVE) != null) {
					List<String> sottoeliminatenuove = (List<String>) sessionMap.get(KEY_SOTTOELIMINATENUOVE);
					for(int i = 0; i < this.chiaveSottocategorienuove.size(); i++) {
						sottoeliminatenuove.add(this.chiaveSottocategorienuove.get(i));
					}
					sessionMap.put(KEY_SOTTOELIMINATENUOVE, sottoeliminatenuove);
				} else {
					sessionMap.put(KEY_SOTTOELIMINATENUOVE, this.chiaveSottocategorienuove);
				}
				if(sessionMap.get(KEY_SOTTOELIMINATEVECCHIE) != null) {
					List<String> sottoeliminatevecchie = (List<String>) sessionMap.get(KEY_SOTTOELIMINATEVECCHIE);
					for(int i = 0; i < this.chiaveSottocategorie.size(); i++) {
						sottoeliminatevecchie.add(this.chiaveSottocategorie.get(i));
					}
					sessionMap.put(KEY_SOTTOELIMINATEVECCHIE, sottoeliminatevecchie);
				} else {
					sessionMap.put(KEY_SOTTOELIMINATEVECCHIE, this.chiaveSottocategorie);
				}
				///////
				List<String> chiavieliminate = new ArrayList<String>();
				for (int i = 0; i < chiaveSottocategorie.size(); i++) {
					chiavieliminate.add(chiaveSottocategorie.get(i).replace("\'", ""));
				}
				for (int j = 0; j < chiaveSottocategorienuove.size(); j++) {
					chiavieliminate.add(chiaveSottocategorienuove.get(j));
				}
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE) == null) {
					sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, chiavieliminate);
				} else {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
					for (int i = 0; i < chiavieliminate.size(); i++) {
						chiaviVecchieEliminate.add(chiavieliminate.get(i));
					}
					sessionMap.put(KEY_SOTTOCATEGORIEELIMINATE, chiavieliminate);
				}
				List<SottoCategoria> sottocategorienuove = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
				List<SottoCategoria> sizesottocategorienuove = new ArrayList<SottoCategoria>();
				for(int i = 0; i < sottocategorienuove.size(); i++) {
					sizesottocategorienuove.add(sottocategorienuove.get(i));
				}
				for (int i = 0; i < chiaveSottocategorienuove.size(); i++) {
					for (int j = 0; j < sizesottocategorienuove.size(); j++) {
						if (sizesottocategorienuove.get(j).getIdsottocategoria() == Integer
								.parseInt(chiaveSottocategorienuove.get(i).replace("\'", ""))) {
							sottocategorienuove.remove(sizesottocategorienuove.get(j));
						}
					}
				}
				sessionMap.put(KEY_SOTTOCATEGORIENUOVE, sottocategorienuove);
				List<SottoCategoria> sottocategorievecchie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
				List<SottoCategoria> sizesottocategorievecchie = new ArrayList<SottoCategoria>();
				for(int i = 0; i < sottocategorievecchie.size(); i++) {
					sizesottocategorievecchie.add(sottocategorievecchie.get(i));
				}
				for (int i = 0; i < chiaveSottocategorie.size(); i++) {
					for (int j = 0; j < sizesottocategorievecchie.size(); j++) {
						if (sizesottocategorievecchie.get(j).getIdsottocategoria() == Integer
								.parseInt(chiaveSottocategorie.get(i).replace("\'", ""))) {
							sottocategorievecchie.remove(sizesottocategorievecchie.get(j));
						}
					}
				}
				sessionMap.put(KEY_SOTTOCATEGORIE, sottocategorievecchie);
			}
			List<String> sottocategoriedaeliminare = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
			List<String> speseinvestimentodaeliminare = new ArrayList<String>();
			if (sessionMap.get(KEY_SPESEELIMINATE) != null)
				speseinvestimentodaeliminare = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
			for (int i = 0; i < sottocategoriedaeliminare.size(); i++) {
				List<SpesaInvestimento> sottocategorie = new SpesaInvestimentoService()
						.findPerSottoCategoria(Integer.parseInt(sottocategoriedaeliminare.get(i)));
				for (int j = 0; j < sottocategorie.size(); j++) {
					speseinvestimentodaeliminare.add(String.valueOf(sottocategorie.get(j).getIdspesainvestimento()));
				}
			}
			sessionMap.put(KEY_SPESEELIMINATE, speseinvestimentodaeliminare);
		} else {
			addActionError("Seleziona una sottocategoria per poterla eliminare");
		}
		return "definizioneSottoCategoria";
	}

	public String indietroSottoCategoria() {
		sessionMap.put(KEY_PAGINENUOVO, null);
		sessionMap.put(KEY_PAGINACORRENTENUOVO, null);
		sessionMap.put(KEY_INIZIONUOVO, null);
		sessionMap.put(KEY_FINENUOVO, null);
		sessionMap.put(KEY_CONTROLLONUOVO, null);
		sessionMap.put(KEY_CONTROLLOINDIETRONUOVO, null);
		sessionMap.put(KEY_CONTROLLOFINENUOVO, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICANUOVO, null);
		sessionMap.put(KEY_SIZENUOVO, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_SIZE, null);
		AnnoContabile annovecchio = (AnnoContabile) sessionMap.get(KEY_PIANOVECCHIO);
		this.pianovecchio = String.valueOf(annovecchio.getIdannocontabile());
		AnnoContabile annonuovo = (AnnoContabile) sessionMap.get(KEY_PIANODADEFINIRE);
		this.pianodadefinire = String.valueOf(annonuovo.getIdannocontabile());
		return definizione();
	}

	
	public String definizioneSpesaInvestimento() {
		HashMap<String, String> mapSot = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona La SottoCategoria");
				List<SottoCategoria> elencoAree = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getIdsottocategoria()), elencoAree.get(i).getSottocategoria());
				}
			}
		};
		List<SottoCategoria> elencoSottCat = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
		List<SottoCategoria> elencoSottCatVecchie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
		AnnoContabile oAnnovecchio = (AnnoContabile) sessionMap.get(KEY_PIANOVECCHIO);
		AnnoContabile oAnno = (AnnoContabile) sessionMap.get(KEY_PIANODADEFINIRE);
		List<SpesaInvestimento> speseinvestimento = new ArrayList<SpesaInvestimento>();
		List<SpesaInvestimento> elencoProvvisorio = new ArrayList<SpesaInvestimento>();
		List<SpesaInvestimento> elencoProvvisorioVecchio = new ArrayList<SpesaInvestimento>();
		for (int z = 0; z < elencoSottCatVecchie.size(); z++) {
			elencoProvvisorioVecchio = new SpesaInvestimentoService()
					.findPerSottoCategoria(elencoSottCatVecchie.get(z).getIdsottocategoria());

			for (int w = 0; w < elencoProvvisorioVecchio.size(); w++) {
				speseinvestimento.add(elencoProvvisorioVecchio.get(w));
			}
		}


		List<SpesaInvestimento> speseinvestimentonuove = new ArrayList<SpesaInvestimento>();
		for (int i = 0; i < elencoSottCat.size(); i++) {
			elencoProvvisorio = new SpesaInvestimentoService()
					.findPerSottoCategoria(elencoSottCat.get(i).getIdsottocategoria());

			for (int j = 0; j < elencoProvvisorio.size(); j++) {
				speseinvestimentonuove.add(elencoProvvisorio.get(j));
			}
		}

		List<SpesaInvestimento> speseinvestimentonuove2 = new ArrayList<SpesaInvestimento>();
		for (int i = 0; i < speseinvestimentonuove.size(); i++) {
			speseinvestimentonuove2.add(speseinvestimentonuove.get(i));
		}
		List<SpesaInvestimento> elenco = new ArrayList<SpesaInvestimento>();
		sessionMap.put(KEY_LISTOLDSPES, elenco);
		sessionMap.put(KEY_MAPSOTCAT, mapSot);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////// dichiarazione array  eliminati, rimossi e aggiunti per la lista di sinistra
			List<String> rimuovispesedefinitevecchie = (List<String>) sessionMap.get(KEY_RIMUOVISPESEDEFINITEVECCHIE);
			List<String> aumentaspesedefinitevecchie= (List<String>) sessionMap.get(KEY_AUMENTASPESEVECCHIE);
			List<String> speseeliminatevecchie = (List<String>) sessionMap.get(KEY_SPESEELIMINATEVECCHIE);
			List<SpesaInvestimento> sizespeseinvestimento = new ArrayList<SpesaInvestimento>();
			for(int i = 0; i < speseinvestimento.size(); i++) {
				sizespeseinvestimento.add(speseinvestimento.get(i));
			}
			
			//////// gestione lista di sinistra
			if(speseeliminatevecchie != null) {

			for (int i = 0; i < sizespeseinvestimento.size(); i++) {
				for(int j = 0; j < speseeliminatevecchie.size(); j++) {
					if(sizespeseinvestimento.get(i).getIdspesainvestimento() == Integer.parseInt(speseeliminatevecchie.get(j).replace("\'", ""))) {
						speseinvestimento.remove(sizespeseinvestimento.get(i));

					}
				}
			} }
			if(rimuovispesedefinitevecchie != null) {

			for (int i = 0; i < sizespeseinvestimento.size(); i++) {
				for(int j = 0; j < rimuovispesedefinitevecchie.size(); j++) {
					if(sizespeseinvestimento.get(i).getIdspesainvestimento() == Integer.parseInt(rimuovispesedefinitevecchie.get(j).replace("\'", "")) ) {
						speseinvestimento.remove(sizespeseinvestimento.get(i));

					}
				}
			} }
			if (aumentaspesedefinitevecchie != null) {
	
				for (int i = 0; i < aumentaspesedefinitevecchie.size(); i++) {
					for (int j = 0; j < sizespeseinvestimento.size(); j++) {
						if (sizespeseinvestimento.get(j).getIdspesainvestimento() != Integer
								.parseInt(aumentaspesedefinitevecchie.get(i).replace("\'", ""))) {
							if (j == sizespeseinvestimento.size()-1) {
								speseinvestimento.add(new SpesaInvestimentoService()
										.findById(Integer.parseInt(aumentaspesedefinitevecchie.get(i).replace("\'", ""))));
							}
						}
					}
				}
			}
			/////////// dichiarazione array  eliminati, rimossi e aggiunti per la lista di destra
			List<SpesaInvestimento> aggiungispesedefinitenuove = (List<SpesaInvestimento>) sessionMap.get(KEY_AGGIUNGISPESEDEFINITENUOVE);
			List<String> toglispesedefinitenuove = (List<String>) sessionMap.get(KEY_TOGLISPESENUOVE);
			List<String> speseeliminatenuove= (List<String>) sessionMap.get(KEY_SPESEELIMINATENUOVE);
			List<SpesaInvestimento> sizespeseinvestimentonuove = new ArrayList<SpesaInvestimento>();
			for(int i = 0; i < speseinvestimentonuove.size(); i++) {
				sizespeseinvestimentonuove.add(speseinvestimentonuove.get(i));
			}
			////////// gestione lista di destra
			if(speseeliminatenuove != null) {
			for (int i = 0; i < sizespeseinvestimentonuove.size(); i++) {
				for(int j = 0; j < speseeliminatenuove.size(); j++) {
					if(sizespeseinvestimentonuove.get(i).getIdspesainvestimento() == Integer.parseInt(speseeliminatenuove.get(j).replace("\'", ""))) {
						speseinvestimentonuove.remove(sizespeseinvestimentonuove.get(i));
	
					}
				}
			} }
			if(toglispesedefinitenuove != null) {

			for (int i = 0; i < sizespeseinvestimentonuove.size(); i++) {
				for(int j = 0; j < toglispesedefinitenuove.size(); j++) {
					if(sizespeseinvestimentonuove.get(i).getIdspesainvestimento() == Integer.parseInt(toglispesedefinitenuove.get(j).replace("\'", ""))) {
						speseinvestimentonuove.remove(sizespeseinvestimentonuove.get(i));

					}
				}
			} }
			
			if (aggiungispesedefinitenuove != null) {
				for (int i = 0; i < aggiungispesedefinitenuove.size(); i++) {
					for (int j = 0; j < sizespeseinvestimentonuove.size(); j++) {
						if (sizespeseinvestimentonuove.get(j).getIdspesainvestimento() != aggiungispesedefinitenuove.get(i).getIdspesainvestimento()) {
							if (j == sizespeseinvestimentonuove.size()-1) {
								speseinvestimentonuove.add(aggiungispesedefinitenuove.get(i));
							}
						}
	
					}
				}
			}
			/////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, speseinvestimentonuove);
			sessionMap.put(KEY_SPESEINVESTIMENTO, speseinvestimento);
		
		sessionMap.put(KEY_SPESEINVESTIMENTONUOVE2, speseinvestimentonuove2);
		return "definizioneSpesaInvestimento";
	}

	public String definisciSpesa() {
		if (this.chiaveSpese != null) {
			if (Integer.parseInt(this.chiavesottocategoria) != 0) {
				////////// gestione liste
					List<String> rimuovispesedefinitevecchie = new ArrayList<String>();
					
					if (sessionMap.get(KEY_RIMUOVISPESEDEFINITEVECCHIE) != null) {
						rimuovispesedefinitevecchie = (List<String>) sessionMap.get(KEY_RIMUOVISPESEDEFINITEVECCHIE);
						for (int i = 0; i < this.chiaveSpese.size(); i++) {
							rimuovispesedefinitevecchie.add(this.chiaveSpese.get(i));
						}
						sessionMap.put(KEY_RIMUOVISPESEDEFINITEVECCHIE, rimuovispesedefinitevecchie);
					} else {
						sessionMap.put(KEY_RIMUOVISPESEDEFINITEVECCHIE, this.chiaveSpese);
					}
					
				
				///////////////
				List<SpesaInvestimento> elenco = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTOLDSPES);
				SottoCategoria oSot = new SottoCategoriaService().findById(Integer.parseInt(this.chiavesottocategoria));
				sessionMap.put(KEY_OGGETTOSOTTOCAT, oSot);
				List<SpesaInvestimento> spesainvestimento = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTO);
				List<SpesaInvestimento> spesainvestimentonew = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTONUOVE);
				List<SpesaInvestimento> aggiungispesedefinitenuove = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < this.chiaveSpese.size(); i++) {
					SpesaInvestimento oSpesa = new SpesaInvestimentoService()
							.findById(Integer.parseInt(this.chiaveSpese.get(i).replace("\'", "")));
					SpesaInvestimento oSpesa2 = new SpesaInvestimentoService()
							.findById(Integer.parseInt(this.chiaveSpese.get(i).replace("\'", "")));
					elenco.add(oSpesa2);
					oSpesa.setOsottocategoria(oSot);
					spesainvestimentonew.add(oSpesa);
					
					if (sessionMap.get(KEY_AGGIUNGISPESEDEFINITENUOVE) != null) {
						aggiungispesedefinitenuove = (List<SpesaInvestimento>) sessionMap.get(KEY_AGGIUNGISPESEDEFINITENUOVE);
						aggiungispesedefinitenuove.add(oSpesa);
					} else {
						aggiungispesedefinitenuove.add(oSpesa);
					}
					
					
					boolean trovato = false;
					for (int j = 0; j < spesainvestimento.size() && !trovato; j++) {
						if (spesainvestimento.get(j).getIdspesainvestimento() == oSpesa.getIdspesainvestimento()) {
							spesainvestimento.remove(j);
							trovato = true;
						}
					}

				}
				sessionMap.put(KEY_LISTOLDSPES, elenco);
				sessionMap.put(KEY_SPESEINVESTIMENTO, spesainvestimento);
				sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, spesainvestimentonew);
				sessionMap.put(KEY_AGGIUNGISPESEDEFINITENUOVE, aggiungispesedefinitenuove);
			} else {
				addActionError(
						"Valorizzare la Sottocategoria del nuovo piano d'investimento per la quale di vuole inserire la spesa d'investimento");
			}
		} else {
			addActionError(
					"Selezionare alemeno una Spesa d'investimento per trasferirla nel nuovo piano d'investimento");
		}
		return "definizioneSpesaInvestimento";
	}

	public String togliDefinisciSpesa() {
		if (this.chiaveSpesenuove != null) {
		
			List<SpesaInvestimento> elenco = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTOLDSPES);
			List<SpesaInvestimento> spese = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTO);
			List<SpesaInvestimento> spesenew = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTONUOVE);
			List<SpesaInvestimento> spesenew2 = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTONUOVE2);
			for (int i = 0; i < this.chiaveSpesenuove.size(); i++) {
				SpesaInvestimento oSpesa = new SpesaInvestimentoService()
						.findById(Integer.parseInt(this.chiaveSpesenuove.get(i).replace("\'", "")));
			
				for (int s = 0; s < spesenew2.size(); s++) {
					if (spesenew2.get(s).getIdspesainvestimento() == oSpesa.getIdspesainvestimento()) {
						addActionError("impossibile inserire la spesa:" + " " + oSpesa.getSpesainvestimento() + " "
						+ "nel vecchio piano d'investimento");
					}
				}
				if (getActionErrors().size() == 0) {
					boolean trovato = false;
					for (int k = 0; k < elenco.size() && !trovato; k++) {
						if (oSpesa.getIdspesainvestimento() == elenco.get(k).getIdspesainvestimento()) {
							oSpesa.setOsottocategoria(elenco.get(k).getOsottocategoria());
							trovato = true;
							elenco.remove(k);
						}
					}
					spese.add(oSpesa);
					trovato = false;
					for (int j = 0; j < spesenew.size() && !trovato; j++) {
						if (spesenew.get(j).getIdspesainvestimento() == oSpesa.getIdspesainvestimento()) {
							spesenew.remove(j);
							trovato = true;
						}
					}
					/////////gestione liste
					List<String> toglispesenuove = new ArrayList<String>();
					List<String> aumentaspesevecchie = new ArrayList<String>();
					if (sessionMap.get(KEY_TOGLISPESENUOVE) != null) {
						toglispesenuove = (List<String>) sessionMap.get(KEY_TOGLISPESENUOVE);
						for (i = 0; i < this.chiaveSpesenuove.size(); i++) {
							toglispesenuove.add(this.chiaveSpesenuove.get(i));
						}
						sessionMap.put(KEY_TOGLISPESENUOVE, toglispesenuove);
					} else {
						sessionMap.put(KEY_TOGLISPESENUOVE, this.chiaveSpesenuove);
					}
					if (sessionMap.get(KEY_AUMENTASPESEVECCHIE) != null) {
						aumentaspesevecchie = (List<String>) sessionMap.get(KEY_AUMENTASPESEVECCHIE);
						for (i = 0; i < this.chiaveSpesenuove.size(); i++) {
							aumentaspesevecchie.add(this.chiaveSpesenuove.get(i));
						}
						sessionMap.put(KEY_AUMENTASPESEVECCHIE, aumentaspesevecchie);
					} else {
						sessionMap.put(KEY_AUMENTASPESEVECCHIE, this.chiaveSpesenuove);
					}
				
				/////////////
				} else {
					return "definizioneSpesaInvestimento";
				}
			}
			sessionMap.put(KEY_LISTOLDSPES, elenco);
			sessionMap.put(KEY_SPESEINVESTIMENTO, spese);
			sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, spesenew);
		} else {
			addActionError("Selezioanare almeno una Spesa per poterla ritrasferire nel vecchio piano d'investimento");
		}
		return "definizioneSpesaInvestimento";
	}

	public String rimuoviSpesa() {
		if (this.chiaveSpese != null || this.chiaveSpesenuove != null) {
			if (this.chiaveSpese != null && this.chiaveSpesenuove == null) {
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SPESEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
				}
				List<SpesaInvestimento> speseinvestimentovecchie = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTO);
				List<SpesaInvestimento> sizespeseinvestimentovecchie = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < speseinvestimentovecchie.size(); i++) {
					sizespeseinvestimentovecchie.add(speseinvestimentovecchie.get(i));
				}
				for (int i = 0; i < this.chiaveSpese.size(); i++) {
					chiaviVecchieEliminate.add(this.chiaveSpese.get(i).replace("\'", ""));
					for (int j = 0; j < sizespeseinvestimentovecchie.size(); j++) {
						if (sizespeseinvestimentovecchie.get(j).getIdspesainvestimento() == Integer.parseInt(this.chiaveSpese.get(i).replace("\'", ""))) {
							speseinvestimentovecchie.remove(sizespeseinvestimentovecchie.get(j));
						}
					}
				}
				////////
				if(sessionMap.get(KEY_SPESEELIMINATEVECCHIE) != null) {
					List<String> speseeliminatevecchie = (List<String>) sessionMap.get(KEY_SPESEELIMINATEVECCHIE);
					for(int i = 0; i < this.chiaveSpese.size(); i++) {
						speseeliminatevecchie.add(this.chiaveSpese.get(i));
					}
					sessionMap.put(KEY_SPESEELIMINATEVECCHIE, speseeliminatevecchie);
				} else {
					sessionMap.put(KEY_SPESEELIMINATEVECCHIE, this.chiaveSpese);
				}
				///////
				sessionMap.put(KEY_SPESEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_SPESEINVESTIMENTO, speseinvestimentovecchie);
			} else if (this.chiaveSpese == null && this.chiaveSpesenuove != null) {
				
				///////
				if(sessionMap.get(KEY_SPESEELIMINATENUOVE) != null) {
					List<String> speseeliminatenuove = (List<String>) sessionMap.get(KEY_SPESEELIMINATENUOVE);
					for(int i = 0; i <this.chiaveSpesenuove.size(); i++) {
						speseeliminatenuove.add(this.chiaveSpesenuove.get(i));
					}
					sessionMap.put(KEY_SPESEELIMINATENUOVE, speseeliminatenuove);
				} else {
					sessionMap.put(KEY_SPESEELIMINATENUOVE, this.chiaveSpesenuove);
				}
				/////////
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SPESEELIMINATE) != null) {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
				}
				List<SpesaInvestimento> speseinvestimentonuove = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTONUOVE);
				List<SpesaInvestimento> sizespeseinvestimentonuove = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < speseinvestimentonuove.size(); i++) {
					sizespeseinvestimentonuove.add(speseinvestimentonuove.get(i));
				}
				for (int i = 0; i < chiaveSpesenuove.size(); i++) {
					chiaviVecchieEliminate.add(chiaveSpesenuove.get(i).replace("\'", ""));
					for (int j = 0; j < sizespeseinvestimentonuove.size(); j++) {
						if (sizespeseinvestimentonuove.get(j).getIdspesainvestimento() == Integer.parseInt(chiaveSpesenuove.get(i).replace("\'", ""))) {
							speseinvestimentonuove.remove(sizespeseinvestimentonuove.get(j));
						}
					}
				}
				sessionMap.put(KEY_SPESEELIMINATE, chiaviVecchieEliminate);
				sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, speseinvestimentonuove);
			} else {
				///////
				if(sessionMap.get(KEY_SPESEELIMINATENUOVE) != null) {
					List<String> speseeliminatenuove = (List<String>) sessionMap.get(KEY_SPESEELIMINATENUOVE);
					for(int i = 0; i < this.chiaveSpesenuove.size(); i++) {
						speseeliminatenuove.add(this.chiaveSpesenuove.get(i));
					}
					sessionMap.put(KEY_SPESEELIMINATENUOVE, speseeliminatenuove);
				} else {
					sessionMap.put(KEY_SPESEELIMINATENUOVE, this.chiaveSpesenuove);
				}
				if(sessionMap.get(KEY_SPESEELIMINATEVECCHIE) != null) {
					List<String> speseeliminatevecchie = (List<String>) sessionMap.get(KEY_SPESEELIMINATEVECCHIE);
			
					for(int i = 0; i < this.chiaveSpese.size(); i++) {
						speseeliminatevecchie.add(this.chiaveSpese.get(i));
					}
					sessionMap.put(KEY_SPESEELIMINATEVECCHIE, speseeliminatevecchie);
				} else {
					sessionMap.put(KEY_SPESEELIMINATEVECCHIE, this.chiaveSpese);
				}
				///////
				List<String> chiavieliminate = new ArrayList<String>();
				for (int i = 0; i < chiaveSpese.size(); i++) {
					chiavieliminate.add(chiaveSpese.get(i).replace("\'", ""));
				}
				for (int j = 0; j < chiaveSpesenuove.size(); j++) {
					chiavieliminate.add(chiaveSpesenuove.get(j));
				}
				List<String> chiaviVecchieEliminate = new ArrayList<String>();
				if (sessionMap.get(KEY_SPESEELIMINATE) == null) {
					sessionMap.put(KEY_SPESEELIMINATE, chiavieliminate);
				} else {
					chiaviVecchieEliminate = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
					for (int i = 0; i < chiavieliminate.size(); i++) {
						chiaviVecchieEliminate.add(chiavieliminate.get(i));
					}
					sessionMap.put(KEY_SPESEELIMINATE, chiavieliminate);
				}
				List<SpesaInvestimento> speseinvestimentonuove = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTONUOVE);
				List<SpesaInvestimento> sizespeseinvestimentonuove = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < speseinvestimentonuove.size(); i++) {
					sizespeseinvestimentonuove.add(speseinvestimentonuove.get(i));
				}
				for (int i = 0; i < chiaveSpesenuove.size(); i++) {
					for (int j = 0; j < sizespeseinvestimentonuove.size(); j++) {
						if (sizespeseinvestimentonuove.get(j).getIdspesainvestimento() == Integer
								.parseInt(chiaveSpesenuove.get(i).replace("\'", ""))) {
							speseinvestimentonuove.remove(sizespeseinvestimentonuove.get(j));
						}
					}
				}
				sessionMap.put(KEY_SPESEINVESTIMENTONUOVE, speseinvestimentonuove);
				List<SpesaInvestimento> speseinvestimentovecchie = (List<SpesaInvestimento>) sessionMap.get(KEY_SPESEINVESTIMENTO);
				List<SpesaInvestimento> sizespeseinvestimentovecchie = new ArrayList<SpesaInvestimento>();
				for (int i = 0; i < speseinvestimentovecchie.size(); i++) {
					sizespeseinvestimentovecchie.add(speseinvestimentovecchie.get(i));
				}
				for (int i = 0; i < chiaveSpese.size(); i++) {
					for (int j = 0; j < sizespeseinvestimentovecchie.size(); j++) {
						if (sizespeseinvestimentovecchie.get(j).getIdspesainvestimento() == Integer.parseInt(chiaveSpese.get(i).replace("\'", ""))) {
							speseinvestimentovecchie.remove(sizespeseinvestimentovecchie.get(j));
						}
					}
				}
				sessionMap.put(KEY_SPESEINVESTIMENTO, speseinvestimentovecchie);
			}
		} else {
			addActionError("Seleziona una sottocategoria per poterla eliminare");
		}
		return "definizioneSpesaInvestimento";
	}

	public String indietroSpesaInvestimento() {
		sessionMap.put(KEY_PAGINENUOVO, null);
		sessionMap.put(KEY_PAGINACORRENTENUOVO, null);
		sessionMap.put(KEY_INIZIONUOVO, null);
		sessionMap.put(KEY_FINENUOVO, null);
		sessionMap.put(KEY_CONTROLLONUOVO, null);
		sessionMap.put(KEY_CONTROLLOINDIETRONUOVO, null);
		sessionMap.put(KEY_CONTROLLOFINENUOVO, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICANUOVO, null);
		sessionMap.put(KEY_SIZENUOVO, null);
		sessionMap.put(KEY_PAGINE, null);
		sessionMap.put(KEY_PAGINACORRENTE, null);
		sessionMap.put(KEY_INIZIO, null);
		sessionMap.put(KEY_FINE, null);
		sessionMap.put(KEY_CONTROLLO, null);
		sessionMap.put(KEY_CONTROLLOINDIETRO, null);
		sessionMap.put(KEY_CONTROLLOFINE, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICA, null);
		sessionMap.put(KEY_SIZE, null);
		return definizioneSottoCategoria();
	}

	
	public String salva() {
		if (sessionMap.get(KEY_SPESEELIMINATE) != null) {
			List<String> speseeliminate = (List<String>) sessionMap.get(KEY_SPESEELIMINATE);
			for (int i = 0; i < speseeliminate.size(); i++) {
				new SpesaInvestimentoService().deleteOj(new SpesaInvestimentoService().findById(Integer.parseInt(speseeliminate.get(i))));
			}
		}
		if (sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE) != null) {
			List<String> sottocategorieeliminate = (List<String>) sessionMap.get(KEY_SOTTOCATEGORIEELIMINATE);
			for (int i = 0; i < sottocategorieeliminate.size(); i++) {
				new SottoCategoriaService().deleteOj(
						new SottoCategoriaService().findById(Integer.parseInt(sottocategorieeliminate.get(i))));
			}
		}
		if (sessionMap.get(KEY_AREEELIMINATE) != null) {
			List<String> areeeliminate = (List<String>) sessionMap.get(KEY_AREEELIMINATE);
			for (int i = 0; i < areeeliminate.size(); i++) {
				new AreaInvestimentoService()
				.deleteOj(new AreaInvestimentoService().findById(Integer.parseInt(areeeliminate.get(i))));
			}
		}
		if (sessionMap.get(KEY_SPESEINVESTIMENTO) != null) {
			List<SpesaInvestimento> speseinvestimentovecchie = (List<SpesaInvestimento>) sessionMap
					.get(KEY_SPESEINVESTIMENTO);
			if (speseinvestimentovecchie.size() > 0) {
				for (int i = 0; i < speseinvestimentovecchie.size(); i++) {
					new SpesaInvestimentoService().persistOrUpdate(speseinvestimentovecchie.get(i));
				}
			}
		}
		if (sessionMap.get(KEY_SPESEINVESTIMENTONUOVE) != null) {
			List<SpesaInvestimento> speseinvestimentonuove = (List<SpesaInvestimento>) sessionMap
					.get(KEY_SPESEINVESTIMENTONUOVE);
			if (speseinvestimentonuove.size() > 0) {
				for (int i = 0; i < speseinvestimentonuove.size(); i++) {
					new SpesaInvestimentoService().persistOrUpdate(speseinvestimentonuove.get(i));
				}
			}
		}
		if (sessionMap.get(KEY_SOTTOCATEGORIE) != null) {
			List<SottoCategoria> sottocategorievecchie = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIE);
			if (sottocategorievecchie.size() > 0) {
				for (int i = 0; i < sottocategorievecchie.size(); i++) {
					new SottoCategoriaService().persistOrUpdate(sottocategorievecchie.get(i));
				}
			}
		}
		if (sessionMap.get(KEY_SOTTOCATEGORIENUOVE) != null) {
			List<SottoCategoria> sottocategorienuove = (List<SottoCategoria>) sessionMap.get(KEY_SOTTOCATEGORIENUOVE);
			if (sottocategorienuove.size() != 0) {
				for (int i = 0; i < sottocategorienuove.size(); i++) {
					new SottoCategoriaService().persistOrUpdate(sottocategorienuove.get(i));
				}
			}
		}
		if (sessionMap.get(KEY_AREE) != null) {
			List<AreaInvestimento> areevecchie = (List<AreaInvestimento>) sessionMap.get(KEY_AREE);
			if (areevecchie.size() != 0) {
				for (int i = 0; i < areevecchie.size(); i++) {
					new AreaInvestimentoService().persistOrUpdate(areevecchie.get(i));
				}
			}
		}
		if (sessionMap.get(KEY_AREENUOVE) != null) {
			List<AreaInvestimento> areenuove = (List<AreaInvestimento>) sessionMap.get(KEY_AREENUOVE);
			if (areenuove.size() != 0) {
				for (int i = 0; i < areenuove.size(); i++) {
					new AreaInvestimentoService().persistOrUpdate(areenuove.get(i));
				}
			}
		}
		AnnoContabile annovecchio = (AnnoContabile) sessionMap.get(KEY_PIANOVECCHIO);
		this.pianovecchio = String.valueOf(annovecchio.getIdannocontabile());
		AnnoContabile annonuovo = (AnnoContabile) sessionMap.get(KEY_PIANODADEFINIRE);
		this.pianodadefinire = String.valueOf(annonuovo.getIdannocontabile());

		addActionError("Piano d'investimento correttamente salvato");

		return execute();
	}

}