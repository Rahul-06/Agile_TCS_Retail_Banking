<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<style>
.center{
  height: 250px;
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
  width: 50%; 
  height: 50%;
  min-width: 200px;
  max-width: 400px;
  padding: 40px;
}
/*https://stackoverflow.com/questions/33626753/trying-to-change-the-old-password-in-mysql-using-jsp-servlet-and-dao*/
</style>

<body align="center">
<div class="center">

<form  action="LoginServlet" method="post">
		<fieldset style="width: 300px">
			<legend> Login to App </legend>
			<table>
				<tr>
					<td>User ID</td>
					<td><input type="text" name="username" required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userpass" required="required" /></td>
				</tr>
				<tr>
					<td><input type="submit"  value="Login" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</div>

<div align="center">
To Sign_IN as Admin<br>
User ID : Admin<br>
Password : 1234
</div>
<br><br>
<div>
To Sign_IN as Employee<br>
User ID : Employee<br>
Password : 1234
</div>
</body>
</html>
