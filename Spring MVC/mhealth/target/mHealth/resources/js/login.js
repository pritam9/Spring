/**
 * 
 */
function verifyLogin(){

	var username = $("#inputUsername").val();
	var password = $("#inputPassword").val();
	if(username && password){
		var user = {};
		user.username = username;
		user.password = password;

		//$.ajax(
		//		{
		//			url:"apps/verifyLogin",
		//			type: "POST",
		//			data: JSON.stringify( user ),
		//			success: onSuccess,
		//			dataType: "json",
		//			contentType: "application/json"
		//		} );
		$.ajax(
				{
					url:"apps/apis/auth/login_ver2",
					type: "POST",
					data: "username="+user.username+"&password="+user.password+"&deviceToken=NA",
					success: onSuccess,
					dataType: "json",
					contentType: "application/x-www-form-urlencoded"
				} );
	} else {
		$(".error-msg").removeClass("hide");
		$(".error-msg").html("Please enter all the fields");
	}


	return false;
}

function onSuccess(data){
	if(data.status != 0){
		$(".error-msg").html(data.message);
		$(".error-msg").removeClass("hide");
	} else {
		//console.log(data);
		//window.location.href = "survey";
		if(data.data.detailsUpdated =='Y')
			window.location.href = "dashboard";
		else
			window.location.href="updateDetails";
		//window.location.href = "add_mi";
	}
}