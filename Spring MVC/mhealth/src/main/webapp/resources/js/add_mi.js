/**
 * 
 */
$(document).ready(function () {
	toggleFields(); //call this first so we start out with the correct visibility depending on the selected form values
	//this will call our toggleFields function every time the selection value of our underAge field changes
	$("#optionTypeSelect").change(function () {
		toggleFields();
	});

});
//this toggles the visibility of our parent permission fields depending on the current selected value of the underAge field
function toggleFields() {
	if ($("#optionTypeSelect").val() == 0) {
		$(".options-field").hide();
		$(".feedback-options-field").hide();
	} else if ($("#optionTypeSelect").val() == 1) {
		$(".options-field").hide();
		$(".feedback-options-field").show();
	} else {
		$(".options-field").show();
		$(".feedback-options-field").hide();
	}
}

function moreOptions(){
	$("#optionsContainer").append("<input class='form-control mi-option-text' placeholder='Option Text' required/> <input class='form-control mi-option-value' placeholder='Option Value' required/><br>");
	return false;
}

function submitMI(){
	addMI();
	return false;
}

function addMI(){
	var request = {};
	request.token = token;
	request.mi = {};
	var title = $("#inputTitle").val();
	var type = $("#typeSelect").val();
	var text = $("#inputText").val();
	var dateTime = $("#inputDateTime").val();
	var optionType = $("#optionTypeSelect").val();
	var optionText = $(".mi-option-text");
	var optionValue = $(".mi-option-value");

	if(title && text && dateTime){
		request.mi.type = parseInt(type);
		request.mi.text = text;
		request.mi.title = title;
		request.mi.dateTime = dateTime;
		request.mi.option_type = parseInt(optionType);

		var canSubmit = true;
		if(optionType > 0){
			request.mi.options_json = [];
			for(var i = 0; i < optionText.length; i++){
				var oText = $(optionText[i]).val();
				var oValue = $(optionValue[i]).val();

				if(oText && oValue) {
					request.mi.options_json.push({ text : oText, value: oValue});
				} else {
					canSubmit = false;
					$(".error-msg").removeClass("hide");
					$(".error-msg").html("Please enter all the fields");
					break;
				}
			}
		}
		if(canSubmit == true){
			request.mi.options_json = JSON.stringify(request.mi.options_json);
			postMI(request);
		}
	} else {
		$(".error-msg").removeClass("hide");
		$(".error-msg").html("Please enter all the fields");
	}

	return false;
}

function postMI(data){
	$.ajax(
			{
				url:"apps/submitMI",
				type: "POST",
				data: JSON.stringify( data ),
				success: function(data){
					console.log(data);
					if(data.status == 0){
						window.location.href = "dashboard";
					} else {
						$(".error-msg").html(data.message);
						$(".error-msg").removeClass("hide");
					}
				},
				dataType: "json",
				contentType: "application/json"
			} );
	return false;
}