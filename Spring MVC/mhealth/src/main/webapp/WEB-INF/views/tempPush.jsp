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
        src="resources/js/dashboard.js"></script>
        <%@include file="navigation.jsp" %>
            <% User user = (User) request.getAttribute("user"); %>
            <% String path = (String) request.getAttribute("path"); %>
            <% Exception  e = (Exception) request.getAttribute("exception"); %>
        <div style="text-align: center; margin: 10px">

        <br><br><h4>Hello <%= user.getFirstName()%>, Push notification has been sent !!</h4>
        <br><br><h4>Certificate path : <%= path%></h4>
        <br><br><h4>Exception : <%= e%></h4>
        
        </div>
        </body>
        </html>
