package com.goliat.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.model.GymConfiguration;
import com.goliat.gym.utiliy.Gym;

@Controller
public class OperationsController {

	
	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method addClient - IN");
		System.out.println("Adding client : " + client);
		int clientId=Gym.addClient(client);	
		ModelAndView mv = new ModelAndView("redirect:pClientAdmin?id="+clientId);
		if(clientId == -1) {
			mv = new ModelAndView("error");
			mv.addObject("error","Ocurrio un error mientras se agregaba al cliente.");
		}
		System.out.println("Method addClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/clientUpdateInfo", method = RequestMethod.POST)
	public ModelAndView updateInfoClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method updateInfoClient - IN");
		System.out.println("Updating client : " + client);
		ModelAndView mv = new ModelAndView("redirect:pClientAdmin?id="+client.getcId());
		Gym.updateInfoClient(client);
		System.out.println("Method updateInfoClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/clientMakePayment", method = RequestMethod.POST)
	public ModelAndView makePaymentClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method makePaymentClient - IN");
		System.out.println("Updating client : " + client);
		ModelAndView mv = new ModelAndView("redirect:pClientAdmin?id="+client.getcId());
		Gym.makePaymentClient(client);
		System.out.println("Method makePaymentClient - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/pGenerateBackup")
	public ModelAndView generateBackups(@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method generateBackups - IN");
		Gym.generateBackup();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pageTitle","Goliat Gym - Administración");
		mv.addObject("lastVisits",Gym.getLastVisits());
		System.out.println("Method generateBackups - OUT");
		return mv;
	}
	
	@RequestMapping(value = "/updateConfig", method = RequestMethod.POST)
	public ModelAndView updateConfig(@ModelAttribute("gymConfig") GymConfiguration gymConfig, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method updateConfig - IN");
		System.out.println("Updating GymConfiguration : " + gymConfig);
		Gym.updateGymInformation(gymConfig);
		ModelAndView mv = new ModelAndView("redirect:pConfig");
		System.out.println("Method updateConfig - OUT");
		return mv;
	}
}
