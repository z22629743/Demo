package com.sample.store.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements java.io.Serializable {

	/**
	 * serialVersionUID is generated automatically
	 */
	private static final long serialVersionUID = 3476619468809859762L;
	//private List<Long> productList = new ArrayList<Long>();
	private List<Product> productList = new ArrayList<Product>();
	private List<Product> cartList = new ArrayList<Product>();
	public List<Product> getCart(){
		return productList;
	}
	public void add(Product aProduct){
		productList.add(aProduct);
	}
	public int count(){
		return productList.size();
	}
	public List<Product> show(long id){
		cartList = new ArrayList<Product>();
		for(Iterator<Product> ir =productList.iterator() ; ir.hasNext();  ){
			Product bProduct = ir.next();
			if(String.valueOf(id).equals(String.valueOf(bProduct.getCustomerID()))){
				cartList.add(bProduct);
			}
		}
		return cartList;
	}
	public List<Product> remove(long id){
		for(Iterator<Product> ir =productList.iterator() ; ir.hasNext();  ){
			Product bProduct = ir.next();
			if(String.valueOf(id).equals(String.valueOf(bProduct.getCustomerID()))){
				ir.remove();
			}
		}
		return cartList;
	}
	public void delete(Product aProduct){
		for(Iterator<Product> ir =productList.iterator() ; ir.hasNext();  ){
			Product bProduct = ir.next();
			if(aProduct.getDesc().equals(bProduct.getDesc())){
				ir.remove();
			}
		}
	}
	public void cleanup(){
		productList = new ArrayList<Product>();
	}

}
