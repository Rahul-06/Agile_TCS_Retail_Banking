package com.amzi.controller;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import com.amzi.bean.Account_details;

import com.amzi.bean.Account;


import com.amzi.service.AccountdetailsService;
import com.amzi.service.AccountService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AccountServelet")
public class AccountServelet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * 
	     * @see HttpServlet#HttpServlet()
	     */
	    public AccountServelet() {
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
			AccountService cs = new AccountService();
			AccountdetailsService cd=new AccountdetailsService();
			String action = request.getParameter("action");
			System.out.println("In post");
			if(action.equalsIgnoreCase("Add Account"))
			{
				Integer acnumber = Integer.parseInt(request.getParameter("acnumber"));
				String acc_type = request.getParameter("acc_type");
				Integer cust_id = Integer.parseInt(request.getParameter("ws_cust_id"));
				Integer deposit = Integer.parseInt(request.getParameter("deposit"));
				
				  Account c = new Account(acnumber,acc_type,cust_id,deposit);
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
				
				Account_details ac=new Account_details(acnumber,cust_id,acc_type,"active","Account created",dtf.format(now));
				cd.createAccountdetails(ac);
				
				int x = cs.createAccount(c);
				if(x > 0)
				{
					RequestDispatcher rd = request.getRequestDispatcher("AccSuccess.jsp");
					request.setAttribute("acnumber",acnumber );
					rd.forward(request, response);
				}
				else
				{
					out.println("<h1>Registration Failed</h1>");
					RequestDispatcher rd = request.getRequestDispatcher("Accregister.jsp");
					rd.include(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("Delete Account"))
			{
				Integer acnumber = Integer.parseInt(request.getParameter("acnumber"));
				Account c1 = cs.searchId(acnumber);
				 
				
				if (c1.getAcnumber() == null) {
					RequestDispatcher rd = request.getRequestDispatcher("FailureA.jsp");
	            	rd.forward(request, response);
				}
				else if (action.equalsIgnoreCase("Delete Account"))
				{  
					
					
					RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
					request.setAttribute("cust",c1);
					rd.forward(request, response);
				}
				
			}
					
		
		else if(action.equalsIgnoreCase("delete"))
		{
			HttpSession session = request.getSession(false);
			Account c = (Account)session.getAttribute("cust");
		    int x = cs.deleteAccount(c.getAcnumber());
			if(x > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Delete_sucessA.jsp");
				request.setAttribute("acnumber",c.getAcnumber());
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
				
	}

	}


