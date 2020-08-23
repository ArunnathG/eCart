<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<hr>
<a href="./ProfileServlet">Home</a>

<span>Basket: <%= request.getParameter("totalCount")%> video(s) <%= request.getParameter("totalPrice")%>
</span>
<a href="./MyAccountServlet">My Account</a> <br/>

<a href="cartServlet">Checkout</a> <br/>
 
 <a href="./LogoutServlet">Logout</a>

<hr>

</body>
</html>