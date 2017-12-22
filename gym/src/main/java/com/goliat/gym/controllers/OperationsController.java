package com.goliat.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperationsController {

	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}
