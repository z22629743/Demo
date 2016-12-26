package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Supplier;

public interface SupplierDAO {
	public void insert(Supplier aSupplier);
	public void delete(Supplier aSupplier);
	public void update(Supplier aSupplier);
	public List<Supplier> getList();
	public Supplier get(Supplier aSupplier);
	public Supplier get(long id);
}
