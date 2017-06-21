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

</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/survey.js"></script>
	<%
		User user = (User) request.getAttribute("user");
	%>

	<div class="Center">
		<h1><%=user.getFirstName()%>'s Strategies Setting Feature/Develop
			a Plan
		</h1>
	</div>

	<br>
	<br>
	<h2>I. Consider Your Options</h2>
	<br>
	<br> The bottom line is that indulging on the alcohol front can
	start to have a negative effect in many areas of our life. A simple way
	to improve your day to day appearance and mood is to drink responsibly.
	Taking a few simple steps to make sure you're not overdoing it is all
	it takes. Why not try dropping a glass size this year?

	<br>
	<p>
		Now that you have some information on how much you've been drinking,
		how much alcohol it takes to get to various BACs, and what effect
		various BACs have on your behavior, you may decide to set a goal for
		yourself. In this section are ways of examining what you stand to gain

		from setting goals, and suggestions for useful strategies to succeed.

		What is a realistic and responsible level of drinking for you? Only
		you can decide. You may wish to think about what you would like to get
		out of drinking, as well as what you would like to avoid. Now is a
		time to review what you stand to gain from moderating your alcohol
		use. Do you wish to eliminate hangovers? To avoid being embarrassed in
		front of friends? To keep from gaining weight from empty calories? To
		avoid developing a pattern of drinking and a tolerance for alcohol
		that requires a lot of drinks (lots of money) to have a good time?
		Avoid all the long-term hazards of drinking? <br>
	<p>
		Maybe you wish to enjoy one or two drinks, feel a mild and pleasant
		relaxing effect, and maintain your control. You may wish to have
		little tolerance for alcohol so that one or two drinks will be enough.
		You may wish to abstain from alcohol altogether. Whatever your goal
		is, it's up to you entirely. <br>
	<p>
		Some individuals do not feel that they have a "problem" with drinking,
		and therefore see no reason to set a goal or limit. We wish to
		emphasize that appropriate drinking limits are good for everyone who
		drinks. Examine your drinking levels and style, and experiment with
		trying a new limit based on BAC levels. Choose a limit minimize the
		negative consequences. <br> <br>
	<h2>II. What is getting in the way of changing</h2>
	<br>
	<br> Before you set up your goals Jane xxx, it would be helpful to
	understand both what you like about drinking and don’t like, the “good
	things and the not-so-good things” about drinking. Take a moment and
	think aobut what you like about drinking. To move the Drinking
	GoalsDrinking Goals item, click and drag it into or out of your list.
	You can add your own “good things” by typing them in a text box.
</body>
</html>
