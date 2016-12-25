package com.sample.store.entity;

import java.sql.Date;

public class ShippingList {
private long soid;
private String customername;
private String customeraddress;
private String customerphone;
private Date ordertime;
private Date shippingtime;
private Date ar_time;
public long getSoid() {
	return soid;
}
public void setSoid(long soid) {
	this.soid = soid;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getCustomeraddress() {
	return customeraddress;
}
public void setCustomeraddress(String customeraddress) {
	this.customeraddress = customeraddress;
}
public String getCustomerphone() {
	return customerphone;
}
public void setCustomerphone(String customerphone) {
	this.customerphone = customerphone;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public Date getShippingtime() {
	return shippingtime;
}
public void setShippingtime(Date shippingtime) {
	this.shippingtime = shippingtime;
}
public Date getAr_time() {
	return ar_time;
}
public void setAr_time(Date ar_time) {
	this.ar_time = ar_time;
}
}
