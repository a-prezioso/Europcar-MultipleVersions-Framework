package com.example.demo.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.TipoVenditore;
import com.example.demo.model.Venditore;
import com.example.demo.service.TipoVenditoreService;
import com.example.demo.service.VenditoreService;

@Controller
@RequestMapping(value = "/Venditore")
public class VenditoreController {

	@Autowired
	VenditoreService Venditoreservice;

	@Autowired
	TipoVenditoreService tipovenditoreservice;

	@GetMapping(value = "/ListaVenditori")
	public ModelAndView listaVenditori() {
		ModelAndView model = new ModelAndView("Venditore/ListaVenditori");
		List<Venditore> listaVenditori = Venditoreservice.getAllVenditori();
		model.addObject("elencoVenditori", listaVenditori);
		return model;
	}

	@GetMapping(value = "/AddVenditore")
	public ModelAndView addVenditore(Model model2, HttpSession sessionObj) {
		Venditore oVenditore = new Venditore();

		if (sessionObj.getAttribute("venditore") != null) {
			Venditore ovenditore = (Venditore) sessionObj.getAttribute("venditore");
			oVenditore.setNome(ovenditore.getNome());
			oVenditore.setCognome(ovenditore.getCognome());
			oVenditore.setIndirizzo(ovenditore.getIndirizzo());
			oVenditore.setNumerotelefono(ovenditore.getNumerotelefono());
		}
		ModelAndView model = new ModelAndView();
		model.addObject("oggettoVenditore", oVenditore);
		List<TipoVenditore> listatipivenditore = tipovenditoreservice.getAllTipiVenditore();
		model.addObject("elencoTipiVenditore", listatipivenditore);
		model.setViewName("Venditore/AddEditVenditore");
		return model;
	}

	@GetMapping(value = "/EditVenditore/{id}")
	public ModelAndView editVenditore(@PathVariable Integer id, HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		if (id != 0) {
			Venditore oVenditore = Venditoreservice.getVenditoreById(id);
			model.addObject("oggettoVenditore", oVenditore);
		} else {
			Venditore ovenditore = (Venditore) sessionObj.getAttribute("venditore");
			model.addObject("oggettoVenditore", ovenditore);
		}
		sessionObj.setAttribute("idvenditore", id);
		List<TipoVenditore> listatipivenditore = tipovenditoreservice.getAllTipiVenditore();
		model.addObject("elencoTipiVenditore", listatipivenditore);
		model.setViewName("Venditore/AddEditVenditore");
		return model;
	}

	@PostMapping(value = "/SaveVenditore")
	public ModelAndView saveVenditore(@Valid @ModelAttribute("oggettoVenditore") Venditore oVenditore,
			BindingResult bindingresult, HttpSession sessionObj) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Venditore/AddEditVenditore");
			return model;
		} else {
			if (oVenditore.getOtipovenditore() == null) {
				sessionObj.setAttribute("venditore", oVenditore);
				return new ModelAndView("redirect:/TipoVenditore/AddTipoVenditore");
			} else {
				Venditoreservice.saveOrUpdate(oVenditore);
				sessionObj.removeAttribute("venditore");
				return new ModelAndView("redirect:/Venditore/ListaVenditori");
			}
		}
	}

	@GetMapping(value = "/DeleteVenditore/{id}")
	public ModelAndView deleteVenditore(@PathVariable("id") Integer id) {
		Venditoreservice.deleteVenditore(id);
		return new ModelAndView("redirect:/Venditore/ListaVenditori");
	}

	@PostMapping(value = "/AddTipoVenditore")
	public ModelAndView AddTipoVenditore() {

		ModelAndView model = new ModelAndView();
		model.setViewName("TipoVenditore/AddEditTipoVenditore");
		return model;

	}

}
