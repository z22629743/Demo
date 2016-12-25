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
public class SalesOrderController {
	private ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	@Autowired
	private ShoppingCart shoppingCart;
	@RequestMapping(value = "/addShoppingCart", method = RequestMethod.GET)
	public ModelAndView addShoppingCart(@ModelAttribute Product product,long customerid){
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		ModelAndView model = new ModelAndView("redirect:/availableProduct?id="+customerid+"&customer="+ customerDAO.get(customerid));
		//only id is passed
		long pid = product.getId();
		System.out.println("pid="+pid +"pid2="+customerid + " "+product.getQuantity());
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		product = productDAO.get(product);//retrieve all information with id
		product.setCustomerID(customerid);
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart"); 
		shoppingCart.add(product);
		//System.out.println(shoppingCart.count());
		return model;
	}
	
	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public ModelAndView showShoppingCart(){
		ModelAndView model = new ModelAndView("showCart");
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		//List<Product> content =  shoppingCart.getCart();
		//model.addObject("shoppingCart",content);
		return model;
	}
	@RequestMapping(value = "/see", method = RequestMethod.GET)
	public ModelAndView see(@ModelAttribute("customerID")long id){
		ModelAndView model = new ModelAndView("showCart");
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
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(@ModelAttribute("id")long id){
		ModelAndView model = new ModelAndView("showCart");
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		System.out.println("id="+id+"Name="+customerDAO.get(id).getName());
		List<Product> pList =  shoppingCart.show(id);
		/*List<Long> pList2 = new ArrayList<Long>();
		List<Integer> pList3 = new ArrayList<Integer>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getId());
			pList3.add(pList.get(i).getQuantity());
		}*/
		int result = 0;
		try {
			result = salesOrderDAO.sellProduct(pList,customerDAO.get(id));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			shoppingCart.remove(id);
		}
		return model;
	}
	@RequestMapping(value = "/deleteSC", method = RequestMethod.GET)
	public ModelAndView deleteShoppingCart(@ModelAttribute Product product,int id){
		ModelAndView model = new ModelAndView("redirect:/showCart");
		//only id is passed
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		product.setId(id);
		product = productDAO.get(product);
		List<Product> content =  shoppingCart.getCart();
		shoppingCart.delete(product);
		System.out.println(shoppingCart.count());
		model.addObject("shoppingCart",content);
		return model;
	}
	@RequestMapping(value = "/newSalesOrder", method = RequestMethod.GET)
	public ModelAndView getcustomerList(){
	
		ModelAndView model = new ModelAndView("newSalesOrder");
		//logger.info("controller");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = customerDAO.getList();
		//logger.info(""+customerList.size());
		model.addObject("customerList", customerList);
		
		return model;
	}

	
	@RequestMapping(value = "/availableProduct", method = RequestMethod.GET)
	public ModelAndView listAvailableProduct(@ModelAttribute("id")long id,Customer customer){
	
		ModelAndView model = new ModelAndView("availableProduct");
		//logger.info("controller");
		System.out.println(id);
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		customer = customerDAO.get(id);
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getAvailableList();
		//logger.info(""+productList.size());
		model.addObject("customer",customer);
		model.addObject("productList", productList);
		
		return model;
	}
	
}
