package com.amzi.dao;
 
import java.time.LocalDateTime; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter; 

import com.amzi.bean.Customer;
import com.amzi.Util.DbConnection;

public class CustomerDao {

	public Integer addCustomer(Customer c)
	{
		int cnt = 0;
		try {
			Connection con = DbConnection.getConnection();
			String query = "insert into customer values (?,?,?,?,?,?,?);";
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, c.getSsn_id());
			pStmt.setInt(2, c.getCust_id());
			pStmt.setString(3, c.getCust_name());
			pStmt.setInt(4, c.getAge());
			pStmt.setString(5, c.getAddress());
			pStmt.setString(6, c.getCity());
			pStmt.setString(7, c.getState());
			
			cnt = pStmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	
	public Customer searchId(Integer cust_id)
	{
		Customer c = new Customer();
		try {
			Connection con = DbConnection.getConnection();
			String query = "select * from customer where ws_cust_id = ?;";
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, cust_id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				c.setSsn_id(rs.getInt(1));
				c.setCust_id(rs.getInt(2));
				c.setCust_name(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setAddress(rs.getString(5));
				c.setState(rs.getString(6));
				c.setCity(rs.getString(7));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	public Integer updateCustomer(Customer c)
	{
		int cnt = 0;
		try {
			Connection con = DbConnection.getConnection();
			
			System.out.println("Updte customer details");
			String query1 = "update customer set ws_cust_name = ?, ws_age = ?, ws_adrs = ? where ws_cust_id = ? ;";
			PreparedStatement pStmt = con.prepareStatement(query1);
			pStmt.setString(1, c.getCust_name());
			pStmt.setInt(2, c.getAge());
			pStmt.setString(3, c.getAddress());
			pStmt.setInt(4, c.getCust_id());
			
			cnt = pStmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		return cnt;
	}
	
	public Integer deleteCustomer(Integer cust_id)
	{
		int cnt = 0;
		try {
			
			Connection con = DbConnection.getConnection();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();
			String query = "update customerdetails set status = ?, message = ?, last_u= ? where ws_cust_id = ? ;";
			PreparedStatement  pStmt = con.prepareStatement(query);
			pStmt.setString(1,"inactive");
			pStmt.setString(2, "Customer has been  deleted");
			pStmt.setString(3, dtf.format(now));
			pStmt.setInt(4, cust_id);
			int cnt1=pStmt.executeUpdate();
			String query1 = "delete from customer where ws_cust_id = ?;";
			 pStmt = con.prepareStatement(query1);
			pStmt.setInt(1, cust_id);
			cnt = pStmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cnt;
		
	}
	
	/* VIEW CUSTOMER */
	
	public Customer viewId(String ssn_id, String cust_id)
	{
		Customer c = new Customer();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pStmt;
			if(ssn_id != "")
			{
				Integer ssn_id1 = Integer.parseInt(ssn_id);
				String query = "select * from customer where ws_ssn_id = ?;";
				pStmt = con.prepareStatement(query);
				pStmt.setInt(1,ssn_id1);
			}
			else
			{
				Integer cust_id1 = Integer.parseInt(cust_id);
				String query = "select * from customer where ws_cust_id = ?;";
				pStmt = con.prepareStatement(query);
				pStmt.setInt(1,cust_id1);
			}
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				c.setSsn_id(rs.getInt(1));
				c.setCust_id(rs.getInt(2));
				c.setCust_name(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setAddress(rs.getString(5));
				c.setState(rs.getString(6));
				c.setCity(rs.getString(7));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return c;
		
	}
	
}
