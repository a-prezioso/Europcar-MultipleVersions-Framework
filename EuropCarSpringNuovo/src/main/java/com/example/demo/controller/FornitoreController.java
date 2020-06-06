package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Fornitore;
import com.example.demo.service.FornitoreService;

@Controller
@RequestMapping(value = "/Fornitore")
public class FornitoreController {

	@Autowired
	FornitoreService Fornitoreservice;

	@GetMapping(value = "/ListaFornitori")
	public ModelAndView listaFornitori() {
		ModelAndView model = new ModelAndView("Fornitore/ListaFornitori");
		List<Fornitore> listafornitori = Fornitoreservice.getAllFornitori();
		model.addObject("elencoFornitori", listafornitori);
		return model;
	}

	@GetMapping(value = "/AddFornitore")
	public ModelAndView addFornitore() {
		ModelAndView model = new ModelAndView();
		Fornitore oFornitore = new Fornitore();
		model.addObject("oggettoFornitore", oFornitore);
		model.setViewName("Fornitore/AddEditFornitore");
		return model;
	}

	@GetMapping(value = "/EditFornitore/{id}")
	public ModelAndView editFornitore(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Fornitore oFornitore = Fornitoreservice.getFornitoreById(id);
		model.addObject("oggettoFornitore", oFornitore);
		model.setViewName("Fornitore/AddEditFornitore");
		return model;
	}

	@PostMapping(value= "/SaveFornitore")
	public ModelAndView saveFornitore(@Valid @ModelAttribute("oggettoFornitore") Fornitore oFornitore, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Fornitore/AddEditFornitore");
			return model;
		} else {
		Fornitoreservice.saveOrUpdate(oFornitore);
		return new ModelAndView("redirect:/Fornitore/ListaFornitori");
		}
	}

	@GetMapping(value = "/DeleteFornitore/{id}")
	public ModelAndView deleteFornitore(@PathVariable("id") Integer id) {
		Fornitoreservice.deleteFornitore(id);
		return new ModelAndView("redirect:/Fornitore/ListaFornitori");
	}

}
