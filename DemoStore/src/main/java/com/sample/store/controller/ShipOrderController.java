package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpSession;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.SalesOrderDAO;
import com.sample.store.dao.CustomerDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;
import com.sample.store.entity.ShoppingCart;


@Controller
public class ShipOrderController {
	private ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping(value = "/see2", method = RequestMethod.GET)
	public ModelAndView see(@ModelAttribute("customerID")long id){
		ModelAndView model = new ModelAndView("shipOrder");
		//SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		//String sql = "SELECT * FROM salesorderitem WHERE customerID LIKE '%"+id+"%'";
		//List<SalesOrder> sqllist = salesOrderDAO.getList(sql);
		if(String.valueOf(id) == null){
			List<Product> pList = shoppingCart.show(0);
			model.addObject(("shoppingCart"),pList);
		}else{
		List<Product> pList = shoppingCart.show(id);
		model.addObject(("shoppingCart"),pList);
	
		}
		return model;
	}

	@RequestMapping(value = "/shipOrder", method = RequestMethod.GET)
	public ModelAndView getcustomerList(){
	
		ModelAndView model = new ModelAndView("shipOrder");
		//logger.info("controller");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = customerDAO.getList();
		//logger.info(""+customerList.size());
		model.addObject("customerList", customerList);
		
		return model;
	}


}
