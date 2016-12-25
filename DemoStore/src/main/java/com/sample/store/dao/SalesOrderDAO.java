package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;

//import com.sample.store.entity.Product;
//import com.sample.store.entity.PurchaseOrder;


public interface SalesOrderDAO {	
	
	public int sellProduct(List<Product> pList,Customer customr) throws SQLException;
	public List<SalesOrder> getList();
	public List<SalesOrder> getList(String sql) ;
}
