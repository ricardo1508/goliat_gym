package com.goliat.gym.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import com.goliat.gym.model.Product;
import com.goliat.gym.model.GymUtil;
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

	@RequestMapping(value = "/productAdd", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method addProduct - IN");
		System.out.println("Adding product : " + product);
		int productId=Gym.addProduct(product);	
		ModelAndView mv = new ModelAndView("redirect:pProductAdmin?id="+productId);
		if(productId == -1) {
			mv = new ModelAndView("error");
			mv.addObject("error","Ocurrio un error mientras se agregaba al cliente.");
		}
		System.out.println("Method addProduct - OUT");
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

	@RequestMapping(value = "/productUpdateInfo", method = RequestMethod.POST)
	public ModelAndView updateInfoProduct(@ModelAttribute("product") Product product, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method updateInfoProduct - IN");
		System.out.println("Updating product : " + product);
		ModelAndView mv = new ModelAndView("redirect:pProductAdmin?id="+product.getIdProduct());
		Gym.updateInfoProduct(product);
		System.out.println("Method updateInfoProduct - OUT");
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

	@RequestMapping(value = "/performSale", method = RequestMethod.POST)
	public ModelAndView performSale(@ModelAttribute("util") GymUtil util, BindingResult result, ModelMap model,@CookieValue("validSession") String validSession) {
		if(Gym.validateSession(validSession) == false) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		System.out.println("Method performSale - IN");
		System.out.println("performSale: " + util);
		List<Product> soldItems = this.getSoldItem(util.getUtil());		
		boolean error=Gym.performSale(soldItems);	
		ModelAndView mv = new ModelAndView("redirect:pReportTodayPayments");
		if(error) {
			mv = new ModelAndView("error");
			mv.addObject("error","Ocurrio un error mientras se agregaba al cliente.");
		}
		System.out.println("Method performSale - OUT");
		return mv;
	}

	private List<Product> getSoldItem(String jsonRequest) {
		List<Product> soldItems = new ArrayList<Product>();
		JSONObject json;   
		try {
			json = new JSONObject(jsonRequest);
			JSONArray array = json.getJSONArray("items");
			for(int i = 0 ; i < array.length() ; i++){
				Product p = new Product();
				p.setpQuantity(1);
				p.setIdProduct(Integer.parseInt(array.getJSONObject(i).getString("id")));
				p.setpName(array.getJSONObject(i).getString("name"));
				p.setpCost(Float.parseFloat(array.getJSONObject(i).getString("cost")));
				addSoldItem(soldItems,p);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return soldItems;
	}

	private void addSoldItem(List<Product> itemsSold, Product item) {
		boolean add = true;
		for(Product it : itemsSold) {
			if(it.getIdProduct() == item.getIdProduct() && it.getpName().equals(item.getpName())){
				it.setpQuantity(it.getpQuantity() + 1);
				it.setpCost(it.getpCost() + item.getpCost());
				add = false;
				break;
			}
		}
		if(add) {
			itemsSold.add(item);
		}   
	}
}
