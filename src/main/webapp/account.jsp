<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%> 

<%@page import="com.shopping.model.Orders"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
    .sectionBackground {
	    width: 20%;
	    background: aliceblue;
	    padding: 50px;
	    margin: 17px;
	    margin-right: 20px;
	    float: left;
	    margin-bottom: 50px;
	   -webkit-box-shadow: 3px 3px 5px 6px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
  -moz-box-shadow:    3px 3px 5px 6px #ccc;  /* Firefox 3.5 - 3.6 */
  box-shadow:         3px 3px 5px 6px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
    }
    
    .userName {
    	display: block;
    	font-size: 35px;
    	text-align: center;
    	padding: 4px;
    	
    }
    .email {
    	display: block;
    	font-size: 15px;
    	text-align: center;
    	padding: 4px;
    	
    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="userHeader.jsp" %>
<% 	Integer i = 0; %>
<% 	List<Orders> Orders = (List<Orders>) session.getAttribute("orders"); %>



		<h2>My Account</h2>
		<hr>
		
	<section class="sectionBackground">
		<label class="userName" id="userName">${userid}</label>
		<label class="email" id="email">${registeremail}</label>
	</section>


	<h2>Your orders</h2>
<%
	if (Orders !=null && !Orders.isEmpty()) 
	{
		%>
	<table border="1">
		<tr>
			<th>invoice id</th>
			<th>items purchased</th>
			<th>invoiced amount</th>
		</tr>
			
	<c:forEach var ="order"  items = "${orders}">
	<% 	i++; %>
	<tr>
       
       <td id="inv_<%=i %>">  <c:out value = "${order.getOrderId()}"/><%=i%></td> 
        <td id="items_<%=i %>"> <c:out value = "${order.getTotalItems()}"/> </td> 
          <td id="amount_<%=i %>">  <c:out value = "${order.getTotalCost()}"/> </td>
     
	</tr>
	</c:forEach>
	
	</table>

		<%
	} else {
		%>
		<div id="message">No orders to display</div>
		
	<%	
	}
	%>

</body>
</html>