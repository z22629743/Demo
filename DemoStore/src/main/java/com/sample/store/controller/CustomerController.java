package com.sample.store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.store.dao.CustomerDAO;
import com.sample.store.dao.ManagerDAO;
import com.sample.store.entity.Account;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Manager;

@Controller
public class CustomerController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		@RequestMapping(value = "/customer", method = RequestMethod.GET)
		public ModelAndView getcustomerList(){
		
			ModelAndView model = new ModelAndView("customer");
			//logger.info("controller");
			CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
			List<Customer> customerList = new ArrayList<Customer>();
			customerList = customerDAO.getList();
			//logger.info(""+customerList.size());
			model.addObject("customerList", customerList);
			
			return model;
		}
		
		
		@RequestMapping(value = "/insertCustomer", method = RequestMethod.GET)
		public ModelAndView insertcustomerPage(){
			ModelAndView model = new ModelAndView("insertCustomer");
			//need the following part for customer category
			/*
			ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
			List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
			articleCategoryList = articleCategoryDAO.getList();
			model.addObject("articleCategoryList", articleCategoryList);
			*/
			return model;
		}
		
		@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
		public ModelAndView insertcustomer(@ModelAttribute Customer customer){
			ModelAndView model = new ModelAndView("redirect:/customer");
			CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
			customerDAO.insert(customer);
			
			return model;
		}

		@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
		public ModelAndView updatecustomerPage(@ModelAttribute Customer customer){
			ModelAndView model = new ModelAndView("updateCustomer");
			CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
			//will need the following part later
			/*
			ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
			List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
			articleCategoryList = articleCategoryDAO.getList();
			*/
			customer = customerDAO.get(customer);
			//System.out.println("id="+customer.getId());
			//will need the following part later
			//model.addObject("articleCategoryList", articleCategoryList);
			model.addObject("customer", customer);
			return model;
		}
		
		@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
		public ModelAndView updatecustomer(@ModelAttribute Customer customer){
			ModelAndView model = new ModelAndView("redirect:/customer");
			CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
			customerDAO.update(customer);	
			return model;
		}

		@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
		public ModelAndView deletecustomer(@ModelAttribute Customer customer){
			ModelAndView model = new ModelAndView("redirect:/customer");
			CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
			customerDAO.delete(customer.getId());
			return model;
		}

}
