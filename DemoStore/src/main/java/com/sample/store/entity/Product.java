package com.sample.store.entity;

import java.sql.Date;


public class Product {
    private long id;
    private long supplierid;
    private String name;
    private String category;
    private String size;
    private String color;
    private String desc;
    private int price;
    private int inventory;
    private int reorderPoint;
    
    private int totalprice;
    private int quantity;
    private long customerID;
    private Date shippingtime;
    /* getters and setters */
    public long getId(){
            return id;
    }
    public void setId(long id){
    	this.id = id;
    }

 
    
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
    	this.desc = desc;
    }

    public int getInventory(){
    		return inventory;
    }
    public void setInventory(int inventory){
		this.inventory = inventory;
    }
    
    public int getReorderPoint(){
    		return reorderPoint;
    }
    public void setReorderPoint(int reorderPoint){
		this.reorderPoint = reorderPoint;
    }
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public Date getShippingtime() {
		return shippingtime;
	}
	public void setShippingtime(Date shippingtime) {
		this.shippingtime = shippingtime;
	}
	public long getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(long supplierid) {
		this.supplierid = supplierid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	

    /*
    public Object get(int attr){
    	switch(attr){
    	case 0:
    		return id;
    	case 1:
    		return category;
    	case 2:
    		return desc;
    	case 3:
    		return inventory;
    	case 4:
    		return reorderPoint;
    	default:
    		return "";
    	}
    }
*/
}//Product
