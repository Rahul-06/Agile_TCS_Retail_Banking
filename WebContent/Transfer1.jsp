<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
    <%@ page import="com.amzi.Util.DbConnection" %> 
<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
<style>
.*{
background-color: #333;
text-colr: white;
}
</style>
</head>
<body>
<FORM>
<%
response.setContentType("text/html");
Connection conn = null;
String url = "jdbc:mysql://ls-ea01ee6ad63a8022e01a44ff0028be35c233ace8.clahbm7vh23u.ap-south-1.rds.amazonaws.com:3306/";
String dbName = "dbmasteragile";
String driver = "com.mysql.jdbc.Driver";
String userName = "agile2tcs";
String password = "agile_tcs";
PreparedStatement ps=null;

try {
	conn = DbConnection.getConnection();
    System.out.println("Connected!");
                            // sql query to insert values in the secified table.
              String queryString = "SELECT * FROM trandetails ORDER BY tnumber DESC LIMIT 2 ";
             
              	      /* createStatement() is used for create statement
              object that is used for 
		sending sql statements to the specified database. */
		ps = conn.prepareStatement(queryString);
            		 
            		 ResultSet rs = ps.executeQuery();
            		 
            		  System.out.println("rs");
            		
                %>
                <center><h3>Transaction History</h3></center>
	           <br>
	           <TABLE BORDER="1" align="center">
            <TR>
                <TH>Transaction Id</TH>
                <TH>Account Number</TH>
                <TH>Date of Transaction</TH>
                <TH>Operation of Transaction</TH>
                <TH>Transaction Type</TH>
                <TH>Transaction Amount</TH>
            </TR>
            
            <TR>
            <% while(rs.next()){ %>
            </TR>
            <TR>
            <TD> <%= rs.getInt(1) %></td>
                <TD> <%= rs.getInt(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
                <TD> <%= rs.getString(4) %></TD>
                <TD> <%= rs.getString(5) %></TD>
                <TD> <%= rs.getString(6) %></TD>
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
		   %>
		   <br>	 
  </FORM>
  <br><center><a href="welcome.jsp">BACK TO HOME</a></center>  
</body>
</html>