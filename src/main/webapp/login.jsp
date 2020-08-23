<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login | cart</title>

    <style type="text/css">
    .formBackground {
	    width: 70%;
	    border: 0.5rem solid #888888;
	    padding: 30px;
	    margin: 0 auto;
	      box-shadow: 5px 10px lightgrey;
    }
    .field {
    	display: flex;
    	width: 70%;
    	margin:30px;
    }
    .input {
    	flex-basis: 35%;
    	height: 35px;
    	border-radius: 4px;
    	border: 1px solid black;
    }
    .label {
    	font-weight: 700;
    	flex-basis: 20%;
    }
    .controls {
    	width: 100%;
    }
    .button {
    	flex-basis: 25%;
    	padding: 10px;
    	border-radius: 3px;
    	color: white;
    	background: black;
    }
    .link {
    		flex-basis: 25%;
    		padding: 18px;
    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Login</h2>
<p>Login with username & password</p>
<hr>



<form action="./LoginServlet" class="formBackground">

	<div class="field">
		<label for="userName" class="label"> user Name</label>
 		<input type="text" class="input" name="userName" id="userName"/>
	</div>

	<div class="field">
		<label for="password" class="label">Password</label>
		<input type="password" class="input" name="password" id="password"/>
	</div>
	
	<div class="field">
		<button type="submit" id="login" class="button"> Login</button>
		<a href="./Registration.jsp" id="register" class="link">Register</a>
	</div>
 

</form>

</body>
</html>