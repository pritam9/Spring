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
        src="resources/js/survey_page6.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <div class="Center"><h1>mHealth Feedback Survey</h1></div>
        <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>
		
		
        <form role="form">




        <div class="form-group" id="parent60">
        <label style="font-size: 22px;margin-top: 10px;">The Protective Behaviors Strategies Scale</label>
        </div>

        <div class="form-group" id="parent61">
        <label >Instructions: Please indicate the degree to which you engage in the following behaviors when using alcohol or “partying.” </label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Never</label>

        <th class="TableBorder"> <label>Rarely</label>

        <th class="TableBorder"> <label>Occasionally</label>

        <th class="TableBorder"> <label>Sometimes</label>

        <th class="TableBorder"> <label>Usually</label>

        <th class="TableBorder"> <label>Always</label>


        <tr>
        <td class="TableBorder">
        <label for="91">Make sure that you go home with a friend</label>

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub91" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="90">Leave the bar/party at a predetermined time</label>

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub90" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="94">Stop drinking at a predetermined time</label>

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub94" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="89">Avoid drinking games</label>

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub89" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="87">Alternate alcoholic and non-alcoholic drinks</label>

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub87" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="85">Use a designated driver</label>

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub85" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="92">Know where your drink has been at all times</label>

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub92" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="88">Have a friend let you know when you have had enough to drink</label>

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub88" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="97">Avoid mixing different types of alcohol</label>

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub97" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="98">Drink slowly, rather than gulp or chug</label>

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub98" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="86">Determine not to exceed a set number of drinks</label>

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub86" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="93">Don't drink shots of liquor</label>

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub93" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="96">Put extra ice in your drink</label>

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub96" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="95">Drink water while drinking alcohol</label>

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub95" id=opt"95" value="5" />


        <tr>
        <td class="TableBorder">
        <label for="99">Avoid trying to “keep up” or “out-drink” others</label>

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"90" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"91" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"92" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"93" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"94" value="4" />

        <td class="TableBorder Center"> <input type="radio" name="sub99" id=opt"95" value="5" />


        </table>
        </div>



        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
        </div>
        </body>
        </html>
