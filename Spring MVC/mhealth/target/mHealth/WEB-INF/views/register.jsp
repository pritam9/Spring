<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit User</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">

</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="resources/js/register.js"></script>
		<%@include file="navigation.jsp" %>
	<div class="container">
	<!-- <h1>Register</h1> -->
	<!-- <table> -->
	<form modelAttribute="user"
		class="form-signin">
		
		<h2 class="form-signin-heading">Please register</h2>
		<div class="form-group">
		<input id="inputUsername" class="form-control"
			placeholder="Username" />
		</div>
		<div class="form-group">	
		<input type="password" id="inputPassword" class="form-control"
			placeholder="Password" />
		</div>
		<div class="form-group">
		<input type="password" id="inputConfirmPassword" class="form-control" placeholder="Confirm Password" />
		</div>
		<div class="form-group">
		<input class="form-control" id="inputEmail"
			placeholder="Email" />
		</div>
		<div class="form-group">
		<input id="inputFirstName" class="form-control"
			placeholder="First name" />
		</div>
		<div class="form-group">
		<input id="inputLastName" class="form-control"
			placeholder="Last Name" />
		</div>
		<div class="form-group">
		<input id="inputNickName" class="form-control"
			placeholder="Nickname: This will be your publicly displayed name" />
		</div>
		<div class="form-group">
		<input type="date" id="inputDOB" class="form-control"
			placeholder="Date of Birth (mm/dd/yyyy)" />
		</div>
		<div class="form-group">
		<button class="btn btn-lg btn-primary btn-block" onclick="return registerUser();">Register</button>
		</div>
		<div class="form-group">
		<h4 class="error-msg hide">Please enter all the fields</h4>
		</div>
	</form>
	<!-- </table> -->
	</div>

</body>
</html>