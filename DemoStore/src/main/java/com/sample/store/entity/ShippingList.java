package com.sample.store.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class ShippingList {
private long soid;
private String customername;
private String customeraddress;
private String customerphone;
private int orderprice;
private Date ordertime;
private Timestamp shippingtime;
private Timestamp ar_time;
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
public Timestamp getShippingtime() {
	return shippingtime;
}
public void setShippingtime(Timestamp shippingtime) {
	this.shippingtime = shippingtime;
}
public Timestamp getAr_time() {
	return ar_time;
}
public void setAr_time(Timestamp ar_time) {
	this.ar_time = ar_time;
}
public int getOrderprice() {
	return orderprice;
}
public void setOrderprice(int orderprice) {
	this.orderprice = orderprice;
}
}
