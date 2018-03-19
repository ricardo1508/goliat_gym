package com.goliat.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.utiliy.Gym;

@Controller
public class OperationsController {

	
	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		System.out.println("Method addClient - IN");
		System.out.println("Adding client : " + client);
		ModelAndView mv = new ModelAndView("home");
		Gym.addClient(client);
		System.out.println("Method addClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/clientUpdateInfo", method = RequestMethod.POST)
	public ModelAndView updateInfoClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		System.out.println("Method updateInfoClient - IN");
		System.out.println("Updating client : " + client);
		ModelAndView mv = new ModelAndView("home");
		Gym.updateInfoClient(client);
		System.out.println("Method updateInfoClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/clientMakePayment", method = RequestMethod.POST)
	public ModelAndView makePaymentClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		System.out.println("Method makePaymentClient - IN");
		System.out.println("Updating client : " + client);
		ModelAndView mv = new ModelAndView("home");
		Gym.makePaymentClient(client);
		System.out.println("Method makePaymentClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/pGenerateBackup")
	public ModelAndView generateBackups() {
		System.out.println("Method generateBackups - IN");
		Gym.generateBackup();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pageTitle","Goliat Gym - Administración");
		mv.addObject("lastVisits",Gym.getLastVisits());
		System.out.println("Method generateBackups - OUT");
		return mv;
	}
	
}
