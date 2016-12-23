package com.sample.store.entity;

import java.sql.Date;


public class Product {
    private long id;
    private int category;
    private String desc;
    private int inventory;
    private int reorderPoint;
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

    public int getCategory(){
            return category;
    }
    public void setCategory(int category){
        this.category = category;
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
