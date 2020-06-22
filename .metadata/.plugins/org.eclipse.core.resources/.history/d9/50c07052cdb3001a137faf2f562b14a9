package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.SottoCategoriaService;

@Controller
@RequestMapping(value = "Budget")
public class BudgetController {
	
	@Autowired
	SottoCategoriaService sotser;
	
	@RequestMapping(value = "/Lista", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("Menu/Budget");
		return model;
	}
	
	@GetMapping(value = "Riconciliazione")
	public ModelAndView riconciliazione() {
		ModelAndView model = new ModelAndView("Budget/Riconciliazione");
		model.addObject("elencoSottoCategorie", sotser.getAllSottoCategorie());
		return model;
	}

}
