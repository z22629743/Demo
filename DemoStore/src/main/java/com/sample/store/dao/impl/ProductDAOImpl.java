package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;
import com.sample.store.entity.Product;
import com.sample.store.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Product aProduct) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product (SupplierID, Name, Category, Size, Color, Description, Price, Inventory, ReorderPoint) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getSupplierid());
			smt.setString(2, aProduct.getName());
			smt.setString(3, aProduct.getCategory());
			smt.setString(4, aProduct.getSize());
			smt.setString(5, aProduct.getColor());
			smt.setString(6, aProduct.getDesc());
			smt.setInt(7, aProduct.getPrice());
			smt.setInt(8, aProduct.getInventory());
			smt.setInt(9, aProduct.getReorderPoint());
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

	public void delete(Product aProduct) {
		
		String sql = "DELETE FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
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

	public void update(Product aProduct) {
		
		String sql = "UPDATE product SET SupplierID=?, Name=?, Category=?, Size=?, Color=?, Description=?, Price=?, Inventory=?, ReorderPoint=? "
				+ "WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getSupplierid());
			smt.setString(2, aProduct.getName());
			smt.setString(3, aProduct.getCategory());
			smt.setString(4, aProduct.getSize());
			smt.setString(5, aProduct.getColor());
			smt.setString(6, aProduct.getDesc());
			smt.setInt(7, aProduct.getPrice());
			smt.setInt(8, aProduct.getInventory());
			smt.setInt(9, aProduct.getReorderPoint());
			smt.setLong(10, aProduct.getId());
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
	
	public List<Product> getAvailableList() {
		String sql = "SELECT * FROM product WHERE Inventory > 0";
		return getList(sql);
	}
	

	public List<Product> getReorderList() {
		String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
		return getList(sql);
	}

	public List<Product> getList() {
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Product> getList(String sql) {
		
		List<Product> productList = new ArrayList<Product>();
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
				Product aProduct = new Product();
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierid(rs.getLong("supplierid"));
				aProduct.setName(rs.getString("name"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setPrice(rs.getInt("price"));
				//System.out.println(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				productList.add(aProduct);
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

	public Product get(Product aProduct) {
		
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierid(rs.getLong("supplierid"));
				aProduct.setName(rs.getString("name"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setPrice(rs.getInt("price"));
				//System.out.println(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
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
		return aProduct;
	}
	
public Product get(long id) {
		Product aProduct = new Product();
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			while(rs.next()){
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierid(rs.getLong("supplierid"));
				aProduct.setName(rs.getString("name"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setPrice(rs.getInt("price"));
				//System.out.println(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
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
		return aProduct;
	}


	public List<Product> get(String name){
		List<Product> productList = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product WHERE Name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, name);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierid(rs.getLong("supplierid"));
				aProduct.setName(rs.getString("name"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setPrice(rs.getInt("price"));
				//System.out.println(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				productList.add(aProduct);
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
	

}
