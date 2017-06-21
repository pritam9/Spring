<%@page import="java.util.HashMap"%>
<%@page import="java.util.Collections"%>
<%@page import="com.uncc.mhealth.model.SubQuestion"%>
<%@page import="java.util.Set"%>
<%@page import="com.uncc.mhealth.model.Question"%>
<%@page import="com.uncc.mhealth.model.Option"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link href="${contextPath}/resources/css/survey.css" rel="stylesheet"/>
<script type="text/javascript">
var token = '<c:out value="${user.token}"/>';
var survey = '<c:out value="${survey}"/>';
var contextPath = '<c:out value="${contextPath}"/>';
var data=${questionListJsonTemplate};
</script>
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script
		src="${contextPath}/resources/js/survey_page${pageNo}.js"></script>
	<script src="${contextPath}/resources/js/form_validation.js"></script>
	<c:if test="${pageNo==1}">
		<div class="Center">
			<c:if test="${user.getIstoApp()=='Y'}">
				<h1>SmarTrek Feedback Survey</h1>
			</c:if>
			<c:if test="${user.getIstoApp()=='N'}">
				<h1>BASICS Feedback Survey</h1>
			</c:if>
		</div>
	</c:if>
	<form role="form">
		<c:if test="${pageNo==1}">
			<br>
			<br>
			<h4>Welcome to the 
			<c:if test="${user.getIstoApp()=='Y'}">SmarTrek feedback surveys.</c:if>
			<c:if test="${user.getIstoApp()=='N'}">BASICS feedback surveys.</c:if> These surveys are
				being collected as part of 
				<c:if test="${user.getIstoApp()=='Y'}">SmarTrek research study.</c:if>
			    <c:if test="${user.getIstoApp()=='N'}">BASICS research study.</c:if>
			    </h4>
			<h4>The surveys consists of items which will ask you questions
				about your alcohol and marijuana use. They take about 30 minutes of
				your time to complete. If you do not wish to answer a particular
				question, then proceed to the next question. Your confidential
				responses will only be linked to your participant ID and will be
				viewed only by the research team. Feel free to call the
				Project Principal Investigator, Donna Kazemi at 704-687-7968 or
				email her at dkazemi@uncc.edu with any questions or concerns. Thank
				you.</h4>
			<h4>By entering the private password you were given to access
				this survey, you are indicating that you have read and understand
				what participation involves and that you voluntarily agree to
				complete the survey.</h4>
			<br>
		</c:if>
		<%
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questionList");
		for (Question question : questions) {
			Set<Option> optionSet = question.getOptions();
			Set<SubQuestion> subquestions = question.getSubquestions();
			ArrayList<Option> options = new ArrayList<Option>(optionSet);
			//Collections.sort(options, Option.Comparators.VALUE);
			switch (question.getType()) {
			case Question.TYPE_HEADING:
				%>
		<div class="form-group" id="parent<%= question.getId()%>">
			<label style="font-size: 22px; margin-top: 10px;"><%= question.getText()%></label>
		</div>
		<%if(question.getId()==29){%>
			<div class="form-group">
			<label style="font-size: 20px; margin-top: 10px;" for="29">Think
				of a typical one week period in your recent past, and complete the
				calendar below as accurately as possible.</label>
		</div>
		<div>
			<span style="font-size: 20px">12 ounce beer = 1 ounce shot = 4
				ounce glass of wine</span><br> <img src="${contextPath}/resources/images/beer.png"
				style="padding-left: 35px"> <img
				src="${contextPath}/resources/images/shot.png" style="padding-left: 105px"> <img
				src="${contextPath}/resources/images/wine.png" style="padding-left: 130px">
		</div>
		<%}%>
		<%
			break;
			case Question.TYPE_TEXT:
					%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label for="<%= question.getId()%>"><%= question.getText()%></label>
			<input type="text" class="form-control" id="<%= question.getId()%>">
		</div>
		
			<% 		break;
			case Question.TYPE_TEXT_AREA:
				%>
	 <div class="form-group RoundedCorner"
		id="parent<%= question.getId()%>">
		<label for="<%= question.getId()%>"><%= question.getText()%></label>
		<textarea rows="4" class="form-control" id="<%= question.getId()%>"></textarea>
	</div>
	
		<% 		break;
				case Question.TYPE_NUMBER:
		%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label for="<%= question.getId()%>"><%= question.getText()%></label>
			<input type="number" min="0" class="form-control"
				id="<%= question.getId()%>">
		</div>
		<%
				break;
			case Question.TYPE_CHECK:
					%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<% 				 
				for(Option option : options ){
					%>
			<label class="form-control"> <input type="checkbox"
				name="<%= question.getId() %>" id="opt<%= option.getId() %>"
				value="<%= option.getValue() %>" /> <%= option.getText() %>
			</label>
			<% 
				}
					%>
		</div>
		<%
				break;
			case Question.TYPE_RADIO:
					%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<% 				 
				for(Option option : options ){
					%>
			<label class="form-control"> <input type="radio"
				name="<%= question.getId() %>" id="opt<%= option.getId() %>"
				value="<%= option.getValue() %>" /> <%= option.getText() %>
			</label>
			<% 
				}
					%>
		</div>
		<%
				
				break;
			case Question.TYPE_SUB_TEXT:
					%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="SubQuestion">
				<% 				 
				for(SubQuestion subquestion : subquestions ){
					%>
				<tr>
					<td><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
					<td><input type="text" class="form-control"
						id="sub<%= subquestion.getId()%>"> <% 
				}
					%>
			</table>
		</div>
		<%

				
				
				break;
			case Question.TYPE_SUB_NUMBER:
					%>
		<div class="form-group RoundedCorner"
			id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="SubQuestion">
				<% 				 
				for(SubQuestion subquestion : subquestions ){
					%>
				<tr>
					<td><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
					<td><input type="number" min="0" class="form-control"
						id="sub<%= subquestion.getId()%>"> <% 
				}
					%>
			</table>
		</div>
		<%
				
				
				break;
			case Question.TYPE_SUB_CHECK:
					%>
		<div class="form-group" id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="TableBorder">
				<tr>
					<th class="TableBorder">
						<% for(Option option : options ){%>
					
					<th class="TableBorder"><label><%= option.getText() %></label>
						<% } %> <%for(SubQuestion subquestion : subquestions ){ %>
				<tr>
					<td class="TableBorder"><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
						<% for(Option option : options ){%>
					<td class="TableBorder Center"><input type="checkbox"
						name="sub<%= subquestion.getId() %>" id=opt
						"<%= option.getId() %>" value="<%= option.getValue() %>" /> <% } %>
						<% } %>
			</table>
		</div>
		<%
				break;
			case Question.TYPE_SUB_RADIO:
				%>
		<%if(question.getId()==86) {%>		
		<div class="form-group survey_heading">
        <label style="font-size: 22px;margin-top: 10px; width: 100%">AUDIT Survey</label>
        </div>
        <%} %>
		<div class="form-group" id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="TableBorder">
				<tr>
					<th class="TableBorder">
						<% for(Option option : options ){%>
					
					<th class="TableBorder"><label><%= option.getText() %></label>
						<% } %> <%for(SubQuestion subquestion : subquestions ){ %>
				<tr>
					<td class="TableBorder"><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
						<% for(Option option : options ){%>
					<td class="TableBorder Center"><input type="radio"
						name="sub<%= subquestion.getId() %>" id=opt
						"<%= option.getId() %>" value="<%= option.getValue() %>" /> <% } %>
						<% } %>
			</table>
		</div>
		<%
				break;
			case Question.TYPE_SUB_OPTION_TEXT:
				%>
		<div class="form-group" id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="TableBorder">
				<tr>
					<th class="TableBorder">
						<% for(Option option : options ){%>
					
					<th class="TableBorder"><label><%= option.getText() %></label>
						<% } %> <%for(SubQuestion subquestion : subquestions ){ %>
				<tr>
					<td class="TableBorder"><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
						<% for(Option option : options ){%>
					<td class="TableBorder Center"><input type="text"
						id="sub<%= subquestion.getId() %>opt<%= option.getId() %>" /> <% } %>
						<% } %>
			</table>
		</div>
		<%
				break;
			case Question.TYPE_SUB_OPTION_NUMBER:
				%>
		<div class="form-group" id="parent<%= question.getId()%>">
			<label><%= question.getText()%></label>
			<table class="TableBorder">
				<tr>
					<th class="TableBorder">
						<% for(Option option : options ){%>
					
					<th class="TableBorder"><label><%= option.getText() %></label>
						<% } %> <%for(SubQuestion subquestion : subquestions ){ %>
				<tr>
					<td class="TableBorder"><label for="<%= subquestion.getId()%>"><%= subquestion.getText()%></label>
						<% for(Option option : options ){%>
					<td class="TableBorder Center"><input type="number"
						id="sub<%= subquestion.getId() %>opt<%= option.getId() %>" /> <% } %>
						<% } %>
			</table>
		</div>
		<%
				break;
			}

		}
	%>
	<input type="hidden" name="token" value="<c:out value="${user.token}"/>"/>
	<input type="hidden" name="survey" value="<c:out value="${survey}"/>"/>
	</form>
	<div style="text-align: center; margin: 10px">
		<h4 class="error-msg hide"></h4>
		<button onclick="return submitSurvey();" class="btn btn-primary">
			<c:if test="${pageNo==8}">
			Submit
		</c:if>
		<c:if test="${pageNo != 8}">
			Next
		</c:if>
		</button>
	</div>
</body>
</html>