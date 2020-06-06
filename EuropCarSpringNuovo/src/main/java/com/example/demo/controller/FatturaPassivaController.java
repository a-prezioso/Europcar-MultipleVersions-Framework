package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AnnoContabile;
import com.example.demo.model.FatturaPassiva;
import com.example.demo.model.FatturaPassivaDettaglio;
import com.example.demo.model.Fornitore;
import com.example.demo.model.OrdineAcquisto;
import com.example.demo.model.OrdineDiAcquistoDettaglio;
import com.example.demo.model.Preventivo;
import com.example.demo.model.SottoCategoria;
import com.example.demo.model.SpesaInvestimento;
import com.example.demo.service.AliquotaIvaService;
import com.example.demo.service.FatturaPassivaDettaglioService;
import com.example.demo.service.FatturaPassivaService;
import com.example.demo.service.FornitoreService;
import com.example.demo.service.PreventivoService;
import com.example.demo.service.SottoCategoriaService;
import com.example.demo.service.SpesaInvestimentoService;

@Controller
@RequestMapping(value = "/FatturaPassiva")
public class FatturaPassivaController {

	@Autowired
	FatturaPassivaService fatser;

	@Autowired
	FatturaPassivaDettaglioService fatdetser;

	@Autowired
	FornitoreService forser;

	@Autowired
	PreventivoService preser;

	@Autowired
	SottoCategoriaService sotser;
	
	@Autowired
	SpesaInvestimentoService spesaser;
	
	@Autowired
	AliquotaIvaService aliser;

	private int count;
	private List<Integer> chiavi;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Integer> getChiavi() {
		return chiavi;
	}

	public void setChiavi(List<Integer> chiavi) {
		this.chiavi = chiavi;
	}

	
	public Integer idAnno(HttpSession sessionObj) {
		AnnoContabile oanno = (AnnoContabile) sessionObj.getAttribute("oggettoAnnoPermanente");
		return oanno.getIdannocontabile();
	}

	@GetMapping(value = "/Menu")
	public ModelAndView lista(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView("FatturaPassiva/MenuFatture");
		sessionObj.setAttribute("oggettoFornitoreFattura", null);
		return model;
	}

	@GetMapping(value = "/DeleteFattura/{id}")
	public ModelAndView deleteFattura(@PathVariable("id") Integer id) {
		fatser.deleteFatturaPassiva(id);
		return new ModelAndView("redirect:/FatturaPassiva/Cerca");
	}
	
	
	@GetMapping(value = "/Cerca")
	public ModelAndView cercaFattura(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView("FatturaPassiva/ListaFatture");
			sessionObj.setAttribute("oggettoFornitoreFattura", new Fornitore());
			model.addObject("oggettoFornitoreFattura", new Fornitore());

		model.addObject("elencoFornitori", forser.getAllFornitori());
		sessionObj.setAttribute("oggettoFatturaTemporanea", null);
		sessionObj.setAttribute("oggettoDettagliTemporanei", null);
		sessionObj.setAttribute("contatore", null);
		return model;
	}
	
	@PostMapping(value = "/ListaFatture")
	public ModelAndView listaFatture(@ModelAttribute("oggettoFornitoreFattura") Fornitore ofornitore, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		sessionObj.setAttribute("oggettoFornitoreFattura", ofornitore);
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.addObject("oggettoFornitoreFattura", ofornitore);
		model.addObject("elencoFatture", fatser.getFatturePerFornitore(ofornitore.getIdfornitore(), idAnno(sessionObj)));
		model.setViewName("FatturaPassiva/ListaFatture");
		return model;
	}
		
	
	@GetMapping(value = "/AddFattura")
	public ModelAndView addFattura(HttpSession sessionObj) {
		this.count = 0;
		sessionObj.setAttribute("contatore", this.count);
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoFatturaTemporanea", new FatturaPassiva());
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.setViewName("FatturaPassiva/AddFattura");
		return model;
	}
	
	@PostMapping(value = "/AddDettagli")
	public ModelAndView addDettagli(@Valid @ModelAttribute("oggettoFatturaTemporanea") FatturaPassiva ofatturatemporanea, BindingResult bindingresult, HttpSession sessionObj) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("FatturaPassiva/AddFattura");
			model.addObject("elencoFornitori", forser.getAllFornitori());
			return model;
		} else {
		ModelAndView model = new ModelAndView();
		sessionObj.setAttribute("oggettoFatturaTemporanea", ofatturatemporanea);
		model.addObject("oggettoDettagliTemporanei", new FatturaPassivaDettaglio());
		model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
		model.addObject("elencoAliquote", aliser.getAllAliquoteIva());
		model.addObject("elencoPreventivi", preser.getAllPreventivi());
		model.setViewName("FatturaPassiva/AddDettagli");
		return model; }
	}
	
	@GetMapping(value = "/AddDettagliSuccessivi")
	public ModelAndView addDettagliSuccessivi(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoDettagliTemporanei", new FatturaPassivaDettaglio());
		model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
		model.addObject("elencoAliquote", aliser.getAllAliquoteIva());
		model.addObject("elencoPreventivi", preser.getAllPreventivi());
		model.setViewName("FatturaPassiva/AddDettagli");
		return model;
	}
	
	@PostMapping(value = "/SaveDettagliListaNuova")
	public ModelAndView saveDettagli(@Valid @ModelAttribute("oggettoDettagliTemporanei") FatturaPassivaDettaglio odettaglitemporanei, BindingResult bindingresult, HttpSession sessionObj) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
			model.addObject("elencoAliquote", aliser.getAllAliquoteIva());
			model.addObject("elencoPreventivi", preser.getAllPreventivi());
			model.setViewName("FatturaPassiva/AddDettagli");
			return model;
		} else {
		ModelAndView model = new ModelAndView();
		this.count = (int) sessionObj.getAttribute("contatore");
		odettaglitemporanei.setIdentifier(this.count + 1);
		sessionObj.setAttribute("contatore", this.count);
			FatturaPassiva ofattura = (FatturaPassiva) sessionObj.getAttribute("oggettoFatturaTemporanea");
			ofattura.getDettagli().add(odettaglitemporanei);
			sessionObj.setAttribute("oggettoFatturaTemporanea", ofattura);
			sessionObj.setAttribute("oggettoDettagliTemporanei", ofattura.getDettagli());
			model.addObject("oggettoFatturaTemporanea", ofattura);
			model.addObject("elencoDettagli", ofattura.getDettagli());
			model.addObject("elencoFornitori", forser.getAllFornitori());
			model.setViewName("FatturaPassiva/AddFatturaConDettagli");
		return model; }
	}

	@GetMapping(value = "/RimuoviDettagliTemporanei/{identifier}")
	public ModelAndView rimuoviDettagliTemporanei(@PathVariable Integer identifier, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		FatturaPassiva ofattura = (FatturaPassiva) sessionObj.getAttribute("oggettoFatturaTemporanea");
		for(int i = 0; i < ofattura.getDettagli().size(); i++) {
			if(ofattura.getDettagli().get(i).getIdentifier() == identifier) {
				ofattura.getDettagli().remove(i);
			}
		}
		sessionObj.setAttribute("oggettoFatturaTemporanea", ofattura);
		sessionObj.setAttribute("oggettoDettagliTemporanei", ofattura.getDettagli());
		model.addObject("oggettoFatturaTemporanea", ofattura);
		model.addObject("elencoDettagli", ofattura.getDettagli());
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.setViewName("FatturaPassiva/AddFatturaConDettagli");
		return model;
	}
	
	
	@PostMapping(value = "/SaveFattura")
	public ModelAndView saveFattura(@Valid @ModelAttribute("oggettoFatturaTemporanea") FatturaPassiva ofattura,
			BindingResult bindingresult, HttpSession sessionObj, Model modelFornitore) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			FatturaPassiva oFattura = (FatturaPassiva) sessionObj.getAttribute("oggettoFatturaTemporanea");
			model.addObject("elencoDettagli", oFattura.getDettagli());
			model.addObject("elencoFornitori", forser.getAllFornitori());
			model.setViewName("FatturaPassiva/AddFatturaConDettagli");
			return model;
		} else {
			List<FatturaPassivaDettaglio> dettagli = (List<FatturaPassivaDettaglio>) sessionObj.getAttribute("oggettoDettagliTemporanei");
			for(int i = 0; i < dettagli.size(); i++) {
				ofattura.getDettagli().add(dettagli.get(i));				
			}
			fatser.saveOrUpdate(ofattura);
			for(int i = 0; i < ofattura.getDettagli().size(); i++) {
				ofattura.getDettagli().get(i).setOfatturapassiva(ofattura);
				fatdetser.saveOrUpdate(ofattura.getDettagli().get(i));
			}
			sessionObj.removeAttribute("oggettoFatturaTemporanea");
			sessionObj.removeAttribute("oggettoDettagliTemporanei");
			sessionObj.removeAttribute("contatore");
			return new ModelAndView("redirect:/FatturaPassiva/Cerca");
		}
	}




	
	
	
	
	///////////////////////////// Sezione Edit

	@GetMapping(value = "/EditFattura/{id}")
	public ModelAndView editOrdine(@PathVariable Integer id, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		FatturaPassiva ofattura = fatser.getFatturaPassivaById(id);
		sessionObj.setAttribute("oggettoFatturaTemporanea", ofattura);
		model.addObject("oggettoFatturaTemporanea", ofattura);
		model.addObject("elencoDettagli", ofattura.getDettagli());
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.setViewName("FatturaPassiva/EditFattura");
		return model;
	}

	@GetMapping(value = "/EditDettaglio/{id}")
	public ModelAndView editDettagli(@PathVariable Integer id, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoDettaglioTemporaneo", fatdetser.getFatturaPassivaDettaglioById(id));
		model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
		model.addObject("elencoPreventivi", preser.getAllPreventivi());
		model.addObject("elencoAliquote", aliser.getAllAliquoteIva());
		model.setViewName("FatturaPassiva/EditDettaglio");
		return model;
	}
	

	@PostMapping(value = "/SaveDettagliModificati")
	public ModelAndView saveDettagliModificati(
			@Valid @ModelAttribute("oggettoDettaglioTemporaneo") FatturaPassivaDettaglio odettagliotemporaneo,
			BindingResult bindingresult, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		if (bindingresult.hasErrors()) {
			model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
			model.addObject("elencoPreventivi", preser.getAllPreventivi());
			model.addObject("elencoAliquote", aliser.getAllAliquoteIva());
			model.setViewName("FatturaPassiva/EditDettaglio");
			return model;
		} else {
			FatturaPassiva ofattura = (FatturaPassiva) sessionObj.getAttribute("oggettoFatturaTemporanea");
			for (int i = 0; i < ofattura.getDettagli().size(); i++) {
				if (ofattura.getDettagli().get(i).getIdfatturapassivadettaglio() == odettagliotemporaneo
						.getIdfatturapassivadettaglio()) {
					ofattura.getDettagli().get(i).setImporto(odettagliotemporaneo.getImporto());
					ofattura.getDettagli().get(i).setOpreventivo(odettagliotemporaneo.getOpreventivo());
					ofattura.getDettagli().get(i).setOspesainvestimento(odettagliotemporaneo.getOspesainvestimento());
					ofattura.getDettagli().get(i).setOaliquota(odettagliotemporaneo.getOaliquota());
					ofattura.getDettagli().get(i).setDettagliofattura(odettagliotemporaneo.getDettagliofattura());
					ofattura.getDettagli().get(i).setImporto(odettagliotemporaneo.getImporto());
					ofattura.getDettagli().get(i).setImportoPagato(odettagliotemporaneo.getImportoPagato());
				}
			}
			sessionObj.setAttribute("oggettoFatturaTemporanea", ofattura);
			sessionObj.setAttribute("oggettoDettagliTemporanei", ofattura.getDettagli());
			model.addObject("oggettoFatturaTemporanea", ofattura);
			model.addObject("elencoDettagli", ofattura.getDettagli());
			model.addObject("elencoFornitori", forser.getAllFornitori());
			model.setViewName("FatturaPassiva/EditFattura");
			return model;
		}
	}

	@PostMapping(value = "/SaveEditFattura")
	public ModelAndView saveEditFattura(@Valid @ModelAttribute("oggettoFatturaTemporanea") FatturaPassiva ofattura,
			BindingResult bindingresult, HttpSession sessionObj, Model modelFornitore) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			FatturaPassiva oFattura = (FatturaPassiva) sessionObj.getAttribute("oggettoFatturaTemporanea");
			model.addObject("elencoDettagli", oFattura.getDettagli());
			model.addObject("elencoFornitori", forser.getAllFornitori());
			model.setViewName("FatturaPassiva/AddFatturaConDettagli");
			return model;
		} else {
			List<FatturaPassivaDettaglio> dettagli = new ArrayList<FatturaPassivaDettaglio>();
			if (sessionObj.getAttribute("oggettoDettagliTemporanei") != null) {
				dettagli = (List<FatturaPassivaDettaglio>) sessionObj.getAttribute("oggettoDettagliTemporanei");
			}
			fatser.saveOrUpdate(ofattura);
//			for (int i = 0; i < oordine.getDettagli().size(); i++) {
//				orddetser.saveOrUpdate(dettagli.get(i));
//			}
			sessionObj.removeAttribute("oggettoFatturaTemporanea");
			sessionObj.removeAttribute("oggettoDettagliTemporanei");
			sessionObj.removeAttribute("contatore");
			return new ModelAndView("redirect:/FatturaPassiva/Cerca");
		}
	}

//	@GetMapping(value = "/AddDettagliModifica/")
//	public ModelAndView addDettagliModifica() {
//		ModelAndView model = new ModelAndView();
//		model.addObject("oggettoDettaglioTemporaneo", new OrdineDiAcquistoDettaglio());
//		model.addObject("elencoSpese", spesaser.getAllSpeseInvestimento());
//		model.addObject("elencoProgetti", proser.getAllProgetti());
//		model.setViewName("OrdineAcquisto/AddDettaglioModifica");
//		return model;
//	}
//	
//	@GetMapping(value = "/RimuoviDettagli/{id}") 
//	public ModelAndView rimuoviDettagli(@PathVariable Integer id, HttpSession sessionObj) {
//		ModelAndView model = new ModelAndView();
//		if(sessionObj.getAttribute("chiavi") != null) {
//			for(int i = 0; i < ((List<Integer>) sessionObj.getAttribute("chiavi")).size(); i++) {
//				this.chiavi.add(((List<Integer>) sessionObj.getAttribute("chiavi")).get(i));
//			} this.chiavi.add(id);
//			sessionObj.setAttribute("chiavi", this.chiavi);
//		} else {
//			sessionObj.setAttribute("chiavi", id);
//		}
//		model.setViewName("OrdineAcquisto/EditOrdine/{id}");
//		return model;
//	}
	
	
	
	
	
	
	
	////////////////////////////RICERCHE

	
	@GetMapping(value = "/Ricerca")
	public ModelAndView ricerca() {
		ModelAndView model = new ModelAndView("FatturaPassiva/RicercaFatture");
		return model;
	}

	@GetMapping(value = "/Fornitore")
	public ModelAndView sceltaFornitore() {
		ModelAndView model = new ModelAndView();
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.addObject("oggettoFornitore", new Fornitore());
		model.setViewName("FatturaPassiva/ElencoPerFornitore");
		return model;
	}

	@PostMapping(value = "CercaPerFornitore")
	public ModelAndView ricercaPerFornitore(@ModelAttribute Fornitore ofornitore, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		List<FatturaPassiva> elenco = fatser.getFatturePerFornitore(ofornitore.getIdfornitore(), idAnno(sessionObj));
		for (int i = 0; i < elenco.size(); i++) {
			List<FatturaPassivaDettaglio> elencoDettagli = elenco.get(i).getDettagli();
			for (int j = 0; j < elencoDettagli.size(); j++) {
				if (elencoDettagli.get(j).getOspesainvestimento().getOsottocategoria().getOarea().getOannocontabile()
						.getIdannocontabile() != idAnno(sessionObj)) {
					elenco.remove(i);
				}

			}
		}
		model.addObject("elencoFatturePassive", elenco);
		model.setViewName("FatturaPassiva/ElencoPerFornitore");
		model.addObject("elencoFornitori", forser.getAllFornitori());
		model.addObject("oggettoFornitore", ofornitore);
		return model;
	}

	@GetMapping(value = "/Preventivo")
	public ModelAndView sceltaPreventivo() {
		ModelAndView model = new ModelAndView();
		model.addObject("elencoPreventivi", preser.getAllPreventivi());
		model.addObject("oggettoPreventivo", new Preventivo());
		model.setViewName("FatturaPassiva/ElencoPerPreventivo");
		return model;
	}

	@PostMapping(value = "/CercaPerPreventivo")
	public ModelAndView ricercaPerPreventivo(@ModelAttribute Preventivo opreventivo, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		model.addObject("elencoPreventivi", preser.getAllPreventivi());
		model.addObject("oggettoPreventivo", opreventivo);
		List<FatturaPassivaDettaglio> listadettagli = fatdetser.getFatturePerPreventivo(opreventivo.getIdpreventivo(),
				idAnno(sessionObj));
		List<FatturaPassiva> listafatture = new ArrayList<FatturaPassiva>();
		for (int i = 0; i < listadettagli.size(); i++) {
			listafatture.add(listadettagli.get(i).getOfatturapassiva());
		}
		boolean trovato;
		if (listafatture.size() != 0) {
			for (int i = listafatture.size() - 1; i > 0; i--) {
				trovato = false;
				for (int j = listafatture.size() - 2; j >= 0 && !trovato; j--) {
					if (listafatture.get(i).getIdfatturapassiva() == listafatture.get(j).getIdfatturapassiva()) {
						listafatture.remove(j);
						trovato = true;
					}
				}
			}
		}
		model.addObject("elencoFatturePassive", listafatture);
		model.setViewName("FatturaPassiva/ElencoPerPreventivo");
		return model;
	}

	@GetMapping(value = "/SottoCategoria")
	public ModelAndView sceltaSottoCategoria() {
		ModelAndView model = new ModelAndView();
		model.addObject("elencoSottoCategorie", sotser.getAllSottoCategorie());
		model.addObject("oggettoSottoCategoria", new SottoCategoria());
		model.setViewName("FatturaPassiva/ElencoPerSottoCategoria");
		return model;
	}

	@PostMapping(value = "/CercaPerSottoCategoria")
	public ModelAndView ricercaPerSottoCategoria(@ModelAttribute SottoCategoria osottocategoria,
			HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		model.addObject("elencoSottoCategorie", sotser.getAllSottoCategorie());
		model.addObject("oggettoSottoCategoria", osottocategoria);
		List<FatturaPassivaDettaglio> listadettagli = fatdetser
				.getFatturePerSottoCategoria(osottocategoria.getIdsottocategoria(), idAnno(sessionObj));
		List<FatturaPassiva> listafatture = new ArrayList<FatturaPassiva>();
		for (int i = 0; i < listadettagli.size(); i++) {
			listafatture.add(listadettagli.get(i).getOfatturapassiva());
		}
		boolean trovato;
		if (listafatture.size() != 0) {
			for (int i = listafatture.size() - 1; i > 0; i--) {
				trovato = false;
				for (int j = listafatture.size() - 2; j >= 0 && !trovato; j--) {
					if (listafatture.get(i).getIdfatturapassiva() == listafatture.get(j).getIdfatturapassiva()) {
						listafatture.remove(j);
						trovato = true;
					}
				}
			}
		}
		model.addObject("elencoFatturePassive", listafatture);
		model.setViewName("FatturaPassiva/ElencoPerSottoCategoria");
		return model;
	}

	
	
	
}
