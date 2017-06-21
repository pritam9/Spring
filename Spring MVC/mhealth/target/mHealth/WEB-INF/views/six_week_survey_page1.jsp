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
        src="resources/js/survey_page1.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <div class="Center"><h1>SmarTrek Feedback Survey</h1></div>
        <form role="form">
        <br><br><h4>Welcome to the SmarTrek feedback surveys. These surveys are being collected as part of SmarTrek
        research study.</h4>
        <h4>The surveys consists of items which will ask you questions about your alcohol and marijuana use. They take
        about 30 minutes of your time to complete. If you do not wish to answer a particular question, then proceed to
        the next question. Your confidential responses will only be linked to your participant ID and will be viewed
        only by the research team. Feel free to call the SmarTrek Project Principal Investigator, Donna Kazemi at
        704-687-7968 or email her at dkazemi@uncc.edu with any questions or concerns. Thank you.</h4>
        <h4>By entering the private password you were given to access this survey, you are indicating that you have read
        and understand what participation involves and that you voluntarily agree to complete the survey.</h4><br>


            <div class="form-group RoundedCorner" id="parent36">
            <label >Please indicate that you have read and understand this section on Confidentiality:</label>

            <label class="form-control">
            <input type="radio" name="36" id="opt60" value="0" /> Yes
            </label>

            <label class="form-control">
            <input type="radio" name="36" id="opt61" value="1" /> No
            </label>

            </div>

            <div class="form-group" id="parent22">
            <label style="font-size: 22px;margin-top: 10px;">Personal Demographics:</label>
            </div>

            <div class="form-group RoundedCorner" id="parent23">
            <label >Please enter your name</label>
            <table class="SubQuestion">

            <tr>
            <td>
            <label for="26">First Name</label>
            <td>
            <input type="text" class="form-control" id="sub26">


            <!-- <tr>
            <td>
            <label for="27">Last Name</label>
            <td>
            <input type="text" class="form-control" id="sub27">
 			-->

            </table>
            </div>

            
            <div class="form-group RoundedCorner" id="parent35">
            <label >How would you rate your overall wellness?</label>

            <label class="form-control">
            <input type="radio" name="35" id="opt55" value="0" /> Poor
            </label>

            <label class="form-control">
            <input type="radio" name="35" id="opt56" value="1" /> Fair
            </label>

            <label class="form-control">
            <input type="radio" name="35" id="opt57" value="2" /> Good
            </label>

            <label class="form-control">
            <input type="radio" name="35" id="opt58" value="3" /> Very Good
            </label>

            <label class="form-control">
            <input type="radio" name="35" id="opt59" value="4" /> Excellent
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent16">
            <label >During the past 30 days, not due to your use of alcohol or other drugs, how many days have you:</label>
            <table class="SubQuestion">

            <tr>
            <td>
            <label for="5">Experienced serious anxiety or tension</label>
            <td>
            <input type="number" class="form-control" id="sub5">


            <tr>
            <td>
            <label for="4">Experienced serious depression</label>
            <td>
            <input type="number" class="form-control" id="sub4">


            <tr>
            <td>
            <label for="113">Experienced trouble controlling violent behavior</label>
            <td>
            <input type="number" class="form-control" id="sub113">


            <tr>
            <td>
            <label for="6">Experienced serious hallucinations</label>
            <td>
            <input type="number" class="form-control" id="sub6">


            <tr>
            <td>
            <label for="112">Experienced serious trouble concentrating or remembering</label>
            <td>
            <input type="number" class="form-control" id="sub112">


            <tr>
            <td>
            <label for="115">Attempted Suicide</label>
            <td>
            <input type="number" class="form-control" id="sub115">


            <tr>
            <td>
            <label for="114">Considered Suicide</label>
            <td>
            <input type="number" class="form-control" id="sub114">


            </table>
            </div>

            <div class="form-group RoundedCorner" id="parent66">
            <label >In the last 30 days have you engaged in sexual activity?</label>

            <label class="form-control">
            <input type="radio" name="66" id="opt164" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="66" id="opt165" value="1" /> no
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent67">
            <label for="67">If so, how many contacts were unprotected (including oral sex)?</label>
            <input type="text" class="form-control" id="67">
            </div>

            <div class="form-group RoundedCorner" id="parent68">
            <label for="68">If you engaged in unprotected sex, how many encounters were with a person who was high on some substance (including alcohol)?</label>
            <input type="text" class="form-control" id="68">
            </div>

            <div class="form-group RoundedCorner" id="parent69">
            <label >Have you ever been tested for HIV?</label>

            <label class="form-control">
            <input type="radio" name="69" id="opt166" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="69" id="opt167" value="1" /> no
            </label>

            </div>



            <div class="form-group" id="parent24">
            <label style="font-size: 22px;margin-top: 10px;">Your Frequency of Alcohol and Marijuana Use:</label>
            </div>

            <div class="form-group" id="parent18">
            <label >Please indicate how often you have used the following substances. Choose one response for each row.</label>
            <table class="TableBorder">
            <tr>
            <th class="TableBorder">

            <th class="TableBorder"> <label>Never Used</label>

            <th class="TableBorder"> <label>Have used, but not in the last 30 days</label>

            <th class="TableBorder"> <label>Have used in the last 30 days</label>


            <tr>
            <td class="TableBorder">
            <label for="12">Marijuana (weed, pot, hashish, hash oil) or synthetic marijuana (Spice, K2)</label>

            <td class="TableBorder Center"> <input type="radio" name="sub12" id=opt"27" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub12" id=opt"28" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub12" id=opt"29" value="2" />


            <tr>
            <td class="TableBorder">
            <label for="11">Alcohol</label>

            <td class="TableBorder Center"> <input type="radio" name="sub11" id=opt"27" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub11" id=opt"28" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub11" id=opt"29" value="2" />


            </table>
            </div>



        </form>
            <div style="text-align: center; margin: 10px">
            <h4 class="error-msg hide"></h4>
            <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
            </div>
        </body>
        </html>
