package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.PurchaseOrderDAO;
import com.sample.store.dao.SupplierDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;
import com.sample.store.entity.Supplier;



/**
 * Handles requests for the application home page.
 */
@Controller
public class PurchaseOrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	@RequestMapping(value = "/reorderProduct", method = RequestMethod.GET)
	public ModelAndView listReorderProduct(){
	
		ModelAndView model = new ModelAndView("reorderProduct");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getReorderList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}
	
	@RequestMapping(value = "/seereorderProduct", method = RequestMethod.GET)
	public ModelAndView seeReorderProduct(@ModelAttribute("supplierid")long id){
		ModelAndView model = new ModelAndView("reorderProduct");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getReorderList();
		List<Product> cartList = new ArrayList<Product>();
		for(Iterator<Product> ir =productList.iterator() ; ir.hasNext();  ){
			Product bProduct = ir.next();
			System.out.println("name="+bProduct.getSupplierid());
			if(String.valueOf(id).equals(String.valueOf(bProduct.getSupplierid()))){
				cartList.add(bProduct);
			}
		}
		//logger.info(""+productList.size());
		model.addObject("productList", cartList);
		
		return model;
	}
	
	@RequestMapping(value = "/createPO", method = RequestMethod.GET)
	public ModelAndView reorderProduct(@ModelAttribute Product product,int quantity){
		ModelAndView model = new ModelAndView("redirect:/reorderProduct");
		System.out.println("q= "+quantity);
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		purchaseOrderDAO.create(product, quantity);//qty is fixed for now
		//System.out.println("id ="+product.getId());
		return model;
	}
	
	@RequestMapping(value = "/po", method = RequestMethod.GET)
	public ModelAndView listPO(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("po");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
		poList=purchaseOrderDAO.getList();
		//System.out.println("#ofPO ="+poList.size());
		model.addObject("poList",poList);
		return model;
	}

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView stockProduct(@ModelAttribute PurchaseOrder po){
		ModelAndView model = new ModelAndView("redirect:/po");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		
		try {
			//TODO result should be checked 
			//int result = purchaseOrderDAO.stockProduct(po);
			purchaseOrderDAO.stockProduct(po);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("#ofPO ="+poList.size());
		//model.addObject("poList",poList);
		return model;
	}
	@RequestMapping(value = "/deletePO", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute Product product, long id){
		ModelAndView model = new ModelAndView("redirect:/po");	
		PurchaseOrderDAO dao = (PurchaseOrderDAO) context.getBean("purchaseOrderDAO");
		product.setId(id);
		dao.delete(product);
		return model;
	}
	
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public ModelAndView supplier(){
	
		ModelAndView model = new ModelAndView("supplier");
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Supplier> supplierList = new ArrayList<Supplier>();
		List<Product> productList = new ArrayList<Product>();
		supplierList = supplierDAO.getList();
		productList = productDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("supplierList",supplierList);
		model.addObject("productList", productList);
		
		return model;
	}
	@RequestMapping(value = "/insertSupplier", method = RequestMethod.GET)
	public ModelAndView insertSupplierPage(){
		ModelAndView model = new ModelAndView("insertSupplier");
		//need the following part for product category
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		model.addObject("articleCategoryList", articleCategoryList);
		*/
		return model;
	}
	
	@RequestMapping(value = "/insertSupplier", method = RequestMethod.POST)
	public ModelAndView insertSupplier(@ModelAttribute Supplier supplier){
		ModelAndView model = new ModelAndView("redirect:/supplier");
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplierDAO.insert(supplier);
		
		return model;
	}
	
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.GET)
	public ModelAndView updateSupplierPage(@ModelAttribute("id")long id, Supplier supplier){
		ModelAndView model = new ModelAndView("updateSupplier");
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		//will need the following part later
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		*/
		supplier.setSupplierid(id);
		supplier = supplierDAO.get(supplier);
		System.out.println("id="+supplier.getSupplierid());
		//will need the following part later
		//model.addObject("articleCategoryList", articleCategoryList);
		model.addObject("supplier", supplier);
		return model;
	}
	
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier){
		ModelAndView model = new ModelAndView("redirect:/supplier");
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplierDAO.update(supplier);	
		return model;
	}

	@RequestMapping(value = "/deleteSupplier", method = RequestMethod.POST)
	public ModelAndView deleteSupplier(@ModelAttribute Supplier supplier){
		ModelAndView model = new ModelAndView("redirect:/supplier");
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplierDAO.delete(supplier);
		return model;
	}
}
