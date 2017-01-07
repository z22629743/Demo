package com.sample.store.dao.impl;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;







//import com.mysql.jdbc.Statement;
//import com.sample.store.entity.Product;
//import com.sample.store.entity.ShoppingCart;
import com.sample.store.dao.SalesOrderDAO;
import com.sample.store.dao.ShipOrderDAO;
import com.sample.store.entity.Customer;
import com.sample.store.entity.Product;
import com.sample.store.entity.SalesOrder;
import com.sample.store.entity.ShippingList;

 public class ShipOrderDAOImpl implements ShipOrderDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int sell(List<SalesOrder> pList) throws SQLException {
		    
		if (pList.size() == 0){
			return 0; // if nothing in the shopping cart
		}
		long orderID = 0;
		int count = 0; // count how many sales order items were processed successfully
		
	    PreparedStatement stCreateOrder = null;
		PreparedStatement stUpdateProduct = null;
		PreparedStatement stInsertOrderItem = null;


		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
	
		    for (SalesOrder aProduct:pList){
		    	//the following two SQL have to be done in the same transaction
		    	//Issue a query and get a result
		    	stUpdateProduct = conn.prepareStatement("UPDATE product SET Inventory = Inventory - ? WHERE ProductId = ?");
		    	stUpdateProduct.setLong(1,aProduct.getQuantity());
		    	stUpdateProduct.setLong(2,aProduct.getProductid());
		    	stUpdateProduct.executeUpdate();
		    	stUpdateProduct.close();
		    	//System.out.println(productID+"is updated");
		    	//System.out.println(productID+"is processed");
		    	count ++;
		      }// for all products on the cart
		      
		      conn.commit();
		      conn.close();
		      
		} // try
    	catch (Exception e) {
    		count = 0;
    		e.printStackTrace();
	  		if (conn!= null) { 
	  			try { 
	  				System.out.print("Transaction is being rolled back"); 
	  				conn.rollback(); } 
	  			catch(SQLException excep){
	  				e.printStackTrace(); 
	  			}
	  		}
	    } finally { 
		  	  if (stCreateOrder != null) {
		  	   stCreateOrder.close(); }
		  	  if (stUpdateProduct != null) { 
		  	   stUpdateProduct.close(); }
		  	  if (stInsertOrderItem != null) { 
			  	   stInsertOrderItem.close(); }
		  	  conn.close();
		} 
	    return count;
	} //sellProduct

	public List<ShippingList> getList(){
		String sql = "SELECT * FROM salesorder";
		return getList(sql);
	}
	public List<ShippingList> getList(String sql){
		List<ShippingList> List = new ArrayList<ShippingList>();
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
				ShippingList aShippingList = new ShippingList();
				aShippingList.setSoid(rs.getLong("soid"));			
				aShippingList.setCustomername(rs.getString("customername"));
				aShippingList.setCustomeraddress(rs.getString("customeraddress"));
				aShippingList.setCustomerphone(rs.getString("customerphone"));
				aShippingList.setOrdertime(rs.getDate("ordertime"));
				aShippingList.setShippingtime(rs.getTimestamp("shippingtime"));
				List.add(aShippingList);
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
		return List;
	}
	
	public List<ShippingList> search(Customer customer) {
		String sql = "SELECT * FROM salesorder WHERE customerName = ?";
		List<ShippingList> List = new ArrayList<ShippingList>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, customer.getName());
			rs = smt.executeQuery();
			while(rs.next()){
				ShippingList aShippingList = new ShippingList();
				aShippingList.setSoid(rs.getLong("soid"));			
				aShippingList.setCustomername(rs.getString("customername"));
				aShippingList.setCustomeraddress(rs.getString("customeraddress"));
				aShippingList.setCustomerphone(rs.getString("customerphone"));
				aShippingList.setOrdertime(rs.getDate("ordertime"));
				aShippingList.setShippingtime(rs.getTimestamp("shippingtime"));
				List.add(aShippingList);
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
		return List;
	}
	
	public int saleout(long id) throws SQLException{
		int result = 0;
		PreparedStatement st = null;

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement("SELECT * from salesorder WHERE SOID = ?");
			smt.setLong(1,id);
			rs = smt.executeQuery();
		    smt.close();
		    
		    conn.setAutoCommit(false);
		    //the following two SQL have to be done in the same transaction
		    st = conn.prepareStatement("UPDATE salesorder SET ShippingTime = Now() WHERE SOID = ?");
		    st.setLong(1,id);
		    result = st.executeUpdate();
		    st.close();
		    conn.commit();
		    conn.close();
		    } // try
		  	catch (SQLException e ) {
		  		e.printStackTrace();
		  		if (conn != null) { 
		  			try { 
		  				System.err.print("Transaction is being rolled back"); 
		  				conn.rollback(); } 
		  			catch(SQLException excep){
		  				e.printStackTrace(); 
		  			}
		  		}
		  		
		  	 } finally { 
		  	 try {
				if (st != null) {
				   st.close(); }
		  	} catch (SQLException e) {
		  		e.printStackTrace();
			}
		      conn.close();
		  	 } 

		return result;
		}

public ShippingList get(long soid) {
	ShippingList sh = new ShippingList();
		String sql = "SELECT * FROM salesorder WHERE SOID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, soid);
			rs = smt.executeQuery();
			while(rs.next()){
				sh.setCustomername(rs.getString("customername"));
				sh.setCustomeraddress(rs.getString("customeraddress"));
				sh.setCustomerphone(rs.getString("customerphone"));
				sh.setOrdertime(rs.getDate("ordertime"));
				sh.setShippingtime(rs.getTimestamp("shippingtime"));
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
		return sh;
	}
public List<SalesOrder> getProductid(long soid){
	List<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();
	String sql = "SELECT * FROM salesorderitem WHERE SOID = ?";
	try {
		conn = dataSource.getConnection();
		smt = conn.prepareStatement(sql);
		smt.setLong(1, soid);
		rs = smt.executeQuery();
		while(rs.next()){
			SalesOrder sh = new SalesOrder();
			sh.setId(rs.getLong("id"));
			sh.setProductid(rs.getLong("productid"));
			sh.setQuantity(rs.getInt("quantity"));
			sh.setCustomerid(rs.getLong("customerid"));
			SalesOrderList.add(sh);
			System.out.println("ID="+sh.getProductid());
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
	return SalesOrderList;
}
}
