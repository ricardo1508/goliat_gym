package com.goliat.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.utiliy.Gym;

@Controller
public class GeneralRedirectController {

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView goToHome(@RequestParam("userName") String userName,
			@RequestParam("userPass") String userPass) {
		boolean validSession = Gym.validateAdminUser(userName, userPass);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pageTitle","Goliat Gym - Administración");
		
		if(validSession == false) {
			mv = new ModelAndView("index");
			mv.addObject("error","Usuario invalido");
		}

		return mv;
	}
	
	@RequestMapping("/pClientAdd")
	public ModelAndView goToClientAdd() {
		ModelAndView mv = new ModelAndView("pClientAdd");
		mv.addObject("pageTitle","Agregar Cliente");
		mv.addObject("client",new Client());
		mv.addObject("month_cost",Gym.getMonthCost());
		return mv;
	}
	
	@RequestMapping("/pReportsMain")
	public ModelAndView goToReportsMain() {
		ModelAndView mv = new ModelAndView("pReportsMain");
		mv.addObject("pageTitle","Reportes");
		return mv;
	}
	
	@RequestMapping("/pClientAdmin")
	public ModelAndView goToClientAdmin() {
		ModelAndView mv = new ModelAndView("pClientAdmin");
		mv.addObject("pageTitle","Administrador Clientes");
		return mv;
	}
}
