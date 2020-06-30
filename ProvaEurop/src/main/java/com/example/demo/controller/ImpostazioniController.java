package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Impostazioni")
public class ImpostazioniController {

	@RequestMapping(value="/Lista", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("Impostazioni/Lista");
		return model;
	}
}
