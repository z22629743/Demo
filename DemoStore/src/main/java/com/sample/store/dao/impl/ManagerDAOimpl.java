package com.sample.store.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.ManagerDAO;
import com.sample.store.entity.Manager;
import com.sample.store.entity.Product;
public class ManagerDAOimpl implements ManagerDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Manager> getList(){
		String sql = "SELECT * FROM manager";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Manager> getList(String sql) {
					
		List<Manager> managerList = new ArrayList<Manager>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Manager manager = new Manager();
				manager.setId(rs.getInt("managerID"));			
				manager.setName(rs.getString("name"));
				manager.setPhone(rs.getString("phone"));
				manager.setAddress(rs.getString("address"));
				manager.setEmail(rs.getString("email"));
				manager.setAccount(rs.getString("account"));
				manager.setPassword(rs.getString("password"));
				manager.setPosition(rs.getString("position"));
				managerList.add(manager);
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
		return managerList;
	}
		  
	public void insert(Manager manager) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO manager (Name, Phone, Address, Email, Account, Password, Position) VALUES(?, ?, ?, ?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, manager.getName());
			smt.setString(2, manager.getPhone());
			smt.setString(3, manager.getAddress());
			smt.setString(4, manager.getEmail());
			smt.setString(5, manager.getAccount());
			smt.setString(6, manager.getPassword());
			smt.setString(7, manager.getPosition());
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

	public Manager get(long id) {
		Manager manager = new Manager();
		String sql = "SELECT * FROM manager WHERE managerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				manager.setId(rs.getInt("managerID"));
				manager.setName(rs.getString("name"));
				manager.setPhone(rs.getString("phone"));
				manager.setAddress(rs.getString("address"));
				manager.setEmail(rs.getString("email"));
				manager.setAccount(rs.getString("account"));
				manager.setPassword(rs.getString("password"));
				manager.setPosition(rs.getString("position"));
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
		return manager;
	}
	public Manager get(String name) {
		Manager manager = new Manager();
		String sql = "SELECT * FROM manager WHERE account = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, name);
			rs = smt.executeQuery();
			if(rs.next()){
				manager.setId(rs.getInt("managerID"));
				manager.setName(rs.getString("name"));
				manager.setPhone(rs.getString("phone"));
				manager.setAddress(rs.getString("address"));
				manager.setEmail(rs.getString("email"));
				manager.setAccount(rs.getString("account"));
				manager.setPassword(rs.getString("password"));
				manager.setPosition(rs.getString("position"));
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
		return manager;
	}
	
	public void update(Manager manager) {
		
		String sql = "UPDATE manager SET Name=?, Phone=?, Address=?, Email=?, Account=?, Password=?, Position=? "
				+ "WHERE managerID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, manager.getName());
			smt.setString(2, manager.getPhone());
			smt.setString(3, manager.getAddress());
			smt.setString(4, manager.getEmail());
			smt.setString(5, manager.getAccount());
			smt.setString(6, manager.getPassword());
			smt.setString(7, manager.getPosition());
			smt.setLong(8, manager.getId());
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
		
		String sql = "DELETE FROM manager WHERE managerID = ?";
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

}
