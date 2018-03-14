package com.goliat.gym.controllers;

import org.apache.log4j.Logger;
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

	private static final Logger LOGGER = Logger.getLogger(OperationsController.class);
	
	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		LOGGER.info("Method addClient - IN");
		LOGGER.info("Adding client : " + client);
		ModelAndView mv = new ModelAndView("home");
		Gym.addClient(client);
		LOGGER.info("Method addClient - OUT");
		return mv;
	}

}
