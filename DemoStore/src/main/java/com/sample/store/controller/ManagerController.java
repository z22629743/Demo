package com.sample.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.CustomerDAO;
import com.sample.store.dao.ManagerDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Manager;
import com.sample.store.entity.Product;

@Controller
public class ManagerController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView getmanagerList(){
	
		ModelAndView model = new ModelAndView("manager");
		//logger.info("controller");
		ManagerDAO managerDAO = (ManagerDAO)context.getBean("managerDAO");
		List<Manager> managerList = new ArrayList<Manager>();
		managerList = managerDAO.getList();
		//logger.info(""+customerList.size());
		model.addObject("managerList", managerList);
		
		return model;
	}
	
	@RequestMapping(value = "/deleteManager", method = RequestMethod.POST)
	public ModelAndView deleteManager(@ModelAttribute Manager manager){
		ModelAndView model = new ModelAndView("redirect:/manager");
		ManagerDAO managerDAO = (ManagerDAO)context.getBean("managerDAO");
		managerDAO.delete(manager.getId());
		return model;
	}
	

	
}
