<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
 <link href="<c:url value="/resources/css/menuBar.css" />"  type="text/css" rel="stylesheet" />
<meta charset="ISO-8859-1">
	
</head>
<body>

<% response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate" );
if(session.getAttribute("userid") == null) {
	response.sendRedirect("login");
} %>

<script language="javascript" type="text/javascript">

function checkOut(pageURL) {

	 window.location = pageURL;
}

</script>
<ul>
	<li> <a id="home" href="userhome">Home</a></li>
	<li> 
		<label id="summary">Basket: ${totalCount} video(s) ${totalPrice} </label>
	</li>
	<li><a href="myaccount">My Account</a> </li>

	<li><button id="checkOut" onclick="checkOut('checkout')" >Checkout</button> </li>
 
 	<li><a id="logOut" href="logout">Logout</a></li>
</ul>


</html>