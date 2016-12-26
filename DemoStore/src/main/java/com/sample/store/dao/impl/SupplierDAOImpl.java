package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.SupplierDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Supplier aSupplier) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO supplier (SupplierID, Name, Phone, Address) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aSupplier.getSupplierid());
			smt.setString(2, aSupplier.getName());
			smt.setString(3, aSupplier.getPhone());
			smt.setString(4, aSupplier.getAddress());

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

	public void delete(Supplier aSupplier) {
		
		String sql = "DELETE FROM supplier WHERE SupplierID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aSupplier.getSupplierid());
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

	public void update(Supplier aSupplier) {
		
		String sql = "UPDATE supplier SET Name=?, Phone=?, Address=?"
				+ "WHERE SupplierID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aSupplier.getName());
			smt.setString(2, aSupplier.getPhone());
			smt.setString(3, aSupplier.getAddress());
			smt.setLong(4, aSupplier.getSupplierid());
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
	public List<Supplier> getList() {
		String sql = "SELECT * FROM supplier";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Supplier> getList(String sql) {
		
		List<Supplier> productList = new ArrayList<Supplier>();
		//will need this part later
		/*
		String sql = "SELECT * FROM article a "
				+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
				+ "ORDER BY articleID DESC";
		*/
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Supplier aSupplier = new Supplier();
				aSupplier.setSupplierid(rs.getLong("supplierid"));
				aSupplier.setName(rs.getString("name"));
				aSupplier.setPhone(rs.getString("phone"));
				aSupplier.setAddress(rs.getString("address"));
				productList.add(aSupplier);
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
		return productList;
	}
	public Supplier get(Supplier aSupplier){
		String sql = "SELECT * FROM supplier WHERE supplierID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aSupplier.getSupplierid());
			rs = smt.executeQuery();
			while(rs.next()){	
				aSupplier.setSupplierid(rs.getLong("supplierid"));
				aSupplier.setName(rs.getString("name"));
				aSupplier.setPhone(rs.getString("phone"));
				aSupplier.setAddress(rs.getString("address"));
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
		return aSupplier;
	}
	
}
