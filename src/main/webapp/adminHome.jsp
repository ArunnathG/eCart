<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>
     
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%> 

<%@page import="com.shopping.model.Videos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<a href="adminhome">Home</a>

 <a href="logout">Logout</a>

<hr>
<h2>Manage videos</h2>
<% 	Integer i = 0; %>
	<%
	if ((List<Videos>) session.getAttribute("videos") !=null) 
	{
		%>
		<table border="1">
			<tr>
				<th>ProductId</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
	<c:forEach var ="videos"  items ="${videos}">
	<% 	i++; %>
	<tr>
	
         <td> <label id="prod_<%=i %>"><c:out value = "${videos.getId()}"/>  </label></td> 
         <td><label id="name_<%=i %>"> <c:out value = "${videos.getName()}"/></label> </td>
          <td><label id="price_<%=i %>"><c:out value = "${videos.getPrice()}"/> </label></td>
          <td><a id="delete_<%=i %>>" href="adminhome?action=delete&id=<%=i-1%>">Delete</a></td>
	 </tr>
	</c:forEach>
	</table>

		<%
	} else {
		%>
		<div id="message">No data to display</div>
	<%	
	}
	%>
	
	<a href="addvideo">Add video</a>
</body>
</html>