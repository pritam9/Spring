/**
 * 
 */
function registerUser(){

	var username = $("#inputUsername").val();
	var password = $("#inputPassword").val();
	var confirmPassword = $("#inputConfirmPassword").val();
	var email = $("#inputEmail").val();
	var firstName = $("#inputFirstName").val();
	var lastName = $("#inputLastName").val();
	var nickName = $("#inputNickName").val();
	var dob = $("#inputDOB").val();
	if(username && password && confirmPassword && email && firstName && lastName && email && dob && nickName){
		if(password == confirmPassword){
			var user = {};
			user.username = username;
			user.password = password;
			user.email = email;
			user.dob = dob
			user.firstName = firstName;
			user.lastName = lastName;
			user.nickname = nickName;

			$.ajax(
					{
						url:"apps/registerUser",
						type: "POST",
						data: JSON.stringify( user ),
						success: onSuccess,
						dataType: "json",
						contentType: "application/json"
					} );
		} else {
			$(".error-msg").removeClass("hide");
			$(".error-msg").html("Passwords do not match");
		}
		
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
		window.location.href = "login";
	}
}