    <%@page import="java.util.HashMap" %>
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
        src="resources/js/survey_page2.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <div class="Center"><h1>mHealth Feedback Survey</h1></div>
            <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>

            <%
		boolean canShow = false;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = questions.indexOf(new Question(18));
		
		
		if(index > -1) {
			for(SubQuestion sq : questions.get(index).getSubquestions()) {
				map.put(sq.getId(), sq.getAnswer());
				if(sq.getAnswer() != null && sq.getAnswer().equals("2")){
					canShow = true;
				}
			}
		}
		
		%>
        <form role="form">
            <% if(canShow){ %>
        <div class="form-group RoundedCorner" id="parent19">
        <label for="19">Approximately how many times have you used the following substances in the past 30 days?</label>
        <table class="SubQuestion">
            <%
			String answer = map.get(11);
			if(answer != null && answer.equals("2")) {
		%>
        <tr>
        <td>
        <label for="15">Alcohol</label>
        <td>
        <input type="number" class="form-control" id="sub15">
            <% } %>


            <%
			answer = map.get(12);
			if(answer != null && answer.equals("2")) {
		%>
        <tr>
        <td>
        <label for="16">Marijuana (weed, pot, hashish, hash oil) or synthetic marijuana (Spice, K2)</label>
        <td>
        <input type="number" class="form-control" id="sub16">
            <% } %>


        </table>
        </div>
        
        <% } %>
        <!-- canShow if condition ends here -->

        <div class="form-group" id="parent29">
        <label style="font-size: 22px;margin-top: 10px;" for="29">"Typical" one Week Alcohol Use Calendar</label>
        </div>
        <div class="form-group">
        <label style="font-size: 20px;margin-top: 10px;" for="29">Think of a typical one week period in your recent
        past, and complete the calendar below as accurately as

        possible.</label>
        </div>
        <div>
        <span style="font-size: 20px">12 ounce beer = 1 ounce shot = 4 ounce glass of wine</span><br>
        <img src="resources/images/beer.png" style="padding-left:35px">
        <img src="resources/images/shot.png" style="padding-left:105px">
        <img src="resources/images/wine.png" style="padding-left:130px">
        </div>


        <div class="form-group" id="parent27">
        <label style="font-size: 22px;margin-top: 10px;" for="27">Please enter the number of “standard drinks” (see
        chart) you had on each day and the number of hours

        you spent drinking. Enter “0” if you did not drink.</label>
        </div>

        <div class="form-group" id="parent28">
        <label style="font-size: 22px;margin-top: 10px;" for="28">Please estimate how many hours you spent high or
        stoned on each day. Enter "0" if you did not use marijuana on that day.</label>
        </div>

        <div class="form-group" id="parent20">
        <label for="20">Typical Week 1</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Sunday</label>

        <th class="TableBorder"> <label>Monday</label>

        <th class="TableBorder"> <label>Tuesday</label>

        <th class="TableBorder"> <label>Wednesday</label>

        <th class="TableBorder"> <label>Thursday</label>

        <th class="TableBorder"> <label>Friday</label>

        <th class="TableBorder"> <label>Saturday</label>


            <%-- <%
			answer = map.get(11);
			if(answer != null && answer.equals("2")) {
		    %> --%>
        <tr>
        <td class="TableBorder">
        <label for="19">Number of drinks:</label>

        <td class="TableBorder Center"> <input type="number" id="sub19opt30" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt31" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt32" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt33" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt34" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt35" />

        <td class="TableBorder Center"> <input type="number" id="sub19opt36" />


        <tr>
        <td class="TableBorder">
        <label for="20">Number of hours drinking</label>

        <td class="TableBorder Center"> <input type="number" id="sub20opt30" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt31" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt32" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt33" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt34" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt35" />

        <td class="TableBorder Center"> <input type="number" id="sub20opt36" />

            <%-- <% } %>

            <%
			answer = map.get(12);
			if(answer != null && answer.equals("2")) {
		    %> --%>
        <tr>
        <td class="TableBorder">
        <label for="21">Number of hours under the influence of marijuana.</label>

        <td class="TableBorder Center"> <input type="number" id="sub21opt30" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt31" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt32" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt33" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt34" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt35" />

        <td class="TableBorder Center"> <input type="number" id="sub21opt36" />

            <%-- <% } %> --%>
        </table>
        </div>

        <%-- <div class="form-group" id="parent79">
        <label for="79">Typical Week 2</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Sunday</label>

        <th class="TableBorder"> <label>Monday</label>

        <th class="TableBorder"> <label>Tuesday</label>

        <th class="TableBorder"> <label>Wednesday</label>

        <th class="TableBorder"> <label>Thursday</label>

        <th class="TableBorder"> <label>Friday</label>

        <th class="TableBorder"> <label>Saturday</label>


            <%
			answer = map.get(11);
			if(answer != null && answer.equals("2")) {
		    %>
        <tr>
        <td class="TableBorder">
        <label for="117">Number of hours drinking</label>

        <td class="TableBorder Center"> <input type="number" id="sub117opt184" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt185" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt186" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt187" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt188" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt189" />

        <td class="TableBorder Center"> <input type="number" id="sub117opt190" />


        <tr>
        <td class="TableBorder">
        <label for="116">Number of drinks:</label>

        <td class="TableBorder Center"> <input type="number" id="sub116opt184" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt185" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt186" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt187" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt188" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt189" />

        <td class="TableBorder Center"> <input type="number" id="sub116opt190" />
            <% } %>
            <% 
			answer = map.get(12);
			if(answer != null && answer.equals("2")) {
		    %>

        <tr>
        <td class="TableBorder">
        <label for="118">Number of hours under the influence of marijuana.</label>

        <td class="TableBorder Center"> <input type="number" id="sub118opt184" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt185" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt186" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt187" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt188" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt189" />

        <td class="TableBorder Center"> <input type="number" id="sub118opt190" />

            <% } %>
        </table>
        </div>
 --%>
            <!-- <div class="form-group RoundedCorner" id="parent57">
            <label for="57">Weight</label>
            <input type="text" class="form-control" id="57">
            </div>

            <div class="form-group RoundedCorner" id="parent58">
            <label for="58">Gender</label>
            <input type="text" class="form-control" id="58">
            </div>

            <div class="form-group RoundedCorner" id="parent59">
            <label for="59">Height</label>
            <input type="text" class="form-control" id="59">
            </div>
 -->            

        <div class="form-group RoundedCorner" id="parent80">
        <label >Think of the time you drank the MOST in the past 30 days. Please fill in the number of “standard drinks”
        of each type

        you consumed and the number of hours you spent drinking on that occasion.</label>
        <table class="SubQuestion">

        <tr>
        <td>
        <label for="121">Spirit (hard liqour)</label>
        <td>
        <input type="number" class="form-control" id="sub121">

		<tr>
        <td>
        <label for="240">Malt Liqour</label>
        <td>
        <input type="number" class="form-control" id="sub240">


        <tr>
        <td>
        <label for="119">Beer</label>
        <td>
        <input type="number" class="form-control" id="sub119">


        <tr>
        <td>
        <label for="120">Wine</label>
        <td>
        <input type="number" class="form-control" id="sub120">


        <tr>
        <td>
        <label for="122">Hours</label>
        <td>
        <input type="number" class="form-control" id="sub122">


        </table>
        </div>

        

        <div class="form-group RoundedCorner" id="parent82">
        <label for="82">Approximately how many hours do you sleep in a typical 24-hour period (including naps)?</label>
        <input type="number" class="form-control" id="82">
        </div>

        <div class="form-group" id="parent83">
        <label style="font-size: 22px;margin-top: 10px;">Your Time and Money</label>
        </div>

        <div class="form-group" id="parent84">
        <label >During a typical week, how many hours do you estimate that you spend:</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Total Hours In Typical Week</label>


        <tr>
        <td class="TableBorder">
        <label for="128">Socializing (hanging out with friends, going to parties and events, etc.)</label>

        <td class="TableBorder Center"> <input type="number" id="sub128opt191" />


        <tr>
        <td class="TableBorder">
        <label for="127">Exercising and/or Playing Sports</label>

        <td class="TableBorder Center"> <input type="number" id="sub127opt191" />


        <tr>
        <td class="TableBorder">
        <label for="126">Extracurriculars (clubs, volunteering, etc.)</label>

        <td class="TableBorder Center"> <input type="number" id="sub126opt191" />


        <tr>
        <td class="TableBorder">
        <label for="123">In classes</label>

        <td class="TableBorder Center"> <input type="number" id="sub123opt191" />


        <tr>
        <td class="TableBorder">
        <label for="125">Studying and doing homework.</label>

        <td class="TableBorder Center"> <input type="number" id="sub125opt191" />


        <tr>
        <td class="TableBorder">
        <label for="124">Working (job, internship, etc.)</label>

        <td class="TableBorder Center"> <input type="number" id="sub124opt191" />


        </table>
        </div>
        
        <div class="form-group RoundedCorner" id="parent81">
        <label for="81">Please estimate how much money you spend on alcohol during a typical week: ($)</label>
        <input type="number" class="form-control" id="81">
        </div>

        <div class="form-group RoundedCorner" id="parent85">
        <label for="85">Please estimate how much money you spend on marijuana during a typical week: ($)</label>
        <input type="number" class="form-control" id="85">
        </div>
        
        <div class="form-group survey_heading">
        <label style="font-size: 22px;margin-top: 10px; width: 100%">AUDIT Survey</label>
        </div>

        <div class="form-group" id="parent86">
        <label >Please select the answer for each question that accurately describes your drinking pattern in the past
        year.</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder" style="width: 16.666666666666668%">

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Never</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Monthly or less</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>2-4 times a month</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>2-3 times a week</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>4 or more times a week</label>


        <tr>
        <td class="TableBorder">
        <label for="129">How often do you have a

        drink containing alcohol?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub129" id=opt"192" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub129" id=opt"193" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub129" id=opt"194" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub129" id=opt"195" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub129" id=opt"196" value="4" />


        </table>
        </div>

        <div class="form-group" id="parent87">
        <label ></label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder" style="width: 16.666666666666668%">

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>1 or 2</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>3 or 4</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>5 or 6</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>7 to 9</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>10 or more</label>


        <tr>
        <td class="TableBorder">
        <label for="130">How many standard drinks do

        you have on a typical day

        when you are drinking?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub130" id=opt"197" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub130" id=opt"198" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub130" id=opt"199" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub130" id=opt"200" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub130" id=opt"201" value="4" />


        </table>
        </div>

        <div class="form-group" id="parent88">
        <label ></label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder" style="width: 16.666666666666668%">

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Never</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Less than Monthly</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Monthly</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Weekly</label>

        <th class="TableBorder" style="width: 16.666666666666668%"> <label>Daily or Almost Daily</label>
        
        <tr>
        <td class="TableBorder">
        <label for="131">How often do you have six or

        more standard drinks on one

        occasion?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub131" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub131" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub131" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub131" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub131" id=opt"206" value="4" />
        
        <tr>
        <td class="TableBorder">
        <label for="132">How often during the last year

        have you found that you were

        not able to stop drinking once

        you had started?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub132" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub132" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub132" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub132" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub132" id=opt"206" value="4" />
        
        
        <tr>
        <td class="TableBorder">
        <label for="133">How often during the last year

        have you failed to do what

        was normally expected of you

        because of drinking?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub133" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub133" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub133" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub133" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub133" id=opt"206" value="4" />

		<tr>
        <td class="TableBorder">
        <label for="134">How often during the last year

        have you needed a first drink

        in the morning to get yourself

        going after a heavy drinking

        session?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub134" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub134" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub134" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub134" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub134" id=opt"206" value="4" />


        <tr>
        <td class="TableBorder">
        <label for="135">How often during the last year

        have you had a feeling of guilt

        or remorse after drinking?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub135" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub135" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub135" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub135" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub135" id=opt"206" value="4" />


        <tr>
        <td class="TableBorder">
        <label for="136">How often during the last year

        have you been unable to

        remember what happened the

        night before because you had

        been drinking?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub136" id=opt"202" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub136" id=opt"203" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub136" id=opt"204" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub136" id=opt"205" value="3" />

        <td class="TableBorder Center"> <input type="radio" name="sub136" id=opt"206" value="4" />

        </table>
        </div>

        <div class="form-group" id="parent89">
        <label ></label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>No</label>

        <th class="TableBorder"> <label>Yes, but not in the last year</label>

        <th class="TableBorder"> <label>Yes, during the last year</label>

		<tr>
        <td class="TableBorder">
        <label for="137">Have you or someone else been injured because of your drinking?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub137" id=opt"207" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub137" id=opt"208" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub137" id=opt"209" value="4" />


        <tr>
        <td class="TableBorder">
        <label for="138">Has a relative, friend, doctor, or other health care worker been

        concerned about your drinking or suggested you cut down?</label>

        <td class="TableBorder Center"> <input type="radio" name="sub138" id=opt"207" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub138" id=opt"208" value="2" />

        <td class="TableBorder Center"> <input type="radio" name="sub138" id=opt"209" value="4" />


        


        </table>
        </div>

        <!-- <div class="form-group" id="parent90">
        <label >The physical and emotional effects of alcohol vary from person to person. Please indicate how often you
        experience the following when you drink alcohol:</label>
        <table class="TableBorder">
        <tr>
        <th class="TableBorder">

        <th class="TableBorder"> <label>Rarely or Never Happens</label>

        <th class="TableBorder"> <label>Sometimes Happens</label>

        <th class="TableBorder"> <label>Often Happens</label>


        <tr>
        <td class="TableBorder">
        <label for="148">I get “sloppy” (clumsy, slur words, etc.).</label>

        <td class="TableBorder Center"> <input type="radio" name="sub148" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub148" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub148" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="152">I have fun.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub152" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub152" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub152" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="154">Friends or acquaintances have to take care of me.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub154" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub154" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub154" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="140">I forget or escape from my responsibilities or problems.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub140" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub140" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub140" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="144">I feel less in control of my actions.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub144" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub144" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub144" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="149">I drunk-text, Facebook, or tweet.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub149" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub149" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub149" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="146">I become more emotional.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub146" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub146" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub146" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="150">I need to drink more than I used to in order to feel the effects of

        alcohol.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub150" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub150" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub150" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="145">I enjoy sex more.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub145" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub145" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub145" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="142">I become loud and boisterous.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub142" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub142" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub142" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="153">I feel closer to my friends.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub153" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub153" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub153" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="139">I notice a change in my energy level.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub139" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub139" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub139" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="151">I do or say things that I can't remember later.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub151" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub151" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub151" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="143">I become less aware of my surroundings.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub143" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub143" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub143" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="141">I hook up with someone.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub141" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub141" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub141" id=opt"212" value="2" />


        <tr>
        <td class="TableBorder">
        <label for="147">I act more outgoing.</label>

        <td class="TableBorder Center"> <input type="radio" name="sub147" id=opt"210" value="0" />

        <td class="TableBorder Center"> <input type="radio" name="sub147" id=opt"211" value="1" />

        <td class="TableBorder Center"> <input type="radio" name="sub147" id=opt"212" value="2" />


        </table>
        </div>
        
        <div class="form-group RoundedCorner" id="parent99">
									<label >Please type in other ways in which alcohol affects you which are not included in the list above:</label>
									<table class="SubQuestion">
					
									<tr>
										<td>
											<label for="177"> </label>
										<td>
											<input type="text" class="form-control" id="sub177">
								
					
									<tr>
										<td>
											<label for="179"> </label>
										<td>
											<input type="text" class="form-control" id="sub179">
								
					
									<tr>
										<td>
											<label for="178"> </label>
										<td>
											<input type="text" class="form-control" id="sub178">
								
					
								</table>
								</div> -->


        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
        </div>
        </body>
        </html>
