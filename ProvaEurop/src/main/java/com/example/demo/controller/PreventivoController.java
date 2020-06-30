package com.example.demo.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Fornitore;
import com.example.demo.model.Preventivo;
import com.example.demo.service.FornitoreService;
import com.example.demo.service.PreventivoService;

@Controller
@RequestMapping(value = "/Preventivo")
public class PreventivoController {

	@Autowired
	PreventivoService preventivoservice;

	@Autowired
	FornitoreService fornitoreservice;

	@GetMapping(value = "/Cerca")
	public ModelAndView cercaPreventivi(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		if (sessionObj.getAttribute("oggettoFornitorePreventivo") != null) {
			Fornitore ofornitore = (Fornitore) sessionObj.getAttribute("oggettoFornitorePreventivo");
			model.addObject("elencoPreventivi", preventivoservice.getPreventiviByForn(ofornitore.getIdfornitore()));
		} else {
			sessionObj.setAttribute("oggettoFornitorePreventivo", new Fornitore());
		}
		model.addObject("oggettoFornitoreSelezione", new Fornitore());
		model.addObject("elencoFornitori", fornitoreservice.getAllFornitori());
		model.setViewName("Preventivo/ListaPreventivi");
		return model;
	}

	@PostMapping(value = "/ListaPreventivi")
	public ModelAndView listaPreventivi(@ModelAttribute Fornitore ofornitore, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoFornitoreSelezione", ofornitore);
		sessionObj.setAttribute("oggettoFornitorePreventivo", ofornitore);
		model.addObject("elencoFornitori", fornitoreservice.getAllFornitori());
		model.addObject("elencoPreventivi", preventivoservice.getPreventiviByForn(ofornitore.getIdfornitore()));
		model.setViewName("Preventivo/ListaPreventivi");
		return model;
	}

	@GetMapping(value = "/AddPreventivo")
	public ModelAndView addSottoCategoria() {
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoPreventivo", new Preventivo());
		model.addObject("elencoFornitori", fornitoreservice.getAllFornitori());
		model.setViewName("Preventivo/AddEditPreventivo");
		return model;
	}

	@GetMapping(value = "/EditPreventivo/{id}")
	public ModelAndView editPreventivo(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoPreventivo", preventivoservice.getPreventivoById(id));
		model.addObject("elencoFornitori", fornitoreservice.getAllFornitori());
		model.setViewName("Preventivo/AddEditPreventivo");
		return model;
	}

	@PostMapping(value = "/SavePreventivo")
	public ModelAndView savePreventivo(@Valid @ModelAttribute("oggettoPreventivo") Preventivo opreventivo,
			BindingResult bindingresult, HttpSession sessionObj, Model modelFornitore) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Preventivo/AddEditPreventivo");
			return model;
		} else {
			opreventivo.getIdpreventivo();
			preventivoservice.saveOrUpdate(opreventivo);
//		sessionObj.removeAttribute("oggettoFornitorePreventivo");
			return new ModelAndView("redirect:/Preventivo/Cerca");
		}
	}

	@GetMapping(value = "/DeletePreventivo/{id}")
	public ModelAndView deletePreventivo(@PathVariable("id") Integer id) {
		preventivoservice.deletePreventivo(id);
		return new ModelAndView("redirect:/Preventivo/Cerca");
	}

}
