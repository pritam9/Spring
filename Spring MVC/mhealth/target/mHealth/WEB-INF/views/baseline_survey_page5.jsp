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
        src="resources/js/survey_page5.js"></script>
        <script src="resources/js/form_validation.js"></script>

        <!-- <div class="Center"><h1>mHealth Feedback Survey</h1></div> -->
        <%  ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");%>
		
		<% 
		boolean canShow = false;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = questions.indexOf(new Question(100));

		for(SubQuestion sq : questions.get(index).getSubquestions()) {
			map.put(sq.getId(), sq.getAnswer());
			if(sq.getAnswer() != null && sq.getAnswer().equals("1")){
				canShow = true;
			}
		}
		%>
        <form role="form">




            <div class="form-group survey_heading" id="parent102">
            <label style="font-size: 22px;margin-top: 10px; width: 100%">B-YAACQ</label>
            </div>

            <div class="form-group" id="parent103">
            <label >You indicated that the following happened to you within the past year. Next to each item below, please indicate approximately how many times each of the following happened to you in the past year, either while you were drinking or as a result of your drinking.</label>
            <table class="TableBorder">
            <tr>
            <th class="TableBorder">

            <th class="TableBorder"> <label>1-2 times</label>

            <th class="TableBorder"> <label>3-4 times</label>

            <th class="TableBorder"> <label>5-9 times</label>

            <th class="TableBorder"> <label>10 or more times</label>
            
            <% 
	            String answer = map.get(180);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="204">While drinking, I have said or done embarrassing things.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub204" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub204" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub204" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub204" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(181);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="205">I have had a hangover (headache, sick stomach) the morning after I had been drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub205" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub205" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub205" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub205" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(182);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="206">I have felt very sick to my stomach or thrown up after drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub206" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub206" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub206" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub206" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(183);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="207">I often have ended up drinking on nights when I had planned not to drink.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub207" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub207" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub207" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub207" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(184);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="208">I have taken foolish risks when I have been drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub208" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub208" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub208" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub208" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(185);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="209">I have passed out from drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub209" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub209" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub209" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub209" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(186);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="210">I have found that I needed larger amounts of alcohol to feel any effect, or that I could no longer get high or drunk on the amount that used to get me high or drunk.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub210" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub210" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub210" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub210" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(187);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="211">When drinking, I have done impulsive things that I regretted later.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub211" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub211" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub211" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub211" id=opt"268" value="3" />
            
            <% } %>
            
            <% 
	            answer = map.get(188);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="212">I’ve not been able to remember large stretches of time while drinking heavily.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub212" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub212" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub212" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub212" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(189);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="213">I have driven a car when I knew I had too much to drink to drive safely.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub213" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub213" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub213" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub213" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(190);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="214">I have not gone to work or missed classes at school because of drinking, a hangover, or illness caused by drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub214" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub214" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub214" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub214" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(191);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="215">My drinking has gotten me into sexual situations I later regretted.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub215" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub215" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub215" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub215" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(192);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="216">I have often found it difficult to limit how much I drink.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub216" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub216" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub216" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub216" id=opt"268" value="3" />

			<% } %>
            
            <% 
	            answer = map.get(193);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="217">I have become very rude, obnoxious or insulting after drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub217" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub217" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub217" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub217" id=opt"268" value="3" />
			<% } %>
            
            <% 
	            answer = map.get(194);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="218">I have woken up in an unexpected place after heavy drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub218" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub218" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub218" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub218" id=opt"268" value="3" />

			<% } %>
            
            <% 
	            answer = map.get(195);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="219">I have felt badly about myself because of my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub219" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub219" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub219" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub219" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(196);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="220">I have had less energy or felt tired because of my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub220" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub220" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub220" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub220" id=opt"268" value="3" />
			<% } %>
            
            <% 
	            answer = map.get(197);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="221">The quality of my work or schoolwork has suffered because of my drinking.'</label>

            <td class="TableBorder Center"> <input type="radio" name="sub221" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub221" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub221" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub221" id=opt"268" value="3" />
			<% } %>
            
            <% 
	            answer = map.get(198);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="222">I have spent too much time drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub222" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub222" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub222" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub222" id=opt"268" value="3" />


            <% } %>
            
            <% 
	            answer = map.get(199);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="223">I have neglected my obligations to family, work, or school because of drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub223" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub223" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub223" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub223" id=opt"268" value="3" />
            <% } %>
            
            <% 
	            answer = map.get(200);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="224">My drinking has created problems between myself and my boyfriend/girlfriend/spouse, parents , or other near relatives.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub224" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub224" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub224" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub224" id=opt"268" value="3" />
            
            <% } %>
            
            <% 
	            answer = map.get(201);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="225">I have been overweight because of drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub225" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub225" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub225" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub225" id=opt"268" value="3" />

            
            
            <% } %>
            
            <% 
	            answer = map.get(202);
				if(answer != null && answer.equals("1")) {
            %>
            <tr>
            <td class="TableBorder">
            <label for="226">My physical appearance has been harmed by my drinking.</label>

            <td class="TableBorder Center"> <input type="radio" name="sub226" id=opt"265" value="0" />

            <td class="TableBorder Center"> <input type="radio" name="sub226" id=opt"266" value="1" />

            <td class="TableBorder Center"> <input type="radio" name="sub226" id=opt"267" value="2" />

            <td class="TableBorder Center"> <input type="radio" name="sub226" id=opt"268" value="3" />
            
            
            
            
            
			<% } %>
            
            <% 
	            answer = map.get(203);
				if(answer != null && answer.equals("1")) {
            %>
            
				<tr>
					<td class="TableBorder"><label for="227">I have felt
							like I needed a drink after I’d gotten up (that is, before
							breakfast).</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub227" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub227" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub227" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub227" id=opt "268" value="3" /> 
				<% } %>
				<% 
	            answer = map.get(248);
				if(answer != null && answer.equals("1")) {
           		 %>
				
				<tr>
					<td class="TableBorder"><label for="272">I have
							damaged property, or done something disruptive such as setting
							off a false fire alarm, or other things like that after drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub272" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub272" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub272" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub272" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(249);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="273">I have gotten
							into physical fights because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub273" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub273" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub273" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub273" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(250);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="274">I have
							injured someone else while drinking or intoxicated.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub274" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub274" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub274" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub274" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(251);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="275">I have felt
							anxious, agitated, or restless after stopping or cutting down on
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub275" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub275" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub275" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub275" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(252);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="276">I have had
							“the shakes” after stopping or cutting down on drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub276" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub276" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub276" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub276" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(253);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="277">I have
							received a lower grade on an exam or paper than I ordinarily
							could have because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub277" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub277" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub277" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub277" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(254);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="278">I have felt
							guilty about my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub278" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub278" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub278" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub278" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(255);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="279">I have had a
							blackout after drinking heavily (i.e., could not remember hours
							at a time)</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub279" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub279" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub279" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub279" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(256);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="280">While
							drinking, I have said harsh or cruel things to someone.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub280" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub280" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub280" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub280" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(257);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="281">I have been
							unhappy because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub281" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub281" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub281" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub281" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(258);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="282">I have tried
							to quit drinking because I thought I was drinking too much.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub282" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub282" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub282" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub282" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(259);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="283">I have
							awakened the day after drinking and found that I could not
							remember a part of the evening before.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub283" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub283" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub283" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub283" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(260);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="284">I have not
							had as much time to pursue activities or recreation because of
							drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub284" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub284" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub284" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub284" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(261);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="285">I have said
							things while drinking that I later regretted.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub285" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub285" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub285" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub285" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(262);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="286">I often have
							thought about needing to cut down or stop drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub286" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub286" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub286" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub286" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(263);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="287">I often drank
							more than I originally had planned.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub287" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub287" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub287" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub287" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(264);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="288">Because of my
							drinking, I have not slept properly.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub288" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub288" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub288" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub288" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(265);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="289">My
							boyfriend/girlfriend/spouse/parents have complained to me about
							my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub289" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub289" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub289" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub289" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(266);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="290">I have been
							less physically active because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub290" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub290" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub290" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub290" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(267);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="291">Because of my
							drinking, I have not eaten properly.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub291" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub291" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub291" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub291" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(268);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="292">I have gotten
							into trouble at work or school because of drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub292" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub292" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub292" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub292" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(269);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="293">I haven’t
							been as sharp mentally because of my drinking.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub293" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub293" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub293" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub293" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(270);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="294">As a result
							of drinking, I neglected to protect myself or my partner from a
							sexually transmitted disease, or unwanted pregnancy.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub294" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub294" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub294" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub294" id=opt "268" value="3" />
				<% } %>
				<% 
	            answer = map.get(271);
				if(answer != null && answer.equals("1")) {
           		 %>
				<tr>
					<td class="TableBorder"><label for="295">Drinking has
							made me feel depressed or sad.</label>
					<td class="TableBorder Center"><input type="radio"
						name="sub295" id=opt "265" value="0" />
					<td class="TableBorder Center"><input type="radio"
						name="sub295" id=opt "266" value="1" />
					<td class="TableBorder Center"><input type="radio"
						name="sub295" id=opt "267" value="2" />
					<td class="TableBorder Center"><input type="radio"
						name="sub295" id=opt "268" value="3" />
				<% } %>
				
			</table>
            </div>





        </form>
        <div style="text-align: center; margin: 10px">
        <h4 class="error-msg hide"></h4>
        <button onclick="return submitSurvey();" class="btn btn-primary">Next</button>
        </div>
        </body>
        </html>
