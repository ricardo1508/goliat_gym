package com.goliat.gym.controllers;

import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.model.Payment;

@Controller
public class OperationsController {

	private static final Logger LOGGER = Logger.getLogger(OperationsController.class);
	
	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		LOGGER.info("Method addClient - IN");
		LOGGER.info("Adding client : " + client);
		ModelAndView mv = new ModelAndView("home");
		// TODO : Add validations to add client		
		// adding the client
		/*SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(Payment.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer clientId = null;
		Integer paymentId = null;
		Payment test = new Payment();
		test.setpAmount(100);
		test.setpDate("2017-01-01");
		test.setpDescription("testing");
		Set<Payment> payments = new TreeSet<Payment>();
		payments.add(test);
		client.setPayments(payments);
		try {
			tx = session.beginTransaction();
			clientId = (Integer) session.save(client); 
			test.setcId(clientId);
			//paymentId = (Integer) session.save(test); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}*/
		// adding the first client payment
		LOGGER.info("Method addClient - OUT");
		return mv;
	}

}
