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

<style type="text/css">
    .createOrder {
	   float: right;
	   background: blue;
	   color: white;
    }
    .continueShopping {
	   float: left;
	   background: blue;
	   color: white;
    }
    .removeCart {
    	  background: green;
	   color: white;
    }
    .tableBackground {
	    width: 70%;
	    background: aliceblue;
	    padding: 50px;
	    margin: 0 auto;
	    margin-bottom: 50px;
	   -webkit-box-shadow: 3px 3px 5px 6px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
  -moz-box-shadow:    3px 3px 5px 6px #ccc;  /* Firefox 3.5 - 3.6 */
  box-shadow:         3px 3px 5px 6px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<script language="javascript" type="text/javascript">

function createOrder(pageURL) {
	 window.location = pageURL;
}

function continueShopping(pageURL)
{
	 window.location = pageURL;
	}
	
function removeFromCart(pageURL)
{
	 window.location = pageURL;
	}
</script>

<%@include file="userHeader.jsp" %>



<div class="tableBackground">
<h2>Video Basket</h2>

<% 	Integer i = 0; %>
<% 	List<CartItems> cart = (List<CartItems>) session.getAttribute("cartItems"); %>
	<%
	if (cart !=null && !cart.isEmpty() ) 
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
	          <td><button id="remove" class="removeCart" onClick="removeFromCart('checkout?action=delete&id=<%=i-1%>')">Remove</button></td>
		 </tr>
		</c:forEach>
		</table>
	
		<p>subTotal: <%= session.getAttribute("totalPrice")%></p>
		<button type="button" class="createOrder" id="createOrder" onclick="createOrder('ordercreation');" >Create Order</button>
		
		<%
	} else {
		%>
		<div id="message">Cart is empty</div>
		
		
	<%	
	}
	%>

<button type="button" class="continueShopping" id="continue" onclick="continueShopping('userhome');" >Continue Shopping</button>
</div>
</body>
</html>