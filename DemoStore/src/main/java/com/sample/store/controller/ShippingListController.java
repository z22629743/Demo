package com.sample.store.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
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
import com.sample.store.dao.ProductDAO;
import com.sample.store.dao.PurchaseOrderDAO;
import com.sample.store.dao.ShippingListDAO;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;
import com.sample.store.entity.ShippingList;

@Controller
public class ShippingListController {
ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	

	

	@RequestMapping(value = "/ar", method = RequestMethod.GET)
	public ModelAndView getProductList(){
	
		ModelAndView model = new ModelAndView("ar");
		//logger.info("controller");
		ShippingListDAO dao = (ShippingListDAO)context.getBean("shippingListDAO");
		List<ShippingList> shippingList = new ArrayList<ShippingList>();
		shippingList = dao.getList();
		//logger.info(""+productList.size());
		model.addObject("saList", shippingList);
		
		return model;
	}
	@RequestMapping(value = "/deleteList", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute ("id")long id){
		ModelAndView model = new ModelAndView("redirect:/ar");
		ShippingListDAO ShippingListDAO = (ShippingListDAO)context.getBean("shippingListDAO");
		ShippingListDAO.delete(id);
		return model;
	}

	@RequestMapping(value = "/arrive", method = RequestMethod.GET)
	public ModelAndView arrive(@ModelAttribute("id")long id, ShippingList sh, Customer customer){
		ModelAndView model = new ModelAndView("redirect:/ar");
		ShippingListDAO ShippingListDAO = (ShippingListDAO)context.getBean("shippingListDAO");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		sh = ShippingListDAO.get(id);
		customer = customerDAO.get(sh.getCustomername());
		//System.out.println("Level = "+customerDAO.get(sh.getCustomername()).getLevel()+"name = "+sh.getCustomername());
		try {
			//TODO result should be checked 
			//int result = purchaseOrderDAO.stockProduct(po);
			ShippingListDAO.arrive(sh);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long time = (System.currentTimeMillis() - sh.getShippingtime().getTime())/1000;
		System.out.println("time = "+time);
//		long ans = sh.getAr_time().getTime() - sh.getShippingtime().getTime();
//		System.out.println("ans"+ans);
		//System.out.println("#ofPO ="+poList.size());
		//model.addObject("poList",poList);
		if(time < 604800){
			if(customer.getLevel().equals("B")){
				customer.setLevel("A");
			}else if(customer.getLevel().equals("C")){
				customer.setLevel("B");
			}else if(customer.getLevel().equals("D")){
				customer.setLevel("C");
			}else if(customer.getLevel().equals("E")){
				customer.setLevel("D");
			}
		}else{
			if(customer.getLevel().equals("A")){
				customer.setLevel("B");
			}else if(customer.getLevel().equals("B")){
				customer.setLevel("C");
			}else if(customer.getLevel().equals("C")){
				customer.setLevel("D");
			}else if(customer.getLevel().equals("D")){
				customer.setLevel("E");
			}
		}
		customerDAO.updateLevel(customer);
		return model;
	}
	
}
