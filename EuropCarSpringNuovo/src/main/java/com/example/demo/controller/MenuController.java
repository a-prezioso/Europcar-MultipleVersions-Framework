package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "menu")
public class MenuController {

	@RequestMapping(value = "/List", method = RequestMethod.GET)
	public ModelAndView list(HttpSession sessionObj) {
		ModelAndView model = new ModelAndView("Menu/MainMenu");
		if (sessionObj.getAttribute("oggettoFornitorePreventivo") != null) {
			sessionObj.removeAttribute("oggettoFornitorePreventivo");
		}
		return model;
	}
}
