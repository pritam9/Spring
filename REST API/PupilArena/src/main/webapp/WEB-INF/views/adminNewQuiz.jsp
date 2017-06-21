<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="resources/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>${title}</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="resources/css/dashboard/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="resources/css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="resources/css/light-bootstrap-dashboard.css"
	rel="stylesheet" />
 <script src="resources/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="resources/js/core/tether.min.js" type="text/javascript"></script>
	<script src="resources/js/core/bootstrap.min.js" type="text/javascript"></script>
	<script src="resources/js/light-bootstrap-dashboard.js"></script>

<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="resources/css/pe-icon-7-stroke.css" rel="stylesheet" />
<!-- Angular Related Stylesheets -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
<script type="text/javascript"
	src="resources/js/angular/admin/adminNewQuiz.js"></script>

</head>
<body data-ng-app="pupilArenaApplication">

	<div class="wrapper">
		<div class="sidebar" data-color="purple"
			data-image="resources/img/sidebar-5.jpg"
			data-ng-controller="sidebarController" data-ng-init="loadDetails()">

			<!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


			<div class="sidebar-wrapper">
				<div class="logo">
					<a class="simple-text"> {{fullName}} </a>
				</div>

				<ul class="nav">
					<li><a href="" data-ng-click="createQuiz()"> <i
							class="pe-7s-graph"></i>
							<p>Create Quiz</p>
					</a></li>
					<!-- li data-ng-show="isMember">
                    <a href="join_team">
                        <i class="pe-7s-graph"></i>
                        <p>Join Team</p>
                    </a>
                </li> -->
					<li class="active"><a href="admin_quizes"> <i class="pe-7s-note2"></i>
							<p>Quizzes</p>
					</a></li>
					<li><a href="" data-ng-click="goToHome()"> <i class="pe-7s-user"></i>
							<p>User Profile</p>
					</a></li>

					<!-- li>
                    <a href="typography.html">
                        <i class="pe-7s-news-paper"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li>
                    <a href="icons.html">
                        <i class="pe-7s-science"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="pe-7s-map-marker"></i>
                        <p>Maps</p>
                    </a>
                </li-->
					<li><a href="" data-ng-click="goToNotifications()"> <i class="pe-7s-bell"></i>
							<p>Notifications</p>
					</a></li>
					<li class="active-pro"><a href="" data-ng-click="logout()">
							<i class="pe-7s-power"></i>
							<p>Logout</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Pupil Arena</a>
					</div>
					<div class="collapse navbar-collapse" id="navigation-example-2" data-ng-controller="sidebarController" data-ng-init="loadDetails()">
                    
    	
    				</div>
				</div>
			</nav>


			<div class="content" data-ng-controller="newQuizController">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">Create New Quiz!</h4>
								</div>
								<div class="content">
									<form name="myForm" novalidate>
										<div class="row">
											<div class="col-md-8 col-xs-12">
												<div class="form-group">
													<label>Quiz Name</label> <input type="text"
														class="form-control" required="required" name="quizName"
														data-ng-model="quizName" placeholder="Quiz Name.."
														data-ng-class="myForm.quizName.$touched && myForm.quizName.$invalid ? 'alert-danger' : ''">
												</div>
											</div>
											<div class="col-md-4 col-xs-12">
												<div class="form-group">
													<label>Quiz Duration</label> <input type="number"
														class="form-control" required="required" name="duration"
														data-ng-model="duration" placeholder="Quiz Duration in Minutes.."
														data-ng-class="myForm.duration.$touched && myForm.duration.$invalid ? 'alert-danger' : ''">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-xs-12">
												<div class="form-group">
													<label>Quiz Summary</label>
													<textarea class="form-control" required="required"
														data-ng-model="summary" name="summary"
														placeholder="Summary of the quiz.. Portion to be covered"
														data-ng-class="myForm.summary.$touched && myForm.summary.$invalid ? 'alert-danger' : ''"></textarea>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-xs-12">
												<div class="form-group">
													<label>Quiz Rules</label>
													<textarea class="form-control" required="required"
														name="rules" data-ng-model="rules" placeholder="Rules.."
														data-ng-class="myForm.rules.$touched && myForm.rules.$invalid ? 'alert-danger' : ''"></textarea>
												</div>
											</div>

										</div>

										


										<button type="submit" data-ng-click="createQuiz()"
											class="btn btn-info btn-fill pull-right">Create
											Quiz</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
						<!-- div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                     <a href="#">
                                    <img class="avatar border-gray" src="resources/img/faces/face-3.jpg" alt="..."/>

                                      <h4 class="title">Mike Andrew<br />
                                         <small>michael24</small>
                                      </h4>
                                    </a>
                                </div>
                                <p class="description text-center"> "Lamborghini Mercy <br>
                                                    Your chick she so thirsty <br>
                                                    I'm in that two seat Lambo"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i></button>

                            </div>
                        </div>
                    </div> -->

					</div>
				</div>
			</div>


			<footer class="footer">
				<div class="container-fluid">
					<nav class="pull-left">
						<ul>
							<li><a href="#"> PR9 </a></li>
							<li><a href="#"> About Us </a></li>
							<li><a href="#"> Blog </a></li>
							<!-- li>
                            <a href="https://github.com/creativetimofficial/now-ui-kit/blob/master/LICENSE.md">
                                MIT License
                            </a>
                        </li> -->
						</ul>
					</nav>
					<p class="copyright pull-right">
						&copy;
						<script>
                        document.write(new Date().getFullYear())
                    </script>
						, Designed by <a href="#" target="_blank">PR9</a>. Coded by <a
							href="#" target="_blank">PR9</a>.
					</p>
				</div>
			</footer>

		</div>
	</div>


</body>

<!--   Core JS Files   -->
<!--script src="resources/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="resources/js/core/tether.min.js" type="text/javascript"></script>
<script src="resources/js/core/bootstrap.min.js" type="text/javascript"></script-->


<!--  Checkbox, Radio & Switch Plugins -->
<script src="resources/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<!-- script src="resources/js/chartist.min.js"></script-->

<!--  Notifications Plugin    -->
<script src="resources/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<!-- script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script-->

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<!--  script src="resources/js/light-bootstrap-dashboard.js"></script-->



</html>
