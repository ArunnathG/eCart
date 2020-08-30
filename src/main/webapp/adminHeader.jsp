<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
  <link href="<c:url value="/resources/css/menuBar.css" />"  type="text/css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate" );
	if(session.getAttribute("adminid") == null) {
		response.sendRedirect("login");
	}
%>


<ul>
  <li><a id="home" href="adminhome">Home</a></li>
  <li><a id="logOut" href="logout">Logout</a></li>
</ul>

</body>
</html>