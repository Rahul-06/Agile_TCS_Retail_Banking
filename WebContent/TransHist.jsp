<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="com.amzi.Util.DbConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
</head>
<body>
<FORM>
<center><h3>Account Statement</h3></center>
<% response.setContentType("text/html");
Connection con = null;
String url = "jdbc:mysql://ls-ea01ee6ad63a8022e01a44ff0028be35c233ace8.clahbm7vh23u.ap-south-1.rds.amazonaws.com:3306/";
String dbName = "dbmasteragile";
String driver = "com.mysql.jdbc.Driver";
String userName = "agiel2tcs";
String password = "agile_tcs";
int acc = Integer.parseInt(request.getParameter("acnumber"));
String ntxn = request.getParameter("txnvalue");
String stdt = request.getParameter("txnstdt");
String etdt = request.getParameter("txneddt");

PreparedStatement ps=null;
try {
	System.out.println(ntxn);
	con = DbConnection.getConnection();
    System.out.println("Connected!");
    String queryString1,queryString2;
                            // sql query to insert values in the secified table.
                            
              queryString1 = "SELECT tnumber,operation_of_transaction,dot,transaction_amount FROM trandetails where acnumber='"+acc+"' ORDER BY tnumber DESC LIMIT "+ntxn+" ";
                            
              queryString2 = "SELECT tnumber,operation_of_transaction,dot,transaction_amount FROM trandetails where acnumber='"+acc+"' and dot between '"+stdt+"' and '"+etdt+"' ";                            
             
              	      /* createStatement() is used for create statement
              object that is used for 
		sending sql statements to the specified database. */
		if(ntxn != "")
		ps = con.prepareStatement(queryString1);
              else 
            	 ps = con.prepareStatement(queryString2);  
            		 
            		 ResultSet rs = ps.executeQuery();
                %>
	           
	           <TABLE BORDER="1" align="center">
            <TR>
                <TH>Transaction ID</TH>
                <TH>Operation</TH>
                <TH>Date of Transaction</TH>
                <TH>Amount</TH>
            </TR>
            
            <TR>
            <% while(rs.next()){ %>
            </TR>
            <TR>
            <TD> <%= rs.getInt(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getDate(3) %></TD>
                <TD> <%= rs.getInt(4) %></TD>
            </TR>
            <% } %>
            
            
            </TABLE>
		          <%
                
	                 }
	                 catch (Exception ex) {
	                	 out.println(ex);
	                 out.println("Unable to connect to database.");
	        
	                    }
	                 finally {
	                     // close all the connections.
	                     ps.close();
	                     con.close();
	                     
	                 }
		   %>	 
  </FORM>
  <br><center><a href="welcome.jsp">BACK TO HOME</a></center>  
</body>
</html>