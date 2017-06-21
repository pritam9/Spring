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

		$.ajax(
				{
					url:"binge/adminlogin",
					type: "POST",
					data: "username="+user.username+"&password="+user.password,
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
		alert("Username/password not correct!");
	} else {
		window.location.href = "homePage";
	}
}