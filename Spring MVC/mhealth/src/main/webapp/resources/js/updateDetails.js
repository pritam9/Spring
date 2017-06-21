/**
 * 
 */
function saveUpdatedDetails(){

	var eMail = $("#inputEmail").val();
	var firstName=$("#inputFirstName").val();
	var lastName = $("#inputLastName").val();
	var nickName=$("#inputNickName").val();
	var DOB=$("#inputDOB").val();
	if(eMail && firstName && lastName && nickName && DOB){
		$.ajax(
				{
					url:"saveUpdatedDetails",
					type: "POST",
					data: "email="+eMail+"&firstName="+firstName+"&lastName="+lastName+"&nickName="+nickName+"&DOB="+DOB,
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
		window.location.href = "dashboard";
	}
}