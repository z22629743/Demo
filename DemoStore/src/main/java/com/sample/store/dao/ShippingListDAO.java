package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;
import com.sample.store.entity.ShippingList;
public interface ShippingListDAO {
	public List<ShippingList> getList();
	public List<ShippingList> getList(String sql);
	public void delete(long soid);
	public int arrive(ShippingList sh) throws SQLException;
	public ShippingList get(long id);
}
