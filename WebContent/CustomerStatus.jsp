<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Status</title>
</head>

<body align="center">
<FORM action="CustomerServelet" method="post">
<% response.setContentType("text/html");
Connection conn = null;
String url = "jdbc:mysql://ls-ea01ee6ad63a8022e01a44ff0028be35c233ace8.clahbm7vh23u.ap-south-1.rds.amazonaws.com:3306/";
String dbName = "dbmasteragile";
String driver = "com.mysql.jdbc.Driver";
String userName = "agile2tcs";
String password = "agile_tcs";
PreparedStatement ps=null;

try {
    Class.forName(driver).newInstance();
    conn = DriverManager.getConnection(url + dbName, userName, password);
    System.out.println("Connected!");
                            // sql query to insert values in the secified table.
              String queryString = "SELECT * FROM customerdetails";
             
              	      /* createStatement() is used for create statement
              object that is used for 
		sending sql statements to the specified database. */
		ps = conn.prepareStatement(queryString);
            		 
            		 ResultSet rs = ps.executeQuery();
            		 
            		 
            		
                %>
	           <br>
	           <center><h3>Customer Status</h3></center>
	           <TABLE BORDER="1" align="center">
            <TR>
                <TH>SSN Id</TH>
                <TH>Customer Id</TH>
                <TH>Customer Name</TH>
                <TH>Status</TH>
                <TH>Message</TH>
                <TH>Last Updated</TH>
                <TH>Refresh</TH>
                
            </TR>
            
            <TR>
            <% while(rs.next()){ 
            %>
            </TR>
            <TR>
            <TD><%= rs.getInt(1) %></td>
                <TD> <%= rs.getInt(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
                <TD> <%= rs.getString(4) %></TD>
                <TD> <%= rs.getString(5) %></TD>
                <TD> <%= rs.getString(6) %></TD>
                <TD><a href="CustomerStatus.jsp">Refresh</a></TD>                
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
	                     conn.close();
	                     
	                 }
		   %> <br>	 
  </FORM>
  <br><center><a href="welcome.jsp">BACK TO HOME</a></center>
</body>
</html>