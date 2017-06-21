    <%@page import="java.util.HashMap"%>
<%@page import="java.util.Collections" %>
        <%@page import="com.uncc.mhealth.model.SubQuestion" %>
        <%@page import="java.util.Set" %>
        <%@page import="com.uncc.mhealth.model.Question" %>
        <%@page import="com.uncc.mhealth.model.Option" %>
        <%@page import="java.util.ArrayList" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link
        href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
        rel="stylesheet">
        <!-- Custom CSS -->
        <link href="resources/css/survey.css" rel="stylesheet">
        <script>var token = '<c:out value="${user.token}"/>';</script>
        <script>var survey = '<c:out value="${survey}"/>';</script>

        </head>
        <body>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <script
        src="resources/js/survey_page8.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <!-- <div class="Center"><h1>mHealth Feedback Survey</h1></div> -->
        <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>
		
		<% 
		boolean canShow = false;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = questions.indexOf(new Question(18));
		
		for(SubQuestion sq : questions.get(index).getSubquestions()) {
			map.put(sq.getId(), sq.getAnswer());
			if(sq.getAnswer() != null && sq.getAnswer().equals("2")){
				canShow = true;
			}
		}
		%>
        <form role="form">


        <div class="form-group survey_heading" id="parent37">
        <label style="font-size: 22px;margin-top: 10px; width: 100%">Importance and Confidence Rulers</label>
        </div>
		<%--TODO: removing this condition <%
			String answer = map.get(11);
			if(answer != null && answer.equals("2")) {
		%> --%>
        <div class="form-group" id="parent38">
        <label >Please select the number that best reflects how important it is to you to make any changes at all in your alcohol use.</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Not at all Important (1)</label>

        <th class="TableBorder"> <label>(2)</label>

        <th class="TableBorder"> <label>(3)</label>

        <th class="TableBorder"> <label>(4)</label>

        <th class="TableBorder"> <label>Unsure How important(5)</label>

        <th class="TableBorder"> <label>(6)</label>

        <th class="TableBorder"> <label>(7)</label>

        <th class="TableBorder"> <label>(8)</label>

        <th class="TableBorder"> <label>(9)</label>

        <th class="TableBorder"> <label>Very Important(10)</label>


        <tr>
        <td class="TableBorder">
        <label for="28">()</label>

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"62" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"63" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"64" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"65" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"66" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"67" value="5" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"68" value="6" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"69" value="7" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"70" value="8" />

        <td class="TableBorder Center"> <input type="radio" name="sub28" id=opt"71" value="9" />


        </table>
        </div>
		<%-- <% } %>
		<%
			answer = map.get(11);
			if(answer != null && answer.equals("2")) {
		%> --%>
        <div class="form-group" id="parent96">
        <label >Please select the number than best reflects how confident you are that you could change your drinking habits if you chose to do so.</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Not at all Confident (1)</label>

        <th class="TableBorder"> <label>(2)</label>

        <th class="TableBorder"> <label>(3)</label>

        <th class="TableBorder"> <label>(4)</label>

        <th class="TableBorder"> <label>Unsure how Confident (5)</label>

        <th class="TableBorder"> <label>(6)</label>

        <th class="TableBorder"> <label>(7)</label>

        <th class="TableBorder"> <label>(8)</label>

        <th class="TableBorder"> <label>(9)</label>

        <th class="TableBorder"> <label>Very Confident (10)</label>


        <tr>
        <td class="TableBorder">
        <label for="174">()</label>

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"233" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"234" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"235" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"236" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"237" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"238" value="5" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"239" value="6" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"240" value="7" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"241" value="8" />

        <td class="TableBorder Center"> <input type="radio" name="sub174" id=opt"242" value="9" />


        </table>
        </div>
		<%-- <% } %>
		<%
			answer = map.get(12);
			if(answer != null && answer.equals("2")) {
		%> --%>
        <div class="form-group" id="parent97">
        <label >Please select the number that best reflects how important it is to you to make any changes at all in your marijuana use.</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Not at all Confident (1)</label>

        <th class="TableBorder"> <label>(2)</label>

        <th class="TableBorder"> <label>(3)</label>

        <th class="TableBorder"> <label>(4)</label>

        <th class="TableBorder"> <label>Unsure how important (5)</label>

        <th class="TableBorder"> <label>(6)</label>

        <th class="TableBorder"> <label>(7)</label>

        <th class="TableBorder"> <label>(8)</label>

        <th class="TableBorder"> <label>(9)</label>

        <th class="TableBorder"> <label>Very Confident (10)</label>


        <tr>
        <td class="TableBorder">
        <label for="175">()</label>

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"243" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"244" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"245" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"246" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"247" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"248" value="5" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"249" value="6" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"250" value="7" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"251" value="8" />

        <td class="TableBorder Center"> <input type="radio" name="sub175" id=opt"252" value="9" />


        </table>
        </div>

		<%-- <% } %>
		<%
			answer = map.get(12);
			if(answer != null && answer.equals("2")) {
		%> --%>
        <div class="form-group" id="parent98">
        <label >Please select the number than best reflects how confident you are that you could change your marijuana use if you chose to do so.</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Not at all Confident (1)</label>

        <th class="TableBorder"> <label>(2)</label>

        <th class="TableBorder"> <label>(3)</label>

        <th class="TableBorder"> <label>(4)</label>

        <th class="TableBorder"> <label>Unsure how Confident (5)</label>

        <th class="TableBorder"> <label>(6)</label>

        <th class="TableBorder"> <label>(7)</label>

        <th class="TableBorder"> <label>(8)</label>

        <th class="TableBorder"> <label>(9)</label>

        <th class="TableBorder"> <label>Very Confident (10)</label>


        <tr>
        <td class="TableBorder">
        <label for="176">()</label>

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"253" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"254" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"255" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"256" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"257" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"258" value="5" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"259" value="6" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"260" value="7" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"261" value="8" />

        <td class="TableBorder Center"> <input type="radio" name="sub176" id=opt"262" value="9" />


        </table>
        </div>
		<%-- <% } %> --%>
        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Submit</button>
        </div>
        </body>
        </html>
