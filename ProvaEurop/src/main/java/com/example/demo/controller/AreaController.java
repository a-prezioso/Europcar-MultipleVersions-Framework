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

import com.example.demo.model.Area;
import com.example.demo.model.Venditore;
import com.example.demo.service.AreaService;
import com.example.demo.service.VenditoreService;

@Controller
@RequestMapping(value = "/Area")
public class AreaController {

	@Autowired
	AreaService areaservice;

	@Autowired
	VenditoreService venditoreservice;

	@GetMapping(value = "/ListaAree")
	public ModelAndView listaAree() {
		ModelAndView model = new ModelAndView("Area/ListaAree");
		List<Area> listaaree = areaservice.getAllAree();
		model.addObject("elencoAree", listaaree);
		return model;
	}

	@GetMapping(value = "/AddArea")
	public ModelAndView addArea() {
		ModelAndView model = new ModelAndView();
		Area oArea = new Area();
		model.addObject("oggettoArea", oArea);
		List<Venditore> listavenditori = venditoreservice.getAllVenditori();
		model.addObject("elencoVenditori", listavenditori);
		model.setViewName("Area/AddEditArea");
		return model;
	}

	@GetMapping(value = "/EditArea/{id}")
	public ModelAndView editArea(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Area oArea = areaservice.getAreaById(id);
		model.addObject("oggettoArea", oArea);
		List<Venditore> listavenditori = venditoreservice.getAllVenditori();
		model.addObject("elencoVenditori", listavenditori);
		model.setViewName("Area/AddEditArea");
		return model;
	}

	@PostMapping(value = "/SaveArea")
	public ModelAndView saveArea(@Valid @ModelAttribute("oggettoArea") Area oArea, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Area/AddEditArea");
			return model;
		} else {
			areaservice.saveOrUpdate(oArea);
			return new ModelAndView("redirect:/Area/ListaAree");
		}
	}

	@GetMapping(value = "/DeleteArea/{id}")
	public ModelAndView deleteArea(@PathVariable("id") Integer id) {
		areaservice.deleteArea(id);
		return new ModelAndView("redirect:/Area/ListaAree");
	}

}
