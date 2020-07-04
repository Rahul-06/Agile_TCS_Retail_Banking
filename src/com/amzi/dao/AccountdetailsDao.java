package com.amzi.dao;

import com.amzi.bean.Account;
import com.amzi.bean.Account_details;
import com.amzi.bean.Customer;
import com.amzi.Util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AccountdetailsDao {
public Integer addAccountdetails(Account_details c)
	{
		int cnt = 0;
		try {
			Connection con = DbConnection.getConnection();
			String query = "insert into account_details values (?,?,?,?,?,?);";
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, c.getAcnumber());
			pStmt.setString(3, c.getAcc_type());
			pStmt.setInt(2, c.getCust_id());
			pStmt.setString(4, c.getStatus());
			pStmt.setString(5,c.getMessage());
			pStmt.setString(6,c.getLast_u());
			
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
	
public Integer updateAccountdetails(Account_details c)
{
	int cnt = 0;
	try {
		Connection con = DbConnection.getConnection();
		String query = "update account_details set status = ?, message = ?  last_u= ? where acnumber = ? ;";
		PreparedStatement pStmt = con.prepareStatement(query);
		pStmt.setString(1, c.getStatus());
		pStmt.setString(2, c.getMessage());
		pStmt.setString(2, c.getLast_u());
		pStmt.setInt(4, c.getAcnumber());
		
		
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