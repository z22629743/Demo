package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.ShippingListDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;
import com.sample.store.entity.ShippingList;

public class ShippingListDAOImpl implements ShippingListDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<ShippingList> getList(){
		String sql = "SELECT * FROM salesorder";
		return getList(sql);
	}
	
	public List<ShippingList> getList(String sql) {
		
		List<ShippingList> List = new ArrayList<ShippingList>();
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
				aShippingList.setShippingtime(rs.getDate("shippingtime"));
				aShippingList.setAr_time(rs.getDate("ar_time"));
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
	
public void delete(long soid) {
		
		String sql = "DELETE FROM salesorder WHERE soid = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, soid);
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


public int arrive(ShippingList sh) throws SQLException{
	long soid = sh.getSoid();
	int result = 0;
	PreparedStatement st = null;
	try {
		conn = dataSource.getConnection();
		//Issue a query and get a result
		smt = conn.prepareStatement("SELECT * from salesorder WHERE SOID = ?");
		smt.setLong(1,soid);
		rs = smt.executeQuery();
		/*PurchaseOrder p;
		int qty=0;
		long pId=0;
	    if(rs.next()) {
	    	p = getPO(rs);
	    	pId = p.getProductId();
	    	qty = p.getQuantity();
	    } // if*/
	    smt.close();
	    
	    conn.setAutoCommit(false);
	    //the following two SQL have to be done in the same transaction
	    st = conn.prepareStatement("UPDATE salesorder SET AR_Time = Now() WHERE SOID = ?");
	    st.setLong(1,soid);
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



}
