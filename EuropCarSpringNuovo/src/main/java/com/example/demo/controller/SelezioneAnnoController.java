package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.AnnoContabile;
import com.example.demo.service.AnnoContabileService;

@Controller
@RequestMapping(value = "/SelezioneAnno")
public class SelezioneAnnoController {

	@Autowired
	AnnoContabileService annoservice;

	@GetMapping(value = "/ListaAnni")
	public ModelAndView listaAnni() {
		ModelAndView model = new ModelAndView("Menu/SelezioneAnnoContabile");
		List<AnnoContabile> listaanni = annoservice.getAllAnni();
		model.addObject("elencoAnni", listaanni);
		AnnoContabile oanno = new AnnoContabile();
		model.addObject("oggettoAnnoPermanente", oanno);
		return model;
	}

	@PostMapping(value = "/ProcessaAnno")
	public ModelAndView processaAnno(@ModelAttribute("oggettoAnnoContabile") AnnoContabile oanno,
			HttpSession sessionObj, RedirectAttributes red) {
		if (oanno.getIdannocontabile() != 0) {
			sessionObj.setAttribute("oggettoAnnoPermanente", oanno);
			return new ModelAndView("redirect:/menu/List");
		} else {
			red.addFlashAttribute("message", "Selezionare un anno per poter proseguire");
			return new ModelAndView("redirect:/SelezioneAnno/ListaAnni");
		}

	}

}
