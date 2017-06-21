
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Login - AppointDoctor</title>
<link href="resources/css/bootstrap.css" type="text/css"
	rel="stylesheet" media="all">
<link href="resources/css/style.css" type="text/css" rel="stylesheet"
	media="all">
<!--web-font-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!--//web-font-->
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hospice Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
<script src="resources/js/adminTODO.js"></script>
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<!-- script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script-->
<!-- //Custom Theme files -->
<!-- js -->
<!-- script src="resources/js/jquery.min.js"></script-->
<script src="resources/js/modernizr.custom.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<script type="text/javascript"
	src="resources/js/modernizr.custom.53451.js"></script>
<script type="text/javascript">
        
    </script>
<!--//end-smoth-scrolling-->
</head>

<body>
	<!--header-->
	<div class="header">
		<div class="container">
			<div class="top-middle">
				<a href="index.html">
					<h3>AppointDoctor</h3>
				</a>
			</div>
			<div class="top-nav">
				<span class="menu"><img src="resources/images/menu-icon.png"
					alt="" /></span>
				<ul class="nav1">
					<li><a href="index.html" class="active">Home</a></li>
					<li><a href="patient.html">Patients</a></li>
					<li><a href="appointment.html">Appointment</a></li>

				</ul>
				<!-- script-for-menu -->
				<script>
                    $("span.menu").click(function () {
                        $("ul.nav1").slideToggle(300, function () {
                            // Animation complete.
                        });
                    });
                </script>
				<!-- /script-for-menu -->
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--//header-->
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Daily Data <small>${USER.lastName }, ${ USER.firstName}</small>
						</h3>
					</div>
					<div class="panel-body">
						<table class="Display" border="1">
							<thead>
								<tr>
									<th>Date id</th>
									<th>Date</th>
									<th>Food</th>
									<th>Servings</th>
									<th>No of Binges</th>
									<th>Vomiting/Laxative/Drugs</th>
									<th>Date Created</th>
									<th>Context</th>
									<th>Feelings</th>
								</tr>
							</thead>
							<c:forEach items="${daily_data}" var="survey_report">

								<tr>
									<td>${survey_report.d_id}</td>
									<td>${survey_report.a_date}</td>
									<td>${survey_report.food}</td>
									<td>${survey_report.servings}</td>
									<td>${survey_report.binge}</td>
									<td>${survey_report.vld}</td>
									<td>${survey_report.i_date}</td>
									<td>${survey_report.context}</td>
									<td>${survey_report.feelings}</td>
								</tr>
							</c:forEach>
						</table>
					</div>



				</div>
			</div>
		</div>
	</div>

	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<a href="index.html">AppointDoctor</a>
			</div>
			<div class="footer-right">
				<p>&copy; 2016 All rights reserved</p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--//footer-->
	<!--smooth-scrolling-of-move-up-->
	<script type="text/javascript">
        $(document).ready(function () {
            /*
            var defaults = {
            	containerID: 'toTop', // fading element id
            	containerHoverID: 'toTopHover', // fading element hover id
            	scrollSpeed: 1200,
            	easingType: 'linear' 
            };
             */

            $().UItoTop({
                easingType: 'easeOutQuart'
            });

        });
    </script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
	<!--//smooth-scrolling-of-move-up-->

</body>
</html>