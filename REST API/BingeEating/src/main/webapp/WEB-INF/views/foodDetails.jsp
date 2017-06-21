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
    <link rel="stylesheet" href="resources/css/jQuery-plugin-progressbar.css">
    <script src="resources/js/jQuery-plugin-progressbar.js"></script>


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
                    <img src="../img/logo.PNG" height="50" width="50" id="logo"/>


                    <a href="UserList.html" class="">The Women Health Project</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5" style="width: 100%;">
                    <ul class="nav navbar-nav" style="float:right;">


                        <button type="button" class="btn btn-warning navbar-btn">Logout</button>

                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</div>


<div class="col-lg-12" style="border-color: #1a1a1a;border-width: 5px;padding: 10px;padding-bottom: 10px;">
    <div class="col-lg-8">
        <div class="panel panel-default responsive">
            <div class="panel-heading"><center>Number of Binge</center></div>
            <center><div id="barchart_material" style="align-self: center"></div></center>

        </div>
    </div>
    <div class="col-lg-4">
        <div class="panel panel-default">
            <div class="panel-heading"><center>User Details</center></div>

            <table class="table">

                <tbody>
                <tr>
                    <td>User Id</td>
                    <td>Mark</td>
                </tr>
                <tr>
                    <td>Current Step</td>
<td><div class="progress-bar"></div>

</td>
                </tr>
                <tr>
                    <td>Joining Date</td>
                    <td>12/5/2016</td>
                </tr>
                </tbody>


            </table>



        </div>
    </div>
</div>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading"><center>Food Details</center></div>
        <table id="foodDetails" class="display" cellspacing="0" width="100%">
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

<script src="js/icheck.min.js"></script>
<script src="js/jquery.fs.selecter.min.js"></script>
<script src="js/jquery.fs.stepper.min.js"></script>
<script src="../js/application.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/html5shiv.js"></script>
<script src="../js/jquery-1.10.1.min.js"></script>
<script src="../js/respond.min.js"></script>
<script src="../js/site.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

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





<!--datepicker-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Total Servings', 'Number of Binge'],
            ['2015', 1170, 460],
            ['2016', 660, 1120],
            ['2017', 1030, 540],
            ['2015', 1170, 460],
            ['2016', 1660, 1120],
            ['2017', 1030, 540],
            ['2015', 1170, 460],
            ['2016', 3660, 1120],
            ['2017', 1030, 540],
            
        ]);

        var options = {
            chart: {
                title: 'Number of Binge',

            },
            bars: 'verticalAlign' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, options);
    }

    $(document).ready(function() {
        $('#foodDetails').DataTable( {
            url:"http://ec2-52-90-79-130.compute-1.amazonaws.com:8080/BingeEating/binge/user/get/daily/food?username=1&date_requested=2016-11-02&token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL215ZG9tYWluLmNvbS8iLCJyb2xlIjoiVVNFUiIsImV4cCI6MTQ4MTY5MDk5MCwiaWF0IjoxNDgxNjcyOTkwLCJ1c2VybmFtZSI6IjEifQ.D93jx0-dVqDn0vxOT_iU31e6GrHXyFea3rVa1GK6A2M",
            type:GET,

            "ajax": "data/objects.txt",
            "columns": [
                { "data": "name" },
                { "data": "position" },
                { "data": "office" },
                { "data": "extn" },
                { "data": "start_date" },
                { "data": "salary" }
            ]
        } );
    } );
</script>
<script type="text/javascript">
    $(".progress-bar").loading();				// you can load automatically
    $('input').on('click', function () {		// use some events to control the loading like this
        $(".progress-bar").loading();
    });

    setTimeout(function () {
        $rotate.css({
            'transition': 'transform ' + opts.duration + 'ms linear',
            'transform': 'rotate(' + opts.percent * 3.6 + 'deg)'
        });
    },1);
</script>

</body>
</html>