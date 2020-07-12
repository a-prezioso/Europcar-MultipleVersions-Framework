package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Utente;
import com.example.demo.model.Venditore;
import com.example.demo.service.UtenteService;
import com.example.demo.service.VenditoreService;
import com.example.demo.util.PasswordUtil;

@Controller
@RequestMapping(value = "/Utente")
public class UtenteController {

	@Autowired
	UtenteService utenteservice;

	@Autowired
	VenditoreService venditoreservice;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping(value = "/ListaUtenti")
	public ModelAndView listaUtenti() {
		ModelAndView model = new ModelAndView("Utente/ListaUtenti");
		List<Utente> listautenti = utenteservice.getAllUtenti();
		model.addObject("elencoUtenti", listautenti);
		return model;
	}

	@GetMapping(value = "/AddUtente")
	public ModelAndView addUtente() {
		ModelAndView model = new ModelAndView();
		Utente oUtente = new Utente();
		model.addObject("oggettoUtente", oUtente);
		List<Venditore> listavenditori = venditoreservice.getAllVenditori();
		model.addObject("elencoVenditori", listavenditori);
		model.setViewName("Utente/AddUtente");
		return model;
	}

	@GetMapping(value = "/EditUtente/{id}")
	public ModelAndView editUtente(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Utente oUtente = utenteservice.getUtenteById(id);
		model.addObject("oggettoUtente", oUtente);
		List<Venditore> listavenditori = venditoreservice.getAllVenditori();
		model.addObject("elencoVenditori", listavenditori);
		model.setViewName("Utente/EditUtente");
		return model;
	}

	@PostMapping(value = "/SaveUtenteAdd")
	public ModelAndView saveUtenteAdd(@Valid @ModelAttribute("oggettoUtente") Utente oUtente,
			BindingResult bindingresult, ModelMap map) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Utente/AddUtente");
			return model;
		} else {
			if (oUtente.getPassword().equalsIgnoreCase(oUtente.getPasswordConfirm())) {
				oUtente.setPassword(passwordEncoder.encode(oUtente.getPassword()));
				utenteservice.saveOrUpdate(oUtente);
				return new ModelAndView("redirect:/Utente/ListaUtenti");
			} else {
				ModelAndView model = new ModelAndView();
				map.addAttribute("message", "Le password devono corrispondere");
				model.addObject(map);
				model.setViewName("Utente/AddUtente");
				return model;
			}
		}
	}
	
	
	@PostMapping(value = "/SaveUtente")
	public ModelAndView saveUtente(@Valid @ModelAttribute("oggettoUtente") Utente oUtente,
			BindingResult bindingresult) {
		
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Utente/EditUtente");
			return model;
		} else {
				utenteservice.saveOrUpdate(oUtente);
				return new ModelAndView("redirect:/Utente/ListaUtenti");
			} 
		}
	
	@GetMapping(value = "/DeleteUtente/{id}")
	public ModelAndView deleteAliquotaIva(@PathVariable("id") Integer id) {
		utenteservice.deleteUtente(id);
		return new ModelAndView("redirect:/Utente/ListaUtenti");
	}

	
	

}
