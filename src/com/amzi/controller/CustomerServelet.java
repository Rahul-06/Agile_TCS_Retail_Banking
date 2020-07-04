package com.amzi.controller;

import com.amzi.Util.DbConnection;

import com.amzi.bean.Customer;

import com.amzi.service.CustomerService;
import com.amzi.bean.Customerdetails;
import com.amzi.service.CustomerdetailsService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CustomerServelet")
public class CustomerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServelet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In get");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		CustomerService cs = new CustomerService();
		CustomerdetailsService cd=new CustomerdetailsService();
		String action = request.getParameter("action");
		System.out.println("In post");
		if(action.equalsIgnoreCase("Add Customer"))
		{
			Integer ssn_id = Integer.parseInt(request.getParameter("ws_ssn"));
			Integer cust_id = Integer.parseInt(request.getParameter("ws_cust_id"));
			String cust_name = request.getParameter("ws_name");
			Integer age = Integer.parseInt(request.getParameter("ws_age"));
			String address = request.getParameter("ws_adrs");
			String city = request.getParameter("ws_city");
			String state = request.getParameter("ws_state");
			
			Customer c = new Customer(ssn_id,cust_id,cust_name,age,address,city,state);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			
			Customerdetails ac=new  Customerdetails(ssn_id,cust_id,cust_name,"active","Customer has been  created",dtf.format(now));
			cd.createCustomerdetails(ac);
			int x = cs.createCustomer(c);
			//String details="create";
			if(x > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				request.setAttribute("custid",cust_id );
				//request.setAttribute("detail", details);
				rd.forward(request, response);
			}
			else
			{
				out.println("<h1>Registration Failed</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				rd.include(request, response);
			}
			
			//HttpSession session = request.getSession();
			//session.setAttribute("cust_details",c);
			
		}
		else if(action.equalsIgnoreCase("Update Id") || action.equalsIgnoreCase("Delete Id"))
		{
			Integer cust_id = Integer.parseInt(request.getParameter("ws_cust_id"));
			Customer c1 = cs.searchId(cust_id);
			
			if (c1.getCust_id() == null) {
				RequestDispatcher rd = request.getRequestDispatcher("Failure.jsp");
            	rd.forward(request, response);
			}
			else if(action.equalsIgnoreCase("Update Id"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				request.setAttribute("cust",c1);
				rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("Delete Id"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("Delete.jsp");
				request.setAttribute("cust",c1);
				rd.forward(request, response);
			}
            
		}
		else if(action.equalsIgnoreCase("update"))
		{
			HttpSession session = request.getSession(false);
			Customer c = (Customer)session.getAttribute("cust");
			String cust_name = request.getParameter("ws_cust_name");
			String address = request.getParameter("ws_adrs");
			Integer age = Integer.parseInt(request.getParameter("ws_age"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			Customer c1 = new Customer(c.getSsn_id(),c.getCust_id(),cust_name,age,address,c.getCity(),c.getState());
			int x = cs.updateCustomer(c1);
			Customerdetails c2 = new Customerdetails(c.getSsn_id(),c.getCust_id(),cust_name,"active","Customer Updated",dtf.format(now));
			 cd.updateCustomerdetails(c2);
			 try {
					Connection con = DbConnection.getConnection();
					
					   String query = "update customerdetails  set ws_name = ?, status = ?, message = ?, last_u= ? where ws_cust_id = ? ;";
						PreparedStatement  pStmt = con.prepareStatement(query);
						pStmt.setString(1,c.getCust_name());
						pStmt.setString(2,"active");
						pStmt.setString(3, "Updated");
						pStmt.setString(4, dtf.format(now));
						pStmt.setInt(5, c.getCust_id());
						int cnt =pStmt.executeUpdate();
					
				
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{ 
					e.printStackTrace();
				}
				
			String details="update";
			if(x > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Update_success.jsp");
				request.setAttribute("custid",c.getCust_id());
				//request.setAttribute("detail", details);
				rd.forward(request, response);
			}
			else
			{
				out.println("<h1>Updation Failed</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("FailureUpd.jsp");
				rd.include(request, response);
			}
			
			//session.setAttribute("cust_details",c1);
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			HttpSession session = request.getSession(false);
			Customer c = (Customer)session.getAttribute("cust");
		
			int x = cs.deleteCustomer(c.getCust_id());
			if(x > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Delete_success.jsp");
				request.setAttribute("custid",c.getCust_id());
				//request.setAttribute("detail", details);
				rd.forward(request, response);
			}
			else
			{
				out.println("<h1>Deletion Failed</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("deletefailure.jsp");
				rd.include(request, response);
			}
			
			//session.setAttribute("cust_details",c1);
		}
		
		/* VIEW CUSTOMER */
		
		else if(action.equalsIgnoreCase("search"))
		{
		    String ssn_id=request.getParameter("ws_ssn_id");
		    String cust_id=request.getParameter("ws_cust_id");
		    Customer c = cs.viewCustomer(ssn_id,cust_id);
	
		    if(c.getCust_id() == null)
		    {
		    	out.println("<h1>View Failed</h1>");
		    	RequestDispatcher rd = request.getRequestDispatcher("view_failure.jsp");
		    	rd.forward(request, response);
		    }
		    else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("View_success.jsp");
				request.setAttribute("cust",c);
				rd.forward(request, response);
			}
			
		}
			
	}

}
