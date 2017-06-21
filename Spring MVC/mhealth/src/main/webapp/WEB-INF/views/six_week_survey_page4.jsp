
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
<link href="resources/css/survey.css" rel="stylesheet">
<script>
	var token = '<c:out value="${user.token}"/>';
</script>
<script>
	var survey = '<c:out value="${survey}"/>';
</script>

</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/survey_page4.js"></script>
	<script src="resources/js/form_validation.js"></script>

	<div class="Center">
		<h1>mHealth Feedback Survey</h1>
	</div>
	<%
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
	%>


	<form role="form">


		<div class="form-group" id="parent101">
			<label style="font-size: 22px; margin-top: 10px;">Alcohol-Related
				Consequences</label>
		</div>

		<div class="form-group" id="parent100">
			<label>Below is a list of things that sometimes happen to
				people either during, or after they have been drinking alcohol. Next
				to each item below, please mark an “X” in either the YES or NO
				column to indicate whether that item describes something that has
				happened to you IN THE PAST MONTH. </label>
			<table class="TableBorder">
				<tr>
					<th class="TableBorder">
					<th class="TableBorder"><label>No</label>
					<th class="TableBorder"><label>Yes</label>
				<tr>
					<td class="TableBorder"><label for="180">While
							drinking, I have said or done embarrassing things.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub180" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub180" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="181">I have had a
							hangover (headache, sick stomach) the morning after I had been
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub181" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub181" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="182">I have felt
							very sick to my stomach or thrown up after drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub182" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub182" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="183">I often have
							ended up drinking on nights when I had planned not to drink.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub183" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub183" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="184">I have taken
							foolish risks when I have been drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub184" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub184" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="185">I have passed
							out from drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub185" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub185" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="186">I have found
							that I needed larger amounts of alcohol to feel any effect, or
							that I could no longer get high or drunk on the amount that used
							to get me high or drunk.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub186" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub186" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="187">When
							drinking, I have done impulsive things that I regretted later.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub187" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub187" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="188">I’ve not been
							able to remember large stretches of time while drinking heavily.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub188" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub188" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="189">I have driven
							a car when I knew I had too much to drink to drive safely.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub189" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub189" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="190">I have not
							gone to work or missed classes at school because of drinking, a
							hangover, or illness caused by drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub190" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub190" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="191">My drinking
							has gotten me into sexual situations I later regretted.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub191" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub191" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="192">I have often
							found it difficult to limit how much I drink.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub192" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub192" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="193">I have become
							very rude, obnoxious or insulting after drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub193" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub193" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="194">I have woken
							up in an unexpected place after heavy drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub194" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub194" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="195">I have felt
							badly about myself because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub195" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub195" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="196">I have had
							less energy or felt tired because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub196" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub196" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="197">The quality
							of my work or schoolwork has suffered because of my drinking.'</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub197" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub197" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="198">I have spent
							too much time drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub198" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub198" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="199">I have
							neglected my obligations to family, work, or school because of
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub199" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub199" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="200">My drinking
							has created problems between myself and my
							boyfriend/girlfriend/spouse, parents , or other near relatives.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub200" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub200" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="201">I have been
							overweight because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub201" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub201" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="202">My physical
							appearance has been harmed by my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub202" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub202" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="203">I have felt
							like I needed a drink after I’d gotten up (that is, before
							breakfast).</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub203" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub203" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="248">I have
							damaged property, or done something disruptive such as setting
							off a false fire alarm, or other things like that after drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub248" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub248" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="249">I have gotten
							into physical fights because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub249" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub249" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="250">I have
							injured someone else while drinking or intoxicated.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub250" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub250" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="251">I have felt
							anxious, agitated, or restless after stopping or cutting down on
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub251" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub251" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="252">I have had
							“the shakes” after stopping or cutting down on drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub252" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub252" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="253">I have
							received a lower grade on an exam or paper than I ordinarily
							could have because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub253" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub253" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="254">I have felt
							guilty about my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub254" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub254" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="255">I have had a
							blackout after drinking heavily (i.e., could not remember hours
							at a time)</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub255" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub255" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="256">While
							drinking, I have said harsh or cruel things to someone.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub256" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub256" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="257">I have been
							unhappy because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub257" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub257" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="258">I have tried
							to quit drinking because I thought I was drinking too much.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub258" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub258" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="259">I have
							awakened the day after drinking and found that I could not
							remember a part of the evening before.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub259" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub259" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="260">I have not
							had as much time to pursue activities or recreation because of
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub260" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub260" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="261">I have said
							things while drinking that I later regretted.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub261" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub261" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="262">I often have
							thought about needing to cut down or stop drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub262" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub262" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="263">I often drank
							more than I originally had planned.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub263" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub263" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="264">Because of my
							drinking, I have not slept properly.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub264" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub264" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="265">My
							boyfriend/girlfriend/spouse/parents have complained to me about
							my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub265" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub265" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="266">I have been
							less physically active because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub266" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub266" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="267">Because of my
							drinking, I have not eaten properly.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub267" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub267" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="268">I have gotten
							into trouble at work or school because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub268" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub268" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="269">I haven’t
							been as sharp mentally because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub269" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub269" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="270">As a result
							of drinking, I neglected to protect myself or my partner from a
							sexually transmitted disease, or unwanted pregnancy.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub270" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub270" id=opt "264" value="1" />
				<tr>
					<td class="TableBorder"><label for="271">Drinking has
							made me feel depressed or sad.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub271" id=opt "263" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub271" id=opt "264" value="1" />
			</table>
		</div>

	</form>
	<div style="text-align: center; margin: 10px">
		<h4 class="error-msg hide"></h4>
		<button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
	</div>
</body>
</html>
