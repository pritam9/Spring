 <%@page import="com.uncc.mhealth.model.User" %>
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
<link href="resources/css/survey.css" rel="stylesheet">
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
    .modal-content iframe{
        margin: 0 auto;
        display: block;
    }
</style>
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<%@include file="navigation.jsp" %>
	<div class="container" style="text-align: center;">
		<h2 style="padding-top: 50px">Thank you for submitting the survey.</h2>
		<br> 
		<a href="feedback"><span class="btn btn-primary survey_link">Feedback</span></a><br><br><br><br>
		<%if(request.getSession().getAttribute("user")!=null){ 
		User user = (User) request.getSession().getAttribute("user"); 
		if(user.getIstoApp().equals("Y")){
		%>
        <div class="row"> 
        <div class="col-sm-6 col-sm-offset-3">
        	<iframe id="SmarTrekVideo" width="560" height="315" src="//www.youtube.com/embed/Bn-ZwCoySaA" frameborder="0" allowfullscreen></iframe>
        </div>
	</div>
	<%}
	}%>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    /* Get iframe src attribute value i.e. YouTube video url
    and store it in a variable */
    var url = $("#SmarTrekVideo").attr('src');
    
    /* Assign empty url value to the iframe src attribute when
    modal hide, which stop the video playing */
    $("#myModal").on('hide.bs.modal', function(){
        $("#SmarTrekVideo").attr('src', '');
    });
    
    /* Assign the initially stored url back to the iframe src
    attribute when modal is displayed again */
    $("#myModal").on('show.bs.modal', function(){
        $("#SmarTrekVideo").attr('src', url);
    });
});
</script>
</html>