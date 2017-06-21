<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Trivia Question</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">
<script>var token = '<c:out value="${user.token}"/>';</script>

</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/add_trivia.js"></script>
		
<%@include file="navigation.jsp"%>
	<div class="container">
		<!-- <table> -->
			<form
				class="form-signin" data-toggle="validator" role="form">
			
				<h2 class="form-signin-heading">Add new Trivia Question</h2>
				
				<input id="inputText"
					class="form-control" placeholder="Text" required/>
				<br>
				<div class="form-group">
				  <label for="categorySelect">Select Trivia Category:</label>
				  <select class="form-control" id="categorySelect">
				    <option value="1">Category 1</option>
				    <option value="2">Category 2</option>
				    <option value="3">Category 3</option>
				  </select>
				</div>
				<div class="form-group" id="optionsContainer">
					<input class='form-control trivia-option-text' placeholder='Option Text' required/>
					<input class='form-control trivia-option-value' placeholder='Option Value' required/>
					<br>
				</div>
				<button class="options-field" onclick=" return moreOptions();">Add more options</button><br>
				<br>
				<input id="inputAnswer"
					class="form-control" placeholder="Correct Answer option value" required/>
				<br>
				<input id="inputExplanation"
					class="form-control" placeholder="Correct Answer Explanation" required/>
				<br>	
				<button class="btn btn-lg btn-primary btn-block" onclick="return submitTrivia();">Add Trivia</button>
				<h4 class="error-msg hide">Please enter all the fields</h4>
			</form>
		<!-- </table> -->
	</div>

</body>
</html>