package com.example.demo.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AnnoContabile;
import com.example.demo.service.AnnoContabileService;

@Controller
@RequestMapping(value = "/AnnoContabile")
public class AnnoContabileController {
	
	@Autowired
	AnnoContabileService annoservice;
	
	@GetMapping(value = "/ListaAnni")
	public ModelAndView listaAnni() {
		ModelAndView model = new ModelAndView("AnnoContabile/ListaAnni");
		List<AnnoContabile> listaanni= annoservice.getAllAnni();
		model.addObject("elencoAnni", listaanni);
		return model;
	}

	@GetMapping(value = "/GeneraAnno")
	public ModelAndView addAreaInvestimento() {
		AnnoContabile oannovecchio = annoservice.getUltimoAnno();
		Calendar datafine = Calendar.getInstance();
		datafine.setTime(oannovecchio.getDatafine());
		datafine.add(Calendar.YEAR, 1);
		Calendar datainizio = Calendar.getInstance();
		datainizio.setTime(oannovecchio.getDatainizio());
		datainizio.add(Calendar.YEAR, 1);
		int a = datainizio.get(Calendar.YEAR);
		String b = String.valueOf(a);
		int c = datafine.get(Calendar.YEAR);
		String d = String.valueOf(c);
		AnnoContabile oanno = new AnnoContabile();
		oanno.setDescrizione(b + "/" + d);
		oanno.setDatainizio(datainizio.getTime());
		oanno.setDatafine(datafine.getTime()); 
		annoservice.saveOrUpdate(oanno);
		return new ModelAndView("redirect:/AnnoContabile/ListaAnni");
	
	}
	
	@GetMapping(value = "/DeleteAnnoContabile/{id}")
	public ModelAndView deleteAnnoContabile(@PathVariable("id") Integer id) {
		annoservice.deleteAnnoContabile(id);
		return new ModelAndView("redirect:/AnnoContabile/ListaAnni");
	}

}
