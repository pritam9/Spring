<%@page import="com.uncc.mhealth.model.Question"%>
 <%@page import="java.util.ArrayList" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- Set the viewport so this responsive site displays correctly on mobile devices -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Resources</title>
    <!-- Include bootstrap CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="//use.fontawesome.com/85981a9ea2.js"></script>
    <style>
    .glyphicon,.fa {
    	padding: 10px;
    }
    </style>
</head>
<body>
<!-- Site header and navigation -->
<div class="container-fluid page-wrap">
	<div style="margin-top:10px;">
		&nbsp;
	</div>
	<div class="col-sm-8 col-sm-offset-2" style="text-align:center;"><h2>Resources</h2></div>
	
	<div class="row">
	<div class="col-sm-8 col-sm-offset-2">
    <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1" style="color:none;text-decoration:none;">Study Personnel Contact</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>Dr. Kazemi <br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:704-687-7968">704-687-7968</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://nursing.uncc.edu/donna-marie-kazemi" target="_blank">http://nursing.uncc.edu/donna-marie-kazemi</a><br>
        </div>
      </div>
    </div>
    </div>
    <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2" style="color:none;text-decoration:none;">UNC Charlotte Campus Resources</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse in">
        <div class="panel-body">
        	<i class="fa fa-university" aria-hidden="true"></i>Center for Wellness Promotion (Sexual Health, Interpersonal Violence Prevention, Tobacco Cessation, BASICS, Collegiate Recovery Community) <br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-7407">(704) 687-7407</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://wellness.uncc.edu" target="_blank">http://wellness.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Counseling Center<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-0311">(704) 687-0311</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://counselingcenter.uncc.edu" target="_blank">http://counselingcenter.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>University Center for Academic Excellence<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-7837">(704) 687-7837</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://ucae.uncc.edu" target="_blank">http://ucae.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Student Health Center<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-7400">(704) 687-7400</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://studenthealth.uncc.edu" target="_blank">http://studenthealth.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Multicultural Academic Services<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-0030">(704) 687-0030</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://mas.uncc.edu" target="_blank">http://mas.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>University Career Center<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-0795">(704) 687-0795</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://career.uncc.edu" target="_blank">http://career.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Dean of Students Office<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-0345">(704) 687-0345</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://unccdso.orgsync.com/" target="_blank">http://unccdso.orgsync.com/</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Office of Disability Services<br>
      		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span><a href="tel:(704) 687-0040">(704) 687-0040</a><br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://ds.uncc.edu" target="_blank">http://ds.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Student Organizations<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://studentorgs.uncc.edu" target="_blank">http://studentorgs.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Alcoholics Anonymous (AA)<br>
      		Mondays from 12 - 1 pm and Wednesdays from 5 - 6 pm Downstairs in the Student Health Center Rm 121<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://wellness.uncc.edu" target="_blank">http://wellness.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Narcotics Anonymous (NA)<br>
      		Thursdays from 5 - 6 pm - Downstairs in the Student Health Center Rm 121<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://wellness.uncc.edu" target="_blank">http://wellness.uncc.edu</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Alcohol Drug Council of North Carolina<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://alcoholdrughelp.org/" target="_blank">http://alcoholdrughelp.org/</a><br>
        </div>
      </div>
    </div>
  </div>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse3" style="color:none;text-decoration:none;">National Resources</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse in">
        <div class="panel-body">
            <h4>Alcohol and Other Drugs</h4>
        	<i class="fa fa-university" aria-hidden="true"></i>Adult Children of Alcoholics (ACOA)<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://www.adultchildren.org/" target="_blank">http://www.adultchildren.org/</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Alcoholics Anonymous (AA)<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://www.aa.org/" target="_blank">http://www.aa.org/</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Harmful Interactions: Mixing Alcohol with Medicines<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://my.ireta.org/sites/ireta.org/files/Harmful_Interactions%20Alcohol%20%26%20Medications.pdf" target="_blank">http://my.ireta.org/sites/ireta.org/files/Harmful_Interactions%20Alcohol%20%26%20Medications.pdf</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>with Medicines<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://pubs.niaaa.nih.gov/publications/Medicine/medicine.htm" target="_blank">http://pubs.niaaa.nih.gov/publications/Medicine/medicine.htm</a><br>
      		<hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Rethinking Drinking<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://www.rethinkingdrinking.niaaa.nih.gov/" target="_blank">http://www.rethinkingdrinking.niaaa.nih.gov/</a><br>
      		 <h4>Sleep</h4>
      		<i class="fa fa-university" aria-hidden="true"></i>National Sleep Foundation<br>
      		 <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		 <a href="http://www.sleepeducation.com" target="_blank">http://www.sleepeducation.com</a><br>
      		 <hr>
      		<i class="fa fa-university" aria-hidden="true"></i>American Academy of Sleep Medicine<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://www.nhlbi.nih.gov" target="_blank">http://www.nhlbi.nih.gov</a><br>
      		<h4>Mental Health</h4>
      		 <i class="fa fa-university" aria-hidden="true"></i>National Institutes of Mental Health<br>
      		 <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		 <a href="http://www.nimh.nih.gov" target="_blank">http://www.nimh.nih.gov</a><br>
      		 <hr>
      		<i class="fa fa-university" aria-hidden="true"></i>Mental Health America<br>
      		<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
      		<a href="http://www.mentalhealthamerica.net" target="_blank">http://www.mentalhealthamerica.net</a><br>
      		 
        </div>
      </div>
    </div>
    </div>
	</div>
	</div>
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
		$('.panel-collapse').collapse('show');
		window.print();
	});
	$('#backButton').on('click',function(){
		window.location.href='dashboard';
	});
});
</script>
</body>
</html>
