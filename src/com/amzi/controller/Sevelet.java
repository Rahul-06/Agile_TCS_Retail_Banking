package com.amzi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import java.util.Date;  

@WebServlet("/Sevelet")
public class Sevelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public Sevelet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In get");
		doPost(request, response);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        Connection conn = null;
	        String url = "jdbc:mysql://ls-ea01ee6ad63a8022e01a44ff0028be35c233ace8.clahbm7vh23u.ap-south-1.rds.amazonaws.com:3306/";
	        String dbName = "dbmasteragile";
	        String driver = "com.mysql.jdbc.Driver";
	        String userName = "agile2tcs";
	        String password = "agile_tcs";
	        RequestDispatcher view,rd;
	        Statement st;
	        try {
	            Class.forName(driver).newInstance();
	            conn = DriverManager.getConnection(url + dbName, userName, password);
	            System.out.println("Connected!");
	          
	           int acc1=Integer.parseInt(request.getParameter("no"));
	            int bal=Integer.parseInt(request.getParameter("amount"));
	            int acc2=Integer.parseInt(request.getParameter("to"));
	           
	            
	            st = conn.createStatement();
	            ResultSet rs = st.executeQuery( "select deposit_amount from account where acnumber='"+acc1+"'");
	            
	            
	            int balance1=0;
	            while (rs.next()) {
	            balance1=rs.getInt("deposit_amount"); 
	            }
	            ResultSet rs1 = st.executeQuery( "select deposit_amount from account where acnumber='"+acc2+"'");
	            
	            int balance2=0;
	            while (rs1.next()) {
	            balance2=rs1.getInt("deposit_amount");
	            }
	            	
	            int bal1=balance1-bal;
	            
	            int bal2=balance2+bal;
	            if(balance1>=500)
	            {
	            String mot1="Withdrawn";
	            String mot2="Deposited";
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	            Date date = new Date();  
	            System.out.println(date);
	            String d1=formatter.format(date); 
	            String type="Online";
	            String sql = 
	            		  "INSERT INTO trandetails (acnumber,dot,operation_of_transaction,transaction_type,transaction_amount) values (?,?,?,?,?)";
	            PreparedStatement pst1 = conn.prepareStatement(sql);
	            pst1.setInt(1,acc1);
	            pst1.setString(2,d1);
	            pst1.setString(3, mot1);
	            pst1.setString(4, type);
	            pst1.setInt(5, bal);
	            pst1.executeUpdate();
	            String sql1 = 
	            		  "INSERT INTO trandetails (acnumber,dot,operation_of_transaction,transaction_type,transaction_amount) values (?,?,?,?,?)";
	            pst1 =conn.prepareStatement(sql1);
	            pst1.setInt(1,acc2);
	            pst1.setString(2,d1);
	            pst1.setString(3, mot2);
	            pst1.setString(4, type);
	            pst1.setInt(5, bal);
	            pst1.executeUpdate();
	            pst1.close();
	            //select * from trandetails t,account a,customer c where t.acnumber=a.acnumber or a.ws_cust_id=c.ws_cust_id;

	            st.addBatch("update account set deposit_amount="+bal1+" where acnumber='"+acc1+"'");
	            st.addBatch("update account set deposit_amount="+bal2+" where acnumber='"+acc2+"'");
	           
	            st.executeBatch();
	            out.println("Transaction has been successfully done.");
	            view = request.getRequestDispatcher("/webpage.jsp");
	            view.forward(request, response);
	            conn.close();
	            
	        }
	            else
	            {
	            	rd = request.getRequestDispatcher("NoBal.jsp");
	            	rd.include(request, response);
		            conn.close();
	            }
	            System.out.println("Disconnected!");
	          
	         
	         
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    /** 
	     * Returns a short description of the servlet.
	     * @return a String containing servlet description
	     */    
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }
	}