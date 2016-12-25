package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.sample.store.dao.ShipOrderDAO;
import com.sample.store.dao.CustomerDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;
import com.sample.store.entity.ShippingList;
import com.sample.store.entity.ShoppingCart;


@Controller
public class ShipOrderController {
	private ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView see(@ModelAttribute("input")String input,@ModelAttribute("searchmethod")String searchmethod){
		ModelAndView model = new ModelAndView("shipOrder");
		ShipOrderDAO shipOrderDAO = (ShipOrderDAO)context.getBean("shipOrderDAO");
		String sql = "SELECT * FROM salesorder WHERE "+searchmethod+" LIKE '%"+input+"%'";
		List<ShippingList> sqllist = shipOrderDAO.getList(sql);

		model.addObject("List",sqllist);
		return model;
	}

	@RequestMapping(value = "/shipOrder", method = RequestMethod.GET)
	public ModelAndView getcustomerList(){
	
		ModelAndView model = new ModelAndView("shipOrder");
		//logger.info("controller");
		ShipOrderDAO shipOrderDAO = (ShipOrderDAO)context.getBean("shipOrderDAO");
		
//		List<Customer> customerList = new ArrayList<Customer>();
//		customerList = customerDAO.getList();
//		//logger.info(""+customerList.size());
		model.addObject("List", shipOrderDAO.getList());
		
		return model;
	}

	@RequestMapping(value = "/saleout", method = RequestMethod.GET)
	public ModelAndView saleout(@ModelAttribute("id")long id){
		ModelAndView model = new ModelAndView("redirect:/shipOrder");
		ShipOrderDAO shipOrderDAO = (ShipOrderDAO)context.getBean("shipOrderDAO");
		List<SalesOrder> list = shipOrderDAO.getProductid(id);
		for(Iterator<SalesOrder> ir =list.iterator() ; ir.hasNext();  ){
			SalesOrder aSalesOrder = ir.next();
			System.out.println("id="+aSalesOrder.getId()+"qty="+aSalesOrder.getQuantity());
			
		}
//		System.out.println("name="+shipOrderDAO.get(id).getCustomername());
		
		try {
			shipOrderDAO.sell(list);
			shipOrderDAO.saleout(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
