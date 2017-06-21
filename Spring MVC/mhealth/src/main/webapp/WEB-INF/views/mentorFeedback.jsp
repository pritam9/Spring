<%@page import="com.uncc.mhealth.model.Question"%>
 <%@page import="java.util.ArrayList" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- Set the viewport so this responsive site displays correctly on mobile devices -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mentor Feedback</title>
    <!-- Include bootstrap CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Site header and navigation -->
<div class="container-fluid page-wrap">
	<div style="margin-top:30px;">
		&nbsp;
	</div>
	<div class="col-sm-8 col-sm-offset-2" style="text-align:center;"><h2>Mentor Feedback</h2></div>
	<%ArrayList<Question> listQuestions=null;
	if(request.getAttribute("mentorFeedback")!=null)
		listQuestions=(ArrayList<Question>)request.getAttribute("mentorFeedback");
	for(Question q:listQuestions){ %>
	<div class="row">
	<div class="col-sm-8 col-sm-offset-2">
		<div class="panel panel-default">
      		<div class="panel-heading"><%=q.getText()%></div>
      		<div class="panel-body"><%=q.getAnswer()%></div>
    	</div>
	</div>
	</div>
	<%} %>
	<div class="col-sm-8 col-sm-offset-2" style="text-align:center;">
	<button id="printButton" type="button" class="btn btn-primary btn-sm">Print</button>
	<button id="backButton" type="button" class="btn btn-primary btn-sm">Back</button>
	</div>
	<div style="margin-bottom:30px;">
		&nbsp;
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$('#printButton').on('click',function(){
		window.print();
	});
	$('#backButton').on('click',function(){
		window.location.href='dashboard';
	});
});
</script>
</body>
</html>
