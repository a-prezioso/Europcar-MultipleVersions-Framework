package controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import model.session.Previsione;
import model.session.SottoCategoria;
import model.session.SpesaInvestimento;
import model.session.Venditore;

public class RicercaPianoInvestimento extends ActionSupport implements SessionAware {

	// Attributi
	private String chiave;
	private SessionMap<String, Object> sessionMap;
	public final static String KEY_LISTAANNI = "listaanni";
	public final static String KEY_LISTAAREE = "listaaree";
	public final static String KEY_LISTASOTTOCATEGORIE = "listasottocategorie";
	public final static String KEY_LISTASPESEINVESTIMENTO = "listaspese";
	public final static String KEY_CHECKAREA = "checkarea";
	public final static String KEY_CHECKSOTTOCATEGORIA = "checksottocategoria";
	public final static String KEY_CHECKSPESAINVESTIMENTO = "checkspesa";
	public final static String KEY_ANNO = "anno";
	private boolean nuovomodifica;
	public static final String KEY_PAGINEANNO = "pagineAnno";
	public static final String KEY_PAGINACORRENTEANNO = "paginacorrenteAnno";
	public static final String KEY_INIZIOANNO = "inizioAnno";
	public static final String KEY_FINEANNO = "fineAnno";
	public static final String KEY_CONTROLLOANNO = "controlloAnno";
	public static final String KEY_CONTROLLOINDIETROANNO = "controlloindietroAnno";
	public static final String KEY_CONTROLLOFINEANNO = "controllofineAnno";
	public static final String KEY_CONTROLLONUOVOMODIFICAANNO = "controllonuovomodificaAnno";
	public static final String KEY_SIZEANNO = "sizeAnno";
	private boolean nuovomodificaArea;
	public static final String KEY_PAGINEAREA = "pagineArea";
	public static final String KEY_PAGINACORRENTEAREA = "paginacorrenteArea";
	public static final String KEY_INIZIOAREA = "inizioArea";
	public static final String KEY_FINEAREA = "fineArea";
	public static final String KEY_CONTROLLOAREA = "controlloArea";
	public static final String KEY_CONTROLLOINDIETROAREA = "controlloindietroArea";
	public static final String KEY_CONTROLLOFINEAREA = "controllofineArea";
	public static final String KEY_CONTROLLONUOVOMODIFICAAREA = "controllonuovomodificaArea";
	public static final String KEY_SIZEAREA = "sizeArea";
	private boolean nuovomodificaSottCat;
	public static final String KEY_PAGINESOTTOCAT = "pagineSottCat";
	public static final String KEY_PAGINACORRENTESOTTOCAT = "paginacorrenteSottCat";
	public static final String KEY_INIZIOSOTTOCAT = "inizioSottCat";
	public static final String KEY_FINESOTTOCAT = "fineSottCat";
	public static final String KEY_CONTROLLOSOTTOCAT = "controlloSottCat";
	public static final String KEY_CONTROLLOINDIETROSOTTOCAT = "controlloindietroSottCat";
	public static final String KEY_CONTROLLOFINESOTTOCAT = "controllofineSottCat";
	public static final String KEY_CONTROLLONUOVOMODIFICASOTTOCAT = "controllonuovomodificaSottCat";
	public static final String KEY_SIZESOTTOCAT = "sizeSottCat";
	private boolean nuovomodificaSpesaInv;
	public static final String KEY_PAGINESPESAINV = "pagineSpesaInv";
	public static final String KEY_PAGINACORRENTESPESAINV = "paginacorrenteSpesaInv";
	public static final String KEY_INIZIOSPESAINV = "inizioSpesaInv";
	public static final String KEY_FINESPESAINV = "fineSpesaInv";
	public static final String KEY_CONTROLLOSPESAINV = "controlloSpesaInv";
	public static final String KEY_CONTROLLOINDIETROSPESAINV = "controlloindietroSpesaInv";
	public static final String KEY_CONTROLLOFINESPESAINV = "controllofineSpesaInv";
	public static final String KEY_CONTROLLONUOVOMODIFICASPESAINV = "controllonuovomodificaSpesaInv";
	public static final String KEY_SIZESPESAINV = "sizeSpesaInv";
	public static final String KEY_OGGETTOSOTTOCAT = "oggettosottocat";
	public static final String KEY_OGGETTOAREA = "oggettoarea";
	private String idarea;
	private String idsottocategoria;
	private String idspesainvestimento;

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

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdsottocategoria() {
		return idsottocategoria;
	}

	public void setIdsottocategoria(String idsottocategoria) {
		this.idsottocategoria = idsottocategoria;
	}

	public String getIdspesainvestimento() {
		return idspesainvestimento;
	}

	public void setIdspesainvestimento(String idspesainvestimento) {
		this.idspesainvestimento = idspesainvestimento;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	// Metodi
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	public String execute() {
		List<AnnoContabile> elenco = new AnnoContabileService()
				.executeParamizedHQLQuery("FROM AnnoContabile ORDER BY datainizio ", AnnoContabile.class);
		sessionMap.put(KEY_LISTAANNI, elenco);
		sessionMap.put(KEY_LISTAAREE, null);
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, null);
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, null);
		sessionMap.put(KEY_CHECKAREA, false);
		sessionMap.put(KEY_CHECKSOTTOCATEGORIA, false);
		sessionMap.put(KEY_CHECKSPESAINVESTIMENTO, false);
		List<AnnoContabile> ali = (List<AnnoContabile>) sessionMap.get(KEY_LISTAANNI);
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTAANNI, ali);
		sessionMap.put(KEY_INIZIOANNO, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINEANNO, z);
			sessionMap.put(KEY_CONTROLLOFINEANNO, false);
		} else {
			sessionMap.put(KEY_FINEANNO, 9);
			sessionMap.put(KEY_CONTROLLOFINEANNO, true);
		}
		sessionMap.put(KEY_CONTROLLOANNO, true);

		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEANNO, k);
		int w = (int) sessionMap.get(KEY_INIZIOANNO);
		sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
			sessionMap.put(KEY_FINEANNO, z);
			sessionMap.put(KEY_CONTROLLOFINEANNO, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOANNO, w - 10);
			sessionMap.put(KEY_FINEANNO, z);
			sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10));
		}
		if (sessionMap.get(KEY_SIZEANNO) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZEANNO);
			sessionMap.put(KEY_SIZEANNO, null);
			if (z > sizevecchia) {

				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOANNO, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTEANNO, k);
				sessionMap.put(KEY_FINEANNO, z);
				sessionMap.put(KEY_CONTROLLOFINEANNO, false);
				if (k > 1)
					sessionMap.put(KEY_CONTROLLOINDIETROANNO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROANNO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
			}
		}
		sessionMap.put(KEY_PAGINESPESAINV, null);
		sessionMap.put(KEY_PAGINACORRENTESPESAINV, null);
		sessionMap.put(KEY_INIZIOSPESAINV, null);
		sessionMap.put(KEY_FINESPESAINV, null);
		sessionMap.put(KEY_CONTROLLOSPESAINV, null);
		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, null);
		sessionMap.put(KEY_CONTROLLOFINESPESAINV, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICASPESAINV, null);
		sessionMap.put(KEY_SIZESPESAINV, null);
		sessionMap.put(KEY_PAGINESOTTOCAT, null);
		sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, null);
		sessionMap.put(KEY_INIZIOSOTTOCAT, null);
		sessionMap.put(KEY_FINESOTTOCAT, null);
		sessionMap.put(KEY_CONTROLLOSOTTOCAT, null);
		sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, null);
		sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICASOTTOCAT, null);
		sessionMap.put(KEY_SIZESOTTOCAT, null);
		sessionMap.put(KEY_PAGINEAREA, null);
		sessionMap.put(KEY_PAGINACORRENTEAREA, null);
		sessionMap.put(KEY_INIZIOAREA, null);
		sessionMap.put(KEY_FINEAREA, null);
		sessionMap.put(KEY_CONTROLLOAREA, null);
		sessionMap.put(KEY_CONTROLLOINDIETROAREA, null);
		sessionMap.put(KEY_CONTROLLOFINEAREA, null);
		sessionMap.put(KEY_CONTROLLONUOVOMODIFICAAREA, null);
		sessionMap.put(KEY_SIZEAREA, null);
		String result = "search";
		return result;
	}

	public String ispezioneAnno() {
		if (this.chiave != null) {
			AnnoContabile oAnno = new AnnoContabileService().findById(Integer.parseInt(this.chiave.replace("\'", "")));
			sessionMap.put(KEY_ANNO, oAnno);
			List<AreaInvestimento> elenco = new AreaInvestimentoService()
					.findPerAnnoContabile(oAnno.getIdannocontabile());
			sessionMap.put(KEY_LISTAAREE, elenco);
			if (elenco.size() == 0) {
				sessionMap.put(KEY_CHECKAREA, true);
			} else {
				sessionMap.put(KEY_CHECKAREA, false);
			}
			sessionMap.put(KEY_CHECKSOTTOCATEGORIA, false);
			sessionMap.put(KEY_CHECKSPESAINVESTIMENTO, false);
			sessionMap.put(KEY_LISTASOTTOCATEGORIE, null);
			sessionMap.put(KEY_LISTASPESEINVESTIMENTO, null);
			List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LISTAAREE);
			int z = ali.size() - 1;
			sessionMap.put(KEY_LISTAAREE, ali);

			sessionMap.put(KEY_INIZIOAREA, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINEAREA, z);
				sessionMap.put(KEY_CONTROLLOFINEAREA, false);
			} else {
				sessionMap.put(KEY_FINEAREA, 9);
				sessionMap.put(KEY_CONTROLLOFINEAREA, true);
			}
			sessionMap.put(KEY_CONTROLLOAREA, true);

			int k = (int) Math.ceil(z / 10.0);
			String a = String.valueOf(z);
			char b = a.charAt(a.length() - 1);
			if (b == '0') {
				k = k + 1;
			}
			sessionMap.put(KEY_PAGINEAREA, k);
			int w = (int) sessionMap.get(KEY_INIZIOAREA);
			sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
			if ((w / 10) + 1 == k) {
				sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
				sessionMap.put(KEY_FINEAREA, z);
				sessionMap.put(KEY_CONTROLLOFINEAREA, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIOAREA, w - 10);
				sessionMap.put(KEY_FINEAREA, z);
				sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10));
			}
			if (sessionMap.get(KEY_SIZEAREA) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZEAREA);
				sessionMap.put(KEY_SIZEAREA, null);
				if (z > sizevecchia) {

					String y = String.valueOf(z);
					char l = y.charAt(a.length() - 1);
					String x = String.valueOf(y.replace(l, '0'));
					sessionMap.put(KEY_INIZIOAREA, Integer.parseInt(x));
					sessionMap.put(KEY_PAGINACORRENTEAREA, k);
					sessionMap.put(KEY_FINEAREA, z);
					sessionMap.put(KEY_CONTROLLOFINEAREA, false);
					if (k > 1)
						sessionMap.put(KEY_CONTROLLOINDIETROAREA, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETROAREA, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
				}
			}

		} else {
			addActionError("Valorizzare un Anno Contabile per poterlo ispezionare! ");
			sessionMap.put(KEY_LISTAAREE, null);
			sessionMap.put(KEY_LISTASOTTOCATEGORIE, null);
			sessionMap.put(KEY_LISTASPESEINVESTIMENTO, null);
			sessionMap.put(KEY_LISTAAREE, null);

		}
		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, null);
		sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, null);
		sessionMap.put(KEY_CONTROLLOINDIETROAREA, null);
		String result = "search";
		return result;
	}

	public String ispezioneArea() {
		if (this.idarea != null) {
			AreaInvestimento oArea = new AreaInvestimentoService()
					.findById(Integer.parseInt(this.idarea.replace("\'", "")));
			List<SottoCategoria> elenco = new SottoCategoriaService().findPerAreaInvestimento(oArea.getIdarea());
			sessionMap.put(KEY_LISTASOTTOCATEGORIE, elenco);
			if (elenco.size() == 0) {
				sessionMap.put(KEY_CHECKSOTTOCATEGORIA, true);
			} else {
				sessionMap.put(KEY_CHECKSOTTOCATEGORIA, false);
			}
			sessionMap.put(KEY_CHECKSPESAINVESTIMENTO, false);
			sessionMap.put(KEY_LISTASPESEINVESTIMENTO, null);
			List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);

			int z = ali.size() - 1;
			sessionMap.put(KEY_LISTASOTTOCATEGORIE, ali);

			sessionMap.put(KEY_INIZIOSOTTOCAT, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINESOTTOCAT, z);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
			} else {
				sessionMap.put(KEY_FINESOTTOCAT, 9);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
			}
			sessionMap.put(KEY_CONTROLLOSOTTOCAT, true);

			int k = (int) Math.ceil(z / 10.0);
			String a = String.valueOf(z);
			char b = a.charAt(a.length() - 1);
			if (b == '0') {
				k = k + 1;
			}
			sessionMap.put(KEY_PAGINESOTTOCAT, k);
			int w = (int) sessionMap.get(KEY_INIZIOSOTTOCAT);
			sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
			if ((w / 10) + 1 == k) {
				sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
				sessionMap.put(KEY_FINESOTTOCAT, z);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIOSOTTOCAT, w - 10);
				sessionMap.put(KEY_FINESOTTOCAT, z);
				sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10));
			}
			if (sessionMap.get(KEY_SIZESOTTOCAT) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZESOTTOCAT);
				sessionMap.put(KEY_SIZESOTTOCAT, null);
				if (z > sizevecchia) {

					String y = String.valueOf(z);
					char l = y.charAt(a.length() - 1);
					String x = String.valueOf(y.replace(l, '0'));
					sessionMap.put(KEY_INIZIOSOTTOCAT, Integer.parseInt(x));
					sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, k);
					sessionMap.put(KEY_FINESOTTOCAT, z);
					sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
					if (k > 1)
						sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
				}
			}
			sessionMap.put(KEY_OGGETTOAREA, oArea);

		} else {
			addActionError("Valorizzare un'Area per poterla ispezionare! ");
		}

		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, null);
		sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, null);
		String result = "search";
		return result;
	}

	public String ispezioneSottoCategoria() {
		if (this.idsottocategoria != null) {
			SottoCategoria oSottoCategoria = new SottoCategoriaService()
					.findById(Integer.parseInt(this.idsottocategoria.replace("\'", "")));
			List<SpesaInvestimento> elenco = new SpesaInvestimentoService()
					.findPerSottoCategoria(oSottoCategoria.getIdsottocategoria());
			sessionMap.put(KEY_LISTASPESEINVESTIMENTO, elenco);
			if (elenco.size() == 0) {
				sessionMap.put(KEY_CHECKSPESAINVESTIMENTO, true);
			} else {
				sessionMap.put(KEY_CHECKSPESAINVESTIMENTO, false);
			}
			List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LISTASPESEINVESTIMENTO);

			int z = ali.size() - 1;
			sessionMap.put(KEY_LISTASPESEINVESTIMENTO, ali);

			sessionMap.put(KEY_INIZIOSPESAINV, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINESPESAINV, z);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
			} else {
				sessionMap.put(KEY_FINESPESAINV, 9);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
			}
			sessionMap.put(KEY_CONTROLLOSPESAINV, true);

			int k = (int) Math.ceil(z / 10.0);
			String a = String.valueOf(z);
			char b = a.charAt(a.length() - 1);
			if (b == '0') {
				k = k + 1;
			}
			sessionMap.put(KEY_PAGINESPESAINV, k);
			int w = (int) sessionMap.get(KEY_INIZIOSPESAINV);
			sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
			if ((w / 10) + 1 == k) {
				sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
				sessionMap.put(KEY_FINESPESAINV, z);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
			} else if (w / 10 == k) {
				sessionMap.put(KEY_INIZIOSPESAINV, w - 10);
				sessionMap.put(KEY_FINESPESAINV, z);
				sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10));
			}
			if (sessionMap.get(KEY_SIZESPESAINV) != null) {
				int sizevecchia = (int) sessionMap.get(KEY_SIZESPESAINV);
				sessionMap.put(KEY_SIZESPESAINV, null);
				if (z > sizevecchia) {

					String y = String.valueOf(z);
					char l = y.charAt(a.length() - 1);
					String x = String.valueOf(y.replace(l, '0'));
					sessionMap.put(KEY_INIZIOSPESAINV, Integer.parseInt(x));
					sessionMap.put(KEY_PAGINACORRENTESPESAINV, k);
					sessionMap.put(KEY_FINESPESAINV, z);
					sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
					if (k > 1)
						sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, true);
				} else if (z < sizevecchia && k == 1) {
					sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, false);
				} else if (z == sizevecchia) {
					sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
				}
			}
			sessionMap.put(KEY_OGGETTOSOTTOCAT, oSottoCategoria);
		} else {
			addActionError("Valorizzare una SottoCategoria per poterla ispezionare");
		}
		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, null);
		String result = "search";
		return result;
	}

	public String indietroAnno() {
		List<AnnoContabile> ali = (List<AnnoContabile>) sessionMap.get(KEY_LISTAANNI);
		sessionMap.put(KEY_LISTAANNI, ali);
		int i = (int) sessionMap.get(KEY_INIZIOANNO) - 10;
		int j = (int) sessionMap.get(KEY_FINEANNO) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIOANNO, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINEANNO, j);
				sessionMap.put(KEY_CONTROLLOFINEANNO, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINEANNO, j);
				sessionMap.put(KEY_CONTROLLOFINEANNO, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETROANNO, false);
				sessionMap.put(KEY_CONTROLLOFINEANNO, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEANNO, k);
		int w = (int) sessionMap.get(KEY_INIZIOANNO);
		sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);

		return "search";
	}

	public String primaAnno() {
		List<AnnoContabile> ali = (List<AnnoContabile>) sessionMap.get(KEY_LISTAANNI);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEANNO, k);
		sessionMap.put(KEY_PAGINACORRENTEANNO, 1);

		sessionMap.put(KEY_INIZIOANNO, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINEANNO, z);
		} else {
			sessionMap.put(KEY_FINEANNO, 9);
		}
		sessionMap.put(KEY_CONTROLLOANNO, true);
		sessionMap.put(KEY_CONTROLLOFINEANNO, true);
		sessionMap.put(KEY_CONTROLLOINDIETROANNO, false);
		return "search";
	}

	public String ultimaAnno() {
		List<AnnoContabile> ali = (List<AnnoContabile>) sessionMap.get(KEY_LISTAANNI);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEANNO, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTEANNO, q + 1);
		sessionMap.put(KEY_INIZIOANNO, q * 10);
		sessionMap.put(KEY_FINEANNO, z);
		sessionMap.put(KEY_CONTROLLOFINEANNO, false);
		sessionMap.put(KEY_CONTROLLOINDIETROANNO, true);

		return avantiAnno();
	}

	public String indietroArea() {
		List<AreaInvestimento> ali = (List<AreaInvestimento>) sessionMap.get(KEY_LISTAAREE);
		sessionMap.put(KEY_LISTAAREE, ali);
		int i = (int) sessionMap.get(KEY_INIZIOAREA) - 10;
		int j = (int) sessionMap.get(KEY_FINEAREA) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIOAREA, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINEAREA, j);
				sessionMap.put(KEY_CONTROLLOFINEAREA, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINEAREA, j);
				sessionMap.put(KEY_CONTROLLOFINEAREA, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETROAREA, false);
				sessionMap.put(KEY_CONTROLLOFINEAREA, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEAREA, k);
		int w = (int) sessionMap.get(KEY_INIZIOAREA);
		sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);

		return "search";
	}

	public String primaArea() {
		List<AreaInvestimento> ali = (List<AreaInvestimento>) sessionMap.get(KEY_LISTAAREE);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEAREA, k);
		sessionMap.put(KEY_PAGINACORRENTEAREA, 1);

		sessionMap.put(KEY_INIZIOAREA, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINEAREA, z);
		} else {
			sessionMap.put(KEY_FINEAREA, 9);
		}
		sessionMap.put(KEY_CONTROLLOAREA, true);
		sessionMap.put(KEY_CONTROLLOFINEAREA, true);
		sessionMap.put(KEY_CONTROLLOINDIETROAREA, false);
		return "search";
	}

	public String ultimaArea() {
		List<AreaInvestimento> ali = (List<AreaInvestimento>) sessionMap.get(KEY_LISTAAREE);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEAREA, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTEAREA, q + 1);
		sessionMap.put(KEY_INIZIOAREA, q * 10);
		sessionMap.put(KEY_FINEAREA, z);
		sessionMap.put(KEY_CONTROLLOFINEAREA, false);
		sessionMap.put(KEY_CONTROLLOINDIETROAREA, true);

		return avantiArea();
	}

	public String indietroSottoCategoria() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, ali);
		int i = (int) sessionMap.get(KEY_INIZIOSOTTOCAT) - 10;
		int j = (int) sessionMap.get(KEY_FINESOTTOCAT) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIOSOTTOCAT, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINESOTTOCAT, j);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINESOTTOCAT, j);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, false);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESOTTOCAT, k);
		int w = (int) sessionMap.get(KEY_INIZIOSOTTOCAT);
		sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);

		return "search";
	}

	public String primaSottoCategoria() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESOTTOCAT, k);
		sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, 1);

		sessionMap.put(KEY_INIZIOSOTTOCAT, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINESOTTOCAT, z);
		} else {
			sessionMap.put(KEY_FINESOTTOCAT, 9);
		}
		sessionMap.put(KEY_CONTROLLOSOTTOCAT, true);
		sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
		sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, false);
		return "search";
	}

	public String ultimaSottoCategoria() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESOTTOCAT, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, q + 1);
		sessionMap.put(KEY_INIZIOSOTTOCAT, q * 10);
		sessionMap.put(KEY_FINESOTTOCAT, z);
		sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
		sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, true);

		return avantiSottoCateogoria();
	}

	public String indietroSpesaInvestimento() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESEINVESTIMENTO);
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, ali);
		int i = (int) sessionMap.get(KEY_INIZIOSPESAINV) - 10;
		int j = (int) sessionMap.get(KEY_FINESPESAINV) - 10;

		if (i >= 0) {
			sessionMap.put(KEY_INIZIOSPESAINV, i);
			if (j - i == 9) {
				sessionMap.put(KEY_FINESPESAINV, j);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
			} else {
				while (j - i < 9) {
					j++;
				}
				sessionMap.put(KEY_FINESPESAINV, j);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
			}
			if (i == 0) {
				sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, false);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
			}
		}
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESPESAINV, k);
		int w = (int) sessionMap.get(KEY_INIZIOSPESAINV);
		sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);

		return "search";
	}

	public String primaSpesaInvestimento() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESEINVESTIMENTO);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESPESAINV, k);
		sessionMap.put(KEY_PAGINACORRENTESPESAINV, 1);

		sessionMap.put(KEY_INIZIOSPESAINV, 0);
		if (9 >= z) {
			sessionMap.put(KEY_FINESPESAINV, z);
		} else {
			sessionMap.put(KEY_FINESPESAINV, 9);
		}
		sessionMap.put(KEY_CONTROLLOSPESAINV, true);
		sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, false);
		return "search";
	}

	public String ultimaSpesaInvestimento() {
		List<SpesaInvestimento> ali = (List<SpesaInvestimento>) sessionMap.get(KEY_LISTASPESEINVESTIMENTO);
		int z = ali.size() - 1;
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESPESAINV, k);
		int q = (int) Math.ceil(z / 10);
		sessionMap.put(KEY_PAGINACORRENTESPESAINV, q + 1);
		sessionMap.put(KEY_INIZIOSPESAINV, q * 10);
		sessionMap.put(KEY_FINESPESAINV, z);
		sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
		sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, true);

		return avantiSpesaInvestimento();
	}

	public String avantiAnno() {
		List<AnnoContabile> ali = (List<AnnoContabile>) sessionMap.get(KEY_LISTAANNI);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICAANNO) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICAANNO);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTAANNI, ali);
		if (sessionMap.get(KEY_CONTROLLOANNO) != null) {
			if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICAANNO) == null) {
				int i = (int) sessionMap.get(KEY_INIZIOANNO) + 19;
				int j = (int) sessionMap.get(KEY_FINEANNO) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIOANNO, j);
					sessionMap.put(KEY_FINEANNO, i);
					sessionMap.put(KEY_CONTROLLOFINEANNO, true);
					sessionMap.put(KEY_CONTROLLOINDIETROANNO, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIOANNO, j);
					sessionMap.put(KEY_FINEANNO, z);
					sessionMap.put(KEY_CONTROLLOFINEANNO, false);
					sessionMap.put(KEY_CONTROLLOINDIETROANNO, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINEANNO, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICAANNO, false);
			}
		} else {
			sessionMap.put(KEY_INIZIOANNO, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINEANNO, z);
				sessionMap.put(KEY_CONTROLLOFINEANNO, false);
			} else {
				sessionMap.put(KEY_FINEANNO, 9);
				sessionMap.put(KEY_CONTROLLOFINEANNO, true);
			}
			sessionMap.put(KEY_CONTROLLOANNO, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEANNO, k);
		int w = (int) sessionMap.get(KEY_INIZIOANNO);
		sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
			sessionMap.put(KEY_FINEANNO, z);
			sessionMap.put(KEY_CONTROLLOFINEANNO, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOANNO, w - 10);
			sessionMap.put(KEY_FINEANNO, z);
			sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10));
		}
		if (sessionMap.get(KEY_SIZEANNO) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZEANNO);
			sessionMap.put(KEY_SIZEANNO, null);
			if (z > sizevecchia) {

				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOANNO, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTEANNO, k);
				sessionMap.put(KEY_FINEANNO, z);
				sessionMap.put(KEY_CONTROLLOFINEANNO, false);
				if (k > 1)
					sessionMap.put(KEY_CONTROLLOINDIETROANNO, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROANNO, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTEANNO, (w / 10) + 1);
			}
		}
		String result = "search";
		return result;
	}

	public String avantiArea() {
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LISTAAREE);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICAAREA) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICAAREA);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTAAREE, ali);
		if (sessionMap.get(KEY_CONTROLLOAREA) != null) {
			if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICAAREA) == null) {
				int i = (int) sessionMap.get(KEY_INIZIOAREA) + 19;
				int j = (int) sessionMap.get(KEY_FINEAREA) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIOAREA, j);
					sessionMap.put(KEY_FINEAREA, i);
					sessionMap.put(KEY_CONTROLLOFINEAREA, true);
					sessionMap.put(KEY_CONTROLLOINDIETROAREA, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIOAREA, j);
					sessionMap.put(KEY_FINEAREA, z);
					sessionMap.put(KEY_CONTROLLOFINEAREA, false);
					sessionMap.put(KEY_CONTROLLOINDIETROAREA, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINEAREA, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICAAREA, false);
			}
		} else {
			sessionMap.put(KEY_INIZIOAREA, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINEAREA, z);
				sessionMap.put(KEY_CONTROLLOFINEAREA, false);
			} else {
				sessionMap.put(KEY_FINEAREA, 9);
				sessionMap.put(KEY_CONTROLLOFINEAREA, true);
			}
			sessionMap.put(KEY_CONTROLLOAREA, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINEAREA, k);
		int w = (int) sessionMap.get(KEY_INIZIOAREA);
		sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
			sessionMap.put(KEY_FINEAREA, z);
			sessionMap.put(KEY_CONTROLLOFINEAREA, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOAREA, w - 10);
			sessionMap.put(KEY_FINEAREA, z);
			sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10));
		}
		if (sessionMap.get(KEY_SIZEAREA) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZEAREA);
			sessionMap.put(KEY_SIZEAREA, null);
			if (z > sizevecchia) {

				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOAREA, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTEAREA, k);
				sessionMap.put(KEY_FINEAREA, z);
				sessionMap.put(KEY_CONTROLLOFINEAREA, false);
				if (k > 1)
					sessionMap.put(KEY_CONTROLLOINDIETROAREA, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROAREA, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTEAREA, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String avantiSottoCateogoria() {
		List<SottoCategoria> ali = (List<SottoCategoria>) sessionMap.get(KEY_LISTASOTTOCATEGORIE);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICASOTTOCAT) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICASOTTOCAT);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, ali);
		if (sessionMap.get(KEY_CONTROLLOSOTTOCAT) != null) {
			if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICASOTTOCAT) == null) {
				int i = (int) sessionMap.get(KEY_INIZIOSOTTOCAT) + 19;
				int j = (int) sessionMap.get(KEY_FINESOTTOCAT) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIOSOTTOCAT, j);
					sessionMap.put(KEY_FINESOTTOCAT, i);
					sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
					sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIOSOTTOCAT, j);
					sessionMap.put(KEY_FINESOTTOCAT, z);
					sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
					sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICASOTTOCAT, false);
			}
		} else {
			sessionMap.put(KEY_INIZIOSOTTOCAT, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINESOTTOCAT, z);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
			} else {
				sessionMap.put(KEY_FINESOTTOCAT, 9);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, true);
			}
			sessionMap.put(KEY_CONTROLLOSOTTOCAT, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESOTTOCAT, k);
		int w = (int) sessionMap.get(KEY_INIZIOSOTTOCAT);
		sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
			sessionMap.put(KEY_FINESOTTOCAT, z);
			sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOSOTTOCAT, w - 10);
			sessionMap.put(KEY_FINESOTTOCAT, z);
			sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10));
		}
		if (sessionMap.get(KEY_SIZESOTTOCAT) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZESOTTOCAT);
			sessionMap.put(KEY_SIZESOTTOCAT, null);
			if (z > sizevecchia) {

				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOSOTTOCAT, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, k);
				sessionMap.put(KEY_FINESOTTOCAT, z);
				sessionMap.put(KEY_CONTROLLOFINESOTTOCAT, false);
				if (k > 1)
					sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROSOTTOCAT, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTESOTTOCAT, (w / 10) + 1);
			}
		}
		return "search";
	}

	public String avantiSpesaInvestimento() {
		List<Venditore> ali = (List<Venditore>) sessionMap.get(KEY_LISTASPESEINVESTIMENTO);
		if (sessionMap.get(KEY_CONTROLLONUOVOMODIFICASPESAINV) != null) {
			this.nuovomodifica = (boolean) sessionMap.get(KEY_CONTROLLONUOVOMODIFICASPESAINV);
		}
		int z = ali.size() - 1;
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, ali);
		if (sessionMap.get(KEY_CONTROLLOSPESAINV) != null) {
			if (!nuovomodifica || sessionMap.get(KEY_CONTROLLONUOVOMODIFICASPESAINV) == null) {
				int i = (int) sessionMap.get(KEY_INIZIOSPESAINV) + 19;
				int j = (int) sessionMap.get(KEY_FINESPESAINV) + 1;
				if (i <= z) {
					sessionMap.put(KEY_INIZIOSPESAINV, j);
					sessionMap.put(KEY_FINESPESAINV, i);
					sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
					sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, true);
				} else if (j <= z) {
					sessionMap.put(KEY_INIZIOSPESAINV, j);
					sessionMap.put(KEY_FINESPESAINV, z);
					sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
					sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, true);
				} else {
					sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
				}
			} else {
				sessionMap.put(KEY_CONTROLLONUOVOMODIFICASPESAINV, false);
			}
		} else {
			sessionMap.put(KEY_INIZIOSPESAINV, 0);
			if (9 >= z) {
				sessionMap.put(KEY_FINESPESAINV, z);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
			} else {
				sessionMap.put(KEY_FINESPESAINV, 9);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, true);
			}
			sessionMap.put(KEY_CONTROLLOSPESAINV, true);
		}
		int k = (int) Math.ceil(z / 10.0);
		String a = String.valueOf(z);
		char b = a.charAt(a.length() - 1);
		if (b == '0') {
			k = k + 1;
		}
		sessionMap.put(KEY_PAGINESPESAINV, k);
		int w = (int) sessionMap.get(KEY_INIZIOSPESAINV);
		sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
		if ((w / 10) + 1 == k) {
			sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
			sessionMap.put(KEY_FINESPESAINV, z);
			sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
		} else if (w / 10 == k) {
			sessionMap.put(KEY_INIZIOSPESAINV, w - 10);
			sessionMap.put(KEY_FINESPESAINV, z);
			sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10));
		}
		if (sessionMap.get(KEY_SIZESPESAINV) != null) {
			int sizevecchia = (int) sessionMap.get(KEY_SIZESPESAINV);
			sessionMap.put(KEY_SIZESPESAINV, null);
			if (z > sizevecchia) {

				String y = String.valueOf(z);
				char l = y.charAt(a.length() - 1);
				String x = String.valueOf(y.replace(l, '0'));
				sessionMap.put(KEY_INIZIOSPESAINV, Integer.parseInt(x));
				sessionMap.put(KEY_PAGINACORRENTESPESAINV, k);
				sessionMap.put(KEY_FINESPESAINV, z);
				sessionMap.put(KEY_CONTROLLOFINESPESAINV, false);
				if (k > 1)
					sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, true);
			} else if (z < sizevecchia && k == 1) {
				sessionMap.put(KEY_CONTROLLOINDIETROSPESAINV, false);
			} else if (z == sizevecchia) {
				sessionMap.put(KEY_PAGINACORRENTESPESAINV, (w / 10) + 1);
			}
		}
		return "search";
	}
}
