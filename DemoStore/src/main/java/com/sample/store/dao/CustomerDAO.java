package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Customer;


public interface CustomerDAO {
	public List<Customer> getList();
	public void insert(Customer aCustomer);

	public Customer get(long id);
	
	public Customer get(Customer aCustomer);
	
	public void update(Customer customer);
	
	public void delete(long id);

	public int count();
}
