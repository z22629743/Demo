package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.ProductDAO;
import com.sample.store.dao.PurchaseOrderDAO;
import com.sample.store.dao.ShippingListDAO;
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
	public ModelAndView arrive(@ModelAttribute("id")long id, ShippingList sh){
		ModelAndView model = new ModelAndView("redirect:/ar");
		ShippingListDAO ShippingListDAO = (ShippingListDAO)context.getBean("shippingListDAO");
		sh.setSoid(id);
		System.out.println(id);
		try {
			//TODO result should be checked 
			//int result = purchaseOrderDAO.stockProduct(po);
			ShippingListDAO.arrive(sh);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("#ofPO ="+poList.size());
		//model.addObject("poList",poList);
		return model;
	}
	
}
