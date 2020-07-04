<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>

</head>
<body>
<%
int id = (Integer)request.getAttribute("custid");
%>
</body>
<script type="text/javascript">
confirm("Customer creation with Customer_ID <%=id%> was done successfully."); 
window.location.href = "Register.jsp";
</script>
</html>