<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: red;
  color: white;
  text-align: center;
}
*{
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 200px; /* Should be removed. Only for demonstration */
  font-size: 14px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
.navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial;
}

/* Links inside the navbar */
.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* The dropdown container */
.dropdown {
  float: left;
  overflow: hidden;
}

/* Dropdown button */
.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: #333;
  font-family: inherit; /* Important for vertical align on mobile phones */
  margin: 0; /* Important for vertical align on mobile phones */
}

/* Add a red background color to navbar links on hover */
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

/* Dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a grey background color to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}
.bank
{
 background-color:black;
 color:red;
 font-family: Arial;
 font-size: 30px;
 }
</style>
</head>
<body>
<div class="bank">
<b>BANK</b>
</div>
<div class="navbar">
  <a href="home.html">Home</a>
  <div class="dropdown">
    <button class="dropbtn">Customer Management
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Register.jsp">Create Customer</a>
      <a href="UpdateId.jsp">Update Customer</a>
      <a href="view.jsp">Search Customer</a>
      <a href="DeleteId.jsp">Delete Customer</a>
    </div>
  </div>
   <div class="dropdown">
    <button class="dropbtn">Account Management
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Accregister.jsp">Create Account</a>
      <a href="SearchAccount.jsp">Search Account</a>
      <a href="DeleteAccNum.jsp">Delete Account</a>
    </div>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Status Details
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" >
      <a href="CustomerStatus.jsp">Customer Status</a>
      <a href="Accountstatus.jsp">Account Status</a>
    </div>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Account Operation
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Withdrawn.jsp">Withdraw Money</a>
      <a href="Deposit.jsp">Deposit Money</a>
      <a href="Transfer.jsp">Transfer Money</a>
    </div>
  </div>
  <a href="AccountStmt.jsp">Account Statements</a>
  <a href="logout.jsp">Logout</a>
</div>
<script>
function fun()
{
	var a = document.getElementById("1");
	var min=1; 
    var max=10000;  
    var random = Math.floor(Math.random() * (+max - +min)) + min; 
    a.value = random;
	}
</script>
<form action="AccountServelet" method="post" align="center">
<table align="center">
<tr>
<h3 align="center">Create Account</h3>
</tr>
   <tr style="visibility:hidden;">
       <td><input type="text" name="acnumber" id="1" required></td>
   </tr>
   <tr>
       <td>Customer Id <span style="color:red;">*</span></td>
       <td><input type="text" name="ws_cust_id" pattern="\d{1,9}" required></td>
   </tr>   
   <tr>
       <td>Account Type <span style="color:red;">*</span></td>
       <td><select id="ac_type" name="acc_type" required>
       		<option value="" disabled selected>Please select your account type</option>
          	<option value="Savings">Savings</option>
  			<option value="Current">Current</option>
	   </select></td>
   </tr>
   <tr>
       <td>Deposit Money <span style="color:red;">*</span></td>
       <td><input type="text" name="deposit" pattern="[0-9]{1,}" required></td>
   </tr>
  
</table>
<input type="submit" name="action" onclick="fun()" value="Add Account">
<input type="reset" name="reset">
</form>
<div class="footer">
  <div class="row">
  <div class="column" style="background-color:#aaa;">
    <h2>About us</h2>
    <p>The Reserve Bank of India was established on April 1, 1935 in accordance with the provisions of the Reserve Bank of India Act, 1934.
The Central Office of the Reserve Bank was initially established in Kolkata but was permanently moved to Mumbai in 1937. The Central Office is where the Governor sits and where policies are formulated.
Though originally privately owned, since nationalisation in 1949, the Reserve Bank is fully owned by the Government of India.</p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Services</h2>
    <p>Retail and consumer Banking</p>
    <p>Personal Internet Banking</p>
   <p> Corporate Internet Banking</p>
    <p>Debit and Credit Cards</p>
  </div>
  <div class="column" style="background-color:#ccc;">
    <h2>Contact Us</h2>
    <p>Email:customer.service@abc.com</p>
    <p>Contact No:022-42406778,022-7889032</p>
    <p>Address: 12,Corporate Office,abc street,def road,efg,Mumbai</p>
  </div>
</div>
</div>
</body>
</html>