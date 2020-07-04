package com.amzi.dao;


import com.amzi.bean.Customerdetails;
import java.time.format.DateTimeFormatter; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.amzi.bean.Customer;
import com.amzi.bean.Customerdetails;
import com.amzi.Util.DbConnection;

public class CustomerdetailsDao {

		public Integer addCustomerdetails(Customerdetails c)
		{
			int cnt = 0;
			try {
				Connection con = DbConnection.getConnection();
				String query = "insert into customerdetails values (?,?,?,?,?,?);";
				PreparedStatement pStmt = con.prepareStatement(query);
				pStmt.setInt(1, c.getSsn_id());
				pStmt.setInt(2, c.getCust_id());
				pStmt.setString(3, c.getCust_name());
				pStmt.setString(4, c.getStatus());
				pStmt.setString(5, c.getMessage());
				pStmt.setString(6, c.getLast_u());
				
				
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
		
	
		public Integer updateCustomerdetails(Customerdetails c)
		{
			int cnt = 0;
			try {
				Connection con = DbConnection.getConnection();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();
				   String query = "update customerdetails  set ws_name = ?, status = ?, message = ?, last_u= ? where ws_cust_id = ? ;";
					PreparedStatement  pStmt = con.prepareStatement(query);
					pStmt.setString(1,c.getCust_name());
					pStmt.setString(2,c.getStatus());
					pStmt.setString(3, c.getMessage());
					pStmt.setString(4, c.getLast_u());
					pStmt.setInt(5, c.getCust_id());
					cnt =pStmt.executeUpdate();
				
			
				
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
		
	
		
	}

