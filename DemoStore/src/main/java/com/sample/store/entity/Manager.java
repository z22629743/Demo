package com.sample.store.entity;

public class Manager {
	private long id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String account;
    private String password;
    private String position;
    /* getters and setters */
    public long getId(){
            return id;
    }
    public void setId(long id){
    	this.id = id;
    }

    public String getName(){
            return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
    	this.phone = phone;
    }

    public String getAddress(){
    		return address;
    }
    public void setAddress(String address){
		this.address = address;
    }
    
    public String getPassword(){
    	return password;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
    
}
