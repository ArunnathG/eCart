<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%> 

<%@page import="com.shopping.model.Videos"%>
<%@page import="com.shopping.model.CartItems"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<a href="userhome">Home</a>

 <a href="logout">Logout</a>

<hr>
<h2>Video Basket</h2>

<% 	Integer i = 0; %>
	<%
	if ((List<Videos>) session.getAttribute("cartItems") !=null) 
	{
		%>
		<table border="1">
			<tr>
				<th>quantity</th>
				<th>product</th>
				<th>price</th>
				<th>sub total</th>
				<th>Action</th>
			</tr>
	<c:forEach var ="cartItems"  items ="${cartItems}">
	<% 	i++; %>
	<tr>
	 <td> <c:out value = "${cartItems.getQuantity()}"/>  </td> 
         <td> <c:out value = "${cartItems.getVideo().getName()}"/> </td>
          <td><c:out value = "${cartItems.getVideo().getPrice()}"/> </td>
          <td><c:out value = "${cartItems.getVideo().getPrice() * cartItems.getQuantity() }"/></td>
          <td><a  href="checkout?action=delete&id=<%=i-1%>">Delete</a></td>
	 </tr>
	</c:forEach>
	</table>

		<%
	} else {
		%>
		<p>no</p>
	<%	
	}
	%>
<p>subTotal: <%= session.getAttribute("totalPrice")%></p>
<a href="userhome">Continue shopping</a>


</body>
</html>