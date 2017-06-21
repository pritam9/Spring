function loadData(){
	var t=$('#foodDetailstable').DataTable( {
		"ajax": {
		    "url": "binge/admin/get/user/details/food",
		    "type": "GET"
		  },
	    "columns": [
	{ "data": "d_id" },
	{ "data": "a_date" },
	{ "data": "food" },
	{ "data": "food" },
	{ "data": "servings" },
	{ "data": "binge" },
	{ "data": "vld" },
	{ "data": "context" },
	{ "data": "feelings" },
	{ "data": "i_date" }
	    ]
	} );
	
	
	var t=$('#physicaActivityTable').DataTable( {
		"ajax": {
		    "url": "binge/admin/get/user/details/activity",
		    "type": "GET"
		  },
	    "columns": [
	
	{ "data": "a_date" },
	{ "data": "activity" },
	{ "data": "duration" },
	{ "data": "i_date" }
	    ]
	} );
	
	var t=$('#weeklyData').DataTable( {
		"ajax": {
		    "url": "binge/admin/get/user/details/weekly",
		    "type": "GET"
		  },
	    "columns": [
	
	{ "data": "w_id" },
	{ "data": "binge" },
	{ "data": "vld" },
	{ "data": "physical_activity" },
	{ "data": "good_days" },
	{ "data": "fruit_vegetables" },
	{ "data": "weight" },
	{ "data": "event_data" },
	{ "data": "a_date" },
	{ "data": "i_date" }
	
	    ]
	} );
}

function postNotif(){
	var notification_text = $("#notification_text").val();
	//var password = $("#inputPassword").val();
	if(notification_text){
		

		$.ajax(
				{
					url:"binge/web/post/notification",
					type: "POST",
					data: "notification_text="+notification_text,
					success: onSuccess,
					error: function(e){
						alert("error"+e);
					},
					dataType: "json",
					contentType: "application/x-www-form-urlencoded"
				} );
	} else {
		$(".error-msg").removeClass("hide");
		$(".error-msg").html("Please enter all the fields");
		alert("Username/Password cannot be blank")
	}


	return false;
}

function onSuccess(data){
	//var obj = JSON.parse(data.data);
	//alert(data.data);
	if(data.status != 0){
		$(".error-msg").html(data.message);
		$(".error-msg").removeClass("hide");
		alert("Error Sending Notification!");
	} else {
		alert("Successfully Sent!");
	}
}
