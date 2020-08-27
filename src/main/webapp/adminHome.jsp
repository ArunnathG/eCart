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

	  <style type="text/css">
	    	#adminHome {
				  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
				  border-collapse: collapse;
				  width: 70%;
				    margin: 0 auto;
	    margin-bottom: 50px;
				}

			#adminHome td, #adminHome th {
			  border: 1px solid #ddd;
			  padding: 8px;
			}
			
			#adminHome tr:nth-child(even){background-color: #f2f2f2;}
			
			#adminHome tr:hover {background-color: #ddd;}
			
			#adminHome th {
			  padding-top: 12px;
			  padding-bottom: 12px;
			  text-align: left;
			  background-color: #4CAF50;
			  color: white;
			}
		    .deleteButton {
		   		background: green;
		   		color: white;
		   		cursor: pointer;
		   		padding: 10px;
		   		width: 100%;
		   		border-radius: 7px;
		    }
		    
		    .addVideoLink {
		    	padding: 10px;
		    	font-size: 26px;
		    	color: black;
		    	cursor: pointer;
		    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script language="javascript" type="text/javascript">

function deleteVideo(pageURL) {

	 window.location = pageURL;
}

</script>

<% 
	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate" );
	if(session.getAttribute("adminid") == null) {
		response.sendRedirect("login");
	}
%>


<%@include file="adminHeader.jsp" %>

<h2>Manage videos</h2>
<% 	Integer i = 0; %>
<% 	List<Videos> Videos = (List<Videos>) session.getAttribute("videos"); %>
	<%
	if (Videos !=null && !Videos.isEmpty()) 
	{
		%>
		<table border="1" id="adminHome">
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
          <td><button class="deleteButton" id="delete_<%=i %>>" onClick="deleteVideo('adminhome?action=delete&id=<%=i-1%>')">Delete</button></td>
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
	
	<a class="addVideoLink" href="addvideo">Add video</a>
</body>
</html>