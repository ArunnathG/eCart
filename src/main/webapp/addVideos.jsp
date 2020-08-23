<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>Add New Video</h2>
<hr>



<form action="addvideo" class="formBackground" method="post">

	<div class="field">
		<label for="name" class="label"> Name</label>
 		<input type="text" class="input" name="name" id="name"/>
	</div>

	<div class="field">
			<label for="description" class="label">Description</label>
	 		<input type="text" class="input" name="description" id="description"/>
		</div>
		
	<div class="field">
	<label for="price" class="label">Price</label>
		<input type="text" class="input" name="price" id="price"/>
</div>
	
	<div class="field">
		<button type="submit" id="save" class="button"> Save</button>
	</div>
 

</form>
</body>
</html>