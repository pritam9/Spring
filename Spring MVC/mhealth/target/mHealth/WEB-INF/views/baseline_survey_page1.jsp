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

            <div class="form-group RoundedCorner" id="parent5">
            <label >Birth Sex. We ask this question in order to calculate your blood alcohol concentration.</label>

            <label class="form-control">
            <input type="radio" name="5" id="opt11" value="0" /> Male
            </label>

            <label class="form-control">
            <input type="radio" name="5" id="opt12" value="1" /> Female
            </label>

            </div>
            
            <div class="form-group RoundedCorner" id="parent108">
									<label >Please indicate your race:</label>
					
				<label class="form-control">
                    <input type="radio" name="108" id="opt285" value="0" /> Caucasian
                </label>
	
				<label class="form-control">
                    <input type="radio" name="108" id="opt286" value="1" /> African American
                </label>
	
				<label class="form-control">
                    <input type="radio" name="108" id="opt287" value="2" /> Asian
                </label>
	
				<label class="form-control">
                    <input type="radio" name="108" id="opt288" value="3" /> Hispanic
                </label>
	
				<label class="form-control">
                    <input type="radio" name="108" id="opt289" value="4" /> Pacific Islander
                </label>

                <label class="form-control">
                 <input type="radio" name="108" id="opt290" value="5" /> White
                </label>
	
				<label class="form-control">
                    <input type="radio" name="108" id="opt291" value="6" /> Other
                </label>
					
			</div>

            <div class="form-group RoundedCorner" id="parent6">
            <label for="6">Where is your hometown?</label>
            <input type="text" class="form-control" id="6">
            </div>

            <div class="form-group RoundedCorner" id="parent7">
            <label for="7">Current Age (in Years):</label>
            <input type="number" class="form-control" id="7">
            </div>

			<div class="form-group RoundedCorner" id="parent109">
				<label for="109">How old were you when you first starting
					drinking (not counting small tastes or sips of alcohol)? (in Years)</label>
				<input type="number" min="0" class="form-control" id="109">
			</div>

		<div class="form-group RoundedCorner" id="parent8">
            <label for="8">Please enter your current weight in pounds. (Used for BAC and other calculations).</label>
            <input type="number" class="form-control" id="8">
            </div>
            
            <div class="form-group RoundedCorner" id="parent59">
            <label for="59">Height in inch</label>
            <input type="number" class="form-control" id="59">
            </div>

            <div class="form-group RoundedCorner" id="parent9">
            <label for="9">Please type in any medications you take on a regular basis. If you do not take any medications, please enter NA.</label>
            <input type="text" class="form-control" id="9">
            </div>

            <div class="form-group RoundedCorner" id="parent10">
            <label >What is your year in school?</label>

            <label class="form-control">
            <input type="radio" name="10" id="opt13" value="0" /> Freshman
            </label>

            <label class="form-control">
            <input type="radio" name="10" id="opt14" value="1" /> Sophomore
            </label>

            <label class="form-control">
            <input type="radio" name="10" id="opt15" value="2" /> Junior
            </label>

            <label class="form-control">
            <input type="radio" name="10" id="opt16" value="3" /> Senior
            </label>

            <!-- <label class="form-control">
            <input type="radio" name="10" id="opt17" value="4" /> Graduate
            </label> -->

            </div>

            <div class="form-group RoundedCorner" id="parent11">
            <label for="11">What is your major?</label>
            <input type="text" class="form-control" id="11">
            </div>

            <div class="form-group RoundedCorner" id="parent12">
            <label for="12">What is your cumulative GPA?</label>
            <input type="number" class="form-control" id="12">
            </div>

            <div class="form-group RoundedCorner" id="parent13">
            <label >Do you have a part-time or full-time job?</label>

            <label class="form-control">
            <input type="radio" name="13" id="opt18" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="13" id="opt19" value="1" /> no
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent14">
            <label >Do you live on or off campus?</label>

            <label class="form-control">
            <input type="radio" name="14" id="opt20" value="0" /> Off Campus
            </label>

            <label class="form-control">
            <input type="radio" name="14" id="opt21" value="1" /> On Campus
            </label>

            </div>

            <!-- <div class="form-group RoundedCorner" id="parent15">
            <label >If you live on campus, which residence hall do you live in?</label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt24" value="0" /> Belk Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt25" value="1" /> Elm Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt26" value="2" /> Greek Village
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt101" value="3" /> Hawthorn Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt102" value="4" /> Holshouser Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt103" value="5" /> Hunt Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt104" value="6" /> Laurel Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt105" value="7" /> Levine Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt106" value="8" /> Lynch Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt107" value="9" /> Maple Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt108" value="10" /> Martin Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt109" value="11" /> Miltimore Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt110" value="12" /> Moore Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt111" value="13" /> Oak Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt112" value="14" /> Pine Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt113" value="15" /> Sanford Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt114" value="16" /> Scott Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt115" value="17" /> Wallis Hall
            </label>

            <label class="form-control">
            <input type="checkbox" name="15" id="opt116" value="18" /> Witherspoon Hall
            </label>

            </div>
 -->
            <div class="form-group RoundedCorner" id="parent30">
            <label >Are you a member of a Fraternity or Sorority?</label>

            <label class="form-control">
            <input type="radio" name="30" id="opt37" value="0" /> Yes
            </label>

            <label class="form-control">
            <input type="radio" name="30" id="opt38" value="1" /> No
            </label>

            </div>

            <!-- <div class="form-group RoundedCorner" id="parent31">
            <label >Which fraternity or sorority are you a member of?</label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt39" value="0" /> Alpha Chi Omega
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt40" value="1" /> Alpha Delta Pi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt41" value="2" /> Alpha Kappa Alpha
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt42" value="3" /> Alpha Phi Alpha
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt117" value="4" /> Alpha Omega Epsilon
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt118" value="5" /> Alpha Sigma Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt119" value="6" /> Chi Omega
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt120" value="7" /> Delta Chi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt121" value="8" /> Delta Phi Lambda
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt122" value="9" /> Delta Sigma Theta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt123" value="10" /> Delta Zeta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt124" value="11" /> Kappa Alpha Order
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt125" value="12" /> Kappa Alpha Psi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt126" value="13" /> Kappa Delta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt127" value="14" /> Kappa Sigma
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt128" value="15" /> Lambda Chi Alpha
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt129" value="16" /> Lambda Theta Alpha
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt130" value="17" /> Lambda Theta Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt131" value="18" /> Mu Sigma Upsilon
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt132" value="19" /> Omega Phi Beta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt133" value="20" /> Omega Psi Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt134" value="21" /> Phi Beta Sigma
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt135" value="22" /> Phi Delta Theta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt136" value="23" /> Phi Mu Alpha
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt137" value="24" /> Phi Sigma Kappa
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt138" value="25" /> Pi Alpha Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt139" value="26" /> Pi Kappa Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt140" value="27" /> Psi Sigma Phi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt141" value="28" /> Sigma Gamma Rho
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt142" value="29" /> Sigma Alpha Epsilon
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt143" value="30" /> Sigma Chi
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt144" value="31" /> Sigma Kappa
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt145" value="32" /> Sigma Phi Epsilon
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt146" value="33" /> Sigma Tau Gamma
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt147" value="34" /> Triangle
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt148" value="35" /> Zeta Beta Tau
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt149" value="36" /> Zeta Phi Beta
            </label>

            <label class="form-control">
            <input type="checkbox" name="31" id="opt150" value="37" /> Zeta Tau Alpha
            </label>

            </div>
 -->
            <div class="form-group RoundedCorner" id="parent32">
            <label >Do you play sports?</label>

            <label class="form-control">
            <input type="radio" name="32" id="opt43" value="0" /> Yes
            </label>

            <label class="form-control">
            <input type="radio" name="32" id="opt44" value="1" /> No
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent33">
            <label >If you play sports, then do you play for Charlotte 49ers Athletics? If not, please select none of the above.</label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt45" value="0" /> Baseball
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt46" value="1" /> Basketball
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt47" value="2" /> Cross Country
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt48" value="3" /> Football
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt49" value="4" /> Golf
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt151" value="5" /> Indoor and Outdoor Track and Field
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt152" value="6" /> Soccer
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt153" value="7" /> Softball
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt154" value="8" /> Tennis
            </label>

            <label class="form-control">
            <input type="checkbox" name="33" id="opt155" value="9" /> Volleyball
            </label>
            
            <label class="form-control">
            <input type="checkbox" name="33" id="opt274" value="10" /> None of the above
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent34">
            <label >If you play sports, then do you play for intramural/club sports? If not, please select none of the above.</label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt50" value="0" /> Badminton
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt51" value="1" /> Basketball
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt52" value="2" /> Billiards
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt53" value="3" /> Bowling
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt54" value="4" /> Frisbee Golf
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt156" value="5" /> Flag Football
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt157" value="6" /> Kickball
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt158" value="7" /> Mini Golf
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt159" value="8" /> Rugby
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt160" value="9" /> Soccer
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt161" value="10" /> Softball
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt162" value="11" /> Tennis
            </label>

            <label class="form-control">
            <input type="checkbox" name="34" id="opt163" value="12" /> Volleyball
            </label>
            
            <label class="form-control">
            <input type="checkbox" name="34" id="opt275" value="13" /> None of the above
            </label>

            </div>
            
            <div class="form-group" id="parent107">
									<label >Please select your preferred timing to receive messages from SmarTrek</label>
									<table class="TableBorder">
									    <tr>
										<th class="TableBorder">
										
										<th class="TableBorder"> <label>8.00 AM -9.15 AM</label>
										
										<th class="TableBorder"> <label>9.30 AM - 10.45 AM</label>
										
										<th class="TableBorder"> <label>11.00 AM - 12.15 PM</label>
										
										<th class="TableBorder"> <label>12.30 PM - 1.45 PM</label>
										
										<th class="TableBorder"> <label>2.00 PM - 3.15 PM</label>
										
										<th class="TableBorder"> <label>3.30 PM - 4.45 PM</label>
										
										<th class="TableBorder"> <label>5.00 PM - 6.15 PM</label>
										
										<th class="TableBorder"> <label>6.30 PM - 7.45 PM</label>
										
										<th class="TableBorder"> <label>8.00 PM - 9.15 PM</label>
										
										
										<tr>
										<td class="TableBorder">
											<label for="241">Monday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub241" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="242">Tuesday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub242" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="243">Wednesday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub243" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="244">Thursday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub244" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="245">Friday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub245" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="246">Saturday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub246" id=opt"284" value="8" />
											
										
										<tr>
										<td class="TableBorder">
											<label for="247">Sunday</label>
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"276" value="0" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"277" value="1" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"278" value="2" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"279" value="3" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"280" value="4" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"281" value="5" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"282" value="6" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"283" value="7" />
											
											<td class="TableBorder Center"> <input type="radio" name="sub247" id=opt"284" value="8" />
											
										
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
            <input type="number" class="form-control" id="67">
            </div>

            <div class="form-group RoundedCorner" id="parent68">
            <label for="68">If you engaged in unprotected sex, how many encounters were with a person who was high on some substance (including alcohol)?</label>
            <input type="number" class="form-control" id="68">
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

            <!-- <div class="form-group RoundedCorner" id="parent70">
            <label for="70">Tell me about your family (married/divorced; siblings; parents thoughts on the incidents):</label>
            <input type="text" class="form-control" id="70">
            </div> -->

            <div class="form-group RoundedCorner" id="parent17">
            <label >How many of your blood relatives have now, or had in the past, what you would consider an alcohol or drug

            use problem?</label>
            <table class="SubQuestion">

            <tr>
            <td>
            <label for="9">Grandparents</label>
            <td>
            <input type="number" class="form-control" id="sub9">


            <tr>
            <td>
            <label for="8">brothers and Sisters</label>
            <td>
            <input type="number" class="form-control" id="sub8">


            <tr>
            <td>
            <label for="10">Uncle or Aunts</label>
            <td>
            <input type="number" class="form-control" id="sub10">


            <tr>
            <td>
            <label for="7">Parents</label>
            <td>
            <input type="number" class="form-control" id="sub7">


            </table>
            </div>

            <div class="form-group RoundedCorner" id="parent71">
            <label for="71">At what age did you take your first drink ?</label>
            <input type="number" class="form-control" id="71">
            </div>

            <div class="form-group RoundedCorner" id="parent72">
            <label >Any previous alcohol or drug sanctions? If you choose no, please ignore following six questions.</label>

            <label class="form-control">
            <input type="radio" name="72" id="opt168" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="72" id="opt169" value="1" /> no
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent73">
            <label for="73">Please explain the incident</label>
            <input type="text" class="form-control" id="73">
            </div>

            <div class="form-group RoundedCorner" id="parent74">
            <label for="74">Date of Incident</label>
            <input type="text" class="form-control" id="74">
            </div>

            <div class="form-group RoundedCorner" id="parent75">
            <label >Type of Violation</label>

            <label class="form-control">
            <input type="radio" name="75" id="opt175" value="0" /> Alcohol
            </label>

            <label class="form-control">
            <input type="radio" name="75" id="opt176" value="1" /> Marijuana
            </label>

            <label class="form-control">
            <input type="radio" name="75" id="opt178" value="3" /> Alcohol and Marijuana
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent76">
            <label >Was your Blood Alcohol Concentration (BAC) taken?</label>

            <label class="form-control">
            <input type="radio" name="76" id="opt180" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="76" id="opt181" value="1" /> no
            </label>

            </div>

            <div class="form-group RoundedCorner" id="parent77">
            <label for="77">If so, what was your BAC percentage ?</label>
            <input type="number" class="form-control" id="77">
            </div>

            <div class="form-group RoundedCorner" id="parent78">
            <label >Did you get transported to the hospital?</label>

            <label class="form-control">
            <input type="radio" name="78" id="opt182" value="0" /> yes
            </label>

            <label class="form-control">
            <input type="radio" name="78" id="opt183" value="1" /> no
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
