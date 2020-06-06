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
import com.example.demo.model.AreaInvestimento;
import com.example.demo.service.AnnoContabileService;
import com.example.demo.service.AreaInvestimentoService;

@Controller
@RequestMapping(value = "/AreaInvestimento")
public class AreaInvestimentoController {
	
	@Autowired
	AreaInvestimentoService areaservice;
	
	@Autowired
	AnnoContabileService annoservice;

	@GetMapping(value = "/ListaAreeInvestimento")
	public ModelAndView listaAreeInvestimento(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView("AreaInvestimento/ListaAreeInvestimento");
		AnnoContabile oanno = (AnnoContabile) sessionObj.getAttribute("oggettoAnnoPermanente");
		List<AreaInvestimento> listaAreeInvestimento = areaservice.getAreePerAnno(oanno.getIdannocontabile());
		model.addObject("elencoAreeInvestimento", listaAreeInvestimento);
		return model;
	}

	@GetMapping(value = "/AddAreaInvestimento")
	public ModelAndView addAreaInvestimento() {
		ModelAndView model = new ModelAndView();
		AreaInvestimento oAreaInvestimento = new AreaInvestimento();
		model.addObject("oggettoAreaInvestimento", oAreaInvestimento);
		List<AnnoContabile> listaanni = annoservice.getAllAnni();
		model.addObject("elencoAnni", listaanni);
		model.setViewName("AreaInvestimento/AddEditAreaInvestimento");
		return model;
	}

	@GetMapping(value = "/EditAreaInvestimento/{id}")
	public ModelAndView editAreaInvestimento(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		AreaInvestimento oAreaInvestimento = areaservice.getAreaInvestimentoById(id);
		model.addObject("oggettoAreaInvestimento", oAreaInvestimento);
		List<AnnoContabile> lsitaanni = annoservice.getAllAnni();
		model.addObject("elencoAnni", lsitaanni);
		model.setViewName("AreaInvestimento/AddEditAreaInvestimento");
		return model;
	}

	@PostMapping(value= "/SaveAreaInvestimento")
	public ModelAndView saveAreaInvestimento(@Valid @ModelAttribute("oggettoAreaInvestimento") AreaInvestimento oAreaInvestimento, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("AreaInvestimento/AddEditAreaInvestimento");
			return model;
		} else {
		areaservice.saveOrUpdate(oAreaInvestimento);
		return new ModelAndView("redirect:/AreaInvestimento/ListaAreeInvestimento");
		}
	}

	@GetMapping(value = "/DeleteAreaInvestimento/{id}")
	public ModelAndView deleteAreaInvestimento(@PathVariable("id") Integer id) {
		areaservice.deleteArea(id);
		return new ModelAndView("redirect:/AreaInvestimento/ListaAreeInvestimento");
	}

}
