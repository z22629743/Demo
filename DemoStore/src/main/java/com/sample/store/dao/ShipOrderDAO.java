package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;
import com.sample.store.entity.ShippingList;

//import com.sample.store.entity.Product;
//import com.sample.store.entity.PurchaseOrder;


public interface ShipOrderDAO {	
	
	public int sell(List<SalesOrder> pList) throws SQLException;
	public List<ShippingList> getList();
	public List<ShippingList> getList(String sql);
	public List<ShippingList> search(Customer customer) ;
	public int saleout(long id) throws SQLException;
	public ShippingList get(long soid);
	public List<SalesOrder> getProductid(long soid);
}
