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

import com.example.demo.model.Progetto;
import com.example.demo.service.ProgettoService;

@Controller
@RequestMapping(value = "/Progetto")
public class ProgettoController {

	@Autowired
	ProgettoService Progettoservice;

	@GetMapping(value = "/ListaProgetti")
	public ModelAndView listaProgetti() {
		ModelAndView model = new ModelAndView("Progetto/ListaProgetti");
		List<Progetto> listaprogetti = Progettoservice.getAllProgetti();
		model.addObject("elencoProgetti", listaprogetti);
		return model;
	}

	@GetMapping(value = "/AddProgetto")
	public ModelAndView addProgetto() {
		ModelAndView model = new ModelAndView();
		Progetto oProgetto = new Progetto();
		model.addObject("oggettoProgetto", oProgetto);
		model.setViewName("Progetto/AddEditProgetto");
		return model;
	}

	@GetMapping(value = "/EditProgetto/{id}")
	public ModelAndView editProgetto(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Progetto oProgetto = Progettoservice.getProgettoById(id);
		model.addObject("oggettoProgetto", oProgetto);
		model.setViewName("Progetto/AddEditProgetto");
		return model;
	}

	@PostMapping(value= "/SaveProgetto")
	public ModelAndView saveProgetto(@Valid @ModelAttribute("oggettoProgetto") Progetto oProgetto, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Progetto/AddEditProgetto");
			return model;
		} else {
		Progettoservice.saveOrUpdate(oProgetto);
		return new ModelAndView("redirect:/Progetto/ListaProgetti");
		}
	}

	@GetMapping(value = "/DeleteProgetto/{id}")
	public ModelAndView deleteProgetto(@PathVariable("id") Integer id) {
		Progettoservice.deleteProgetto(id);
		return new ModelAndView("redirect:/Progetto/ListaProgetti");
	}

}
