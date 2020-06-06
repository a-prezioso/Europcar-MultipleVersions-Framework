package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Budget")
public class BudgetController {
	
	@RequestMapping(value = "/Lista", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("Menu/Budget");
		return model;
	}

}
