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
        src="resources/js/survey_page3.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <!-- <div class="Center"><h1>mHealth Feedback Survey</h1></div> -->
        <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>
		
		
        <form role="form">


            <div class="form-group" id="parent41">
            <label style="font-size: 22px;margin-top: 10px;">Brief Comprehensive Effects of Alcohol (CEA)</label>
            </div>

            <div class="form-group" id="parent42">
            <label style="font-size: 22px;margin-top: 10px;">This questionnaire assess two things:</label>
            </div>

            <div class="form-group" id="parent43">
            <label style="font-size: 22px;margin-top: 10px;">1) what you would expect to happen if you were under the influence of alcohol, and</label>
            </div>

            <div class="form-group" id="parent44">
            <label style="font-size: 22px;margin-top: 10px;">2) whether you think the effect is good or bad.</label>
            </div>

            <div class="form-group" id="parent45">
            <label style="font-size: 22px;margin-top: 10px;">A. Choose from “disagree to agree” depending on whether you expect the effect to happen to you if you were under the influence of alcohol. These effects will vary, depending on the amount of alcohol you typically consume. Circle one answer for the first set of numbers after each statement.</label>
            </div>

            <div class="form-group" id="parent46">
            <label style="font-size: 22px;margin-top: 10px;"> 1= Disagree, 2=Slightly Disagree, 3= Slightly Agree, 4= Agree</label>
            </div>

            <div class="form-group" id="parent47">
            <label >IF I WERE UNDER THE INFLUENCE FROM DRINKING ALCOHOL:</label>
            <table class="TableBorder">
            <tr>
            <th class="TableBorder">

            <th class="TableBorder"> <label>1</label>

            <th class="TableBorder"> <label>2</label>

            <th class="TableBorder"> <label>3</label>

            <th class="TableBorder"> <label>4</label>
            <tr>
            <td class="TableBorder">
            <label for="53">I would enjoy sex more.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub53" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub53" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub53" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub53" id=opt"77" value="3" />
            
            <tr>
            <td class="TableBorder">
            <label for="54">I would feel dizzy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub54" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub54" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub54" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub54" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="55">I would be clumsy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub55" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub55" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub55" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub55" id=opt"77" value="3" />
             <tr>
            <td class="TableBorder">
            <label for="56">I would be loud, boisterous, or noisy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub56" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub56" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub56" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub56" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="57">I would feel peaceful.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub57" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub57" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub57" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub57" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="58">I would be brave and daring.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub58" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub58" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub58" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub58" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="59">I would be courageous.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub59" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub59" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub59" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub59" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="60">I would act agressively.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub60" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub60" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub60" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub60" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="61">I would feel guilty.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub61" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub61" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub61" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub61" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="62">I would feel calm.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub62" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub62" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub62" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub62" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="63">I would feel moody.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub63" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub63" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub63" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub63" id=opt"77" value="3" />
            <tr>
            <td class="TableBorder">
            <label for="64">It would be easier to talk to people.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub64" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub64" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub64" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub64" id=opt"77" value="3" />
            
            <tr>
            <td class="TableBorder">
            <label for="65">I would be a better lover.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub65" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub65" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub65" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub65" id=opt"77" value="3" />
            
            
            
            


           


            


            


            <tr>
            <td class="TableBorder">
            <label for="66">I would take risks.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub66" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub66" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub66" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub66" id=opt"77" value="3" />


            


            


            


            


            <tr>
            <td class="TableBorder">
            <label for="67">I would act sociable.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub67" id=opt"74" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub67" id=opt"75" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub67" id=opt"76" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub67" id=opt"77" value="3" />


            


            


            


            


            


            


            </table>
            </div>

            <div class="form-group" id="parent48">
            <label style="font-size: 22px;margin-top: 10px;">B. Choose from “bad to good” depending on whether you think the particular effect is bad, neutral, good, etc.  We want to know if you think a particular effect is bad or good, regardless of whether or not you expect it to happen to you. Circle only one answer for the last set of numbers after each statement.</label>
            </div>

            <div class="form-group" id="parent49">
            <label style="font-size: 22px;margin-top: 10px;">1= Bad, 2= Slightly  Bad, 3= Neutral, 4= Slightly Good, 5= Good</label>
            </div>

            <div class="form-group" id="parent50">
            <label >IF I WERE UNDER THE INFLUENCE FROM DRINKING ALCOHOL:</label>
            <table class="TableBorder">
            <tr>
            <th class="TableBorder">

            <th class="TableBorder"> <label>1</label>

            <th class="TableBorder"> <label>2</label>

            <th class="TableBorder"> <label>3</label>

            <th class="TableBorder"> <label>4</label>

            <th class="TableBorder"> <label>5</label>
            <tr>
            <td class="TableBorder">
            <label for="68">I would enjoy sex more.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub68" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub68" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub68" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub68" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub68" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="69">I would feel dizzy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub69" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub69" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub69" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub69" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub69" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="70">I would be clumsy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub70" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub70" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub70" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub70" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub70" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="71">I would be loud, boisterous, or noisy.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub71" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub71" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub71" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub71" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub71" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="72">I would feel peaceful.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub72" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub72" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub72" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub72" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub72" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="73">I would be brave and daring.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub73" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub73" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub73" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub73" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub73" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="74">I would be courageous.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub74" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub74" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub74" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub74" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub74" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="75">I would act agressively.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub75" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub75" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub75" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub75" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub75" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="76">I would feel guilty.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub76" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub76" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub76" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub76" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub76" id=opt"82" value="4" />
            <tr>
            <td class="TableBorder">
            <label for="77">I would feel calm.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub77" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub77" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub77" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub77" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub77" id=opt"82" value="4" />


            <tr>
            <td class="TableBorder">
            <label for="78">I would feel moody.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub78" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub78" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub78" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub78" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub78" id=opt"82" value="4" />


            <tr>
            <td class="TableBorder">
            <label for="79">It would be easier to talk to people.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub79" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub79" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub79" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub79" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub79" id=opt"82" value="4" />
            
            
            
            
            
            
            
            
            
            
            
            
            


            


            


            


            


            <tr>
            <td class="TableBorder">
            <label for="80">I would be a better lover.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub80" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub80" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub80" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub80" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub80" id=opt"82" value="4" />


            

            

            <tr>
            <td class="TableBorder">
            <label for="81">I would take risks.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub81" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub81" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub81" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub81" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub81" id=opt"82" value="4" />


            
			<tr>
            <td class="TableBorder">
            <label for="82">I would act sociable.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub82" id=opt"78" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub82" id=opt"79" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub82" id=opt"80" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub82" id=opt"81" value="3" />

            <td class="TableBorder Center"> <input type="radio" name="sub82" id=opt"82" value="4" />
			

            

            


            


            


            </table>
            </div>
           

        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
        </div>
        </body>
        </html>
