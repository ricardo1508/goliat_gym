package com.goliat.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralRedirectController {

	@RequestMapping("/home")
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pageTitle","Goliat Gym - Administración");
		return mv;
	}
	
	@RequestMapping("/pClientAdd")
	public ModelAndView goToClientAdd() {
		ModelAndView mv = new ModelAndView("pClientAdd");
		mv.addObject("pageTitle","Agregar Cliente");
		return mv;
	}
	
}
