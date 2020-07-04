package com.amzi.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Servelet2 extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public Servelet2() {
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
	 
	        Statement st;
	        try {
	            Class.forName(driver).newInstance();
	            conn = DriverManager.getConnection(url + dbName, userName, password);
	            System.out.println("Connected!");
	            int acc1=Integer.parseInt(request.getParameter("no"));
	            int bal=Integer.parseInt(request.getParameter("amount"));
	           
	            st = conn.createStatement();
	            ResultSet rs = st.executeQuery( "select deposit from account where acnumber='"+acc1+"'");
	           if(rs.next()!=false)
	           {
	 
	            int balance1=0;
	            while (rs.next()) {
	            balance1=rs.getInt("deposit"); 
	            }
	            
               
	            int bal1=balance1+bal;
	          
	            String mot1="Deposited";
	        
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	            Date date = new Date();  
	            System.out.println(date);
	            String d1=formatter.format(date); 
	            String type="Online";
	            String sql = 
	            		  "INSERT INTO `trandetails`(acnumber,dot,operation,t_type,t_amount)values (?,?,?,?,?)";
	            PreparedStatement pst1 = conn.prepareStatement(sql);
	            pst1.setInt(1,acc1);
	            pst1.setString(2,d1);
	            pst1.setString(3, mot1);
	            pst1.setString(4, type);
	            pst1.setInt(5, bal);
	            pst1.executeUpdate();
	           
	          
	            pst1.close();
	            //select * from trandetails t,account a,customer c where t.acnumber=a.acnumber or a.ws_cust_id=c.ws_cust_id;

	            st.addBatch("update account set deposit="+bal1+" where acnumber='"+acc1+"'");
	          
	            st.executeBatch();
	            out.println("Successfully done.");
	            RequestDispatcher view = request.getRequestDispatcher("/webpage2.jsp");
	            view.forward(request, response);
	            conn.close();
	            System.out.println("Disconnected!");
                }
	      
	           else
	           {
	        	   out.println("Account dont exist");
	        	   RequestDispatcher view = request.getRequestDispatcher("/id.jsp");
		            view.forward(request, response);
		            conn.close();
		            System.out.println("Disconnected!");
	           }
	        }
	        catch (Exception e) {
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
