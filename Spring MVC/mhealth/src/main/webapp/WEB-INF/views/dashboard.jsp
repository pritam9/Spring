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
        <style type="text/css">
			.modal {
				display: none;
				position: fixed;
				z-index: 1000;
				top: 0;
				left: 0;
				height: 100%;
				width: 100%;
				background: rgba(255, 255, 255, .8) url('http://i.stack.imgur.com/FhHRx.gif') 50% 50% no-repeat;
			}

			body.loading {
				overflow: hidden;
			}

			body.loading .modal {
				display: block;
			}
		</style>
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
        <div style="text-align: center; margin: 10px">

        <br><br><h2 style="padding: 30px">Hello <%= user.getFirstName()%>, Welcome to the mHealth application</h2>
        <div style="margin: 10px">
        <%if(request.getAttribute("isFeedBackGenerated")==null || !request.getAttribute("isFeedBackGenerated").equals("Y")){ %>
        <a href="survey_baseline/1"><span class="btn btn-primary survey_link">Baseline Survey</span></a><br><br>
        <%} %>
        <a href="survey_sixweek/1"><span class="btn btn-primary survey_link">Six Week Survey</span></a><br><br>
        <%if(request.getAttribute("isFeedBackGenerated")!=null && request.getAttribute("isFeedBackGenerated").equals("Y")){ %>
        <a href="feedback"><span class="btn btn-primary survey_link">Feedback</span></a><br><br>
        <%if(user.getIstoApp().equals("N")) {%>
         <a href="mentorFeedback"><span class="btn btn-primary survey_link">Mentor Feedback</span></a><br><br>
        <%} %>
        <%} %>
        <!-- <a href="survey_b_yaacq"><span class="btn btn-primary survey_link">B-YAACQ Survey</span></a><br><br>
        <a href="survey_cea"><span class="btn btn-primary survey_link">CEA Survey</span></a><br><br>
        <a href="survey_ddq"><span class="btn btn-primary survey_link">Daily Drinking Questionnaire Survey</span></a><br><br>
        <a href="survey_pss"><span class="btn btn-primary survey_link">PSS Survey</span></a><br><br>
        <a href="survey_rcq"><span class="btn btn-primary survey_link">RCQ Survey</span></a><br><br> -->
            <% if(user.getAdmin() > 0) { %>
            <!-- <button onclick="return getUserSurvey();" class="btn btn-primary">Export Survey</button> -->
            <button onclick="return downloadUserSurveys();" class="btn btn-primary">Export Survey</button>
            <!-- <a href="get_survey_csv"><span class="btn btn-primary survey_link">Download Survey CSV</span></a><br><br> -->
        <!-- <a href="add_mi"><span class="btn btn-primary survey_link">Add new MI</span></a><br><br>
        <a href="add_trivia"><span class="btn btn-primary survey_link">Add new Trivia question</span></a><br><br> -->
            <% } %>
        <h4 class="error-msg hide"></h4>
        </div>
        </div>
        <div class="modal"><!-- Place at bottom of page --></div>
        </body>
        </html>
