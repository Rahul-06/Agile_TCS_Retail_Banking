<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AccountSuccess</title>

</head>
<body>
<%
int id = (Integer)request.getAttribute("acnumber");
%>
</body>
<script type="text/javascript">
confirm("Account creation with Account_Number <%=id%> was done successfully."); 
window.location.href = "Accregister.jsp";
</script>
</html>