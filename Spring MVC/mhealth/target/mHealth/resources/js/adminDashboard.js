$(function(){

	var bacLogCanvas = document.getElementById("baclogweeklychart").getContext("2d");
	console.log("@@@JS Called : ");
	
	var response = '';
	$.ajax(
			{
				url:"apps/apis/dashboard/getBac",
				type: "POST",
				data: "token=81F9F499-27C0-4546-9AE6-E1C4AC2531D0|kkshemka|1454997251638",
				dataType: "json",
				contentType: "application/json",
				success : function(text)
                {
                    response = text.data;
                    
                	var JSONObj = jQuery.parseJSON(response.bacData);
                	
                	var bacLogData = {
                			labels: [],
                			datasets: [
                				{
                					label: "Drinks per week",
                					fillColor: "rgba(220,220,220,0.5)",
                					data: []
                				}
                			]
                		};

                	for(var key in JSONObj){
                		bacLogData.labels.push("Week " + key);
                		bacLogData.datasets[0].data.push(parseInt(JSONObj[key]));
                	}
                	
                	
                	var bacLogChart = new Chart(bacLogCanvas).Bar(bacLogData, {
                		barShowStroke: false
                	});
                	
                	var DivMsgCount = document.getElementById("msgCount");
                	DivMsgCount.innerHTML = "Total number of messages sent: " + parseInt(response.msgCount);
                	var DivResponseTime = document.getElementById("avgResponseTime");
                	DivResponseTime.innerHTML = "Average response time of users: 0";
                	var DivUserCount = document.getElementById("userCount");
                	DivUserCount.innerHTML = "Number of Users: " + parseInt(response.userList.length);
                	
                	
                	var userListTable = document.getElementById("UserListTable");
                	
                	var count = 0;
                	for (var key in response.userList){
                		
                		var user = response.userList[key];
                		
                		// Create an empty <tr> element and add it to the 1st position of the table:
                		var row = userListTable.insertRow(count);

                		// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
                		var cell1_avatar = row.insertCell(0);
                		var cell2_name = row.insertCell(1);
                		var cell3_startdate = row.insertCell(2);
                		var cell4_messages = row.insertCell(3);
                		var cell5_pf = row.insertCell(4);

                		// Add some text to the new cells:
                		cell1_avatar.innerHTML = "Avatar";
                		cell2_name.innerHTML = user.firstName + " " + user.lastName;
                		cell3_startdate.innerHTML = "Start Date: mm/dd/yyyy";
                		cell4_messages.innerHTML = "<a>Messages shown</a>";
                		cell5_pf.innerHTML = "<a>Personal Feedback</a>";
                	}
                	
                	
                	
                    
                }
			} 
			
	);
	


});