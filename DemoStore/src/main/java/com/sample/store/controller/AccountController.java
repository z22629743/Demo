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
@SessionAttributes("newaccount")
public class AccountController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init(){
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute Account account, Manager man,String name) {
		ModelAndView model = new ModelAndView("redirect:/loginsuccess");	
		Account account_session = (Account)context.getBean("account");
		ManagerDAO dao = (ManagerDAO)context.getBean("managerDAO");
		man = dao.get(account.getUsername());
			if(account.getUsername().equals(dao.get(account.getUsername()).getAccount()) && account.getPassword().equals(dao.get(account.getUsername()).getPassword())){
				account_session.setUsername(account.getUsername());
				System.out.println("Success");
				model.addObject("newaccount",man); 
			}
			else{
				model = new ModelAndView("index");
				account_session.setUsername("");
				account_session.setPassword("");
				man = dao.get(account.getUsername());
				System.out.println("failed");
				model.addObject("message", "登入失敗");
				model.addObject("newaccount",man);
				}	
		
		//System.out.println("model:"+account.getUsername());
		//System.out.println("session:"+account_session.getName());
		
		return model;
		/*ModelAndView model = new ModelAndView("redirect:/product");
		//you can modify this part to check username and password with DB, AD, LDAP, or open id
		Account account_session = (Account)context.getBean("account");
		if ("sa".equals(account.getUsername()) && "ilovesa".equals(account.getPassword())){
			//save username and password in the session bean
			//Account account_session = (Account)context.getBean("account");
			account_session.setUsername(account.getUsername());
			account_session.setPassword(account.getPassword());
			//another way of using session attributes
			model.addObject("newaccount",account_session);  //save it in session for navbar.jsp
			System.out.println("Successful!");
			
		}
		else{
			model = new ModelAndView("index");
			model.addObject("message", "登入失敗");
			System.out.println("failed!");
			//reset username and password in the session bean
			//Account account_session = (Account)context.getBean("account");
			account_session.setUsername("");
			account_session.setPassword("");
			model.addObject("newaccount",account_session); //save it in session for navbar.jsp
		}	

		return model;*/
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute Account account) {
		ModelAndView model = new ModelAndView("index");

		return model;
	}
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView newuser(){
		ModelAndView model = new ModelAndView("manager");
		return model;
	}
	 @RequestMapping(value = "/newuser", method = RequestMethod.POST)
		public ModelAndView newuser(@ModelAttribute Manager manager){
			ModelAndView model = new ModelAndView("redirect:/manager");	
			ManagerDAO dao = (ManagerDAO) context.getBean("managerDAO");
			manager.setId(dao.count());
			dao.insert(manager);
			return model;
		}

	 @RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
		public ModelAndView loginsuccess(@ModelAttribute Account account, Manager man,String name) {
			ModelAndView model = new ModelAndView("loginsuccess");

			return model;
		}

		
}
