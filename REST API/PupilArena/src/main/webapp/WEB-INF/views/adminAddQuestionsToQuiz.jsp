<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="resources/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>${title}</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="resources/css/dashboard/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="resources/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="resources/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
     <script src="resources/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="resources/js/core/tether.min.js" type="text/javascript"></script>
	<script src="resources/js/core/bootstrap.min.js" type="text/javascript"></script>
	<script src="resources/js/light-bootstrap-dashboard.js"></script>
    
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="resources/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <!-- Angular Related Stylesheets -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
    <script type="text/javascript" src="resources/js/angular/admin/addQuestions.js"></script>
        
</head>
<body data-ng-app="pupilArenaApplication">

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="resources/img/sidebar-5.jpg" data-ng-controller="sidebarController" data-ng-init="loadDetails()">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simple-text">
                    {{fullName}}
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href=""  data-ng-click="createQuiz()">
                        <i class="pe-7s-graph"></i>
                        <p>Create Quiz</p>
                    </a>
                </li>
                <!-- li data-ng-show="isMember">
                    <a href="join_team">
                        <i class="pe-7s-graph"></i>
                        <p>Join Team</p>
                    </a>
                </li> -->
                <li class="active">
                    <a href="admin_quizes">
                        <i class="pe-7s-note2"></i>
                        <p>Quizzes</p>
                    </a>
                </li>
                <li>
                    <a href="" data-ng-click="goToHome()">
                        <i class="pe-7s-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                
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
                <li>
                    <a href="" data-ng-click="goToNotifications()">
                        <i class="pe-7s-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
				<li class="active-pro">
                    <a href="" data-ng-click="logout()">
                        <i class="pe-7s-power"></i>
                        <p>Logout</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Pupil Arena</a>
                </div>
                <div class="collapse navbar-collapse" id="navigation-example-2" data-ng-controller="sidebarController" data-ng-init="loadDetails()">
                    
    	
    			</div>
            </div>
        </nav>


        <div class="content" data-ng-controller="addQuestionsController" data-ng-init="loadQuestions()">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Quiz Questions</h4>
                            </div>
                            <div class="content">
                            	<div class="row">
                                <div class="header">
											<h4 class="title">Quiz Questions List</h4>
											<p class="category">You can remove questions from quiz here..</p>
										</div>
		
		
										<div class="content table-responsive table-full-width">
											<table class="table table-hover table-striped">
												<thead>
													<th>Question</th>
													<th></th>
													
												</thead>
												<tbody>
													<tr data-ng-repeat="question in quizQuestions | startFrom:qCurrentPage*qPageSize | limitTo:qPageSize">
														<td data-ng-hide="question.imgUrl==null"><img class="col-md-4 col-xs-12" alt="" src="resources/img/quiz/{{question.imgUrl}}"></td>
														<td data-ng-show="question.imgUrl==null">{{question.questionText}}</td>
														<td><button class="btn btn-danger btn-fill btn-md  pe-7s-close-circle" data-ng-click="removeQuestion(question.questionId)"> Remove</button></td>
													</tr>
												</tbody>
											</table>
		
										</div>
                                 

                                 </div>
                            </div>
                        </div>
                        <div class="pagination pull-right">
							<button class="btn btn-success btn-fill btn-sm pe-7s-prev" data-ng-disabled="qCurrentPage == 0" data-ng-click="qCurrentPage=qCurrentPage-1"></button>
			    			{{qCurrentPage + 1}}/{{qNumberOfPages()}}
			    			<button class="btn btn-success btn-fill btn-sm  pe-7s-next" data-ng-disabled="qCurrentPage >= qGetData().length / qPageSize - 1" data-ng-click="qCurrentPage = qCurrentPage + 1"></button>
						</div>
                    </div>
                </div>
                <!-- Questions table to be added to quiz!! -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Add Questions</h4>
                            </div>
                            <div class="content">
                            	<!-- div class="col-md-12 content"> -->
									<div class="card">
		
										<div class="header">
											<h4 class="title">Questions List</h4>
											<p class="category">You can add questions to quiz here..</p>
										</div>
		
										<!-- Removing table-full-width --> 
										<div class="content table-responsive">
											<table class="table table-hover table-striped">
												<thead>
													<th>Question</th>
													<th></th>
													
												</thead>
												<tbody>
													<tr data-ng-repeat="question in remainingQuestions |filter:''| startFrom:rCurrentPage*rPageSize | limitTo:rPageSize">
														<td data-ng-hide="question.imgUrl==null"><img class="col-md-4 col-xs-12" alt="" src="resources/img/quiz/{{question.imgUrl}}"></td>
														<td data-ng-show="question.imgUrl==null">{{question.questionText}}</td>
														<td><button class="btn btn-info btn-fill btn-md  pe-7s-plus" data-ng-click="addQuestion(question.questionId)"> Add</button>
														<!-- i class="pe-7s-close-circle"
															data-ng-click="removeQuestion(question.questionId)"></i> --></td>
													</tr>
												</tbody>
											</table>
		
										</div>
									</div>
									<div class="pagination pull-right">
										<button class="btn btn-success btn-fill btn-sm pe-7s-prev" data-ng-disabled="rCurrentPage == 0" data-ng-click="rCurrentPage=rCurrentPage-1"></button>
						    			{{rCurrentPage + 1}}/{{numberOfPages()}}
						    			<button class="btn btn-success btn-fill btn-sm  pe-7s-next" data-ng-disabled="rCurrentPage >= rGetData().length / rPageSize - 1" data-ng-click="rCurrentPage = rCurrentPage + 1"></button>
									</div>
								<!-- </div> -->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End of Quiz questions -->
                
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                PR9
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                About Us
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
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
                    </script>, Designed by <a href="#" target="_blank">PR9</a>. Coded by <a href="#" target="_blank">PR9</a>.
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
