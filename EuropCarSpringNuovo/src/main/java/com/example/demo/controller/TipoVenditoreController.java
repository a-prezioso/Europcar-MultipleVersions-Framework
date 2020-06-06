package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.TipoVenditore;
import com.example.demo.service.TipoVenditoreService;

@Controller
@RequestMapping(value = "/TipoVenditore")
public class TipoVenditoreController {

	@Autowired
	TipoVenditoreService TipoVenditoreservice;

	@GetMapping(value = "/AddTipoVenditore")
	public ModelAndView addTipoVenditore() {

		ModelAndView model = new ModelAndView();
		TipoVenditore oTipoVenditore = new TipoVenditore();
		model.addObject("oggettoTipoVenditore", oTipoVenditore);
		model.setViewName("TipoVenditore/AddEditTipoVenditore");
		return model;
	}

	@PostMapping(value = "/SaveTipoVenditore")
	public ModelAndView saveTipoVenditore(@Valid @ModelAttribute("oggettoTipoVenditore") TipoVenditore oTipoVenditore,
			BindingResult bindingresult, HttpSession sessionObj) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("TipoVenditore/AddEditTipoVenditore");
			return model;
		} else {
			TipoVenditoreservice.saveOrUpdate(oTipoVenditore);
			if (sessionObj.getAttribute("idvenditore") == null)
				return new ModelAndView("redirect:/Venditore/AddVenditore");
			else
				return new ModelAndView("redirect:/Venditore/EditVenditore/{id}");
		}
	}

}
