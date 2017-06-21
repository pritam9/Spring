<%@page import="com.uncc.mhealth.model.MI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit User</title>
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
	<script src="resources/js/add_mi.js"></script>
		
<%@include file="navigation.jsp"%>
	<div class="container">
		<% ArrayList<MI> miList = (ArrayList<MI>)request.getAttribute("miList"); %>
		<!-- <table> -->
			<form
				class="form-signin" data-toggle="validator" role="form">
			
				<h2 class="form-signin-heading">Add new MI</h2>
				
				<input id="inputTitle"
					class="form-control" placeholder="Title" required/>
				<br>
				<div class="form-group">
				  <label for="typeSelect">Select MI Type:</label>
				  <select class="form-control" id="typeSelect">
				    <option value="0">Only Text</option>
				    <option value="1">Only Image</option>
				    <option value="2">Text with Image</option>
				    <option value="3">Question with Text</option>
				    <option value="4">Question with Image</option>
				    <option value="5">Question with Text and Image</option>
				  </select>
				</div>
				
				<input id="inputText"
					class="form-control" placeholder="MI text" required/>
				<br>	
				<div class="form-group">
				  <label for="optionTypeSelect">Select Option type:</label>
				  <select class="form-control" id="optionTypeSelect">
				    <option value="0">No Options</option>
				    <option value="1">Feedback Options</option>
				    <option value="2">Options for Web URL</option>
				    <option value="3">Options for App URL</option>
				  </select>
				</div>	
				
				<div class="form-group options-field" id="optionsContainer">
					<input class='form-control mi-option-text' placeholder='Option Text' required/>
					<input class='form-control mi-option-value' placeholder='Option Value' required/>
					<br>
				</div>
				<div class="form-group feedback-options-field" id="feedbackOptionsContainer">
					<input class='form-control' placeholder='Option Text' required/>
					<select class="form-control" id="optionValueSelect">
					<% for(MI mi : miList){ %>
							<option value="<%= mi.getId()%>"><%= mi.getText()%></option>
					<% } %>
					</select>
					<br>
				</div>
				<button class="options-field" onclick=" return moreOptions();">Add more options</button><br>
				<br>
				<input id="inputDateTime"
					class="form-control" placeholder="Number of days to push this MI" required/>
				<br>	
				<button class="btn btn-lg btn-primary btn-block" onclick="return submitMI();">Add MI</button>
				<h4 class="error-msg hide">Please enter all the fields</h4>
			</form>
		<!-- </table> -->
	</div>

</body>
</html>