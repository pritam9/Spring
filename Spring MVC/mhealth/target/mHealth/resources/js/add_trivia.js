/**
 * 
 */

function moreOptions(){
	$("#optionsContainer").append("<input class='form-control trivia-option-text' placeholder='Option Text' required/> <input class='form-control trivia-option-value' placeholder='Option Value' required/><br>");
	return false;
}

function submitTrivia(){
	addTrivia();
	return false;
}

function addTrivia(){
	var request = {};
	request.token = token;
	request.question = {};
	var text = $("#inputText").val();
	var category = $("#categorySelect").val();
	var answer = $("#inputAnswer").val();
	var explanation = $("#inputExplanation").val();
	var optionText = $(".trivia-option-text");
	var optionValue = $(".trivia-option-value");

	if(category && text && answer){
		request.question.text = text;
		request.question.category = parseInt(category);
		request.question.answer = answer;
		request.question.explanation = explanation;

		var canSubmit = true;

		request.question.options_json = [];
		for(var i = 0; i < optionText.length; i++){
			var oText = $(optionText[i]).val();
			var oValue = $(optionValue[i]).val();

			if(oText && oValue) {
				request.question.options_json.push({ text : oText, value: oValue});
			} else {
				canSubmit = false;
				$(".error-msg").removeClass("hide");
				$(".error-msg").html("Please enter all the fields");
				break;
			}
		}
		if(canSubmit == true){
			request.question.options_json = JSON.stringify(request.question.options_json);
			postTrivia(request);
		}
	} else {
		$(".error-msg").removeClass("hide");
		$(".error-msg").html("Please enter all the fields");
	}

	return false;
}

function postTrivia(data){
	$.ajax(
			{
				url:"apps/submitTrivia",
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