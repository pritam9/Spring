<!DOCTYPE html>
<html>

<head>
    <title>Login - AppointDoctor</title>
    <link href="resources/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="resources/css/style.css" type="text/css" rel="stylesheet" media="all">
    <!--web-font-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!--//web-font-->
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Hospice Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- //Custom Theme files -->
    <!-- js -->
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/modernizr.custom.js"></script>
    <!-- //js -->
    <!-- start-smoth-scrolling-->
    <script type="text/javascript" src="resources/js/move-top.js"></script>
    <script type="text/javascript" src="resources/js/easing.js"></script>
    <script type="text/javascript" src="resources/js/modernizr.custom.53451.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 1000);
            });









            $.ajax({
                type: "GET",
                url: "https://api.github.com/users/hadley/orgs",
                data: JSON,
                success: function (data) {
                    // this part is what happens with the JSON data

                    //console.log(data);

                    var content = '';
                    var data = $.parseJSON(data);
                    
                    $.each(data, function (i, post) {
                     content = "<tr>" + "<td>" + post.id + "</td>" + "<td>" + post.url + "</td>" + "</tr>";
                         $(content).appendTo("#tbody");
                    });
                    console.log(content+"eachrow");
                   
                },

                error: function (errorThrown) {
                    alert('error');
                    console.log(errorThrown);
                },
                dataType: "html"
            });

        });
    </script>
    <!--//end-smoth-scrolling-->
</head>

<body>
    <!--header-->
    <div class="header">
        <div class="container">
            <div class="top-middle">
                <a href="index.html">
                    <h3>Women Health</h3>
                </a>
            </div>
            <div class="top-nav">
                <span class="menu"><img src="resources/images/menu-icon.png" alt="" /></span>
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
    <!--blog-->

    <div class="blog">
        <div class="container">

            <div id="loginBox" class="features-info" style="text-align: center;">

                <table id="search-results">

                    <thead>
                        <tr>
                            <th>Patient Name</th>
                            <th>Patient Id</th>
                            <th>Appointment Time</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">

                    </tbody>




                </table>
                <!--
                <ul  id="search-results">
                    <li>Results</li>
                </ul>
-->

            </div>
        </div>
    </div>
    <!--//blog-->
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
    <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
    <!--//smooth-scrolling-of-move-up-->
</body>

</html>