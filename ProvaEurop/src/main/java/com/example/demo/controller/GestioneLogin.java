package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.AnnoContabile;
import com.example.demo.model.Utente;
import com.example.demo.service.AnnoContabileService;
import com.example.demo.service.UtenteService;
import com.example.demo.util.PasswordUtil;

@Controller
@RequestMapping(value = "/Login")
public class GestioneLogin {

	@Autowired
	UtenteService utenteservice;
	
	@Autowired
	AnnoContabileService annoservice;

	@GetMapping(value = "/Login")
	public ModelAndView gestioneLogin() {
		ModelAndView model = new ModelAndView();
		Utente oUtente = new Utente();
		model.addObject("oggettoUtentePermanente", oUtente);
		model.setViewName("Menu/Login");
		return model;
	}

	@PostMapping(value = "/Utente")
	public ModelAndView gestioneLogin(@Valid @ModelAttribute Utente outente, BindingResult bindingresult,
			HttpSession sessionObj, RedirectAttributes red) {
		Utente oUtente = utenteservice.getUtenteByUserPass(outente.getUsername(), PasswordUtil.cryptWithMD5(outente.getPassword()));
		if ( oUtente != null) {
			oUtente = utenteservice.getUtenteByUserPass(outente.getUsername(), PasswordUtil.cryptWithMD5(outente.getPassword()));
			sessionObj.setAttribute("oggettoUtentePermanente", oUtente);
			ModelAndView model = new ModelAndView();
			model.setViewName("Menu/SelezioneAnnoContabile");
			List<AnnoContabile> listaanni = annoservice.getAllAnni();
			model.addObject("elencoAnni", listaanni);
			AnnoContabile oanno = new AnnoContabile();
			model.addObject("oggettoAnnoPermanente", oanno);
			return model;
		} else {
			ModelAndView model = new ModelAndView();
			model.addObject("oggettoUtentePermanente", oUtente);
			red.addFlashAttribute("message", "Utente non trovato");
			return new ModelAndView("redirect:/Login/Login");
		}
		}
	

//	@PostMapping(value = "/Save/{id}")
//	public ModelAndView editUtente(@PathVariable Integer id) {
//		ModelAndView model = new ModelAndView();
//		Utente oUtente = utenteservice.getUtenteById(id);
//		model.addObject("oggettoUtente", oUtente);
//		model.setViewName("Utente/EditPassword");
//		return model;
//	}
}
