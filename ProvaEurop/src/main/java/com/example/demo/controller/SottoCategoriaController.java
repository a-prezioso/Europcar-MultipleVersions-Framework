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
import com.example.demo.model.SottoCategoria;
import com.example.demo.service.AreaInvestimentoService;
import com.example.demo.service.SottoCategoriaService;

@Controller
@RequestMapping(value = "/SottoCategoria")
public class SottoCategoriaController {

	@Autowired
	SottoCategoriaService sottoCategoriaservice;
	
	@Autowired
	AreaInvestimentoService areaservice;

	@GetMapping(value = "/ListaSottoCategorie")
	public ModelAndView listaSottoCategorie(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView("SottoCategoria/ListaSottoCategorie");
		AnnoContabile oanno = (AnnoContabile) sessionObj.getAttribute("oggettoAnnoPermanente");
		List<SottoCategoria> listaSottoCategorie = sottoCategoriaservice.getSottoCategoriePerAnno(oanno.getIdannocontabile());
		model.addObject("elencoSottoCategorie", listaSottoCategorie);
		return model;
	}

	@GetMapping(value = "/AddSottoCategoria")
	public ModelAndView addSottoCategoria() {
		ModelAndView model = new ModelAndView();
		SottoCategoria oSottoCategoria = new SottoCategoria();
		model.addObject("oggettoSottoCategoria", oSottoCategoria);
		List<AreaInvestimento> listaaree = areaservice.getAllAreeInvestimento();
		model.addObject("elencoAree", listaaree);
		model.setViewName("SottoCategoria/AddEditSottoCategoria");
		return model;
	}

	@GetMapping(value = "/EditSottoCategoria/{id}")
	public ModelAndView editSottoCategoria(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		SottoCategoria oSottoCategoria = sottoCategoriaservice.getSottoCategoriaById(id);
		model.addObject("oggettoSottoCategoria", oSottoCategoria);
		List<AreaInvestimento> listaaree = areaservice.getAllAreeInvestimento();
		model.addObject("elencoAree", listaaree);
		model.setViewName("SottoCategoria/AddEditSottoCategoria");
		return model;
	}

	@PostMapping(value= "/SaveSottoCategoria")
	public ModelAndView saveSottoCategoria(@Valid @ModelAttribute("oggettoSottoCategoria") SottoCategoria oSottoCategoria, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("SottoCategoria/AddEditSottoCategoria");
			return model;
		} else {
		sottoCategoriaservice.saveOrUpdate(oSottoCategoria);
		return new ModelAndView("redirect:/SottoCategoria/ListaSottoCategorie");
		}
	}

	@GetMapping(value = "/DeleteSottoCategoria/{id}")
	public ModelAndView deleteSottoCategoria(@PathVariable("id") Integer id) {
		sottoCategoriaservice.deleteSottoCategoria(id);
		return new ModelAndView("redirect:/SottoCategoria/ListaSottoCategorie");
	}

}
