package com.goliat.gym.controllers;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goliat.gym.model.Client;
import com.goliat.gym.model.Employee;

@Controller
public class OperationsController {

	@RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView("home");
		/*SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setFirstName("Ricardo");
			employee.setLastName("Sanches");
			employee.setSalary(1000);
			employeeID = (Integer) session.save(employee); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}*/
		System.out.println("===== " + client.getName());
		return mv;
	}

}
