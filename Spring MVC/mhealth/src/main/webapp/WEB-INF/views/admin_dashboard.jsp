    <%@page import="com.uncc.mhealth.model.User" %>
        <%@page import="java.util.Collections" %>
        <%@page import="com.uncc.mhealth.model.SubQuestion" %>
        <%@page import="java.util.Set" %>
        <%@page import="com.uncc.mhealth.model.Question" %>
        <%@page import="com.uncc.mhealth.model.Option" %>
        <%@page import="java.util.ArrayList" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8"
                 pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<% 
			
		
		
		 %>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dashboard</title>
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
        <script
        src="resources/js/adminDashboard.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
        <%@include file="navigation.jsp" %>
            <% User user = (User) request.getAttribute("user"); %>
        
        <div style="text-align: left; margin: 10px">
        <h2 style="margin-bottom:30px;padding-top:60px">Hello <%= user.getFirstName()%>, Welcome to the mHealth application</h2>
        <div class="row">
		<div class="col-sm-6">
		<div class="panel panel-default">
        <div class="panel-heading"><h4>System status</h4></div>
        <div class="panel-body">
        <div id="avgResponseTime">
        
        </div>
        <div id="userCount">
        
        </div>
        <div id="msgCount">
        
        </div>
        </div>
        </div>
        <div class="panel panel-default"><div class="panel-heading"><H4>Total consumption of drinks per week<H4></div><div class="panel-body">
		<canvas id="baclogweeklychart" width="400" height="400"></canvas>
            </div></div>
        </div>
            
            <div class="col-sm-6">
            <div class="panel panel-default">
            <div class="panel-heading">
            
            	<H4>Users List</H4><BR></div>
            	<div class="panel-body">
		        <div><a href="User/new">New User</a></div>
		        <table id="UserListTable" border="1">
				
				</table>	
				</div>
        </div>
        </div>
        </div>
        </div>
        </body>
        </html>
