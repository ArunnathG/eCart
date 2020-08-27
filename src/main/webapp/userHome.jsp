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
    .sectionBackground {
	    width: 70%;
	    background: aliceblue;
	    padding: 50px;
	    margin: 0 auto;
	    margin-bottom: 50px;
	   -webkit-box-shadow: 3px 3px 5px 6px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
  -moz-box-shadow:    3px 3px 5px 6px #ccc;  /* Firefox 3.5 - 3.6 */
  box-shadow:         3px 3px 5px 6px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
    }
    .price {
    float: right;
    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script language="javascript" type="text/javascript">

function addToCart(pageURL) {

	 window.location = pageURL;
}

</script>
<hr>
<a href="userhome">Home</a>

<span>Basket: ${totalCount} video(s)
</span>
<a href="myaccount">My Account</a> <br/>

<a href="checkout">Checkout</a> <br/>
 
 <a href="logout">Logout</a>

<hr>
<% 	Integer i = 0; 
	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate" );
	if(session.getAttribute("userid") == null) {
		response.sendRedirect("login");
	}
%>
<% 	List<Videos> Videos = (List<Videos>) session.getAttribute("videos"); %>
<%
	if (Videos !=null && !Videos.isEmpty()) 
	{
		%>
	<div>
			
	<c:forEach var ="videos"  items = "${videos}">
	<% 	i++; %>
	<section class="sectionBackground">
       
       <label class="price" id="name_<%=i %>">  <c:out value = "${videos.getPrice()}"/> </label> 
        <label id="name_<%=i %>"> <c:out value = "${videos.getName()}"/> </label> <p>
          <label id="desc_<%=i %>">  <c:out value = "${videos.getDescription()}"/> </label>
         <input type="button" onclick="addToCart('userhome?action=add&id=${videos.getId()}&pos=<%= i %>');" value="Add to cart" />
     
	</section>
	</c:forEach>
	
	</div>

		<%
	} else {
		%>
		<div>No videos to display</div>
		
	<%	
	}
	%>
</body>
</html>