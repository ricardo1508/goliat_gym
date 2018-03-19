package com.goliat.gym.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.model.GymConfiguration;
import com.goliat.gym.utiliy.Gym;

@Controller
public class GeneralRedirectController {

	
	@RequestMapping(value = "/home")
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pageTitle","Goliat Gym - Administración");
		mv.addObject("lastVisits",Gym.getLastVisits());
		return mv;
	} // end goToHome
	
	@RequestMapping(value = "/logout")
	public ModelAndView goToIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	} // end goToHome
	
	@RequestMapping(value = "/pConfig")
	public ModelAndView goToConfig() {
		ModelAndView mv = new ModelAndView("pConfig");
		GymConfiguration gymConfug = new GymConfiguration();
		mv.addObject("pageTitle","Configuración");
		mv.addObject("gymConfig",gymConfug);
		return mv;
	} // end goToHome
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView goToHome(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
		ModelAndView mv = new ModelAndView("home");
		try {
			boolean validSession = Gym.validateAdminUser(userName, userPass);
			mv.addObject("pageTitle","Goliat Gym - Administración");
			mv.addObject("lastVisits",Gym.getLastVisits());
			if(validSession == false) {
				mv = new ModelAndView("index");
				mv.addObject("error","Usuario invalido");
			}			
		} catch(Exception e) {
			mv = new ModelAndView("error"); 
		}		
		return mv;
	} // end goToHome
	
	@RequestMapping("/pClientLogin")
	public ModelAndView goToClientLogin() {
		ModelAndView mv = new ModelAndView("pClientLogin");
		return mv;
	}
	
	@RequestMapping(value = "/clienVisit")
	public ModelAndView clientVisit() {
		ModelAndView mv = new ModelAndView("pClientLogin");
		return mv;
	}
	
	@RequestMapping(value = "/clienVisit",params= {"userId"})
	public ModelAndView clientVisit(@RequestParam("userId") String userId) {
		Client client = Gym.clientVisit(userId);
		ModelAndView mv = new ModelAndView("pClientLogin");						
		if(client == null) {
			mv.addObject("error","Id de cliente invalido");
		} else {
			mv.addObject("client",client);
			mv.addObject("validClient",true);
			mv.addObject("currentDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
	
	@RequestMapping(value = "/pClientAdmin",params= {"id"})
	public ModelAndView goToClientAdmin(@RequestParam(value = "id") String id) {
		ModelAndView mv = new ModelAndView("pClientAdmin");
		// get Client
		Client client = Gym.getClientByID(id);
		mv.addObject("client",client);
		mv.addObject("pageTitle",client.getcName() + " " + client.getcLastName() + " " + client.getcSecondLastName() + " - ID: " + client.getcId());
		mv.addObject("month_cost",Gym.getMonthCost());
		return mv;
	}
	
	@RequestMapping("/pClients")
	public ModelAndView goToClients() {
		ModelAndView mv = new ModelAndView("pClients");
		mv.addObject("pageTitle","Clientes");
		// Getting all clients information
		List<Client> clients = Gym.getAllClients();
		mv.addObject("clients", clients);
		return mv;
	}
}
