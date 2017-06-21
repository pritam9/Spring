<%@page import="com.uncc.mhealth.model.PF"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.uncc.mhealth.model.User"%>
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
<% try{ %>

<%  
		User user = (User) request.getAttribute("user");
		PF pf = (PF) request.getAttribute("pf");
		DecimalFormat df = new DecimalFormat(".###");
		df.setRoundingMode(RoundingMode.CEILING);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<style type="text/css">
@media print {
	.feedback_header, .printWhite{
		color:white !important;
	}
	.printOrange{
		color:orange !important;
	}
}
.rotate90 {
    -webkit-transform: rotate(-90deg);
    -moz-transform: rotate(-90deg);
    -o-transform: rotate(-90deg);
    -ms-transform: rotate(-90deg);
    transform: rotate(-90deg);
}

</style>
<link
	href="resources/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- Custom CSS -->
    <link href="resources/css/survey.css" rel="stylesheet">
	<script>var token = '<c:out value="${user.token}"/>';</script>
	<script>var alcoholUsage = '<c:out value="${pf.alcoholUsage}"/>';</script>
	<script>var averageDrink = '<c:out value="${pf.averageDrink}"/>';</script>
	<script>var total = '<c:out value="${pf.total}"/>';</script>
	<script>var alpha = '<c:out value="${pf.alpha}"/>';</script>
	<script>var gender = '<c:out value="${pf.gender}"/>';</script>
	<script>var maxTotal = '<c:out value="${pf.maxTotal}"/>';</script>
</head>
<body style="padding: 10px">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.min.js"></script>
		<script
		src="resources/js/feedback.js"></script>
		
    <div class="col-xs-offset-1 col-xs-10 col-xs-offset-1"><div class="Center"><h1><%= user.getFirstName()%>'s Personalized Feedback</h1></div>  </div>

        <br><br><div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5"><h4>This Project is designed to assist you in examining your drinking and marijuana use in a safe and accepting environment. Your responses to the survey and this feedback report are confidential and are available only to you and your MI Coach.</h4></div>
		<br><br>   
	
	    <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
		<h4 class="feedback_header" id="FREQUENCY">Your Frequency of Drinking</h4></div>
		
		<br><br>
        <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
		<h5>You typically drink alcohol on <span class="dynamic_field"><%= pf.alcoholUsage %> days per month</span>, which puts you the <span class="dynamic_field"><%= pf.alcoholPercentile %>th percentile</span>. That means that you drink as or more frequently than <span class="dynamic_field"><%= pf.alcoholPercentile %>%</span> of UNC Charlotte Students</h5>
            </div>
		
		<br><br>
		<div class="col-xs-8">
			<canvas id="freqDrinkingChart"></canvas>
        </div>
		
		<br><br>
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
		<h4 class="feedback_header" id="QUANTITY">Your Quantity of Drinking</h4>
            </div>
		<br><br>
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
		<h5>You drink an average of <span class="dynamic_field"><%= pf.averageDrink%> drink per occasion</span>, which puts you in the <span class="dynamic_field"><%= pf.drinkPercentile%>th percentile</span>. That  means that you drink as many or more drinks than <span class="dynamic_field"><%= pf.drinkPercentile%>%</span> of UNC Charlotte students.
		</h5>
            </div>
		<br><br>
            <div class="col-xs-8">
		<canvas id="quantityDrinkingChart"></canvas>
            </div>
	
	<br><br>
	
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
		<h4 class="feedback_header" id="DRINKSUMMARY">Summary of Your Drinking Patterns</h4>
            </div>
		<!-- <th style="background: #535353; color: white">Your Pattern of Marijuana Use</th> -->
		<br><br>
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
			<ul>
				<li>Average number of drinks you consume in a typical week: <span class="dynamic_field"><%= pf.total%></span></li>
				<%-- <li>Average number of drinks you consume in a typical month: <span class="dynamic_field"><%= (averageDrink*4)%></span></li> --%>
				<li>Highest number of drinks you consumed on one occasion in the past 30 days: <span class="dynamic_field"><%= pf.maxTotal%></span></li>
				<!-- <li>Amount of money you spend on alcohol in a typical month: $XX</li>
				<li>Your approximate annual expenditure for alcohol: $XX</li> -->
			</ul>
            </div>
		
		<!-- <td>
			You use marijuana on approximately XX days month, which puts you in the XXth percentile. That means your marijuana use is as or more frequent than XX% of UNC Charlotte students.
		</td> -->
	<%-- <% System.out.println("jsp: CEA"); %> --%>
        <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<br><br><h4 class="feedback_header" id="CEA">How You Feel About Your Alcohol Experiences</h4>
	<br><br><h5>You indicated that you are likely to experience the following when you drink alcohol. Then you rated the acceptability of these experiences.</h5>
	<br><br>
        </div>
		
        <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<table border="1">
	<tr>
	<th>Item List</th>
	<th>Disagree</th>
	<th>Slightly Disagree</th>
	<th>Slightly Agree</th>
	<th>Agree</th>
	<% for(SubQuestion sq : pf.getCea1().getSubquestions()) {%>
	<tr>
	<%
	String color0 = "white";
	String color1 = "white";
	String color2 = "white";
	String color3 = "white";
	if(sq.getAnswer() != null){
		if(sq.getAnswer().equals("1")){
			color1 = "yellow";
		} else if(sq.getAnswer().equals("2"))	{
			color2 = "yellow";
		} else if(sq.getAnswer().equals("3"))	{
			color3 = "yellow";
		} else {
			color0 = "yellow";
		}
	}
	
	%>
	<td><%= sq.getText() %></td>
	<% String color = "yellow"; %>
	<td style="background : <%= color0%>">1</td>
	<td style="background : <%= color1%>">2</td>
	<td style="background : <%= color2%>">3</td>
	<td style="background : <%= color3%>">4</td>
	<% } %>
	
	</table>
        <p></p>
        </div>
        
	<br><br>
        <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<table border="1">
	<tr>
	<th>Item List</th>
	<th>Bad</th>
	<th>Slightly Bad</th>
	<th>Neutral</th>
	<th>Slightly Good</th>
	<th>Good</th>
	<% for(SubQuestion sq : pf.getCea2().getSubquestions()) {%>
	<tr>
	<%
	String color1 = "white";
	String color2 = "white";
	String color3 = "white";
	String color4 = "white";
	String color0 = "white";
	if(sq.getAnswer() != null){
		if(sq.getAnswer().equals("1")){
			color1 = "yellow";
		} else if(sq.getAnswer().equals("2"))	{
			color2 = "yellow";
		} else if(sq.getAnswer().equals("3"))	{
			color3 = "yellow";
		} else if(sq.getAnswer().equals("4"))	{
			color4 = "yellow";
		} else {
			color0 = "yellow";
		}
	}
	
	%>
	<td><%= sq.getText() %></td>
	<% String color = "yellow"; %>
	<td style="background : <%= color0%>">1</td>
	<td style="background : <%= color1%>">2</td>
	<td style="background : <%= color2%>">3</td>
	<td style="background : <%= color3%>">4</td>
	<td style="background : <%= color4%>">5</td>
	
	<% } %>
	
	</table>
        </div>
	
	<%-- <% System.out.println("jsp: BAC"); %> --%>
	<br><br>
        <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<h4 class="feedback_header" id="BAC">Blood Alcohol Concentration (BAC)</h4>
	<h5><%= user.getFirstName()%>, according to the information you provided in the Surveys about your typical quantity of alcohol use, hours of use, your birth sex, and your weight, your peak and typical BAC during the last 30 days were calculated.</h5>
	<br><br>
	<h5>Your BAC in a typical week  (<span class="dynamic_field"><%= pf.typicalBAC%></span>) was based on: <span class="dynamic_field"><%= pf.firstDrink%> drinks in <%= pf.firstDrinkHours%> hours</span></h5>
	<br><h5>Your Peak BAC (<span class="dynamic_field"><%= pf.peakBAC%></span>) was based on: <span class="dynamic_field"><%= pf.maxTotal%> drinks in <%= pf.maxHours%> hours</span></h5>
	<br><br>
	<h4>How Does BAC Affect How We Feel and Behave?</h4>
	<img src="resources/images/brain.png">
	<br><br>
	<h4 id="BIPHASIC">Biphasic Effect of Alcohol</h4>
        
	<img src="resources/images/biphasic_effects.png">
        </div>
	<!-- <br><br>
	<img src="resources/images/bac1.png"> -->
	<br><br>
	
	<div style="max-width: 100%;">
	<div style="padding: 10px; background: black; color: white; display: inline-block;" id="BACCHART">
		<div><h4 class="printWhite"><%= pf.genderString%> <%= pf.weight%> lbs <span class="printOrange" style="color: orange; font-size: 30px">Blood Alcohol Concentration</span></h4></div>
	<table>
	<tr>
		<td colspan="2" style="text-align:center;">Hours</td>
	</tr>
	<tr>
		<td style="width:88px;" class="rotate90">No of Drinks</td>
		<td><table border="1" bordercolor="black">
			<tr>
				<th style="background: white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<%  for (int i = 1; i <= 13; i++) { %>
				<th style="background: lightgray"> <%= i%></th>
				<% } %>
			</tr>
			<% for(int hours = 0; hours <= 8; hours++){ %>	
			<tr>
				
				<% 
				String alternateColor = "white";
				if((hours % 2) == 0) {
						alternateColor = "lightgray";
					}
				%>
				
				<td style="background : <%= alternateColor%>; color: black"> <%= hours%></td>
				<%  for (int drinks = 1; drinks <= 13; drinks++) {
						double a = 	drinks * 12 * 0.05;
						double bac = (a * 5.14/( pf.getWeight() * pf.r)) - 0.015 * hours;
						if(bac < 0){
							bac = 0;
						}
						String color = "white";
						if(bac <= 0.059){
							color = "green";
						} else if(bac <= 0.139){
							color = "orange";
						} else if(bac <= 0.240){
							color = "red";
						} else {
							color = "grey";
						}
						
						String bacFormatted = df.format(bac);
				%>	
				<td style="background : <%= color%>"> <%= bacFormatted%></td>
				<% } %>
				</tr>
			<% } %>
		</table>
		</td>
	</tr>
	</table>
	</div>
                    
	<br><br>
	<img src="resources/images/bac2.png">
	<br><br>
	<h4 id="SOBERING">Sobering Up: The Elimination of Alcohol From Your Body</h4>
	<br>
	<h5>Alcohol leaves the body at a constant rate of about .015% of BAC per hour for most people. Activities like taking a shower, drinking coffee, or exercising will NOT affect how fast alcohol is eliminated from your body. Only time will sober you up.</h5>
                    
	<ul>
	
	
		<li>At your PEAK BAC of <span class="dynamic_field"><%= pf.peakBAC%></span>, it will take <span class="dynamic_field"><%= pf.peakSober%> hours</span> until you are sober.</li>
		<li>At your TYPICAL BAC of <span class="dynamic_field"><%= pf.typicalBAC%></span>, it will take <span class="dynamic_field"><%= pf.typicalSober%> hours</span> until you are sober.</li>
	</ul>
	<br><br>
	<h4>Change in BAC on Your Highest Drinking Occasion</h4>
	<br><br>
	<div class="col-xs-8">
		<canvas id="bacChangesChart"></canvas>
	</div>
	</div>
	<br><br>
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5"><h4 class="feedback_header" id="NUTRITION">Alcohol and Your Nutrition</h4> 
	<br>
	<h5>Based on an average of 150 to 250 calories per standard drink, you consume about <span class="dynamic_field"><%= pf.maxAlcoholCal1%> to <%= pf.maxAlcoholCal2%>  calories</span> in a typical day from alcohol alone.</h5>
	<br>
	<% String gType = (pf.gender.equals("0") ? "male" : "female"); %>
	<h5>This represents <span class="dynamic_field"><%= pf.maxAlcoholPercent1%>% to <%= pf.maxAlcoholPercent2%>% </span> of the monthly calorie requirement. However, the calories provided by alcohol have no nutritional value.</h5>
	<br><br>
	 <div class="col-xs-4" style="padding-bottom:10px;">
	<h4>150 Calories per Drink</h4>
	<canvas id="alcoholNutritionChart" ></canvas>
	</div >
	<div class="col-xs-4" style="padding-bottom:10px;">
	<h4>250 Calories per Drink</h4>
	<canvas id="alcoholNutritionChart2"></canvas>
	</div>
	<br><br>
	<br>
	<img src="resources/images/sleep_effects.png" id="SLEEP">
	<br><br>
	<h4 class="feedback_header" id="BYAACQ">Your Problems From Alcohol Use</h4>
	<br><h5>Listed below are the problems you reported on the survey which resulted from your drinking during the past year. Your score reflects your risk for future problems related to alcohol.</h5>
	<br><br>
        </div>
        
                    <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">

	<table border="1">
		<tr>
			<th>Problems from drinking</th>
			<th>Experiences in the past 12 months include</th>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
					<td>None(0)</td>
					<td>Your Score is <span class="dynamic_field"><%= pf.byaacqScore%></span></td>
					</tr>
					<tr>
					<td>Low(1-4)</td>
					<td></td>
					</tr>
					<tr>
					<td>Moderate(5-9)</td>
					<td></td>
					</tr>
					<tr>
					<td>Significant(10-14)</td>
					<td></td>
					</tr>
					<tr>
					<td>Severe(15-20)</td>
					<td></td>
					</tr>
					<tr>
					<td>Very Severe (21-24)</td>
					<td></td>
					</tr>
					<tr>
					<td>Scale</td>
					<td></td>
					</tr>
				</table>
			</td>
			<td>
				<ul>
					<% if(pf.getByaacq()!= null) {
					      for(SubQuestion sq : pf.getByaacq().getSubquestions()) {
							String ans = sq.getAnswer();
							String times = null;
							if(ans != null){
								if(ans.equals("4")){
									times = "0 times";
								}else if(ans.equals("0")){
									times = "1-2 times";
								} else if(ans.equals("1")){
									times = "3-4 times";
								} else if(ans.equals("2")){
									times = "5-9 times";
								} else {
									times = "10 or more times";
								}
							}
							if(times != null){
					%>
					<li><%= sq.getText()%> <%= times%>
					<%} } }%>
				</ul>
			</td>
		</tr>

	</table>
                </div>
	<br><br>
                <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<h4 class="feedback_header" id="AUDIT">Your Risk for Alcohol-Related Problems</h4>
	<br><img src="resources/images/audit_score.png">
	<br><br>
	<h4 class="feedback_header">The Alcohol Use Disorders Identification Test (AUDIT)</h4>
	<br><h5>In the Survey, you completed the AUDIT screening test which estimated your risk for alcohol-related problems.</h5>
	<br><br>
	<h4>Your Risk Score on the AUDIT was <span class="dynamic_field"><%= pf.auditScore %>  (<%= pf.auditRisc %>)</span></h4>
	<br><h4>Here are the specific responses from your screening which contributed to your score:</h4>
	<br>
	<ul>
		<%
			for(String detail : pf.auditPoints){
		%>
		<li> <%= detail%>
		<% } %>
		
	</ul>
	<!-- <br><img src="resources/images/continum.png"> -->
	<br><br>
	<h4 class="feedback_header" id="RISK">Genetic Risk Factors</h4>
	<h5>Family history affects your risk for dependence on alcohol. Based on your responses to this survey section, your genetic risk level is:  <span class="dynamic_field"><%= pf.geneticRisk %></span>
	<br><br>Genetics are not destiny, but alcohol use problems tend to run in families. Children, siblings, or parents of alcoholics have been estimated to have a seven times greater chance of developing alcoholism than the general population. This risk increases for male relatives of male alcoholics. For men in the general population, without any family history, the risk of developing alcoholism is between 3% to 5%. For sons of alcoholic fathers, the chance of developing alcoholism has been estimated to be as high as 20% to 50%.

	<br><br>Many people ask if these statistics are a product of nature (genetics) or nurture (the home environment). The answer is both. Research shows that being raised in an environment where alcohol is abused increases a child’s chance of becoming alcohol dependent. In other studies, children of alcoholics, who were adopted at birth and raised in non-alcoholic households, are two to three times more likely than their counterparts to develop alcohol dependency regardless of their home environment. Finally, remember that even if no one in your family has had an alcohol or other drug  problem that does not mean that you are immune from experiencing one.
	</h5>
	

	<br><br>
	<h4 class="feedback_header" id="RULER">Your Feeling about Making a Change</h4><br>
	<h5>Your readiness to make changes in your alcohol use is function of importance you place on changing and your confidence that you could make changes</h5><br>
            </div>
            <div class="col-xs-offset-0.5 col-xs-11 col-xs-offset-0.5">
	<table border="1">
	
	<tr>
	<td colspan="10">On the survey, you indicated how important it was for you to make a change in your drinking.
	
	<% if (pf.ruler1 != null) {%>
	<% for(SubQuestion sq : pf.ruler1.getSubquestions()) {%>
	<tr>
	<%
	String color1 = "white";
	String color2 = "white";
	String color3 = "white";
	String color4 = "white";
	String color5 = "white";
	String color6 = "white";
	String color7 = "white";
	String color8 = "white";
	String color9 = "white";
	String color10 = "white";
	if(sq.getAnswer() != null){
		if(sq.getAnswer().equals("0")){
			color1 = "yellow";
		} else if(sq.getAnswer().equals("1"))	{
			color2 = "yellow";
		} else if(sq.getAnswer().equals("2"))	{
			color3 = "yellow";
		} else if(sq.getAnswer().equals("3"))	{
			color4 = "yellow";
		} else if(sq.getAnswer().equals("4"))	{
			color5 = "yellow";
		} else if(sq.getAnswer().equals("5"))	{
			color6 = "yellow";
		} else if(sq.getAnswer().equals("6"))	{
			color7 = "yellow";
		} else if(sq.getAnswer().equals("7"))	{
			color8 = "yellow";
		} else if(sq.getAnswer().equals("8"))	{
			color9 = "yellow";
		} else if(sq.getAnswer().equals("9"))	{
			color10 = "yellow";
		}
	}
	
	%>
	<td style="background : <%= color1%>">1</td>
	<td style="background : <%= color2%>">2</td>
	<td style="background : <%= color3%>">3</td>
	<td style="background : <%= color4%>">4</td>
	<td style="background : <%= color5%>">5</td>
	<td style="background : <%= color6%>">6</td>
	<td style="background : <%= color7%>">7</td>
	<td style="background : <%= color8%>">8</td>
	<td style="background : <%= color9%>">9</td>
	<td style="background : <%= color10%>">10</td>
	
	<% } %>
	<% } %>
	
	<tr>
	<td colspan="4">Not Important
	<td>Unsure
	<td colspan="5">Very Important
	
	
	<tr>
	<td colspan="10">On the survey, you indicated how confident you were than you could make a change in your drinking.
	
	<% if (pf.ruler2 != null) {%>
	<% for(SubQuestion sq : pf.ruler2.getSubquestions()) {%>
	<tr>
	<%
	String color1 = "white";
	String color2 = "white";
	String color3 = "white";
	String color4 = "white";
	String color5 = "white";
	String color6 = "white";
	String color7 = "white";
	String color8 = "white";
	String color9 = "white";
	String color10 = "white";
	if(sq.getAnswer() != null){
		if(sq.getAnswer().equals("0")){
			color1 = "yellow";
		} else if(sq.getAnswer().equals("1"))	{
			color2 = "yellow";
		} else if(sq.getAnswer().equals("2"))	{
			color3 = "yellow";
		} else if(sq.getAnswer().equals("3"))	{
			color4 = "yellow";
		} else if(sq.getAnswer().equals("4"))	{
			color5 = "yellow";
		} else if(sq.getAnswer().equals("5"))	{
			color6 = "yellow";
		} else if(sq.getAnswer().equals("6"))	{
			color7 = "yellow";
		} else if(sq.getAnswer().equals("7"))	{
			color8 = "yellow";
		} else if(sq.getAnswer().equals("8"))	{
			color9 = "yellow";
		} else if(sq.getAnswer().equals("9"))	{
			color10 = "yellow";
		}
	}
	
	%>
	<td style="background : <%= color1%>">1</td>
	<td style="background : <%= color2%>">2</td>
	<td style="background : <%= color3%>">3</td>
	<td style="background : <%= color4%>">4</td>
	<td style="background : <%= color5%>">5</td>
	<td style="background : <%= color6%>">6</td>
	<td style="background : <%= color7%>">7</td>
	<td style="background : <%= color8%>">8</td>
	<td style="background : <%= color9%>">9</td>
	<td style="background : <%= color10%>">10</td>
	
	<% } %>
	<% } %>
	
	<tr>
	<td colspan="4">Not Confident
	<td>Unsure
	<td colspan="5">Very Confident
	
	</table>
	
	<br><br>
	<h4 class="feedback_header" id="PSS">Your Protective Behaviors Strategies: Alcohol</h4>
	<br><h5>You identified some Protective Behaviors Strategies that you are already implementing or that you would consider trying. </h5>
	<br><br>
	<table border="1" >
	<tr>
		<th>Never</th>
		<th>Rarely</th>
		<th>Occasionally</th>
        </tr>
        
	
	<tr>
		<td>
		<ul>
		<% for(String str : pf.pssNever){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
		<td>
		<ul>
		<% for(String str : pf.pssRarely){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
		<td>
		<ul>
		<% for(String str : pf.pssOccasionally){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
                    </tr>
            <tr>
		<th>Sometimes</th>
		<th>Usually</th>
		<th>Always</th>
		
	</tr>
            <tr>
		<td>
		<ul>
		<% for(String str : pf.pssSometimes){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
		<td>
		<ul>
		<% for(String str : pf.pssUsually){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
		<td>
		<ul>
		<% for(String str : pf.pssAlways){ %>
				<li> <%= str%>
		<% } %>
		</ul>
		</td>
		

	</tr>
	</table>
                    </div>
	
	
	
	<%-- <% System.out.println("jsp: END"); %> --%>
	<% } catch(Exception e){
			response.getWriter().println("Please fill survey completely before viewing feedback");
			e.printStackTrace();
		} 
	%>
</body>
</html>