/**
 * 
 */
function submitSurvey(){
	//console.log("Token: "+token);
	onSurveyData(data);
	return false;
}
function getSurvey() {
	$.ajax(
			{
				url: contextPath+"/resources/js/baseline_survey_page1_data.json",
				type: "GET",
				success: onSurveyData,
				dataType: "json",
				contentType: "application/json"
			});
}
function createAnswerResponse(){

	var question = {answer: null, options: null, survey: "", text: "",type: null};
	question.id = 18;
	question.subquestions = [];

	var subquestion = {text: ""};
	subquestion.id = 11;

	subquestion.answer = $('input[name=sub11]:checked').val();

	var subquestion1 = {};
	subquestion1.id = 12;

	subquestion1.answer = $('input[name=sub12]:checked').val();

	question.subquestions.push(subquestion);
	question.subquestions.push(subquestion1);

	postSurvey([question]);

}

function postSurvey(data){
	//check age
	if(survey.indexOf("baseline") > -1){
		if($($("#7")[0]).val() > 50 || $($("#7")[0]).val() < 0 ) {
			$("#parent7").addClass("survey_error");
			$('.error-msg').removeClass("hide");
			$('.error-msg').text("Please enter age between 1-50");
			return;
		} else if($($("#71")[0]).val() > 50 || $($("#71")[0]).val() < 0 ) {
			$("#parent71").addClass("survey_error");
			$('.error-msg').removeClass("hide");
			$('.error-msg').text("Please enter age between 1-50");
			return;
		} else if($($("#77")[0]).val() < 0 ) {
			$("#parent77").addClass("survey_error");
			$('.error-msg').removeClass("hide");
			$('.error-msg').text("Please enter non-negative value for BAC");
			return;
		}

	}
	var request = {};
	request.token = token;
	request.questions = data;
	request.survey = survey;
	console.log(request);
	$.ajax(
			{
				url:contextPath+"/apps/submitSurveyPage",
				type: "POST",
				data: JSON.stringify( request ),
				success: function(data){
					console.log(data);
					if(data.status == 0){
						if(survey.indexOf("baseline") > -1) {
							window.location.href = contextPath+"/survey_baseline/2";
						} else {
							window.location.href = contextPath+"/survey_sixweek/2";
						}

					} else {
						$(".error-msg").html(data.message);
						$(".error-msg").removeClass("hide");
					}
				},
				dataType: "json",
				contentType: "application/json"
			} );
}