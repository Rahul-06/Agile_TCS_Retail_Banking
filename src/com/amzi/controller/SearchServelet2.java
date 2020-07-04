package com.amzi.controller;

import com.amzi.Util.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/SearchServelet2")
public class SearchServelet2 extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Statement st;
        try {
            
            Connection conn = DbConnection.getConnection();
            System.out.println("Connected!");
            String ws_cust_id = request.getParameter("ws_cust_id");
 
            ArrayList al = null;
            ArrayList pid_list = new ArrayList();
            String query =  "select * from customer,account where customer.ws_cust_id=account.ws_cust_id AND account.ws_cust_id='" + ws_cust_id + "' ";
 
            System.out.println("query " + query);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
 
            while (rs.next()) {
                al = new ArrayList();
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getString(5));
                al.add(rs.getString(6));
                al.add(rs.getString(7));
                al.add(rs.getString(8));
                al.add(rs.getString(9));
               //al.add(rs.getString(10));
                al.add(rs.getString(11));
 
                System.out.println("al :: " + al);
                pid_list.add(al);
            }
 
            request.setAttribute("piList", pid_list);
            RequestDispatcher view = request.getRequestDispatcher("/SearchView.jsp");
            view.forward(request, response);
            conn.close();
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