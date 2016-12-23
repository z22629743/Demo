package com.sample.store.entity;

public class SalesOrder {
private long id;
private long soid;
private long productid;
private long quantity;
private long customerid;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getSoid() {
	return soid;
}
public void setSoid(long soid) {
	this.soid = soid;
}
public long getProductid() {
	return productid;
}
public void setProductid(long productid) {
	this.productid = productid;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public long getCustomerid() {
	return customerid;
}
public void setCustomerid(long customerid) {
	this.customerid = customerid;
}
}
