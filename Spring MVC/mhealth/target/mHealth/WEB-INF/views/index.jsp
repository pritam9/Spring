<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>mHealth</title>
</head>
<body>
<h1>Welcome to mHealth</h1>
content will be added soon.

</body>
</html> -->
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>mHealth</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link href="resources/css/main.css" rel="stylesheet">
    <link href="resources/css/animations.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">mHealth</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#page-top">Home</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/#contact">Contact</a>
                    </li>
                    <%
                    	if(request.getSession().getAttribute("user") != null){
                    %>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/dashboard">Dashboard</a>
                    </li>
                    <%
                    } %>
                    <%
                    	if(request.getSession().getAttribute("user") == null){
                    %>
                    <li>
                        <a class="page-scroll" href="login">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="register">Register</a>
                    </li>
                     <%
                    } else {
                     
                    %>
                    <li>
                        <a class="page-scroll" href="<%=request.getContextPath()%>/logout">Logout</a>
                    </li>
                    <% } %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Section -->
    <section id="intro" class="intro-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-8" id="vAlign" style="color:black">
                    <h1 class="stretchRight">mHealth</h1>
                    <h4>
                      Use the virtual coach to have a safer driking experience.
                    </h4>
                    <a class="btn btn-default page-scroll" href="#about">Read More</a>
                </div>
                <div class="col-lg-4">
                  <img class="slideLeft" id="intro-img" alt="app" src="resources/images/app.png">
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section id ="about" class="about-section">
      <div class="container">
          <h1>About</h1>
            <!-- <div class="row about-content">
                <div class="col-lg-6">
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  </p>

                </div>
                <div class="col-lg-6">
                  <p>
                    The goal of the mHealth mobile app is to enable effective communication and interaction with students enrolled in the pBMI+SP arm of the study. The mobile app will be used for a wide variety of purposes, including data collection, intervention, behavior tracking, incentive offering and education. Moreover, the app will replace current face to face meeting for MI (Motivational Interviewing) processes.
                  </p>
                </div>
            </div> -->
          </div>
          <div class="container tabs-content">
          <!-- Tab Content -->
            <div class="row">
              <div class="col-lg-6 col-sm-6">
			             <div class="iphone-div slideRight">
				                 <img class="img-responsive side-Image" src="resources/images/2.jpg" alt="">
			              </div>
			              <!-- <div class="android-div">
				                  <img class="img-responsive" src="resources/image/2.png" alt="">
			              </div> -->
		          </div>
		        <div class="col-lg-6 tab-side" id="center-element">
        			<!-- <ul id="myTab" class="nav nav-tabs">
        				<li class="active"><a href="#service-one" data-toggle="tab" class="i-div"><i class="fa fa-apple"></i> Apple</a></li>
        				<li><a href="#service-two" data-toggle="tab"  class="a-div"><i class="fa fa-android"></i> Android</a></li>
        			</ul> -->
        			<div id="myTabContent" class="tab-content">
        				<div class="tab-pane fade in active" id="service-one">
        					<h3>iOS Version</h3>
        					<p>The goal of the mHealth mobile app is to enable effective communication and interaction with students enrolled in the pBMI+SP arm of the study. The mobile app will be used for a wide variety of purposes, including data collection, intervention, behavior tracking, incentive offering and education. Moreover, the app will replace current face to face meeting for MI (Motivational Interviewing) processes.</p>
        					<!-- <p>Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p> -->
        					<a href="#"><button class="btn btn-cs floating"><i class="fa fa-apple"></i> Coming Soon</button></a>
        				</div>
        				<div class="tab-pane fade" id="service-two">
        					<h3>Android Version</h3>
        					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
        					<p>Etiam placerat nunc ut tellus tristique, non posuere neque iaculis. Fusce aliquet dui ut felis rhoncus, vitae molestie mauris auctor. Donec pellentesque feugiat leo a adipiscing. Pellentesque quis tristique eros, sed rutrum mauris.</p>
        					<a href="#"><button class="btn btn-cs"><i class="fa fa-android"></i> Coming Soon</button></a>
        				</div>
        			</div>
		        </div>
          </div>
        </div>
      </section>

    <!-- Services Section -->
    <section id="team" class="team-section">
        <div class="container">
          <div class="row white centered">
            <h1 class="centered">Team behind mHealth</h1>
            <hr>
            <br>
            <br>
            <div class="col-lg-6 centered">
              <img class="img img-thumbnail" id="team-pic1" src="resources/images/Dr-Shehab.jpg" height="120px" width="120px" alt="">
              <br>
              <h4><b>Dr.Mohamed Shehab</b></h4>
              <a href="http://liisp.uncc.edu/~mshehab/" target="_blank"><i class="fa fa-globe fa-lg"></i></a>
              <a href="#"><i class="fa fa-linkedin-square fa-lg"></i></a>
              <p>Dr. Shehab is an Associate Professor of Software and Information Systems Department at the University of North Carolina at Charlotte. He received his PhD degree in Electrical and Computer Engineering from Purdue University in August 2007. In particular, his research focuses on advancing the state of the art in the design and implementation of distributed access control protocols to cope with the requirements of emerging distributed frameworks, Mobile Applications, Web Services, Social Networks, and Database Systems.</p>
            </div><!-- col-lg-6 -->
            <div class="col-lg-6 centered">
              <img class="img img-thumbnail" id="team-pic2" src="resources/images/Donna.png" height="120px" width="120px" alt="">
              <br>
              <h4><b>Dr.Kazemi</b></h4>
              <a href="http://nursing.uncc.edu/donna-marie-kazemi" target="_blank"><i class="fa fa-globe fa-lg"></i></a>
              <a href="#"><i class="fa fa-linkedin-square fa-lg" target="_blank"></i></a>
              <p>Dr. Kazemi, PhD, MSN, RN is a faculty member in the School of Nursing at the University of North Carolina-Charlotte. Her program of research has focused on applied and clinical research on addictive behaviors among populations at high risk such as young adults, college students, military personnel, and underserved ethnic minority populations. Her program of research promotes an multifaceted integrated approach that addresses the  individual, community, and society to impact high risk addictive behaviors.</p>
            </div><!-- col-lg-6 -->
        </div><!-- row -->
        </div>
    </section>
    <section class="dev-team">
      <div class="container">
      	<div class="row white centered">
      	 <h1 class="centered">SmarTrek Video</h1>
            <hr>
      	</div>
        <div class="row">
            <iframe id="SmarTrekVideo" width="560" height="315" src="//www.youtube.com/embed/Bn-ZwCoySaA" frameborder="0" allowfullscreen></iframe>
        </div>
      </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="contact-section">
        <div class="container">
            <div class="row">
              <h1>Get in touch</h1>
                <div class="col-lg-12">
                  <h3>School of Nursing</h3>
                  <h4>University of North Carolina at Charlotte</h4>
                </div>
            </div>
        </div>
    </section>

    <div class="footerwrap">
			<div class="container">
				<p>Copyright © 2015</p>
			</div>
		</div>
    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
    <script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Scrolling Nav JavaScript -->
    <script src="resources/js/jquery.easing.min.js"></script>
    <script src="resources/js/animations.js"></script>
    <script src="animations.js"></script>

</body>

</html>
