    <%@page import="com.uncc.mhealth.model.User" %>
        <%@page import="java.util.Collections" %>
        <%@page import="java.util.Set" %>
        <%@page import="java.util.ArrayList" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8"
                 pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Details</title>
        <link
        href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
        rel="stylesheet">
        <!-- Custom CSS -->
        <link href="resources/css/survey.css" rel="stylesheet">
        <script>var token = '<c:out value="${user.token}"/>';</script>

        </head>
        <body>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <script src="resources/js/updateDetails.js"></script>
        <%@include file="navigation.jsp" %>
            <% User user = (User) request.getAttribute("user"); %>
        <div class="container-fluid" style="padding-top:50px;">
	<!-- <h1>Register</h1> -->
	<!-- <table> -->
	<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
	<form modelAttribute="user"
		class="form-signin">
		
		<h2 class="form-signin-heading">Update Details</h2>
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
		<button class="btn btn-lg btn-primary btn-block" onclick="return saveUpdatedDetails();">Update</button>
		</div>
		<h4 class="error-msg hide">Please enter all the fields</h4>
	</form>
	</div>
	<div class="col-sm-offset-4 col-sm-6">
		<%if(request.getAttribute("msg")!=null){ %>
		<h4 class="error-msg"><%=request.getAttribute("msg")%></h4>
		<%} %>
	</div>
	</div>
	<!-- </table> -->
	</div>
        </body>
        </html>
