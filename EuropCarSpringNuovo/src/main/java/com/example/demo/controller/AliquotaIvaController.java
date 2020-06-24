package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AliquotaIva;
import com.example.demo.service.AliquotaIvaService;

@Controller
@RequestMapping(value = "/AliquotaIva")
public class AliquotaIvaController {
	
	@Autowired
	private Environment environment;

	@Autowired
	AliquotaIvaService AliquotaIvaservice;
	
	@Autowired
	@Qualifier("1")
	AliquotaIva aliquota;

	@GetMapping(value = "/ListaAliquoteIva")
	public ModelAndView listaAliquoteIva() {
		ModelAndView model = new ModelAndView("AliquotaIva/ListaAliquoteIva");
		List<AliquotaIva> listaaliquoteIva = AliquotaIvaservice.getAllAliquoteIva();
		model.addObject("elencoAliquoteIva", listaaliquoteIva);
		environment.getProperty("prova");
		return model;
	}

	@GetMapping(value = "/AddAliquotaIva")
	public ModelAndView addAliquotaIva() {
		ModelAndView model = new ModelAndView();
		AliquotaIva oAliquotaIva = new AliquotaIva();
		model.addObject("oggettoAliquotaIva", oAliquotaIva);
		model.setViewName("AliquotaIva/AddEditAliquotaIva");
		return model;
	}

	@GetMapping(value = "/EditAliquotaIva/{id}")
	public ModelAndView editAliquotaIva(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		AliquotaIva oAliquotaIva = AliquotaIvaservice.getAliquotaIvaById(id);
		model.addObject("oggettoAliquotaIva", oAliquotaIva);
		model.setViewName("AliquotaIva/AddEditAliquotaIva");
		return model;
	}

	@PostMapping(value = "/SaveAliquotaIva")
	public ModelAndView saveAliquotaIva(@Valid @ModelAttribute("oggettoAliquotaIva") AliquotaIva oAliquotaIva) {

			AliquotaIvaservice.saveOrUpdate(oAliquotaIva);
			return new ModelAndView("redirect:/AliquotaIva/ListaAliquoteIva");
		
	}

	@GetMapping(value = "/DeleteAliquotaIva/{id}")
	public ModelAndView deleteAliquotaIva(@PathVariable("id") Integer id) {
		AliquotaIvaservice.deleteAliquotaIva(id);
		return new ModelAndView("redirect:/AliquotaIva/ListaAliquoteIva");
	}

}
