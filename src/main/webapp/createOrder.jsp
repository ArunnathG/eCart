<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    .formBackground {
	    width: 70%;
	    border: 0.5rem solid #888888;
	    padding: 30px;
	    margin: 0 auto;
	   -webkit-box-shadow: 3px 3px 5px 6px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
  -moz-box-shadow:    3px 3px 5px 6px #ccc;  /* Firefox 3.5 - 3.6 */
  box-shadow:         3px 3px 5px 6px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
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
    .error {
    	color: red;
    }
     .success {
    	color: green;
    }
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<hr>
<a href="userhome">Home</a>

<span>Basket: ${totalCount} video(s)
</span>
<a href="myaccount">My Account</a> <br/>

<a href="checkout">Checkout</a> <br/>
 
 <a href="logout">Logout</a>

<hr>

<h3>Create Order</h3>
<p>Please enter your delivery address</p>
<hr>
<p class="success" id="success">${orderSuccess}</p>
<p class="error" id="error">${orderError}</p>
<form action="ordercreation" class="formBackground" method="post">


	<div class="field">
		<label for="name" class="label">Name</label>
 		<input type="text" class="input" name="name" id="name" maxlength="30" required/>
	</div>
	
	<div class="field">
		<label for="address" class="label">Address</label>
 		<input type="text" class="input" name="address" id="address" maxlength="30" required/>
	</div>

	<div class="field">
		<label for="city" class="label">City</label>
		<input type="text" class="input" name="city" id="city" maxlength="30" required/>
	</div>
	
	<div class="field">
			<label for="country" class="label">Country</label>
			<input type="text" class="input" name="country" id="country" maxlength="30" required/>
		</div>
		
		<div class="field">
			<label for="pinCode" class="label">pinCode</label>
			<input type="text" class="input" name="pinCode" id="pinCode" maxlength="30" required/>
		</div>
	
	<div class="field">
		<button type="submit" id="completeOrder" class="button"> Complete Order</button>
	</div>


</form>
</body>
</html>