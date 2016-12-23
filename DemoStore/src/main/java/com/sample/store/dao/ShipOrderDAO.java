package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;

//import com.sample.store.entity.Product;
//import com.sample.store.entity.PurchaseOrder;


public interface ShipOrderDAO {	
	
	public int sellProduct(List<Product> pList) throws SQLException;
	public List<SalesOrder> getList();
	public List<SalesOrder> getList(String sql) ;
}
