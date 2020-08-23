<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

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


<% 	List<Videos> videos  = (ArrayList<Videos>)request.getAttribute("videos"); %>
<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
		</tr>
		
		<%
// Iterating through subjectList

if(videos != null)  // Null check for the object
{
	Iterator<Videos> iterator = videos.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		Videos videoDetails = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr><td><%=videoDetails.getId()%></td>
		<td><%=videoDetails.getName()%></td>
		<td><%=videoDetails.getPrice()%></td>
		<td> 
		<a href="cartServlet?action=add&id=<%=videoDetails.getId()%>">add</a>
		 
		</td>
	</tr>
	<%
	}
}
%>


</body>
</html>