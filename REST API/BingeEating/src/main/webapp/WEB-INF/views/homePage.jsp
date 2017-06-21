<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Login - AppointDoctor</title>
<link href="resources/css/bootstrap.css" type="text/css"
	rel="stylesheet" media="all">
<link href="resources/css/bootstrap.min.css" type="text/css"
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
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<!-- script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script-->
<!-- //Custom Theme files -->
<!-- js -->
<!-- script src="resources/js/jquery.min.js"></script-->
<script src="resources/js/modernizr.custom.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/js/modernizr.custom.53451.js"></script>

<!-- DatePicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
        
    </script>
<!--//end-smoth-scrolling-->
</head>

<body>
	<!--header-->
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-5">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<img src="resources/img/logo.PNG" height="50" width="50" id="logo" />


						<a href="#" class="">The Women Health Project</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-5" style="width: 100%;">
						<ul class="nav navbar-nav" style="float: right;">

							<form action="logout" method="get">
								<button type="submit" class="btn btn-warning navbar-btn">Logout</button>
							</form>
						</ul>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
	</div>

	<!--//header-->
	<div class="row">
		<div class="col-sm-7">
			<c:if test="${ROLE=='admin' }">
				<!--Add new User -->
				<div class="container">
					<div class="row centered-form">
						<div class="col-sm-7">
							<!-- col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2 -->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										Please Register new Patient details <small>New
											Patient!</small>
									</h3>
								</div>
								<div class="panel-body">
									<form role="form">
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="first_name" id="first_name"
														class="form-control input-sm" placeholder="First Name">
												</div>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="last_name" id="last_name"
														class="form-control input-sm" placeholder="Last Name">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="first_name" id="username"
														class="form-control input-sm" placeholder="Username">
												</div>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="last_name" id="password"
														class="form-control input-sm" placeholder="Password">
												</div>
											</div>
										</div>

										<button type="submit" onclick="return registerPatient();"
											class="btn btn-info btn-block">Register</button>

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- End of Add New User -->
			</c:if>

			<!-- View Upcoming Appointments -->
			<!-- div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							List of Patients
						</h3>
					</div>
					<div class="panel-body">
						<table id="myAppointment" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email Id</th>
									<th>Password</th>
									<th>High BP</th>
									<th>Medicine Prescribed</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email Id</th>
									<th>Password</th>
									<th>High BP</th>
									<th>Medicine Prescribed</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div-->
			<!-- End of Upcoming Appointments -->

			<!-- View All Users under Supporter -->
			<div class="container">
				<div class="row centered-form">
					<div class="col-sm-7">
						<!-- col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">List of Patients</h3>
							</div>
							<div class="panel-body table-responsive">
								<table id="myUsers"
									class="table table-striped table-bordered table-hover"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Step</th>
											<th>Start Date</th>
											<th></th>
										</tr>
									</thead>
									<!-- tfoot>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Step</th>
									<th>Start Date</th>
									<th></th>
								</tr>
							</tfoot-->
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End of View All Users under Supporter -->
		</div>
		<div class="col-sm-5">
			<div class="panel">
				<ul id="userTab" class="nav nav-tabs nav-justified">
					<li class=""><a href="#sameDayUser" data-toggle="tab">TODAY</a></li>
					<li class="active"><a href="#allUser" data-toggle="tab">Book
							Appointments</a></li>
					<!--<li class=""><a href="#appointment" data-toggle="tab">Book Appointment </a></li>-->

				</ul>
				<div id="userTabContent" class="tab-content">
					<div class="tab-pane fade" id="sameDayUser">
						<label>Date</label> <input type="text" id="datepicker">
						<div class="panel panel-default">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>User Id</th>
										<th>Appointment Time</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Mark</td>
										<td>9:00</td>

									</tr>
									<tr>
										<td>2</td>
										<td>Jacob</td>
										<td>9:30</td>


									</tr>
									<tr>
										<td>3</td>
										<td>Larry</td>
										<td>10:00</td>
										<!-- td><a href="foodDetails.html">User Details</a></td>
										<td>
											<button type="button" class="btn btn-info btn-xs"
												id="visited">Visited</button>
											<button type="button" class="btn btn-info btn-xs"
												id="notvisited">Not Visited</button>


										</td-->
									</tr>
								</tbody>


							</table>
						</div>
					</div>
					<div class="tab-pane fade active in" id="allUser">
						<div class="panel panel-default">

							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>User Id</th>

										<th>Book Appointment</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Mark</td>

										<td><button type="button" class="btn btn-info"
												id="bookAppointment">Book Appointment</button></td>

									</tr>
									<tr>
										<td>2</td>
										<td>Jacob</td>

										<td><button type="button" class="btn btn-info"
												id="bookAppointment">Book Appointment</button></td>

									</tr>
									<tr>
										<td>3</td>
										<td>Larry</td>

										<td><button type="button" class="btn btn-info"
												id="bookAppointment">Book Appointment</button></td>

									</tr>
								</tbody>


							</table>


						</div>

					</div>

				</div>

			</div>
		</div>
	</div>

	<!-- MODAL -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h3>
					<center>
						<b>Book Appointment</b>
					</center>
				</h3>
			</div>

			<div class="modal-body">
				<form action="">
					<table class="modal-body" align="center">

						<tr>
							<td><label style="margin: 10px">User Id</label></td>
							<td>:- 1</td>
						</tr>
						<tr>
							<td><label style="margin: 10px">Date</label></td>
							<td><input type="text" id="datepickerAppointment"></td>
						</tr>

						<tr>
							<td><label style="margin: 10px">Time</label></td>
							<td><input type="time" style="margin-bottom: 10px;"></td>
						</tr>
					</table>

					<center>
						<button type="submit" class="btn btn-primary">Submit</button>

					</center>
				</form>
			</div>
		</div>

	</div>

	<!-- MODAL END -->
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
<script>
$(document).ready(function(){

    getAllData();
   
});
</script>
<!-- MODAL SHOW -->
	<script type="text/javascript">
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("bookAppointment");

    console.log(btn);
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
        console.log("click");
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

	<!-- END MODAL SHOW -->

	<!-- DATEPICKER -->
	<script>
    $( function datePicker(){
        $( "#datepicker" ).datepicker({
            showButtonPanel: true
        });
    } );
    $( function() {
        $( "#datepickerAppointment" ).datepicker({
            showButtonPanel: true
        });
    } );


    $( function() {
        var dateFormat = "mm/dd/yy",
                from = $( "#from" )
                        .datepicker({
                            defaultDate: "+1w",
                            changeMonth: true,
                            numberOfMonths: 3
                        })
                        .on( "change", function() {
                            to.datepicker( "option", "minDate", getDate( this ) );
                        }),
                to = $( "#to" ).datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 3
                })
                        .on( "change", function() {
                            from.datepicker( "option", "maxDate", getDate( this ) );
                        });

        function getDate( element ) {
            var date;
            try {
                date = $.datepicker.parseDate( dateFormat, element.value );
            } catch( error ) {
                date = null;
            }

            return date;
        }
    } );


</script>
	<!-- END DATEPICKER -->
</html>