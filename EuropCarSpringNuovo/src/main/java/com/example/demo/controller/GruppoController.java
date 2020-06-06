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

import com.example.demo.model.Gruppo;
import com.example.demo.service.GruppoService;

@Controller
@RequestMapping(value = "/Gruppo")
public class GruppoController {

	@Autowired
	GruppoService Grupposervice;

	@GetMapping(value = "/ListaGruppi")
	public ModelAndView listaGruppi() {
		ModelAndView model = new ModelAndView("Gruppo/ListaGruppi");
		List<Gruppo> listagruppi = Grupposervice.getAllGruppi();
		model.addObject("elencoGruppi", listagruppi);
		return model;
	}

	@GetMapping(value = "/AddGruppo")
	public ModelAndView addGruppo() {
		ModelAndView model = new ModelAndView();
		Gruppo oGruppo = new Gruppo();
		model.addObject("oggettoGruppo", oGruppo);
		model.setViewName("Gruppo/AddEditGruppo");
		return model;
	}

	@GetMapping(value = "/EditGruppo/{id}")
	public ModelAndView editGruppo(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Gruppo oGruppo = Grupposervice.getGruppoById(id);
		model.addObject("oggettoGruppo", oGruppo);
		model.setViewName("Gruppo/AddEditGruppo");
		return model;
	}

	@PostMapping(value= "/SaveGruppo")
	public ModelAndView saveGruppo(@Valid @ModelAttribute("oggettoGruppo") Gruppo oGruppo, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Gruppo/AddEditGruppo");
			return model;
		} else {
		Grupposervice.saveOrUpdate(oGruppo);
		return new ModelAndView("redirect:/Gruppo/ListaGruppi");
		}
	}

	@GetMapping(value = "/DeleteGruppo/{id}")
	public ModelAndView deleteGruppo(@PathVariable("id") Integer id) {
		Grupposervice.deleteGruppo(id);
		return new ModelAndView("redirect:/Gruppo/ListaGruppi");
	}

}
