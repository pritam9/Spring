<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


    <link rel="stylesheet" href="resources/css/bootflat.css">
    <link rel="stylesheet" href="resources/css/bootflat.min.css">

    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/site.css">
    <link rel="stylesheet" href="resources/css/site.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/userDetails.js"></script>
    <!-- script src="https://code.jquery.com/jquery-1.12.3.js"></script-->
    <script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
    

    <style type="text/css">
        .progress {width: 200px; height: 200px; border-radius: 50%; background-color: #E5E5E5; position: relative;}
        .progress.gt-50 {background-color: #22A7F0;}
        .ss-progress {content: ""; position: absolute; border-radius: 50%; left: calc(50% - 100px); top: calc(50% - 100px); width: 200px; height: 200px; clip: rect(0, 200px, 200px, 100px);}
        .ss-progress .ss-progress-fill { content: ""; position: absolute; border-radius: 50%; left: calc(50% - 100px); top: calc(50% - 100px);
            width: 200px; height: 200px; clip: rect(0, 100px, 200px, 0); background: #22A7F0; transform: rotate(60deg);}
        .gt-50 .ss-progress {clip: rect(0, 100px, 200px, 0);}
        .gt-50 .ss-progress .ss-progress-fill {clip: rect(0, 200px, 200px, 100px); background: #E5E5E5;}
        .ss-percent {content: ""; position: absolute; border-radius: 50%; left: calc(50% - 173.91304px/2); top: calc(50% - 173.91304px/2);
            width: 173.91304px; height: 173.91304px; background: #fff; text-align: center; display: table;}
        .ss-percent span {display: block; font-size: 2.6em; font-weight: bold; color: #4B77BE;}
        .ss-percent-wrapper {display: table-cell; vertical-align: middle;}

    </style>

</head>
<body>
<div class="row">
    <div class="col-md-12">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-5">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="resources/img/logo.PNG" height="50" width="50" id="logo"/>


                    <a href="#" class="">The Women Health Project</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5" style="width: 100%;">
                    <ul class="nav navbar-nav" style="float:right;">

						<form action="logout" method="get">
                        <button type="submit" onclick="href.redirect = logout" class="btn btn-warning navbar-btn">Logout</button>
						</form>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</div>

<div class="col-lg-12">
    <div class="col-md-9">
        <div class="panel">
            <ul id="myTab1" class="nav nav-tabs nav-justified">
                <li class="active"><a href="#foodDetails" data-toggle="tab">Food Detail</a></li>
                <li class=""><a href="#physicalActivity" data-toggle="tab">Physical Activity </a></li>
                <li class=""><a href="#weeklyReport" data-toggle="tab">Weekly Report </a></li>
                <li class=""><a href="#sendNotification" data-toggle="tab">Send Notification</a></li>
            </ul>
            <div id="foodDetail" class="tab-content">
                <div class="tab-pane fade active in" id="foodDetails">

                    <div id="food_detail_graph" ></div>

                    <div class="panel panel-default">
                        <div class="panel-heading table-responsive">Food Details</div>
                        <table id="foodDetailstable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Day </th>
                                <th>Actual Date</th>
                                <th>Food Image</th>
                                <th>Food</th>
                                <th>Servings</th>
                                <th>Binge</th>
                                <th>VLD</th>
                                <th>Context</th>
                                <th>Feelings</th>
                                <th>Date of Insertion</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Day </td>
                                <td>Actual Date</td>
                                <td>Food Details</td>
                                <td>Food</td>
                                <td>Servings</td>
                                <td>Binge</td>
                                <td>VLD</td>
                                <td>Context</td>
                                <td>Feelings</td>
                                <td>Date of Insertion</td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                 </div>
                <div class="tab-pane fade active  " id="physicalActivity">
                    <div id="physical_activity_graph" ></div>

                    <div class="panel panel-default">
                        <div class="panel-heading table-responsive">Food Details</div>
                        <table id="physicaActivityTable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                
                                <th>Actual Date</th>
                                <th>Activity</th>
                                <th>Duration</th>
                                <th>Date of Insertion</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                
                                <td>Actual Date</td>
                                <td>Activity</td>
                                <td>Duration</td>
                                <td>Date of Insertion</td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="tab-pane fade active" id="weeklyReport">
                    <div id="curvechart" ></div>

                    <div class="panel panel-default">
                        <div class="panel-heading table-responsive">Food Details</div>
                        <table id="weeklyData" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Week No </th>
                                <th>Binge</th>
                                <th>V/L/D</th>
                                <th>Physical Activity</th>
                                <th>good Days</th>
                                <th>Fruits Vegetables</th>
                                <th>Weight</th>
                                <th>Event</th>
                                <th>Week Start</th>
                                <th>Week End</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Week No </td>
                                <td>Binge</td>
                                <td>V/L/D</td>
                                <td>Physical Activity</td>
                                <td>good Days</td>
                                <td>Fruits Vegetables</td>
                                <td>Weight</td>
                                <td>Event</td>
                                <td>Week Start</td>
                                <td>Week End</td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="tab-pane fade " id="sendNotification" style="padding-bottom: 50px">
                    <div class="panel panel-default">

                        <form>
                            <div class="col-lg-12" style="margin: 10px">
                                <label>Message</label> <input id="notification_text" type="text" size="80%">
                                <button type="submit" onclick="return postNotif();">Send</button>
                            </div>

                        </form>
                    </div>

                </div>



            </div>




        </div>

    </div>
    <div class="col-lg-3">
        <div class="panel panel-default">
            <div class="panel-heading" style="padding-bottom: 10px">User Details</div>
            
                
            <table style="margin: 10px;align:center">
                <tr align="center">
                    <div class="progress" data-percent="${USER.step}" style="padding-left:5px">
                        <div class="ss-progress">
                            <div class="ss-progress-fill"></div>
                        </div>
                        <div class="ss-percent">
                            <div class="ss-percent-wrapper">
                                <span>0</span>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr align="center">
                <div class="panel panel-default">
                    <div class="panel-heading" style="padding-bottom: 10px"><center>First Name</center></div>
                    <label style="text-align: center;">${USER.firstName}</label>
                    </div>

                </tr>
                <tr>
                    <div class="panel panel-default">
                        <div class="panel-heading" style="padding-bottom: 10px"><center>Last Name</center></div>
                        <label style="text-align: center;">${USER.lastName}</label>
                    </div>

                </tr>
                <tr>
                    <div class="panel panel-default">
                        <div class="panel-heading" style="padding-bottom: 10px"><center>Starting Date</center></div>
                        <label>${USER.start_date}</label>
                    </div>

                </tr>
                <tr>
                	<form action = "promote" method="POST"> 
                	<button type="submit" class="btn btn-info" id="promote">Promote to Next Step</button>
					</form>
                </tr>
                
            </table>

            

        </div>
    </div>


    </div>






<!-- script src="resources/js/icheck.min.js"></script>
<script src="resources/js/jquery.fs.selecter.min.js"></script>
<script src="resources/js/jquery.fs.stepper.min.js"></script>
<script src="resources/js/application.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/html5shiv.js"></script>
<!-- script src="resources/js/jquery-1.10.1.min.js"></script>
<script src="resources/js/respond.min.js"></script>
<script src="resources/js/site.min.js"></script> -->
<!-- script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script-->

<script>
    function updatePercentage () {

        var elem = $(this);
        var current = elem.data("percent-current") || 0;

        var percent = parseInt(current) + 1;
        var max = parseInt(elem.data("percent"));
        if (percent > max) {
            percent = max;
        }

        percent = percent.toFixed(1);

        deg = parseInt(360*percent/8);

        percent = parseInt(percent);
        console.log(percent+"percent");
        elem.data("percent-current", percent);

        elem.toggleClass('gt-50', percent > 4);

        elem.find('.ss-progress-fill').css('transform','rotate('+ deg +'deg)');
        elem.find('.ss-percent span').html(percent);
        if (percent != max) {
            window.setTimeout( updatePercentage.bind(this), 50);
        }
    }


    $(function(){
        var $ppc = $('.progress');
        $ppc.each(updatePercentage);
    });

</script>

<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
    	var jsonData = $.ajax({
            url: "get/food/details",
            dataType: "json",
            async: false
            }).responseText;
            //alert(jsonData);
        // Create our data table out of JSON data loaded from server.
        var data = new google.visualization.DataTable(jsonData);

        var options = {
            
            chart: {
                title:"Total Servings Vs. Number Of Binge",


            },
            legend: {'position':'top','alignment':'start'},
            bars: 'verticalAlign' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('food_detail_graph'));

        chart.draw(data, options);
    }

</script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);
    ///get/activity/details
    function drawChart() {
    	var jsonData = $.ajax({
            url: "get/activity/details",
            dataType: "json",
            async: false
            }).responseText;
            //alert(jsonData);
        // Create our data table out of JSON data loaded from server.
        var data = new google.visualization.DataTable(jsonData);

        var options = {
            chart: {
                title:"Physical Activity Duration",


            },
            legend: {'position':'top','alignment':'start'},
            bars: 'verticalAlign' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('physical_activity_graph'));

        chart.draw(data, options);
    }

</script>



<script type="text/javascript">
    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

    	var jsonData = $.ajax({
            url: "get/weekly/details",
            dataType: "json",
            async: false
            }).responseText;
            //alert(jsonData);
        // Create our data table out of JSON data loaded from server.
        var data = new google.visualization.DataTable(jsonData);

        var options = {
            chart: {
                title: 'Weekly Details',
            },

        };

        var chart = new google.charts.Bar(document.getElementById('curvechart'));

        chart.draw(data, options);
    }
</script>

</body>
<script type="text/javascript">
loadData();
</script>
</html>