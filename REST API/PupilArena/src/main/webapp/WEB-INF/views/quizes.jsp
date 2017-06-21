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
    <script type="text/javascript" src="resources/js/angular/quiz.js"></script>
        
</head>
<body data-ng-app="pupilArenaApplication">

<div class="wrapper">
    <div class="sidebar" data-color="orange" data-image="resources/img/sidebar-5.jpg" data-ng-controller="sidebarController" data-ng-init="loadDetails()">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simple-text">
                    {{fullName}}
                </a>
            </div>

            <ul class="nav">
                <li data-ng-show="isLeader">
                    <a href="create_team">
                        <i class="pe-7s-graph"></i>
                        <p>Create Team</p>
                    </a>
                </li>
                <li data-ng-show="isMember">
                    <a href="join_team">
                        <i class="pe-7s-graph"></i>
                        <p>Join Team</p>
                    </a>
                </li>
                <li class="active">
                    <a href="#">
                        <i class="pe-7s-note2"></i>
                        <p>Quizes</p>
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


        <div class="content" data-ng-controller="quizController" data-ng-init="loadQuizDetails()">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Quizes</h4>
                            </div>
                            <div class="content">
                            	<div class="row">
                                <div class="col-xs-12 col-sm-6 col-md-12" data-ng-repeat="quiz in quizes">
                                     <div class="thumbnail">
                                         <!--img class="img-rounded" src="img/thumbnail-2.jpg"-->
                                         <div class="panel panel-primary">
                                             <div class="panel-heading">
                                                 <h3 class="panel-title">{{quiz.quizId}} {{quiz.quizName}}</h3>
                                             </div>
                                             <div class="panel-body">
                                                 <p class="panel-title">Summary:</p>
                                                 <p>{{quiz.quizInfo}}</p>
                                                 <p class="panel-title">Rules:</p>
                                                 <p>{{quiz.quizRules}}</p>

                                                 <p>
                                                 <!--a href="" class="btn btn-warning" data-ng-click="participate(quiz.quizId)" role="button">Participate</a-->
                                                 <a href="" class="btn btn-warning"  data-ng-click="checkIfParticipated(quiz.quizId)" role="button">Participate</a>
                                                 <a href="" data-ng-hide="quiz.locked" class="btn btn-danger pull-right" data-ng-click="startQuiz(quiz.quizId)" role="button">Start Quiz Now</a>
                                                 <a href="" data-ng-show="quiz.locked && isApeared" class="btn btn-danger pull-right" data-ng-click="viewQuizResult(quiz.quizId)" role="button">View Quiz Result</a>
                                                 </p>
                                                 <div class="card table-responsive table-full-width"  data-ng-show="quizId==quiz.quizId && !isParticipated && myGroups.length>0">
													<table class="table table-hover table-striped">
														<thead>
															<th>Group Name</th>
															<th></th>
															
														</thead>
														<tbody>
															<tr data-ng-repeat="group in myGroups">
																
																<td>{{group.groupName}}</td>
																<td><button class="btn btn-danger btn-fill btn-md  pe-7s-plus" data-ng-click="participate(quiz.quizId,group.groupId)"> With This Group</button></td>
															</tr>
														</tbody>
													</table>
				
												</div>
		        
                                             </div>
                                            </div>

                                     </div>
                                 </div>
                                 

                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pagination pull-right">
				<button class="btn btn-success btn-fill btn-sm pe-7s-prev" data-ng-disabled="currentPage == 0" data-ng-click="currentPage=currentPage-1">{{Previous}}</button>
    			{{currentPage + 1}}/{{numberOfPages()}}
    			<button class="btn btn-success btn-fill btn-sm  pe-7s-next" data-ng-disabled="currentPage >= getData().length / pageSize - 1" data-ng-click="currentPage = currentPage + 1">{{Next}}</button>
			</div>
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
