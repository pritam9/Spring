$(function(){
	
	function BuildBarChart(Chartoptions){
		var ChartObj= new Chart(Chartoptions.canvasObj, {
	        type: 'bar',
	        data: {
	        	labels:Chartoptions.labelsArray,
	            datasets: [{
	            	label: Chartoptions.labelText,
	            	data: Chartoptions.dataArray,
	                backgroundColor:Chartoptions.backgroundColorArray 
	            }]
	        },
	        options: {
			scales: {
			    yAxes: [{
			      scaleLabel: {
			        display: true,
			        labelString: Chartoptions.yAxesLabel
			      }
			    }],
	            xAxes: [{
			      scaleLabel: {
			        display: true,
			        labelString: Chartoptions.xAxesLabel
			      }
			    }]
			}     
		}
	    });
		return ChartObj;
	}
	/****************************************************************/
	var freqDrinkingCanvas = document.getElementById("freqDrinkingChart").getContext("2d");
	var freqDrinkingChartOpt={
			canvasObj:freqDrinkingCanvas,
			labelsArray:["Never", "Not in last 30 days", "1-2", "3-5", "6-9", "10-19", "20+"],
			labelText:"% of Students",
			dataArray:[21.7, 14.5, 19.9, 18.9, 10.5, 10, 4.5],
			backgroundColorArray:['rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)'],
			yAxesLabel:"% of Students",
			xAxesLabel:"Number of days"
	}
	var freqDrinkingChart = BuildBarChart(freqDrinkingChartOpt);

	var barIndex = 0;
	//now based on data provided by Dr. Li
	if(alcoholUsage == 0){
		barIndex = 1;
	} else if(alcoholUsage == 1 || alcoholUsage == 2){
		barIndex = 2;
	} else if(alcoholUsage >= 3 && alcoholUsage <= 5){
		barIndex = 3;
	} else if(alcoholUsage >= 6 && alcoholUsage <= 9){
		barIndex = 4;
	} else if(alcoholUsage >= 10 && alcoholUsage <= 19){
		barIndex = 5;
	} else {//20+
		barIndex = 6;
	}
	freqDrinkingChart.data.datasets[0].backgroundColor[barIndex] = "green";
	freqDrinkingChart.update();
	
   /****************************************************************/

	var quantityDrinkingCanvas = document.getElementById("quantityDrinkingChart").getContext("2d");
	var quantityDrinkingChartOpt={
			canvasObj:quantityDrinkingCanvas,
			labelsArray:["None", "1", "2", "3", "4", "5", "6", "7", "8", "9-10+"],
			labelText:"% of Students",
			dataArray:[30, 11, 15.3, 12.4, 9.6, 7.7, 5.6, 2.2, 3.3, 2.9],
			backgroundColorArray:['rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)','rgba(220,220,220,0.5)'],
			yAxesLabel:"% of Students",
			xAxesLabel:"Number of drinks"
	}
	var quantityDrinkingChart=BuildBarChart(quantityDrinkingChartOpt);
	
	var barIndex = 0;
	//now based on new data sent by Dr. Li
	switch(averageDrink){
		case "0":
			barIndex = 0;
			break;
		case "1":
			barIndex = 1;
			break;
		case "2":
			barIndex = 2;
			break;
		case "3":
			barIndex = 3;
			break;
		case "4":
			barIndex = 4;
			break;
		case "5":
			barIndex = 5;
			break;
		case "6":
			barIndex = 6;
			break;
		case "7":
			barIndex = 7;
			break;
		case "8":
			barIndex = 8;
			break;
		default:
			barIndex = 9;
			break;
	}
	quantityDrinkingChart.data.datasets[0].backgroundColor[barIndex] = "green";
	quantityDrinkingChart.update();
	
	/***************************************************************/

	//var monthlyCalReq = (gender == "0") ? 30 * 2800 : 30 * 2200;
	var dailyCalReq = (gender == "0") ? 2800 : 2200;

	//var alcoholCal = total * 4 * 150;
	var maxAlcoholCal = maxTotal * 150;

	//var foodCal = monthlyCalReq - alcoholCal;
	var foodCal = dailyCalReq - maxAlcoholCal;

	var foodPercent = 100 * foodCal/(dailyCalReq);
	var alcoholPercent = 100 * maxAlcoholCal/(dailyCalReq)
	var alcoholNutritionCanvas1 = document.getElementById("alcoholNutritionChart").getContext("2d");
	var alcoholNutritionData1 = {
		    labels: ["Food (%)","Alcohol (%)"],
		    datasets: [
		               {
		                   data: [foodPercent, alcoholPercent],
		                   backgroundColor: [
		                       "#46BFBD",
		                       "#F7464A"
		                   ],
		                   hoverBackgroundColor: [
		                       "#5AD3D1",
		                       "#FF5A5E"
		                   ]
		               }
		             ]
		};

	//var alcoholNutritionChart = new Chart(alcoholNutritionCanvas).Pie(alcoholNutritionData);
	var alcoholNutritionChart1 = new Chart(alcoholNutritionCanvas1,{
	    type: 'pie',
	    data: alcoholNutritionData1,
	});


	//alcoholCal = total * 4 * 250;
	maxAlcoholCal = maxTotal * 250;
	var foodCal = dailyCalReq - maxAlcoholCal;

	var foodPercent = 100 * foodCal/(dailyCalReq);
	var alcoholPercent = 100 * maxAlcoholCal/(dailyCalReq)
	var alcoholNutritionCanvas2 = document.getElementById("alcoholNutritionChart2").getContext("2d");
	var alcoholNutritionData2 = {
	    labels: ["Food (%)","Alcohol (%)"],
	    datasets: [
	               {
	                   data: [foodPercent, alcoholPercent],
	                   backgroundColor: [
	                       "#46BFBD",
	                       "#F7464A"
	                   ],
	                   hoverBackgroundColor: [
	                       "#5AD3D1",
	                       "#FF5A5E"
	                   ]
	               }
	             ]
	};

	//var alcoholNutritionChart = new Chart(alcoholNutritionCanvas).Pie(alcoholNutritionData);
	var alcoholNutritionChart2 = new Chart(alcoholNutritionCanvas2,{
	    type: 'pie',
	    data: alcoholNutritionData2,
	});
	
	/****************************************************************/
	
	
	var bacChanges = [0];
	var labels = [""];
	var currentBac = 999;
	var hours = 0;
	while(true){
		currentBac = alpha - 0.015 * hours;
		if(currentBac <= 0) {
			break;
		} else {
			bacChanges.push(currentBac);
			if(hours == 0){
				labels.push("MIDNIGHT");
			} else {
				var time =  (hours >= 12) ? ((hours == 12) ? "12 PM" : (hours - 12)+ "PM") : hours + "AM";
				labels.push(time);
			}
		}
		hours ++;
	}
	//console.log(labels);
	//console.log(bacChanges);
	var bacChangesCanvas = document.getElementById("bacChangesChart").getContext("2d");

	var bacChangesData = {
		labels: labels,
		datasets: [
			{
				label: "Change in BAC of you high drinking occasion",
				fillColor: "rgba(220,220,220,0.2)",
				strokeColor: "rgba(220,220,220,1)",
				pointColor: "rgba(220,220,220,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)",
				data: bacChanges
			}
		]
	};

	//var bacChangesChart = new Chart(bacChangesCanvas).Line(bacChangesData);
	var bacChangesChart = new Chart(bacChangesCanvas, {type: 'line',data: bacChangesData});
});