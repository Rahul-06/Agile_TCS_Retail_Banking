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

import com.amzi.Util.DbConnection;

import java.text.SimpleDateFormat;  
import java.util.Date;  

@WebServlet("/Servelet1")
public class Servelet1 extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public Servelet1() {
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
	        Connection con = null;
	        
	 
	        Statement st;
	        try {
	        	con = DbConnection.getConnection();
	            System.out.println("Connected!");
	            int acc1=Integer.parseInt(request.getParameter("no"));
	            int bal=Integer.parseInt(request.getParameter("amount"));
	            st = con.createStatement();
	            ResultSet rs = st.executeQuery( "select deposit_amount from account where acnumber='"+acc1+"' and deposit_amount> '499' ");
	            int balance1=0;
	            while (rs.next()) {
	            balance1=rs.getInt("deposit_amount"); 
	            }
	            
	            if(balance1>=500)
	            {
	            int bal1=balance1-bal;
	            
	          
	            String mot1="Withdrawn";
	            
	        
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	            Date date = new Date();  
	            System.out.println(date);
	            String d1=formatter.format(date); 
	            String type="Online";
	            String sql = 
	            		  "INSERT INTO trandetails (acnumber,dot,operation_of_transaction,transaction_type,transaction_amount) values (?,?,?,?,?)";
	            PreparedStatement pst1 = con.prepareStatement(sql);
	            pst1.setInt(1,acc1);
	            pst1.setString(2,d1);
	            pst1.setString(3, mot1);
	            pst1.setString(4, type);
	            pst1.setInt(5, bal);
	            pst1.executeUpdate();
	           
	          
	            pst1.close();
	            //select * from trandetails t,account a,customer c where t.acnumber=a.acnumber or a.ws_cust_id=c.ws_cust_id;

	            st.addBatch("update account set deposit_amount="+bal1+" where acnumber='"+acc1+"'");
	          
	            st.executeBatch();
	            out.println("Successfully done.");
	            RequestDispatcher view = request.getRequestDispatcher("/webpage1.jsp");
	            view.forward(request, response);
	            con.close();
	            }
	            else {
		        RequestDispatcher rd = request.getRequestDispatcher("BalLow.jsp");	
		        rd.include(request, response);
	            con.close();
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
