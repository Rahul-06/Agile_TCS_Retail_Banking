package com.amzi.dao;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.amzi.bean.Account;
import com.amzi.Util.DbConnection;
import com.amzi.bean.Account_details;
public class AccountDao {

	public Integer addAccount(Account c)
	{
		int cnt = 0;
		try {
			Connection con = DbConnection.getConnection();
			String query = "insert into account values (?,?,?,?);";
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, c.getAcnumber());
			pStmt.setString(2, c.getAcc_type());
			pStmt.setInt(3, c.getCust_id());
			pStmt.setInt(4, c.getDeposit());
			
			
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
	public Account searchId(Integer acnumber)
	{
		Account c = new Account();
		Account_details c1 = new Account_details();
		try {
			
				
			Connection con = DbConnection.getConnection();	
			
		
			String query1 = "select * from account where acnumber = ?;";
			PreparedStatement pStmt = con.prepareStatement(query1);
			pStmt.setInt(1, acnumber);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				c.setAcnumber(rs.getInt(1));
				c.setAcc_type(rs.getString(2));
				c.setCust_id(rs.getInt(3));
				c.setDeposit(rs.getInt(4));
				
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
	public Integer deleteAccount(Integer acnumber)
	{
		int cnt = 0;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();
			Connection con = DbConnection.getConnection();
			String query = "update account_details set status = ?, message = ?,last_u= ? where acnumber = ? ;";
			PreparedStatement  pStmt = con.prepareStatement(query);
			pStmt.setString(1,"inactive");
			pStmt.setString(2, "Account deleted");
			pStmt.setString(3, dtf.format(now));
			pStmt.setInt(4, acnumber);
			int cnt1=pStmt.executeUpdate();
			String query1 = "delete from account where acnumber = ?;";
			pStmt = con.prepareStatement(query1);
			pStmt.setInt(1, acnumber);
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
}