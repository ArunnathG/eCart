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
         <td> <c:out value = "${videos.getId()}"/>  </td> 
         <td> <c:out value = "${videos.getName()}"/> </td>
          <td><c:out value = "${videos.getPrice()}"/> </td>
          <td><a  href="adminhome?action=delete&id=<%=i-1%>">Delete</a></td>
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
	
	<a href="addvideo">Add video</a>
</body>
</html>