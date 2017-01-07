package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.CustomerDAO;
import com.sample.store.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Customer> getList(){
		String sql = "SELECT * FROM customer";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Customer> getList(String sql) {
					
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerID"));			
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setLevel(rs.getString("level"));
				customerList.add(customer);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return customerList;
	}
		  
	public void insert(Customer customer) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO customer (Name, Phone, Address, Level) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, customer.getName());
			smt.setString(2, customer.getPhone());
			smt.setString(3, customer.getAddress());
			smt.setString(4, customer.getLevel());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	public Customer get(long id) {
		Customer customer = new Customer();
		String sql = "SELECT * FROM customer WHERE customerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				customer.setId(rs.getInt("customerID"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setLevel(rs.getString("level"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return customer;
	}
	public Customer get(Customer aCustomer) {
		Customer customer = new Customer();
		String sql = "SELECT * FROM customer WHERE customerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aCustomer.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				customer.setId(rs.getInt("customerID"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setLevel(rs.getString("level"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return customer;
	}
	public Customer get(String name) {
		Customer customer = new Customer();
		String sql = "SELECT * FROM customer WHERE Name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, name);
			rs = smt.executeQuery();
			if(rs.next()){
				customer.setId(rs.getInt("customerID"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setLevel(rs.getString("level"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return customer;
	}
	public void update(Customer customer) {
		
		String sql = "UPDATE customer SET Name=?, Phone=?, Address=?, Level=? "
				+ "WHERE customerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, customer.getName());
			smt.setString(2, customer.getPhone());
			smt.setString(3, customer.getAddress());
			smt.setString(4, customer.getLevel());
			smt.setLong(5, customer.getId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	public void delete(long id) {
		
		String sql = "DELETE FROM customer WHERE customerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public int count(){
		return 0; //no longer needed
	}
	
public void updateLevel(Customer customer) {
		
		String sql = "UPDATE customer SET Level=? WHERE customerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, customer.getLevel());
			smt.setLong(2, customer.getId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
}
