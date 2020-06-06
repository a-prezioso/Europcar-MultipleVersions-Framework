package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;
import com.example.demo.util.PasswordUtil;

@Controller
@RequestMapping(value = "/Impostazioni")
public class ImpostazioniUtenteController {
	
	@Autowired
	UtenteService utenteservice;
	
	@GetMapping(value = "/Utente")
	public ModelAndView editUtente(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView();
		Utente oUtente = (Utente) sessionObj.getAttribute("oggettoUtentePermanente");
		model.addObject("oggettoUtente", oUtente);
		model.setViewName("Impostazioni/EditPassword");
		return model;
	}
	
	@PostMapping(value = "/SaveUtente")
	public ModelAndView saveUtente(@Valid @ModelAttribute("oggettoUtente") Utente oUtente,
			BindingResult bindingresult, ModelMap map) {
		if (bindingresult.hasErrors()) {
			ModelAndView model = new ModelAndView();
			model.setViewName("Impostazioni/EditPassword");
			return model;
		} else {

			if (oUtente.getPassword().equalsIgnoreCase(oUtente.getPasswordConfirm())) {
				oUtente.setPassword(PasswordUtil.cryptWithMD5(oUtente.getPassword())); 
				oUtente.setPasswordConfirm(oUtente.getPassword());
				utenteservice.saveOrUpdate(oUtente);
				return new ModelAndView("redirect:/Impostazioni/Lista");
			} else {
				ModelAndView model = new ModelAndView();
				map.addAttribute("message", "Le password devono corrispondere");
				model.addObject(map);
				model.setViewName("Impostazioni/EditPassword");
				return model;
			}
		}
	}
	
	

}
