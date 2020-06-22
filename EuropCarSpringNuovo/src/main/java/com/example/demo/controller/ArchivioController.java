package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Archivio")
public class ArchivioController {

	@RequestMapping(value="/Lista", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("Archivio/Lista");
		DispatcherServlet dispatcher = new DispatcherServlet();
		return model;
	}
}
