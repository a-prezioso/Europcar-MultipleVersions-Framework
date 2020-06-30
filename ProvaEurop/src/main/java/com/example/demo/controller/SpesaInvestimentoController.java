package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.example.demo.model.AnnoContabile;
import com.example.demo.model.SottoCategoria;
import com.example.demo.model.SpesaInvestimento;
import com.example.demo.service.SottoCategoriaService;
import com.example.demo.service.SpesaInvestimentoService;

@Controller
@RequestMapping(value="/SpesaInvestimento")
public class SpesaInvestimentoController {

	@Autowired
	SpesaInvestimentoService speser;
	
	@Autowired
	SottoCategoriaService sotser;
	
	@GetMapping(value="/ListaSpeseInvestimento")
	public ModelAndView listaspese(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		AnnoContabile oanno = (AnnoContabile) sessionObj.getAttribute("oggettoAnnoPermanente");
		model.addObject("elencoSpeseInvestimento", speser.getSpesePerAnno(oanno.getIdannocontabile()));
		model.setViewName("SpesaInvestimento/ListaSpeseInvestimento");
		return model;
	}
	
	

	@GetMapping(value = "/AddSpesaInvestimento")
	public ModelAndView addSpesaInvestimento() {
		ModelAndView model = new ModelAndView();
		SpesaInvestimento oSpesaInvestimento = new SpesaInvestimento();
		model.addObject("oggettoSpesaInvestimento", oSpesaInvestimento);
		List<SottoCategoria> listasottocategorie = sotser.getAllSottoCategorie();
		model.addObject("elencoSottoCategorie", listasottocategorie);
		model.setViewName("SpesaInvestimento/AddEditSpesaInvestimento");
		return model;
	}

	@GetMapping(value = "/EditSpesaInvestimento/{id}")
	public ModelAndView editSpesaInvestimento(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		SpesaInvestimento oSpesaInvestimento = speser.getSpesaInvestimentoById(id);
		model.addObject("oggettoSpesaInvestimento", oSpesaInvestimento);
		List<SottoCategoria> listasottocategorie = sotser.getAllSottoCategorie();
		model.addObject("elencoSottoCategorie", listasottocategorie);
		model.setViewName("SpesaInvestimento/AddEditSpesaInvestimento");
		return model;
	}

	@PostMapping(value= "/SaveSpesaInvestimento")
	public ModelAndView saveSpesaInvestimento(@Valid @ModelAttribute("oggettoSpesaInvestimento") SpesaInvestimento oSpesaInvestimento, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("SpesaInvestimento/AddEditSpesaInvestimento");
			return model;
		} else {
		speser.saveOrUpdate(oSpesaInvestimento);
		return new ModelAndView("redirect:/SpesaInvestimento/ListaSpeseInvestimento");
		}
	}

	@GetMapping(value = "/DeleteSpesaInvestimento/{id}")
	public ModelAndView deleteSpesaInvestimento(@PathVariable("id") Integer id) {
		speser.deleteSpesaInvestimento(id);
		return new ModelAndView("redirect:/SpesaInvestimento/ListaSpeseInvestimento");
	}
	
	
	
	
	
}
