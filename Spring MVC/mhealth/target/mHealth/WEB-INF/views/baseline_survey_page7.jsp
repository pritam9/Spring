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
        src="resources/js/survey_page7.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <!-- <div class="Center"><h1>mHealth Feedback Survey</h1></div> -->
        <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>
		
		
        <form role="form">


            <div class="form-group" id="parent62">
            <label style="font-size: 22px;margin-top: 10px;">Centre for Alcohol & Drug Studies Newcastle City Health NHS Trust</label>
            </div>

            <!-- <div class="form-group" id="parent63">
            <label style="font-size: 22px;margin-top: 10px;">Complete this survey if you are a drinker only:</label>
            </div> -->

            <div class="form-group survey_heading" id="parent64">
            <label style="font-size: 22px;margin-top: 10px; width: 100%">READINESS TO CHANGE QUESTIONNAIRE</label>
            </div>

            <div class="form-group" id="parent65">
            <label >The following questionnaire is designed to identify how you personally feel about your drinking right now. Please read each of the questions below carefully, and then decide whether you agree or disagree with the statements. Please check the answer of your choice to each question. Your answers are completely private and confidential.</label>
            <table class="TableBorder">
            <tr>
            <th class="TableBorder">

            <th class="TableBorder"> <label>Strongly Disagree</label>

            <th class="TableBorder"> <label>Disagree</label>

            <th class="TableBorder"> <label>Unsure</label>

            <th class="TableBorder"> <label>Agree</label>

            <th class="TableBorder"> <label>Strongly Agree</label>
			<tr>
            <td class="TableBorder">
            <label for="100">I don’t think I drink too much.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub100" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub100" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub100" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub100" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub100" id=opt"100" value="4" />
			<tr>
            <td class="TableBorder">
            <label for="101">I am trying to drink less than I used to.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub101" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub101" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub101" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub101" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub101" id=opt"100" value="4" />

			<tr>
            <td class="TableBorder">
            <label for="102">I enjoy my drinking, but sometimes I drink too much.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub102" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub102" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub102" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub102" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub102" id=opt"100" value="4" />
			
			<tr>
            <td class="TableBorder">
            <label for="103">Sometimes I think I should cut down on my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub103" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub103" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub103" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub103" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub103" id=opt"100" value="4" />
			
			<tr>
            <td class="TableBorder">
            <label for="104">It’s a waste of time thinking about my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub104" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub104" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub104" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub104" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub104" id=opt"100" value="4" />
			<tr>
            <td class="TableBorder">
            <label for="105">I have just recently changed my drinking habits.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub105" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub105" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub105" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub105" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub105" id=opt"100" value="4" />
			<tr>
            <td class="TableBorder">
            <label for="106">Anyone can talk about wanting to do something about drinking, but I am actually doing something about it.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub106" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub106" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub106" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub106" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub106" id=opt"100" value="4" />
			<tr>
            <td class="TableBorder">
            <label for="107">I am at the stage where I should think about drinking less alcohol.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub107" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub107" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub107" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub107" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub107" id=opt"100" value="4" />
			
			
			
			
			














            

            

            <tr>
            <td class="TableBorder">
            <label for="108">My drinking is a problem sometimes.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub108" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub108" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub108" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub108" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub108" id=opt"100" value="4" />

			<tr>
            <td class="TableBorder">
            <label for="109">There is no need for me to think about changing my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub109" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub109" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub109" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub109" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub109" id=opt"100" value="4" />

            
            

            <tr>
            <td class="TableBorder">
            <label for="110">I am actually changing my drinking habits right now</label>

            <td class="TableBorder Center"> <input type="radio" name="sub110" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub110" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub110" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub110" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub110" id=opt"100" value="4" />


            

            

            

            <tr>
            <td class="TableBorder">
            <label for="111">Drinking less alcohol would be pointless for me.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub111" id=opt"96" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub111" id=opt"97" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub111" id=opt"98" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub111" id=opt"99" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub111" id=opt"100" value="4" />


            


            


            </table>
            </div>


        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
        </div>
        </body>
        </html>
